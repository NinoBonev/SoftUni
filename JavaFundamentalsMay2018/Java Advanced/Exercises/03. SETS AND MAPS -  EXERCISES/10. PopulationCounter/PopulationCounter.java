import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 28.5.2018 г., 10:52
 */
public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Long>> population = new LinkedHashMap<>();

        String line;
        while (!"report".equals(line = scanner.nextLine())) {
            String city = line.split("\\|")[0];
            String country = line.split("\\|")[1];
            Long cityPopulation = Long.parseLong(line.split("\\|")[2]);

            population.putIfAbsent(country, new LinkedHashMap<>());
            population.get(country).putIfAbsent(city, cityPopulation);
        }

        population.entrySet().stream()
                .sorted((x, y) -> y.getValue().values().stream().reduce(0L, (a, b) -> a + b)
                    .compareTo(x.getValue().values().stream().reduce(0L, (a, b) -> a + b)))
                .forEach(z -> {
            System.out.printf("%s (total population: %d)%n", z.getKey(), z.getValue().values().stream().reduce(0L, (a, b) -> a + b));
            z.getValue().entrySet().stream()
                    .sorted((n, m) -> m.getValue().compareTo(n.getValue()))
                    .forEach(l -> System.out.printf("=>%s: %d%n", l.getKey(), l.getValue()));
        });
    }
}
