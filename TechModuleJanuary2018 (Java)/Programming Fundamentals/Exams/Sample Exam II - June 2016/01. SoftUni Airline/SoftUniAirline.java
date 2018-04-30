import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class SoftUniAirline {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Integer flightsCount = Integer.parseInt(console.readLine());
        BigDecimal flightCountDecimal = new BigDecimal(flightsCount);

        BigDecimal totalProfit = new BigDecimal(0);

        for (int i = 0; i < flightsCount; i++) {
            Integer adultPassengersCount = Integer.parseInt(console.readLine());
            Double adultTicketPrice = Double.parseDouble(console.readLine());
            Integer youngPassengersCount = Integer.parseInt(console.readLine());
            Double youngTicketPrice = Double.parseDouble(console.readLine());
            Double fuelPrice = Double.parseDouble(console.readLine());
            Double fuelConsumption = Double.parseDouble(console.readLine());
            Integer flightDuration = Integer.parseInt(console.readLine());

            BigDecimal currentIncome = new BigDecimal(adultPassengersCount * adultTicketPrice + youngPassengersCount * youngTicketPrice);
            BigDecimal currentFlightExpenses = new BigDecimal(fuelConsumption * fuelPrice * flightDuration);
            BigDecimal currentProfit = currentIncome.subtract(currentFlightExpenses);
            totalProfit = totalProfit.add(currentProfit);

            if (currentProfit.compareTo(BigDecimal.ZERO) == 1) {
                System.out.printf("You are ahead with %.3f$.%n", currentProfit);
            } else {
                System.out.printf("We’ve got to sell more tickets! We’ve lost %.3f$.%n", currentProfit);
            }

        }

        System.out.printf("Overall profit -> %.3f$.%n", totalProfit);
        System.out.printf("Average profit -> %.3f$.%n", totalProfit.divide(flightCountDecimal));

    }
}
