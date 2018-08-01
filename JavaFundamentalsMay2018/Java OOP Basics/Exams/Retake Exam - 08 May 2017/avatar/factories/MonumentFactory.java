package factories;

import entities.monuments.*;

/**
 * Created by Nino Bonev - 31.7.2018 г., 22:17
 */
public class MonumentFactory {

    public MonumentFactory() {
    }

    public static Monument createMonument(String type, String name, int affinity) {
        switch (type) {
            case "Air":
                return new AirMonument(name, affinity);
            case "Earth":
                return new EarthMonument(name, affinity);
            case "Fire":
                return new FireMonument(name, affinity);
            case "Water":
                return new WaterMonument(name, affinity);
            default:
                return null;
        }
    }
}
