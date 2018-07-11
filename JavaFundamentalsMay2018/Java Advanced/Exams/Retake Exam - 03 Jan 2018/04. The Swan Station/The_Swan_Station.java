import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 28.6.2018 г., 18:02
 */
public class The_Swan_Station {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> TheNumber = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> input = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (Integer num:
             input) {
            queue.offer(num);
        }

        for (Integer num:
             TheNumber) {
            while (queue.peekFirst() % num != 0){
                int queueNum = queue.poll();
                queue.offer(queueNum + 1);
            }
            int resultNum = queue.poll();
            result.add(resultNum);
        }

        System.out.println(result.toString().replaceAll("[\\[\\]]", ""));
    }
}
