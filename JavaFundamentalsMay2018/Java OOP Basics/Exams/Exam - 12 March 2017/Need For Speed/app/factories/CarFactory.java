package app.factories;

import app.entities.cars.Car;
import app.entities.cars.PerformanceCar;
import app.entities.cars.ShowCar;

/**
 * Created by Nino Bonev - 14.7.2018 г., 10:30
 */
public final class CarFactory {

    private CarFactory() {
    }

    public static Car createCar(String type, String brand, String model, int yearOfProduction,
                                int horsepower, int acceleration, int suspension, int durability) {
        Car newCar = null;

        switch (type) {
            case "Performance":
                newCar = new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                break;
            case "Show":
                newCar = new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                break;
        }
        return newCar;
    }

}
