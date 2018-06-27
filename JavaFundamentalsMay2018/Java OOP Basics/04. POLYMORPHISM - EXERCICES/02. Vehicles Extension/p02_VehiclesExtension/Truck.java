package p02_VehiclesExtension;

/**
 * Created by Nino Bonev - 26.6.2018 г., 9:03
 */
public class Truck implements Vehicle {
    double fuelQuantity;
    double fuelConsumption;
    double tankCapacity;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
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
        if (quantity <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (this.getFuelQuantity() + 0.95 * quantity > this.getTankCapacity()){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += 0.95 * quantity;
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", this.getFuelQuantity()).replace(",", ".");
    }
}
