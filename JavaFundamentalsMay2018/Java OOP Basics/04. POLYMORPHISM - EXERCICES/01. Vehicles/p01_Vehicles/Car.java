package p01_Vehicles;

/**
 * Created by Nino Bonev - 26.6.2018 г., 9:03
 */
public class Car implements Vehicle {
    double fuelQuantity;
    double fuelConsumption;

    public Car(double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = 0.9 + fuelConsumption;
    }

    @Override
    public void drive(double distance) {
        if (this.getFuelConsumption() * distance > this.getFuelQuantity()){
            throw new IllegalArgumentException("Car needs refueling");
        }
        this.fuelQuantity -= distance * this.getFuelConsumption();
    }

    @Override
    public void refuel(double quantity) {
        this.fuelQuantity += quantity;
    }

    @Override
    public double distanceTravelled(double distance) {
        return distance * this.getFuelConsumption();
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", this.getFuelQuantity()).replace(",", ".");
    }
}
