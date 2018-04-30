import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SieveOfEratosthenes {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(console.readLine());
        for (int num = 2; num <= m; num++) {
            boolean prime = true;
            int divider = 2;
            int maxDivider = (int) Math.sqrt(num);
            while (divider <= maxDivider) {
                if (num % divider == 0) {
                    prime = false;
                    break;
                }
                divider++;
            }
            if (prime) {
                System.out.printf("%d ", num);
            }
        }

    }
}
