package p03_WildFarm;

/**
 * Created by Nino Bonev - 26.6.2018 г., 10:27
 */
public abstract class Mammal extends Animal{
    private String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten);
        this.livingRegion = livingRegion;
    }
}
