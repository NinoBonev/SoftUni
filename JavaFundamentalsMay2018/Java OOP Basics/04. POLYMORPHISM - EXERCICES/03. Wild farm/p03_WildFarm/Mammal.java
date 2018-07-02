package p03_WildFarm;

import java.text.DecimalFormat;

/**
 * Created by Nino Bonev - 26.6.2018 г., 10:27
 */
public abstract class Mammal extends Animal{
    private String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]",
                this.getAnimalType(),
                this.getAnimalName(), df.format(this.getAnimalWeight()).replace(",", "."),
                this.livingRegion,
                this.getFoodEaten());
    }
}
