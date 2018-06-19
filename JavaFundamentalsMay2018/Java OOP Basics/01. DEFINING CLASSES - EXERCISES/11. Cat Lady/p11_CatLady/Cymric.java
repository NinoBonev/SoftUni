package p11_CatLady;

/**
 * Created by Nino Bonev - 19.6.2018 г., 11:34
 */
public class Cymric {
    private String name;
    private double furLength;

    public Cymric() {
    }

    public Cymric(String name, double furLength) {
        this.name = name;
        this.furLength = furLength;
    }

    public String getName() {
        return name;
    }

    public double getFurLength() {
        return furLength;
    }
}
