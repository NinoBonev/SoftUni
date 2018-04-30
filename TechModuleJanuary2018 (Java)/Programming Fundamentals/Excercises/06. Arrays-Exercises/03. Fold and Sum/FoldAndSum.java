import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class FoldAndSum {
    public static void main(String[] args) throws IOException{

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int [] input = Arrays.stream(console.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = input.length / 4;
        int [] topArray = new int[input.length / 2];
        int [] bottomArray = new int[input.length / 2];

        for (int i = 0; i < input.length / 4; i++)
        {
            topArray[i] = input[count - i - 1];
            topArray[topArray.length - i - 1] = input[input.length - count + i];
            bottomArray[2 * i] = input[2 * i + count];
            bottomArray[2 * i + 1] = input[2 * i + count + 1];
        }

        int[] result = new int[count * 2];

        for (int i = 0; i < result.length; i++)
        {
            result[i] = topArray[i] + bottomArray[i];
        }

        for (int number:
             result) {

            System.out.printf("%d ", number);
        }
    }
}
