package p02_VehiclesExtension;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 26.6.2018 г., 9:02
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split(" ");
        String[] truckInfo = scanner.nextLine().split(" ");
        String[] busInfo = scanner.nextLine().split(" ");


        Car car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]), Double.parseDouble(carInfo[3]));
        Truck truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]), Double.parseDouble(truckInfo[3]));
        Bus bus = new Bus(Double.parseDouble(busInfo[1]), Double.parseDouble(busInfo[2]), Double.parseDouble(busInfo[3]));
        DecimalFormat decimalFormat = new DecimalFormat("0.##");

        Integer count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            String[] command = scanner.nextLine().split(" ");
            String vehicle = command[1];
            Double amount = Double.parseDouble(command[2]);
            try {
            switch (command[0]) {
                case "Drive":
                    switch (vehicle) {
                        case "Car":
                            car.drive(amount);
                            System.out.printf("Car travelled %s km%n", decimalFormat.format(amount).replace(",", "."));
                            break;
                        case "Truck":
                            truck.drive(amount);
                            System.out.printf("Truck travelled %s km%n", decimalFormat.format(amount).replace(",", "."));
                            break;
                        case "Bus":
                            bus.drive(amount);
                            System.out.printf("Bus travelled %s km%n", decimalFormat.format(amount).replace(",", "."));
                    }
                    break;
                case "Refuel":
                    switch (vehicle) {
                        case "Car":
                            car.refuel(amount);
                            break;
                        case "Truck":
                            truck.refuel(amount);
                            break;
                        case "Bus":
                            bus.refuel(amount);
                            break;
                    }
                    break;
                case "DriveEmpty" :
                    bus.driveEmpty(amount);
                    break;
            }
            } catch (IllegalArgumentException exp){
                System.out.println(exp.getMessage());
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
