import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Rainer {
    public static void main(String[] args) throws IOException{

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int[] data = Arrays.stream(console.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Integer index = data[data.length - 1];
        int[] field = Arrays.stream(data).limit(data.length - 1).toArray();
        int steps = 0;

        while (true)
        {
            int[] reduced = Arrays.stream(field).map(x -> x - 1).toArray();

            if (reduced[index] == 0)
            {
                field = reduced;
                break;
            }
            else
            {
                steps++;
                for (int i = 0; i < reduced.length; i++)
                {
                    if (reduced[i] == 0)
                    {
                        reduced[i] = data[i];
                    }
                }
                field = reduced;
            }

            index = Integer.parseInt(console.readLine());
        }

        Arrays.stream(field).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        System.out.println(steps);

    }
}
