package entities.monuments;

/**
 * Created by Nino Bonev - 31.7.2018 г., 18:49
 */
public class WaterMonument extends Monument{
    private int waterAffinity;

    public WaterMonument(String name, int waterAffinity) {
        super(name);
        this.waterAffinity = waterAffinity;
    }

    @Override
    public String toString() {
        return String.format("Water Monument: %s, Water Affinity: %d\n", this.getName(), this.waterAffinity);
    }

    @Override
    public int getAffinity() {
        return this.waterAffinity;
    }
}
