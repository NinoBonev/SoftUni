import java.util.*;

/**
 * Created by Nino Bonev - 29.5.2018 г., 9:21
 */
public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer logsNumber = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, Integer>> userLogs = new HashMap<>();

        for (int i = 0; i < logsNumber; i++) {
            String data = scanner.nextLine();

            String name = data.split(" ")[1];
            String IP = data.split(" ")[0];
            Integer duration = Integer.parseInt(data.split(" ")[2]);


            userLogs.putIfAbsent(name, new HashMap<>());
            userLogs.get(name).putIfAbsent(IP, 0);
            Integer currentDuration = userLogs.get(name).get(IP);
            userLogs.get(name).replace(IP, currentDuration + duration);
        }

        int[] count = new int[]{0};
        userLogs.entrySet().stream().sorted((x, y) -> x.getKey().compareTo(y.getKey())).forEach(z -> {
            System.out.printf("%s: %d [", z.getKey(), z.getValue().values().stream().reduce(0, (n, m) -> n + m));
            if (z.getValue().size() > 1){
                count[0] = z.getValue().size();
            }
            z.getValue().entrySet().stream().sorted((a, b) -> a.getKey().compareTo(b.getKey())).forEach(w -> {
                if (count[0] > 1){
                    System.out.printf("%s, ", w.getKey());
                    count[0]--;
                } else {
                    System.out.printf("%s]%n", w.getKey());
                }
            });
        });
    }
}
