package factories;

import entities.benders.*;

/**
 * Created by Nino Bonev - 31.7.2018 г., 22:04
 */
public class BenderFactory {

    public BenderFactory() {
    }

    public static Bender createBender(String type, String name, long power, double secondaryParameter) {
        switch (type) {
            case "Air":
                return new AirBender(name, power, secondaryParameter);
            case "Water":
                return new WaterBender(name, power, secondaryParameter);
            case "Fire":
                return new FireBender(name, power, secondaryParameter);
            case "Earth":
                return new EarthBender(name, power, secondaryParameter);
            default:
                return null;
        }
    }
}
