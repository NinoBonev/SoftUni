import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 25.5.2018 г., 16:14
 */
public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer inputCount = Integer.parseInt(scanner.nextLine());
        List<String> elements = new ArrayList<>();

        for (int i = 0; i < inputCount; i++) {
            String[] thisElements = scanner.nextLine().split(" ");
            for (int j = 0; j < thisElements.length; j++) {
                if (!elements.contains(thisElements[j])){
                    elements.add(thisElements[j]);
                }
            }
        }

        Collections.sort(elements);
        elements.forEach(x -> System.out.printf("%s ", x));
    }
}
