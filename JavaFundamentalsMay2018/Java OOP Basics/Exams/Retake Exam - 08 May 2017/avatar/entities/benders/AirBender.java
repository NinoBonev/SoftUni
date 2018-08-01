package entities.benders;

/**
 * Created by Nino Bonev - 31.7.2018 г., 18:48
 */
public class AirBender extends Bender {
    private double aerialIntegirty;
    public AirBender(String name, long power, double aerialIntegirty) {
        super(name, power);
        this.aerialIntegirty = aerialIntegirty;
    }

    public double getAerialIntegirty() {
        return aerialIntegirty;
    }

    @Override
    public double getTotalPower() {
        return super.getPower() * this.aerialIntegirty;
    }

    @Override
    public String toString() {
        return String.format("Air Bender: %s, Power: %d, Aerial Integrity: %.2f\n", this.getName(), this.getPower(), this.getAerialIntegirty());
    }
}
