package p06_RawData;

/**
 * Created by Nino Bonev - 16.6.2018 г., 9:51
 */
public class Tire {
    private double tirePressure;
    private double tireAge;

    public Tire() {
    }

    public Tire(double tirePressure, double tireAge) {
        this.tirePressure = tirePressure;
        this.tireAge = tireAge;
    }

    public double getTirePressure() {
        return tirePressure;
    }

    public void setTirePressure(double tirePressure) {
        this.tirePressure = tirePressure;
    }

    public double getTireAge() {
        return tireAge;
    }

    public void setTireAge(double tireAge) {
        this.tireAge = tireAge;
    }
}
