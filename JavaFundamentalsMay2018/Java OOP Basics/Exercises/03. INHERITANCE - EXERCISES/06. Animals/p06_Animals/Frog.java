package p06_Animals;

/**
 * Created by Nino Bonev - 24.6.2018 г., 10:39
 */
public class Frog extends Animal {
    public Frog() {
    }

    public Frog(String name, double age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected String produceSound() {
        return "Frogggg";
    }
}
