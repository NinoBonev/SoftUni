package p11_CatLady;

/**
 * Created by Nino Bonev - 19.6.2018 г., 11:35
 */
public class StreetExtraordinaire {
    private String name;
    private double decibelsOfMeows;

    public StreetExtraordinaire() {
    }

    public StreetExtraordinaire(String name, double decibelsOfMeows) {
        this.name = name;
        this.decibelsOfMeows = decibelsOfMeows;
    }

    public String getName() {
        return name;
    }

    public double getDecibelsOfMeows() {
        return decibelsOfMeows;
    }
}
