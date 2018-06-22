import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 22.6.2018 г., 16:51
 */
public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();

        Collections.addAll(stack, data);
        int sum = 0;
        while (stack.size() > 1){
            Integer firstNum = Integer.parseInt(stack.pop());
            String operand = stack.pop();
            Integer secondNum = Integer.parseInt(stack.pop());

            switch (operand){
                case "+" :
                    sum = firstNum + secondNum;
                    stack.push(sum + "");
                    break;
                case "-" :
                    sum = firstNum - secondNum;
                    stack.push(sum + "");
                    break;
            }
        }

        System.out.println(stack.pop());
    }
}
