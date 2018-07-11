package p03_Ferrari;

import java.util.Scanner;

/**
 * Created by Nino Bonev - 29.6.2018 г., 12:56
 */
public class Ferrari implements Car{
    private String driverName;

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String model() {
        return "488-Spider";
    }

    @Override
    public String driver() {
        return this.driverName;
    }

    @Override
    public String useBreaks() {
        return "Brakes!";
    }

    @Override
    public String pushGas() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", this.model(), this.useBreaks(), this.pushGas(), this.driverName);
    }
}
