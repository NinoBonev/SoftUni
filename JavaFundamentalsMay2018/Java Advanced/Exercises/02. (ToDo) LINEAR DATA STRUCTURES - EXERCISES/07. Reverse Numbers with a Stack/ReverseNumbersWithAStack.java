import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 22.6.2018 г., 17:38
 */
public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < data.length; i++) {
            stack.push(data[i]);
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
