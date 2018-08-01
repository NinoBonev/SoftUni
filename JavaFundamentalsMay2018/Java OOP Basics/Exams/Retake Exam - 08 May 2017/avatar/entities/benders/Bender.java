package entities.benders;

/**
 * Created by Nino Bonev - 31.7.2018 г., 18:47
 */
public abstract class Bender {
    private String name;
    private long power;

    Bender(String name, long power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public long getPower() {
        return power;
    }

    public abstract double getTotalPower();
}
