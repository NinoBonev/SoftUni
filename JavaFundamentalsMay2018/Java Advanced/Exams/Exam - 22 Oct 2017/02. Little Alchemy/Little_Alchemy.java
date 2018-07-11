import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 1.7.2018 г., 23:53
 */
public class Little_Alchemy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stonesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .forEachOrdered(stonesQueue::addLast);

        ArrayDeque<Integer> storeStack = new ArrayDeque<>();
        String line;
        while (!"Revision".equals(line = scanner.nextLine())) {
            String[] command = line.split(" ");
            Integer amount = Integer.parseInt(command[2]);
            switch (command[0] + " " + command[1]) {
                case "Apply acid":
                    for (int i = 0; i < amount; i++) {
                        if (!stonesQueue.isEmpty()) {
                            Integer stone = stonesQueue.poll();
                            if (stone - 1 == 0) {
                                storeStack.push(stone);
                            } else {
                                stonesQueue.offer(stone - 1);
                            }
                        } else {
                            break;
                        }
                    }
                    break;
                case "Air leak":
                    if (!storeStack.isEmpty()) {
                        storeStack.pop();
                        stonesQueue.offer(amount);
                    }
                    break;
            }
        }

        while (!stonesQueue.isEmpty()) {
            System.out.print(stonesQueue.poll() + " ");
        }
        System.out.println();
        System.out.println(storeStack.size());
    }
}
