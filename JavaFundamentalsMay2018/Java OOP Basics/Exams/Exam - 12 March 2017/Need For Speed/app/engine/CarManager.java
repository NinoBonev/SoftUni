package app.engine;

import app.entities.Garage;
import app.entities.cars.Car;
import app.entities.cars.ShowCar;
import app.entities.races.Race;
import app.factories.CarFactory;
import app.factories.RaceFactory;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Nino Bonev - 14.7.2018 г., 9:42
 */
public class CarManager {
    private Map<Integer, Car> cars;
    private Map<Integer, Race> races;

    private Garage garage;

    public CarManager() {
        this.cars = new LinkedHashMap<>();
        this.races = new LinkedHashMap<>();
        this.garage = new Garage();
    }

    public void register(int id, String type, String brand, String model, int yearOfProduction,
                         int horsepower, int acceleration, int suspension, int durability) {
        Car resultCar = CarFactory.createCar(type, brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.cars.put(id, resultCar);
    }

    public String check(int id) {
        Car car = this.cars.get(id);

        return car.toString();
    }

    public void open(int id, String type, int length, String route, int prizePool) {
        Race race = RaceFactory.openRace(type, length, route, prizePool);
        this.races.put(id, race);
    }

    public void participate(int carId, int raceId) {
        Car car = this.cars.get(carId);
        if (!this.garage.parkedCars().contains(car)) {
            this.races.get(raceId).addParticipants(this.cars.get(carId));
        }
    }

    public String start(int id) {
        String result = "";

        if (this.races.get(id).getParticipants().size() > 0) {
            Race currentRace = this.races.remove(id);
            result = currentRace.toString();
        } else {
            result = "Cannot start the race with zero participants.";
        }

        return result;
    }

    public void park(int id) {
        boolean isNotParticipating = true;
        for (Race race : this.races.values()) {
            if (race.getParticipants().contains(this.cars.get(id))) {
                isNotParticipating = false;
            }
        }
        if (isNotParticipating) {
            this.garage.addParkedCar(this.cars.get(id));
        }
    }

    public void unpark(int id) {
        if (this.garage.parkedCars().contains(this.cars.get(id))) {
            this.garage.unparkCar(this.cars.get(id));
        }
    }

    public void tune(int tuneIndex, String addOn) {
        if (this.garage.parkedCars().size() > 0) {
            for (Car car :
                    this.garage.parkedCars()) {
                car.tune(tuneIndex, addOn);
            }
        }
    }
}
