package animals;


/**
 * Created by Nino Bonev - 18.7.2018 г., 21:27
 */
public class Cat extends Animal {
    private int intelligenceCoefficient;

    public Cat(String name, int age, int intelligenceCoefficient) {
        super(name, age);
        this.intelligenceCoefficient = intelligenceCoefficient;
    }

    public int getIntelligenceCoefficient() {
        return intelligenceCoefficient;
    }
}
