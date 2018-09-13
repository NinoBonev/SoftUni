import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 13.9.2018 г., 12:28
 */
public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        System.out.println(CalcFactorial(num));
    }

    private static BigInteger CalcFactorial(int num){
        if (num == 0){
            return BigInteger.valueOf(1);
        }

        return BigInteger.valueOf(num).multiply(CalcFactorial(num - 1));
    }
}
