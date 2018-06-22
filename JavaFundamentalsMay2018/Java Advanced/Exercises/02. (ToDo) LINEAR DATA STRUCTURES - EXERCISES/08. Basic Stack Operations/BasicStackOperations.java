import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 22.6.2018 г., 18:00
 */
public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] data = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Integer pushNum = data[0];
        Integer popNum = data[1];
        Integer checkNum = data[2];

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < pushNum; i++) {
            stack.push(numbers[i]);
        }
        for (int i = 0; i < popNum; i++) {
            stack.pop();
        }
        if (stack.isEmpty()){
            System.out.println(0);
        } else {
            if (stack.contains(checkNum)){
                System.out.println("true");
            } else {
                System.out.println(stack.stream().min(Comparator.naturalOrder()).get());
            }
        }

    }
}
