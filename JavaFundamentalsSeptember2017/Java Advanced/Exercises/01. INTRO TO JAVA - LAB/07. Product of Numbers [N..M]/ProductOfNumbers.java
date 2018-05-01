import java.math.BigInteger;
import java.util.Scanner;

public class ProductOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer N = scanner.nextInt();
        Integer M = scanner.nextInt();
        BigInteger product = BigInteger.ONE;

        for (int i = N; i <= M; i++) {
            BigInteger current = BigInteger.valueOf(i);
            product = product.multiply(current);
        }

        System.out.printf("product[%d..%d] = %d", N, M, product);
    }
}
