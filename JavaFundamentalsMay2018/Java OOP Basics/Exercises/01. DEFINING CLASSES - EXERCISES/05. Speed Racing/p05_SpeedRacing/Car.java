package p05_SpeedRacing;

/**
 * Created by Nino Bonev - 19.6.2018 г., 12:44
 */
public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCost;
    private Integer distanceTraveled;

    public Car() {
    }

    public Car(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distanceTraveled = 0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public void setFuelCost(double fuelCost) {
        this.fuelCost = fuelCost;
    }

    public Integer getDistanceTraveled() {
        return this.distanceTraveled;
    }

    public void calculateTravel(Integer distance){
        if (this.fuelAmount / this.fuelCost >= distance){
            this.fuelAmount -= distance * this.fuelCost;
            this.distanceTraveled += distance;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.getModel(), this.getFuelAmount(), this.getDistanceTraveled()).replace(",", ".");
    }
}
