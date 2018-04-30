import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LargestCommonEnd {
    public static void main(String[] args) throws IOException{

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String [] firstLine = console.readLine().split("\\s+");
        String [] secondLine = console.readLine().split("\\s+");


        int smallerArray = Math.min(firstLine.length, secondLine.length);
        int equalLeft = 0;
        int equalRight = 0;

        for (int i = 0; i < smallerArray; i++)
        {
            if (firstLine[i].equals(secondLine[i]))
            {
                equalLeft++;
            }
            else
            {
                break;
            }
        }

        for (int j = 0; j < smallerArray; j++)
        {
           if (firstLine[firstLine.length - 1 - j].equals(secondLine[secondLine.length - 1 - j]))
            {
                equalRight++;
            }
            else
            {
                break;
            }
        }

        int maxCount = Math.max(equalLeft, equalRight);
        System.out.println(maxCount);

    }
}
