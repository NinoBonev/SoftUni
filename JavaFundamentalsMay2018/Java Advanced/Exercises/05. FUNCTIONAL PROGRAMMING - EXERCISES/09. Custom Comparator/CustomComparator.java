import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 7.6.2018 г., 9:47
 */
public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        Comparator<Integer> integerComparator = (a, b) -> {
            boolean firstIsEven = a % 2 == 0;
            boolean secondIsEven = b % 2 == 0;
            if (firstIsEven && !secondIsEven){
                return -1;
            } else if (!firstIsEven && secondIsEven){
                return 1;
            }else {
                return a - b;
            }
        };

        Collections.sort(numbers, integerComparator);
        numbers.forEach(x -> System.out.printf("%d ", x));
    }
}
