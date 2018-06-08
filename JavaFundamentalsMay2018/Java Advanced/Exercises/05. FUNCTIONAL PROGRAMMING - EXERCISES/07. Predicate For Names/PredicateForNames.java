import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 7.6.2018 г., 9:00
 */
public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer nameLength = Integer.parseInt(scanner.nextLine());
        List<String> names = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        Predicate<String> namesPredicate = name -> name.length() <= nameLength;
        Function<String, Boolean> filterNames = name -> namesPredicate.test(name);
        names.stream().filter(filterNames::apply).forEach(System.out::println);
    }
}
