package p06_RawData;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 16.6.2018 г., 9:46
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer dataCount = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < dataCount; i++) {
            String[] rawData = scanner.nextLine().split(" ");
            //“<Model> <EngineSpeed> <EnginePower> <CargoWeight> <CargoType>
            // <Tire1Pressure> <Tire1Age> <Tire2Pressure> <Tire2Age> <Tire3Pressure> <Tire3Age> <Tire4Pressure> <Tire4Age>
            String model = rawData[0];
            int engineSpeed = Integer.parseInt(rawData[1]);
            int enginePower = Integer.parseInt(rawData[2]);
            int cargoWeight = Integer.parseInt(rawData[3]);
            String cargoType = rawData[4];
            double[] tiresPressure = new double[4];
            int[] tiresAge = new int[4];
            for (int j = 0; j < 4; j++) {
                tiresPressure[j] = Double.parseDouble(rawData[5 + j * 2]);
                tiresAge[j] = Integer.parseInt(rawData[6 + j * 2]);
            }

            Car car = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType, tiresPressure, tiresAge);
            cars.putIfAbsent(car.getModel(), car);
        }

        String command = scanner.nextLine();

        if (command.equals("flamable")){
            cars.entrySet().stream()
                    .filter(car ->
                            car.getValue().getEngine().getEnginePower() > 250)
                    .forEach(z -> System.out.println(z.getKey()));
        } else if (command.equals("fragile")){
            cars.entrySet().stream()
                    .filter(car ->
                    car.getValue().getTires().stream().anyMatch(x -> x.getTirePressure() < 1))
                    .forEach(z -> System.out.println(z.getKey()));
        }
    }
}
