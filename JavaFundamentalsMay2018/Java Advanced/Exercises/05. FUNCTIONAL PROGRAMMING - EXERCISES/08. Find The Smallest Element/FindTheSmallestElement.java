import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 7.6.2018 г., 9:37
 */
public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> minElement = num -> {
            Integer thisElement = Integer.MAX_VALUE;
            Integer thisElementPosition = 0;
            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i) <= thisElement){
                    thisElement = nums.get(i);
                    thisElementPosition = i;
                }
            }

            return thisElementPosition;
        };

        System.out.println(minElement.apply(nums));
    }
}
