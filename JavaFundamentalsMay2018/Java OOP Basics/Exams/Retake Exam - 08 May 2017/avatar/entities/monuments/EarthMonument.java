package entities.monuments;

/**
 * Created by Nino Bonev - 31.7.2018 г., 18:49
 */
public class EarthMonument extends Monument{
    private int earthAffinity;

    public EarthMonument(String name, int earthAffinity) {
        super(name);
        this.earthAffinity = earthAffinity;
    }

    @Override
    public String toString() {
        return String.format("Earth Monument: %s, Earth Affinity: %d\n", this.getName(), this.earthAffinity);
    }

    @Override
    public int getAffinity() {
        return this.earthAffinity;
    }
}
