import java.util.*;

/**
 * Created by Nino Bonev - 25.5.2018 г., 16:25
 */
public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] chars = scanner.nextLine().toCharArray();
        Map<Character, Integer> countChars = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            countChars.putIfAbsent(chars[i], 0);
            countChars.replace(chars[i], countChars.get(chars[i]) + 1);
        }

        countChars.entrySet().stream().sorted((z, y) -> z.getKey().compareTo(y.getKey())).forEach(x -> System.out.printf("%c: %d time/s%n", x.getKey(), x.getValue()));
    }
}
