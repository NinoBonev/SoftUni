package frogg;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 18.7.2018 г., 18:45
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Lake lake;
        String line;
        while (!"END".equals(line = scanner.nextLine())) {
            List<Integer> lakeIntegers = Arrays.stream(line.split("[,]*\\s"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            lake = new Lake(lakeIntegers);
            StringBuilder sb = new StringBuilder();
            for (Integer integer : lake) {
                sb.append(integer).append(", ");
            }
            System.out.println(sb.toString().substring(0, sb.length() - 2));
        }
    }
}
