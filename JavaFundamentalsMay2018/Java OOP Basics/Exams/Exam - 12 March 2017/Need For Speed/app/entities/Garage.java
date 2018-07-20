package app.entities;

import app.entities.cars.Car;

import java.util.*;

/**
 * Created by Nino Bonev - 14.7.2018 г., 8:53
 */
public class Garage {
    private List<Car> parkedCars;

    public Garage() {
        this.parkedCars = new LinkedList<>();
    }

    public List<Car> parkedCars () {
        return this.parkedCars;
    }

    public void addParkedCar(Car car) {
        this.parkedCars.add(car);
    }

    public void unparkCar(Car car){
        this.parkedCars.remove(car);
    }
}
