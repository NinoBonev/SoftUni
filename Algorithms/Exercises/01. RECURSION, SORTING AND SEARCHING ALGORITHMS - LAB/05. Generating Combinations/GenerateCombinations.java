import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 13.9.2018 г., 13:11
 */
public class GenerateCombinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int elements = Integer.parseInt(scanner.nextLine());
        int[] result = new int[elements];

        Generate(0, 0, arr, result);
    }

    private static void Generate(int index, int border, int[] arr, int[] result){
        if (index == result.length){
            StringBuilder print = new StringBuilder();
            for (int i = 0; i < result.length; i++) {
                print.append(result[i] + " ");
            }
            System.out.println(print.toString().trim());
        } else {
            for (int i = border; i < arr.length; i++) {
                result[index] = arr[i];
                Generate(index + 1, i + 1, arr, result);
            }
        }
    }
}
