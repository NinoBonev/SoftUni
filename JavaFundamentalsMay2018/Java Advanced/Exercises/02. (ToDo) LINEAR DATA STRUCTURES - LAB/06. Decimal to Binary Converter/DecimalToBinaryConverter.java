import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 22.6.2018 г., 17:09
 */
public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer decimalNum = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (decimalNum == 0){
            System.out.println(0);
        } else {
            while (decimalNum != 0){
                stack.push(decimalNum % 2);
                decimalNum /= 2;
            }
            while (!stack.isEmpty()){
                System.out.print(stack.pop());
            }
        }

    }
}
