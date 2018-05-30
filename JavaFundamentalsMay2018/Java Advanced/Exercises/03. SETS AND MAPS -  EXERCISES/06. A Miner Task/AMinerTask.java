import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 28.5.2018 г., 7:44
 */
public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resources = new LinkedHashMap<>();

        String resource;
        while (!"stop".equals(resource=scanner.nextLine()))
        {
            Integer quantity = Integer.parseInt(scanner.nextLine());
            resources.putIfAbsent(resource, 0);
            resources.replace(resource, resources.get(resource) + quantity);
        }

        for (Map.Entry<String, Integer> entry:
             resources.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
