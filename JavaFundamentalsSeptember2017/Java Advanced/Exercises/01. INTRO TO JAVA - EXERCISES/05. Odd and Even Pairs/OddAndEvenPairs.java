import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 1.5.2018 г., 14:11
 */
public class OddAndEvenPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (nums.length % 2 != 0){
            System.out.println("invalid length");
        } else {
            for (int i = 1; i < nums.length; i+= 2) {
                if (nums[i - 1] % 2 == 0 && nums[i] % 2 == 0) {
                    System.out.printf("%d, %d -> both are even%n", nums[i - 1], nums[i]);
                } else if (nums[i - 1] % 2 != 0 && nums[i] % 2 != 0){
                    System.out.printf("%d, %d -> both are odd%n", nums[i - 1], nums[i]);
                } else {
                    System.out.printf("%d, %d -> different%n", nums[i - 1], nums[i]);
                }
            }
        }
    }
}
