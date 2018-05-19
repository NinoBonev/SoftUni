import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 1.5.2018 г., 16:09
 */
public class VehiclePark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] vehicles = scanner.nextLine().split(" ");
        Integer vehiclesSold = 0;

        String line;
        while (!"End of customers!".equals(line = scanner.nextLine()))
        {
            String type = line.split(" ")[0];
            Integer seats = Integer.parseInt(line.split(" ")[2]);
            boolean hasVehicle = false;

            for (int i = 0; i < vehicles.length; i++) {
                if (vehicles[i].charAt(0) == type.toLowerCase().charAt(0)){
                    if (Integer.parseInt(vehicles[i].substring(1, vehicles[i].length())) == seats)
                    {
                        hasVehicle = true;
                        Integer price = (int)vehicles[i].charAt(0) * seats;
                        System.out.printf("Yes, sold for %d$%n", price);
                        vehicles[i] = "sold";
                        vehiclesSold++;
                        break;
                    }
                }
            }

            if (!hasVehicle){
                System.out.println("No");
            }
        }

        String[] vehiclesLeft = Arrays.stream(vehicles).filter(x -> !x.equals("sold")).toArray(String[]::new);
        String result = String.join(", ", vehiclesLeft);
        System.out.printf("Vehicles left: %s%n", result);
        System.out.printf("Vehicles sold: %d", vehiclesSold);
    }
}
