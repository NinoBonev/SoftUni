package p04_FragileBaseClass;

import java.util.ArrayList;

/**
 * Created by Nino Bonev - 23.6.2018 г., 10:48
 */
public class Animal {
    protected ArrayList<Food> foodEaten;

    public Animal(){
        this.foodEaten = new ArrayList<>();
    }

    public final void eat(Food food){
        this.foodEaten.add(food);
    }

    public void eatAll(Food[] foods){
        for (Food food:
             foods) {
            eat(food);
        }
    }
}
