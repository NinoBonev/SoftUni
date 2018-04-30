import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;


public class Trainers {
    public static void main(String[] args) throws IOException{

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int participants = Integer.parseInt(console.readLine());
        Map<String, BigDecimal> result = new TreeMap<>();
        BigDecimal Technical = new BigDecimal(0);
        BigDecimal Theoretical = new BigDecimal(0);
        BigDecimal Practical = new BigDecimal(0);

        for (int i = 0; i < participants; i++)
        {
            int distance = Integer.parseInt(console.readLine());
            double cargoWeight = Double.parseDouble(console.readLine());
            String team = console.readLine();

            BigDecimal currentProfit = new BigDecimal((cargoWeight * 1000 * 1.5) - (0.7 * distance * 1600 * 2.5));

            if (team.equals("Technical"))
            {
                Technical = Technical.add(currentProfit);
            }
            else if (team.equals("Theoretical"))
            {
                Theoretical = Theoretical.add(currentProfit);
            }
            else if (team.equals("Practical"))
            {
                Practical = Practical.add(currentProfit);
            }
        }

        BigDecimal winning1 = Technical.max(Theoretical);
        BigDecimal winnigFinal = winning1.max(Practical);

        if (winnigFinal.equals(Theoretical))
        {
            System.out.printf("The Theoretical Trainers win with $%.3f.", winnigFinal);
        }
        else if (winnigFinal.equals(Technical))
        {
            System.out.printf("The Technical Trainers win with $%.3f.", winnigFinal);
        }
        else if (winnigFinal.equals(Practical))
        {
            System.out.printf("The Practical Trainers win with $%.3f.", winnigFinal);
        }
    }
}