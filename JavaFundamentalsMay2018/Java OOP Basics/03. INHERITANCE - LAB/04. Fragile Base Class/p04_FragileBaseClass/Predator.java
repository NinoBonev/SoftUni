package p04_FragileBaseClass;

/**
 * Created by Nino Bonev - 23.6.2018 г., 10:48
 */
public class Predator extends Animal {
    private int health;

    public void feed(Food food){
        super.eat(food);
        health++;
    }
}
