package centers;

import animals.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 18.7.2018 г., 21:26
 */
public class AdoptionCenter extends Center {
    private List<Animal> animals;

    public AdoptionCenter(String name) {
        super(name);
        this.animals = new ArrayList<>();
    }

    public List<Animal> getAnimals() {
        return this.animals;
    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }

    public List<Animal> cleanse() {
         List<Animal> animalToCleanse = this.getAnimals().stream()
                .filter(x -> !x.isCleansingStatus()).collect(Collectors.toList());
         return animalToCleanse;
    }

    public long getAnimalsForAdoptionCount(){
        return this.animals.stream().filter(Animal::isCleansingStatus).count();
    }

    public void adopt(Animal animal){
        this.getAnimals().remove(animal);
    }
}
