import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class MaxSequenceOfIncreasingElements {
    public static void main(String[] args) throws IOException{

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int [] array = Arrays.stream(console.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int longestSeqLength = 1;
        int longestSeqStart = 0;
        int currentSeqLength = 1;
        int currentSeqStart = 0;

        for(int i = 1; i< array.length; i++)
        {
            if(array[i] > array[i-1])
            {
                currentSeqLength++;

                if(currentSeqLength>longestSeqLength)
                {
                    longestSeqLength = currentSeqLength;
                    longestSeqStart = currentSeqStart;
                }
            }
            else
            {
                currentSeqLength = 1;
                currentSeqStart = i;
            }
        }

        for(int i=longestSeqStart; i<longestSeqStart+longestSeqLength; i++)
        {
            System.out.print(array[i] + " ");
        }
    }
}
