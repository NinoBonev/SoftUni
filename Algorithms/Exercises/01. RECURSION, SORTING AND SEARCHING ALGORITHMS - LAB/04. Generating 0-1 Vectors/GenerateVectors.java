import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 13.9.2018 г., 12:46
 */
public class GenerateVectors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[size];

        Generate(0, arr);
    }

    private static void Generate(int index, int[] arr){
        if (index == arr.length){
            StringBuilder print = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                print.append(arr[i]);
            }
            System.out.println(print.toString());
        } else {
            for (int i = 0; i <= 1; i++) {
                arr[index] = i;
                Generate(index + 1, arr);
            }
        }
    }
}
