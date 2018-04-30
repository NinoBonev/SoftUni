import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RotateAndSum {
    public static void main(String[] args) throws IOException{

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int [] array = Arrays.stream(console.readLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rotate = Integer.parseInt(console.readLine());

        int [] resultArray = new int[array.length];

        for (int i = 0; i < rotate; i++)
        {
            int [] tempArray = new int[array.length];
            for (int j = 0; j < array.length; j++)
            {
                tempArray[j] = array[(j - 1 + array.length) % array.length];
            }

            for (int k = 0; k < array.length; k++)
            {
                resultArray[k] += tempArray[k];
            }
            array = tempArray;
        }

        for (Integer n:
             resultArray) {

            System.out.printf("%d ", n);
        }
    }
}
