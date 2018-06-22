import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 22.6.2018 г., 18:16
 */
public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer commandsCount = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Long> stack = new ArrayDeque<>();

        for (int i = 0; i < commandsCount; i++) {
            String line = scanner.nextLine();
            switch (line.charAt(0)){
                case '1' :
                    Long num = Long.parseLong(line.split(" ")[1]);
                    stack.push(num);
                    break;
                case '2' :
                    stack.pop();
                    break;
                case '3' :
                    System.out.println(stack.stream().max(Comparator.naturalOrder()).get());
            }
        }
    }
}
