package p06_Animals;

/**
 * Created by Nino Bonev - 24.6.2018 г., 10:39
 */
public class Dog extends Animal {

    public Dog() {
    }

    public Dog(String name, double age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected String produceSound() {
        return "BauBau";
    }
}
