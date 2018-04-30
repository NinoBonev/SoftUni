import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class NSA {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Map<String, LinkedHashMap<String, Integer>> register = new LinkedHashMap<>();

        String line;
        while (!"quit".equals(line = console.readLine()))
        {
            String[] command = line.replace(" -> ", " ").split(" ");
            String country = command[0];
            String spyName = command[1];
            Integer daysInService = Integer.parseInt(command[2]);

            register.putIfAbsent(country, new LinkedHashMap<>());
            register.get(country).putIfAbsent(spyName, 0);
            register.get(country).replace(spyName, daysInService);
        }

        register.entrySet().stream()
                .sorted((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()))
                .forEach(x -> {
                    System.out.printf("Country: %s%n", x.getKey());
                    x.getValue().entrySet().stream()
                            .sorted((z, w) -> Integer.compare(w.getValue(), z.getValue()))
                            .forEach(c -> System.out.printf("**%s : %d%n", c.getKey(), c.getValue()));
                });
    }
}
