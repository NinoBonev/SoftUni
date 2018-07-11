package p03_WildFarm;

/**
 * Created by Nino Bonev - 26.6.2018 г., 11:18
 */
public class Felime extends Mammal {
    public Felime(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    protected String makeSound() {
        return null;
    }
}
