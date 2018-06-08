import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by Nino Bonev - 6.6.2018 г., 10:59
 */
public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String line;
        while (!"end".equals(line = scanner.nextLine())){
            Function<int[], int[]> add = num -> {
                for (int i = 0; i < nums.length; i++) {
                    nums[i] += 1;
                }
                return num;
            };
            Function<int[], int[]> multiply = num -> {
                for (int i = 0; i < nums.length; i++) {
                    nums[i] *= 2;
                }
                return num;
            };
            Function<int[], int[]> subtract = num -> {
                for (int i = 0; i < nums.length; i++) {
                    nums[i] -= 1;
                }
                return num;
            };


            if (line.equals("add")){
                add.apply(nums);
            } else if (line.equals("multiply")){
                multiply.apply(nums);
            } else if (line.equals("subtract")){
                subtract.apply(nums);
            } else if (line.equals("print")){
                for (int i = 0; i < nums.length; i++) {
                    System.out.print(nums[i] + " ");
                }
            }
        }
    }
}
