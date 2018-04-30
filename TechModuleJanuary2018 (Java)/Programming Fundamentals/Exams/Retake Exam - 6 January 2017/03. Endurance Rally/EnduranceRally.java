import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class EnduranceRally {
    public static void main(String[] args) throws IOException{

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<String> drivers = Arrays
                .asList(console.readLine()
                        .split(" "));

        List<Double> trackLayout = Arrays
                .stream(console.readLine()
                        .split(" "))
                .map(Double::valueOf)
                .collect(Collectors.toList());

        List<Integer> checkPoints = Arrays
                .stream(console.readLine()
                        .split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        for (String driver:
             drivers) {

            //int startFuell = driver.charAt(0);
            double fuelLeft = driver.charAt(0);
            int pointReach = 0;

            for (int i = 0; i < trackLayout.size(); i++)
            {
                if (checkPoints.contains(i))
                {
                    fuelLeft += trackLayout.get(i);
                    pointReach++;
                }
                else
                {
                    if (fuelLeft - trackLayout.get(i) > 0)
                    {
                        fuelLeft -= trackLayout.get(i);
                        pointReach++;
                    }
                    else
                    {
                        pointReach = i;
                        System.out.printf("%s - reached %d%n", driver, pointReach);
                        break;
                    }
                }
            }
            if (pointReach == trackLayout.size())
            {
                System.out.printf("%s - fuel left %.2f%n", driver, fuelLeft);
            }
        }
    }
}
