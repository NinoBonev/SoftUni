import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Generating_0_1_Vectors {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(console.readLine());
        int[] arr = new int[length];

        Generate(0, arr);
    }

    private static void Generate(int index, int[] arr) {

        if (index == arr.length) {
            String result = Arrays.stream(arr)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));
            System.out.println(result);
        }
        else
        {

            for (int i = 0; i <= 1; i++) {
                arr[index] = i;
                Generate(index + 1, arr);

            }
        }
    }
}
