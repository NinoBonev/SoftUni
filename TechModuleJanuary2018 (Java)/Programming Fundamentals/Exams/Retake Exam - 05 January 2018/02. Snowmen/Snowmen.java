import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Snowmen {
    public static void main(String[] args) throws IOException{

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> input = Arrays.stream(console.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        while (input.size() > 1)
        {
            List<Integer> current = new ArrayList<>(input);

            for (int i =0; i < input.size(); i++)
            {
                Integer attack = i;
                Integer target = input.get(i);

                if (target > input.size())
                {
                    target = target % input.get(i);
                }

                Integer absoluteValue = Math.abs(attack - target);

                if (attack == target)
                {
                current.remove(i);
                System.out.printf("%d performed harakiri%n", attack);
                }
                else if (absoluteValue % 2 == 0)
                {
                    System.out.printf("%d x %d -> %d wins%n", i, target, i);
                }
                else if (absoluteValue % 2 != 0)
                {
                    current.remove(i);
                    System.out.printf("%d x %d -> %d wins%n", target, i, target);
                }
            }

            input = current;
        }

    }
}
