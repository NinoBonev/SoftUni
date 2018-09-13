import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 13.9.2018 г., 12:11
 */
public class ArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(Sum(arr, 0));
    }

    private static int Sum(int[] array, int index){
        if (index == array.length){
            return 0;
        }

        return array[index] + Sum(array, index + 1);
    }
}
