import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class HornetAssault {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<Long> beehives = Arrays.stream(console.readLine().split(" ")).map(Long::parseLong).collect(Collectors.toList());
        List<Long> hornets = Arrays.stream(console.readLine().split(" ")).map(Long::parseLong).collect(Collectors.toList());

        long hornetsSumPower = hornets.stream().reduce(0L, (x, y) -> x + y );

        for (int i = 0; i < beehives.size(); i++)
        {
            if (beehives.get(i) >= hornetsSumPower && hornets.size() > 0)
            {
                beehives.set(i, beehives.get(i) - hornetsSumPower);
                hornetsSumPower -= hornets.get(0);
                hornets.remove(0);
            }
            else
            {
                if (hornets.size() > 0)
                {
                    beehives.set(i, 0L);
                }
            }
        }

        if (beehives.stream().reduce(0L, (x, y) -> x + y) > 0)
        {
            beehives.stream().filter(x -> x > 0).forEach(x -> System.out.printf("%s ", x));
        }
        else
        {
            String actual = hornets.stream().map(i -> i.toString()).reduce((t, u) -> t + " " + u).get();
            System.out.println(actual);
        }
    }
}