import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveDrawing {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(console.readLine());

        Print(number);
    }

    private static void Print(int n){

        if (n == 0){
            return;
        }

        System.out.println(new String(new char[n]).replace('\0', '*'));

        Print(n - 1);

        System.out.println(new String(new char[n]).replace('\0', '#'));
    }
}
