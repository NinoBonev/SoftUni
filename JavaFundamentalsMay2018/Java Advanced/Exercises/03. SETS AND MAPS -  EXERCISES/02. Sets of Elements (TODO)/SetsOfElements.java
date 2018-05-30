import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 25.5.2018 г., 12:04
 */
public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer n = scanner.nextInt();
        Integer m = scanner.nextInt();
        scanner.nextLine();
        List<Integer> listN = new LinkedList<>();
        List<Integer> listM = new LinkedList<>();
        List<Integer> result = new LinkedList<>();

        for (int i = 0; i < n + m; i++) {
            if (i < n) {
                listN.add(Integer.parseInt(scanner.nextLine()));
            } else {
                listM.add(Integer.parseInt(scanner.nextLine()));
            }
        }

        for (int i = 0; i < listM.size(); i++) {
            if (listN.contains(listM.get(i))) {
                result.add(listN.get(i));
            }
        }

        result.forEach(x -> System.out.printf("%d ", x));
    }
}
