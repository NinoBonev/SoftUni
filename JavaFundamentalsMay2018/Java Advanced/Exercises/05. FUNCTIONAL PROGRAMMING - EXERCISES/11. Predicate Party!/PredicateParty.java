import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 8.6.2018 г., 11:14
 */
public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        List<String> filteredNames = new ArrayList<>();

        String line;
        while (!"Party!".equals(line = scanner.nextLine())){
            String command = line.split(" ")[0];
            String operation = line.split(" ")[1];
            String operationParameters = line.split(" ")[2];

            if (command.equals("Remove")){
                if (operation.equals("StartsWith")){
                    filteredNames = StartsWith(operationParameters, names);
                    names.removeAll(filteredNames);
                } else if (operation.equals("EndsWith")){
                    filteredNames = EndsWith(operationParameters, names);
                    names.removeAll(filteredNames);
                } else if (operation.equals("Length")){
                    filteredNames = Length(operationParameters, names);
                    names.removeAll(filteredNames);
                }
            } else if (command.equals("Double")){
                if (operation.equals("StartsWith")){
                    filteredNames = StartsWith(operationParameters, names);
                    names.addAll(filteredNames);
                } else if (operation.equals("EndsWith")){
                    filteredNames = EndsWith(operationParameters, names);
                    names.addAll(filteredNames);
                } else if (operation.equals("Length")){
                    filteredNames = Length(operationParameters, names);
                    names.addAll(filteredNames);
                }
            }
        }

        names.sort(Comparator.naturalOrder());
        if (names.isEmpty()){
            System.out.println("Nobody is going to the party!");
        } else {
            int[] count = new int[]{names.size()};
            names.forEach(z -> {
                if (count[0] > 1){
                    System.out.printf("%s, ", z);
                    count[0]--;
                } else {
                    System.out.printf("%s are going to the party!%n", z);
                }
                });
        }
    }

    public static List<String> StartsWith(String operationParameters, List<String> names){
        Predicate<String> namesPredicate = name -> name.startsWith(operationParameters);
        Function<String, Boolean> filterNames = name -> namesPredicate.test(name);
        List<String> result = names.stream().filter(filterNames::apply).collect(Collectors.toList());

        return result;
    }

    public static List<String> EndsWith(String operationParameters, List<String> names){
        Predicate<String> namesPredicate = name -> name.endsWith(operationParameters);
        Function<String, Boolean> filterNames = name -> namesPredicate.test(name);
        List<String> result = names.stream().filter(filterNames::apply).collect(Collectors.toList());

        return result;
    }

    public static List<String> Length(String operationParameters, List<String> names){
        Integer length = Integer.parseInt(operationParameters);
        Predicate<String> namesPredicate = name -> name.length() == length;
        Function<String, Boolean> filterNames = name -> namesPredicate.test(name);
        List<String> result = names.stream().filter(filterNames::apply).collect(Collectors.toList());

        return result;
    }
}
