package entities.benders;

/**
 * Created by Nino Bonev - 31.7.2018 г., 18:48
 */
public class WaterBender extends Bender{
    private double waterClarity;

    public WaterBender(String name, long power, double waterClarity) {
        super(name, power);
        this.waterClarity = waterClarity;
    }

    public double getWaterClarity() {
        return waterClarity;
    }

    @Override
    public double getTotalPower() {
        return super.getPower() * this.waterClarity;
    }

    @Override
    public String toString() {
        return String.format("Water Bender: %s, Power: %d, Water Clarity: %.2f\n", this.getName(), this.getPower(), this.getWaterClarity());
    }
}
