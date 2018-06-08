import java.util.*;
        import java.util.function.Function;
        import java.util.function.Predicate;
        import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 7.6.2018 г., 8:42
 */
public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int division = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> isDivisible = num -> num % division != 0;
        Function<Integer, Boolean> filterNums = isDivisible::test;

        Collections.reverse(nums);
        nums.stream().filter(filterNums::apply).forEach(z -> System.out.printf("%d ", z));
    }
}