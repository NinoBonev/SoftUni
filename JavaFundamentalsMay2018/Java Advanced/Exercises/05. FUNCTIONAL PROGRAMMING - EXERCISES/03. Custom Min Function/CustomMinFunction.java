import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

/**
 * Created by Nino Bonev - 6.6.2018 г., 10:27
 */
public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> minNum = num -> {
            Integer minNumber = Integer.MAX_VALUE;
            for (int number:
                 nums) {
                if (number < minNumber){
                    minNumber = number;
                }
            }
            return minNumber;
        };

        System.out.println(minNum.apply(nums));
    }
}
