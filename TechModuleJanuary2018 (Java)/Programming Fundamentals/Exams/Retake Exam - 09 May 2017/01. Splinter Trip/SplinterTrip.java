import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class SplinterTrip {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Double tripDistance = Double.parseDouble(console.readLine());
        Double fuelTankCapacity = Double.parseDouble(console.readLine());
        BigDecimal tankCapacity = new BigDecimal(fuelTankCapacity);
        Double milesInHeavyWind = Double.parseDouble(console.readLine());

        BigDecimal fuelNeeded = new BigDecimal(1.05 * ((tripDistance - milesInHeavyWind) * 25 + milesInHeavyWind * 25 * 1.5));

        System.out.printf("Fuel needed: %.2fL%n", fuelNeeded);
        if (fuelNeeded.compareTo(tankCapacity) == -1 || fuelNeeded.compareTo(tankCapacity) == 0) {
            System.out.printf("Enough with %.2fL to spare!%n", tankCapacity.subtract(fuelNeeded));
        } else {
            System.out.printf("We need %.2fL more fuel.", fuelNeeded.subtract(tankCapacity));
        }
    }
}
