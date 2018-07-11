package p03_WildFarm;

/**
 * Created by Nino Bonev - 26.6.2018 г., 11:18
 */
public class Tiger extends Felime {
    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    protected String makeSound() {
        return "ROAAR!!!";
    }

    @Override
    protected void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Vegetable")){
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
        super.eat(food);
    }
}
