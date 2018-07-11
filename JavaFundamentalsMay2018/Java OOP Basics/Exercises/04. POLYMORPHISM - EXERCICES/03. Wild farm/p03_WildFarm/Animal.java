package p03_WildFarm;

/**
 * Created by Nino Bonev - 26.6.2018 г., 10:27
 */
public abstract class Animal {
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;

    public Animal(String animalName, String animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    protected String getAnimalName() {
        return animalName;
    }

    protected String getAnimalType() {
        return animalType;
    }

    protected Double getAnimalWeight() {
        return animalWeight;
    }

    protected Integer getFoodEaten() {
        return foodEaten;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    protected abstract String makeSound();

    protected void eat(Food food){
        this.foodEaten += food.getQuantity();
    }
}
