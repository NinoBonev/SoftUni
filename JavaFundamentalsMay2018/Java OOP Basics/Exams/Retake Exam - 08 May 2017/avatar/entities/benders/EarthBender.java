package entities.benders;

/**
 * Created by Nino Bonev - 31.7.2018 г., 18:49
 */
public class EarthBender extends Bender{
    private double groundSaturation;

    public EarthBender(String name, long power, double groundSaturation) {
        super(name, power);
        this.groundSaturation = groundSaturation;
    }

    public double getGroundSaturation() {
        return groundSaturation;
    }

    @Override
    public double getTotalPower() {
        return super.getPower() * this.groundSaturation;
    }

    @Override
    public String toString() {
        return String.format("Earth Bender: %s, Power: %d, Ground Saturation: %.2f\n", this.getName(), this.getPower(), this.getGroundSaturation());
    }
}
