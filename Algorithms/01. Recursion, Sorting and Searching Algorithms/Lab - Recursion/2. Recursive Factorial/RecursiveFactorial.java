import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveFactorial {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int factorial = Integer.parseInt(console.readLine());

        System.out.println(Factorial(factorial));

    }

    private static int Factorial(int n) {

        if (n == 0){

            return 1;
        }

        return n * Factorial(n - 1);
    }
}
