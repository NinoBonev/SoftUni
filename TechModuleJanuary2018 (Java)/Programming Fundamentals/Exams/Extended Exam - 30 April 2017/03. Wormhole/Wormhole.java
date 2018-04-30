import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Wormhole {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int [] data = Arrays.stream(console.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int steps = 0;

        for (int i = 0; i < data.length; i++){
            if (data[i] == 0){
                steps++;
            } else {
                int current = i;
                steps++;
                i = data[i];
                data[current] = 0;
            }
        }

        System.out.println(steps);
    }
}
