package p03_WildFarm;

import java.text.DecimalFormat;

/**
 * Created by Nino Bonev - 26.6.2018 г., 11:18
 */
public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    protected String makeSound() {
        return "Meowwww";
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]",
                this.getAnimalType(),
                this.getAnimalName(),
                this.breed,
                df.format(this.getAnimalWeight()).replace(",", "."),
                this.getLivingRegion(),
                this.getFoodEaten());
    }
}
