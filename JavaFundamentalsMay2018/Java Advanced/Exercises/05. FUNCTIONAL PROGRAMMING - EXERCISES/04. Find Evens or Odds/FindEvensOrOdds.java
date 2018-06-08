import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Created by Nino Bonev - 6.6.2018 г., 10:36
 */
public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int startNum = nums[0];
        int endNum = nums[1];
        String command = scanner.nextLine();
        Predicate<String> printCase = thisCase -> thisCase.equals("odd");

        if (printCase.test(command)){
            printOdd(startNum, endNum);
        } else {
            printEven(startNum, endNum);
        }
    }

    private static void printEven(int num1, int num2){
        for (int i = num1; i <= num2 ; i++) {
            if (i % 2 == 0){
                System.out.print(i + " ");
            }
        }
    }

    private static void printOdd(int num1, int num2){
        for (int i = num1; i <= num2 ; i++) {
            if (i % 2 != 0){
                System.out.print(i + " ");
            }
        }
    }
}
