package p03_WildFarm;

/**
 * Created by Nino Bonev - 26.6.2018 г., 10:32
 */
public class Mouse extends Mammal{
    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    protected String makeSound() {
        return "SQUEEEAAAK!";
    }

    @Override
    protected void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Meat")){
            throw new IllegalArgumentException("Mice are not eating that type of food!");
        }
        super.eat(food);
    }
}
