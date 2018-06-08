import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 7.6.2018 г., 11:00
 */
public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer endOfSequence = Integer.parseInt(scanner.nextLine());
        List<Integer> divisionNumbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> result = new LinkedList<>();
        BiPredicate<Integer, Integer> isDivisible = (x, y) -> x % y == 0;

        for (int i = 1; i <= endOfSequence; i++) {
            Integer count = 0;
            for (Integer num:
                 divisionNumbers) {
                if (isDivisible.test(i, num)){
                    count++;
                }
            }

            if (count == divisionNumbers.size()){
                result.add(i);
            }
        }

        result.forEach(x -> System.out.printf("%d ", x));
    }
}
