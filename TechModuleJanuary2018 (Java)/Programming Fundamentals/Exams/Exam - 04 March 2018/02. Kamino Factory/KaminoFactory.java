import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class New {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(console.readLine());

        int sample = 0;
        int bestSample = 1;
        int[] bestDNA_Arr = new int[n];
        int maxCounter = -1;
        int maxStartingIndex = 0;

        String line;
        while (!"Clone them!".equals(line = console.readLine())) {
            int[] DNA = Arrays.stream(line.split("[!]+")).mapToInt(Integer::parseInt).toArray();
            sample++;

            int thisDNA = 0;
            int start = 0;

            for (int i = 0; i < n; i++) {

                if (DNA[i] == 1) {
                    thisDNA++;
                    start = i - thisDNA;
                    if (thisDNA > maxCounter) {
                        bestDNA_Arr = DNA;
                        maxCounter = thisDNA;
                        maxStartingIndex = start;
                        bestSample = sample;
                    } else if (thisDNA == maxCounter && start < maxStartingIndex) {
                        bestDNA_Arr = DNA;
                        maxStartingIndex = start;
                        bestSample = sample;
                    } else if (thisDNA == maxCounter && start == maxStartingIndex) {
                        int thisDNS_Sum = Arrays.stream(DNA).sum();
                        int bestDNA_Sum = Arrays.stream(bestDNA_Arr).sum();

                        if (thisDNS_Sum > bestDNA_Sum) {
                            bestDNA_Arr = DNA;
                            maxStartingIndex = start;
                            bestSample = sample;
                        }
                    }
                } else {
                    thisDNA = 0;
                }
            }
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", bestSample, Arrays.stream(bestDNA_Arr).sum());
        for (int i = 0; i < n; i++) {
            System.out.print(bestDNA_Arr[i] + " ");
        }
    }
}