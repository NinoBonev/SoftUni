package p07_Food_Shortage;

/**
 * Created by Nino Bonev - 30.6.2018 г., 9:46
 */
public class Rebel implements Buyer{
    private String name;
    private Integer age;
    private String group;
    private Integer food;

    public Rebel(String name, Integer age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.food = 0;
    }

    @Override
    public Integer Food() {
        return this.food;
    }

    @Override
    public void buyFood() {
        this.food += 5;
    }
}
