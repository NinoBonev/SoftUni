import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 22.6.2018 г., 18:34
 */
public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] data = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Integer offerNum = data[0];
        Integer pollNum = data[1];
        Integer checkNum = data[2];

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < offerNum; i++) {
            queue.offer(numbers[i]);
        }
        for (int i = 0; i < pollNum; i++) {
            queue.poll();
        }
        if (queue.isEmpty()){
            System.out.println(0);
        } else {
            if (queue.contains(checkNum)){
                System.out.println("true");
            } else {
                System.out.println(queue.stream().min(Comparator.naturalOrder()).get());
            }
        }
    }
}
