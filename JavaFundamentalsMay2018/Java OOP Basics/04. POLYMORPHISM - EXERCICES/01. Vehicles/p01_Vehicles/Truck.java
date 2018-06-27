package p01_Vehicles;

/**
 * Created by Nino Bonev - 26.6.2018 г., 9:03
 */
public class Truck implements Vehicle {
    double fuelQuantity;
    double fuelConsumption;

    public Truck(double fuelQuantity, double fuelConsumption) {
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
        this.fuelConsumption = 1.6 + fuelConsumption;
    }

    @Override
    public void drive(double distance) {
        if (this.getFuelConsumption() * distance > this.getFuelQuantity()){
            throw new IllegalArgumentException("Truck needs refueling");
        }
        this.fuelQuantity -= distance * this.getFuelConsumption();
    }

    @Override
    public void refuel(double quantity) {
        this.fuelQuantity += 0.95 * quantity;
    }

    @Override
    public double distanceTravelled(double distance) {
        return distance * this.getFuelConsumption();
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", this.getFuelQuantity()).replace(",", ".");
    }
}
