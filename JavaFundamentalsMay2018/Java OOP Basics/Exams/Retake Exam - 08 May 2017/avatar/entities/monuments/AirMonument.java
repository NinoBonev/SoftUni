package entities.monuments;

/**
 * Created by Nino Bonev - 31.7.2018 г., 18:49
 */
public class AirMonument extends Monument {
    private int airAffinity;

    public AirMonument(String name, int airAffinity) {
        super(name);
        this.airAffinity= airAffinity;
    }

    @Override
    public String toString() {
        return String.format("Air Monument: %s, Air Affinity: %d\n", this.getName(), this.airAffinity);
    }

    @Override
    public int getAffinity() {
        return this.airAffinity;
    }
}
