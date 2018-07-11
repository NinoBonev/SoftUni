package p05_SpeedRacing;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 19.6.2018 г., 12:42
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = new LinkedList<>();

        Integer count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            String[] carInfo = scanner.nextLine().split(" ");
            String carModel = carInfo[0];
            double fuelAmount = Double.parseDouble(carInfo[1]);
            double fuelCostFor1km = Double.parseDouble(carInfo[2]);
            Car car = new Car(carModel, fuelAmount, fuelCostFor1km);
            cars.add(car);
        }

        String line;
        while (!"End".equals(line = scanner.nextLine())){
            String[] command = line.split(" ");
            String carModel = command[1];
            Integer distance = Integer.parseInt(command[2]);
            cars.stream().filter(x -> x.getModel().equals(carModel)).forEach(y -> y.calculateTravel(distance));
        }

        cars.forEach(System.out::println);
    }
}
