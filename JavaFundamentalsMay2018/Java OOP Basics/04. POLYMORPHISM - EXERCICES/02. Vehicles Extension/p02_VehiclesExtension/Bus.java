package p02_VehiclesExtension;

/**
 * Created by Nino Bonev - 26.6.2018 г., 10:03
 */
public class Bus implements Vehicle{
    double fuelQuantity;
    double fuelConsumption;
    double tankCapacity;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
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
        this.fuelConsumption = fuelConsumption;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public void driveEmpty(double distance){
        if (this.getFuelConsumption() * distance > this.getFuelQuantity()){
            throw new IllegalArgumentException("Bus needs refueling");
        }
        this.fuelQuantity -= distance * this.getFuelConsumption();
    }

    @Override
    public void drive(double distance) {
        if ((this.getFuelConsumption() + 1.4) * distance > this.getFuelQuantity()){
            throw new IllegalArgumentException("Bus needs refueling");
        }
        this.fuelQuantity -= distance * (this.getFuelConsumption() + 1.4);
    }

    @Override
    public void refuel(double quantity) {
        if (quantity <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (this.getFuelQuantity() + quantity > this.getTankCapacity()){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += quantity;
    }

    @Override
    public String toString() {
        return String.format("Bus: %.2f", this.getFuelQuantity()).replace(",", ".");
    }
}
