import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Entertrain {
    public static void main(String[] args) throws IOException{

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int locomotivPower = Integer.parseInt(console.readLine());
        List<Integer> wagonsWeight = new ArrayList<>();

        String line;
        while (!"All ofboard!".equals(line = console.readLine()))
        {
            if (wagonsWeight.stream().mapToInt(Integer::intValue).sum() + Integer.parseInt(line)<= locomotivPower)
            {
                int newWagon = Integer.parseInt(line);
                wagonsWeight.add(newWagon);
            }
            else if (wagonsWeight.stream().mapToInt(Integer::intValue).sum() + Integer.parseInt(line) > locomotivPower)
            {
                int newWagon = Integer.parseInt(line);
                wagonsWeight.add(newWagon);

                int wagonSum = wagonsWeight.stream().mapToInt(Integer::intValue).sum();
                int avarage = (int)wagonSum / wagonsWeight.size();

                int closestDifference = Integer.MAX_VALUE;
                int wangonIndex = 0;

                for (int i = 0; i < wagonsWeight.size(); i++)
                {
                    if (Math.abs(avarage - wagonsWeight.get(i)) < closestDifference)
                    {
                        int currentDifference = Math.abs(avarage - wagonsWeight.get(i));
                        closestDifference = currentDifference;
                        wangonIndex = i;
                    }
                }

                wagonsWeight.remove(wangonIndex);
            }
        }

        wagonsWeight.add(0, locomotivPower);
        Collections.reverse(wagonsWeight);
        String listString = wagonsWeight.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
        System.out.println(listString);
    }
}