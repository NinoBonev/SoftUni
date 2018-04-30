import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GeneratingCombinations {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(console.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int combinationSize = Integer.parseInt(console.readLine());

        Generate(numbers, new int[combinationSize], 0, 0);
    }

    private static void Generate(int[] arr, int[] result, int index, int border){

        if (border == result.length) {
            System.out.println(Arrays.toString(result).replaceAll("[,\\[\\]]", ""));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            result[border] = arr[i];
            Generate(arr, result, i + 1, border + 1);
        }
    }
}
