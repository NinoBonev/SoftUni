import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RecursiveArraySum {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(console.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(Sum(0, numbers));
    }

    private static int Sum(int index, int[] numbers){

        if (index == numbers.length - 1){

            return numbers[index];
        }

        return numbers[index] + Sum(index + 1, numbers);
    }
}
