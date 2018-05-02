import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 1.5.2018 г., 14:34
 */
public class FirstOddOrEvenElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] elements = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();
        Integer numberOfElements = Integer.parseInt(command.split(" ")[1]);
        String type = command.split(" ")[2];
        Integer count = 0;


        for (int i = 0; i < elements.length; i++) {
            if (elements[i] % 2 == 0 && type.equals("even") && count < numberOfElements) {
                System.out.print(elements[i] + " ");
                count++;
                if (i == elements.length - 1) {
                    count = numberOfElements;
                }
            } else if (elements[i] % 2 != 0 && type.equals("odd") && count < numberOfElements) {
                System.out.print(elements[i] + " ");
                count++;
                if (i == elements.length - 1) {
                    count = numberOfElements;
                }
            }
        }
    }
}
