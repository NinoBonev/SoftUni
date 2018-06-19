package p11_CatLady;

/**
 * Created by Nino Bonev - 19.6.2018 г., 11:33
 */
public class Siamese {
    private String name;
    private double earSize;

    public Siamese() {
    }

    public Siamese(String name, double earSize) {
        this.name = name;
        this.earSize = earSize;
    }

    public String getName() {
        return name;
    }

    public double getEarSize() {
        return earSize;
    }
}
