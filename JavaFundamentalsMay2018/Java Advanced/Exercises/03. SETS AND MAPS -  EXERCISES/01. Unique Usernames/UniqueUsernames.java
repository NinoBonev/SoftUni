import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 25.5.2018 г., 12:00
 */
public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer inputCount = Integer.parseInt(scanner.nextLine());
        List<String> names = new LinkedList<>();

        for (int i = 0; i < inputCount; i++) {
            String name = scanner.nextLine();
            if (!names.contains(name))
            {
                names.add(name);
            }
        }

        names.forEach(System.out::println);

    }
}
