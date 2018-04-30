import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompareCharArrays {
    public static void main(String[] args) throws IOException{

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String [] firstArray = console.readLine().trim().split(" ");
         String [] secondArray = console.readLine().trim().split(" ");

        StringBuilder firstString = new StringBuilder();
        StringBuilder secondString = new StringBuilder();

        for (int i = 0; i < firstArray.length; i++)
        {
            firstString.append(firstArray[i]);
        }
        for (int i = 0; i < secondArray.length; i++)
        {
            secondString.append(secondArray[i]);
        }

        ArrayList<String> result = new ArrayList<>();
        result.add(firstString.toString());
        result.add(secondString.toString());
        Collections.sort(result);

        for (String x:
             result) {
            System.out.println(x);
        }

    }
}
