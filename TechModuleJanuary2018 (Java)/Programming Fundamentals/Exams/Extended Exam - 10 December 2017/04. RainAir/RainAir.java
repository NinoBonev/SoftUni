import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class RainAir {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, LinkedList<Integer>> result = new LinkedHashMap<>();

        String line;
        while (!"I believe I can fly!".equals(line = console.readLine()))
        {
            String customerName = line.split(" ")[0];

            if (line.contains("="))
            {
                String customer2Name = line.split(" = ")[1];

                result.get(customerName).clear();
                result.get(customerName).addAll(result.get(customer2Name));
            }
            else
            {
                List<Integer> data = Arrays.stream(line.split(" "))
                        .skip(1)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                result.putIfAbsent(customerName, new LinkedList<>());
                result.get(customerName).addAll(data);

            }
        }
        result.entrySet().stream().sorted((x, y) -> {
            int compare = Integer.compare(y.getValue().size(), x.getValue().size());

            if (compare == 0)
            {
                compare = x.getKey().compareTo(y.getKey());
            }

            return compare;
        })
                .forEach(z -> {
                    z.getValue().sort(Comparator.naturalOrder());
                    String flights = z.getValue().stream().map(i -> i.toString()).collect(Collectors.joining(", "));
                    System.out.printf("#%s ::: %s%n", z.getKey(), flights);
                });
    }
}