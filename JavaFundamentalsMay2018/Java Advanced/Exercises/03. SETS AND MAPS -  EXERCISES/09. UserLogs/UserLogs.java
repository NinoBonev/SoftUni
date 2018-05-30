import java.util.*;

/**
 * Created by Nino Bonev - 28.5.2018 г., 9:48
 */
public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> data = new LinkedHashMap<>();

        String line;
        while (!"end".equals(line=scanner.nextLine()))
        {
            String IP = line.split(" ")[0].trim().split("=")[1].trim();
            String user = line.split(" ")[2].trim().split("=")[1].trim();

            data.putIfAbsent(user, new LinkedHashMap<>());
            data.get(user).putIfAbsent(IP, 0);
            data.get(user).replace(IP, data.get(user).get(IP) + 1);
        }

        int[] count = new int[]{0};
        data.entrySet().stream().sorted((x, y) -> x.getKey().compareTo(y.getKey())).forEach(z -> {
            System.out.printf("%s:%n", z.getKey());
            if (z.getValue().size() > 1){
                count[0] = z.getValue().size();
            }
            z.getValue().entrySet().stream().forEach(w -> {

                if (count[0] > 1){
                    System.out.printf("%s => %d, ", w.getKey(), w.getValue());
                    count[0]--;
                } else {
                    System.out.printf("%s => %d.%n", w.getKey(), w.getValue());
                }
            });
        });
    }
}
