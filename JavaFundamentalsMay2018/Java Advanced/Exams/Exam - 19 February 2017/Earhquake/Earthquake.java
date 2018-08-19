import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 18.8.2018 г., 8:51
 */
public class Earthquake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer count = Integer.parseInt(scanner.nextLine());
        ArrayDeque<ArrayDeque<Integer>> dequeList = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ArrayDeque<Integer> waves = new ArrayDeque<>();
            for (int j = 0; j < input.length; j++) {
                waves.offer(input[j]);
            }
            dequeList.add(waves);
        }

        while (dequeList.peek() != null){
            ArrayDeque<Integer> current = dequeList.poll();
            Integer currentWave = current.poll();
            if (current.size() > 0){
                Integer nextWave = current.peek();
                if (currentWave >= nextWave ){
                    current = current.stream().filter(x -> x > currentWave).collect(Collectors.toCollection(ArrayDeque::new));
                    result.add(currentWave);
                    if (current.size() > 0) {
                        dequeList.offer(current);
                    }
                } else {
                    result.add(currentWave);
                    dequeList.offer(current);
                }
            } else {
                result.add(currentWave);
            }

        }

        System.out.println(result.size());
        System.out.println(result.toString().replace("[", "")
        .replace("]", "")
        .replace(",", ""));

    }
}
