package p06_Animals;

/**
 * Created by Nino Bonev - 24.6.2018 г., 10:39
 */
public class Tomcat extends Cat {
    public Tomcat() {
    }

    public Tomcat(String name, double age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected String produceSound() {
        return "Give me one million b***h";
    }
}
