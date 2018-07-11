package p04_MordorsCrueltyPlan;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nino Bonev - 23.6.2018 г., 12:55
 */
public class Gandalf {
    private String mood;
    private int happiness;
    private String[] foodsEaten;
    private Map<String, Integer> foods = new HashMap<>();

    public Gandalf(String[] foodsEaten) {
        this.setFoods();
        this.setFoodsEaten(foodsEaten);
        this.setHappiness();
        this.setMood();
    }

    public String[] getFoodsEaten() {
        return foodsEaten;
    }

    private void setFoodsEaten(String[] foodsEaten) {
        this.foodsEaten = foodsEaten;
    }

    public String getMood() {
        return mood;
    }

    private void setMood() {
        if(this.happiness < -5){
            this.mood = "Angry";
        }else if(this.happiness <= 0){
            this.mood = "Sad";
        }else if(this.happiness <= 15){
            this.mood = "Happy";
        }else{
            this.mood = "JavaScript";
        }
    }

    public int getHappiness() {
        return happiness;
    }

    private void setHappiness() {
        for (int i = 0; i < foodsEaten.length; i++){
            if(foods.containsKey(foodsEaten[i])){
                this.happiness += foods.get(foodsEaten[i]);
            }else{
                this.happiness--;
            }
        }
    }

    public Map<String, Integer> getFoods() {
        return foods;
    }

    private void setFoods() {
        this.foods.put("cram", 2);
        this.foods.put("lembas", 3);
        this.foods.put("apple", 1);
        this.foods.put("melon", 1);
        this.foods.put("honeycake", 5);
        this.foods.put("mushrooms", -10);
    }
}
