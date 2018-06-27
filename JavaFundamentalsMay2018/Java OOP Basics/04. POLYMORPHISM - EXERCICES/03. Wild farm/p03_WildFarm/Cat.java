package p03_WildFarm;

/**
 * Created by Nino Bonev - 26.6.2018 г., 11:18
 */
public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
        this.breed = breed;
    }
}
