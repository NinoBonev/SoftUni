package entities.monuments;

/**
 * Created by Nino Bonev - 31.7.2018 г., 18:49
 */
public class FireMonument extends Monument {
    private int fireAffinity;

    public FireMonument(String name, int fireAffinity) {
        super(name);
        this.fireAffinity = fireAffinity;
    }

    @Override
    public String toString() {
        return String.format("Fire Monument: %s, Fire Affinity: %d\n", this.getName(), this.fireAffinity);
    }

    @Override
    public int getAffinity() {
        return this.fireAffinity;
    }
}
