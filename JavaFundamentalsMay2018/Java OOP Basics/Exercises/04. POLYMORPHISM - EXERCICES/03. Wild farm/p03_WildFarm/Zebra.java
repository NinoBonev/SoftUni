package p03_WildFarm;

/**
 * Created by Nino Bonev - 26.6.2018 г., 11:07
 */
public class Zebra extends Mammal {
    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    protected String makeSound() {
        return "Zs";
    }

    @Override
    protected void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Meat")){
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
        super.eat(food);
    }
}
