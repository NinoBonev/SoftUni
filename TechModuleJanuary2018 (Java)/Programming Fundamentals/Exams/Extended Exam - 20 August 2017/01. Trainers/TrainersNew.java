import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;


public class TrainersNew {
    public static void main(String[] args) throws IOException{

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int participants = Integer.parseInt(console.readLine());
        Map<String, BigDecimal> result = new LinkedHashMap<>();


        for (int i = 0; i < participants; i++)
        {
            int distance = Integer.parseInt(console.readLine());
            long cargoWeight = Long.parseLong(console.readLine());
            String team = console.readLine();

            BigDecimal currentProfit = new BigDecimal((cargoWeight * 1000 * 1.5) - (0.7 * distance * 1600 * 2.5));

            if (team.equals("Technical"))
            {
                result.putIfAbsent("Technical", BigDecimal.ZERO);
                BigDecimal technicalCurrent = result.get("Technical");
                result.replace("Technical", technicalCurrent.add(currentProfit));
            }
            else if (team.equals("Theoretical"))
            {
                result.putIfAbsent("Theoretical", BigDecimal.ZERO);
                BigDecimal theoreticalCurrent = result.get("Theoretical");
                result.replace("Theoretical", theoreticalCurrent.add(currentProfit));
            }
            else if (team.equals("Practical"))
            {
                result.putIfAbsent("Practical", BigDecimal.ZERO);
                BigDecimal practicalCurrenr = result.get("Practical");
                result.replace("Practical", practicalCurrenr.add(currentProfit));
            }
        }

        result.entrySet().stream()
                .sorted((x, y) -> y.getValue().compareTo(x.getValue()))
                .limit(1)
                .forEachOrdered(z -> System.out.printf("The %s Trainers win with $%.3f.", z.getKey(), z.getValue()));
    }
}







