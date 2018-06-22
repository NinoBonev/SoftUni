import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 22.6.2018 г., 17:16
 */
public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(" ");
        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, data);

        Integer n = Integer.parseInt(scanner.nextLine());
        while (queue.size() > 1){
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }

            System.out.println("Removed " + queue.poll());
        }

        System.out.println("Last is " + queue.poll());
    }
}
