package entities.benders;

/**
 * Created by Nino Bonev - 31.7.2018 г., 18:48
 */
public class FireBender extends Bender{
    private double heatAggression;

    public FireBender(String name, long power, double heatAggression) {
        super(name, power);
        this.heatAggression = heatAggression;
    }

    public double getHeatAggression() {
        return heatAggression;
    }

    @Override
    public double getTotalPower() {
        return super.getPower() * this.heatAggression;
    }

    @Override
    public String toString() {
        return String.format("Fire Bender: %s, Power: %d, Heat Aggression: %.2f\n", this.getName(), this.getPower(), this.getHeatAggression());
    }
}
