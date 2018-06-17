package p06_RawData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nino Bonev - 16.6.2018 г., 9:52
 */
public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    public Car() {
    }

    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType, double[] tiresPressure, int[] tiresAge) {
        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoWeight, cargoType);
        this.tires = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            this.tires.add(new Tire(tiresPressure[i], tiresAge[i]));
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Tire> getTires() {
        return tires;
    }

    public void setTires(List<Tire> tires) {
        this.tires = tires;
    }
}
