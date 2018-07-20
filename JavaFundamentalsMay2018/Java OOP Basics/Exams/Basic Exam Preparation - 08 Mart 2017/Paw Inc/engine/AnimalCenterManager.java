package engine;

import animals.Animal;
import animals.Cat;
import animals.Dog;
import centers.AdoptionCenter;
import centers.CleansingCenter;
import factories.AdoptionCenterFactory;
import factories.CatFactory;
import factories.CleansingCentreFactory;
import factories.DogFactory;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 18.7.2018 г., 22:18
 */
public class AnimalCenterManager {
    private List<Animal> animals;
    private Map<String, CleansingCenter> cleansingCenters;
    private Map<String, AdoptionCenter> adoptionCenters;
    private List<Animal> adoptedAnimal;
    private List<Animal> cleansedAnimal;


    public AnimalCenterManager() {
        this.animals = new ArrayList<>();
        this.cleansingCenters = new LinkedHashMap<>();
        this.adoptionCenters = new LinkedHashMap<>();
        this.adoptedAnimal = new ArrayList<>();
        this.cleansedAnimal = new ArrayList<>();
    }

    public void registerCleansingCenter(String name) {
        CleansingCenter newCentre = CleansingCentreFactory.createCleansingCentre(name);
        cleansingCenters.putIfAbsent(name, newCentre);
    }

    public void registerAdoptionCenter(String name) {
        AdoptionCenter newCentre = AdoptionCenterFactory.createAdoptingCentre(name);
        adoptionCenters.putIfAbsent(name, newCentre);
    }

    public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName) {
        Dog dog = DogFactory.createDog(name, age, learnedCommands);
        this.adoptionCenters.get(adoptionCenterName).addAnimal(dog);
    }

    public void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName) {
        Cat cat = CatFactory.createCat(name, age, intelligenceCoefficient);
        this.adoptionCenters.get(adoptionCenterName).addAnimal(cat);
    }

    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName) {
        List<Animal> sendForCleansing = this.adoptionCenters.get(adoptionCenterName)
                .cleanse();
        sendForCleansing.forEach(x -> {
                    this.cleansingCenters.get(cleansingCenterName).addAnimals(adoptionCenterName, x);
                });
        this.adoptionCenters.get(adoptionCenterName).getAnimals().removeAll(sendForCleansing);
    }

    public void cleanse(String cleansingCenterName) {
        this.cleansingCenters.get(cleansingCenterName).getAnimals().entrySet().stream()
                .forEach(x -> {
                    x.getValue().stream().forEach(y -> {
                        y.changeCleansingStatus(true);
                        this.cleansedAnimal.add(y);
                        this.adoptionCenters.get(x.getKey()).addAnimal(y);
                    });
                });
    }

    public void adopt(String adoptionCenterName) {
        List<Animal> adopted = this.adoptionCenters.get(adoptionCenterName).getAnimals().stream()
                .filter(Animal::isCleansingStatus)
                .collect(Collectors.toList());
        this.adoptedAnimal.addAll(adopted);
        this.adoptionCenters.get(adoptionCenterName).getAnimals().removeAll(adopted);
    }

    public void printStatistics(){
        StringBuilder sb = new StringBuilder();
        List<Animal> sortedByNameAdopted = this.adoptedAnimal.stream().sorted(Comparator.comparing(Animal::getName)).collect(Collectors.toList());
        List<Animal> sortedByNameCleansed = this.cleansedAnimal.stream().sorted(Comparator.comparing(Animal::getName)).collect(Collectors.toList());

        String printSortedByNameAdopted;
        if (sortedByNameAdopted.size() > 0){
            printSortedByNameAdopted = sortedByNameAdopted.toString().replace("[", "").replace("]", "");
        } else {
            printSortedByNameAdopted = "None";
        }

        String printSortedByNameCleansed;
        if (sortedByNameCleansed.size() > 0){
            printSortedByNameCleansed = sortedByNameCleansed.toString().replace("[", "").replace("]", "");
        } else {
            printSortedByNameCleansed = "None";
        }

        long animalsToAdopt = this.adoptionCenters.values().stream().mapToLong(AdoptionCenter::getAnimalsForAdoptionCount).sum();
        long animalsToCleanse = this.cleansingCenters.values().stream().mapToLong(CleansingCenter::getAnimalsForCleansingCount).sum();
        sb.append("Paw Incorporative Regular Statistics")
                .append(System.lineSeparator())
                .append(String.format("Adoption Centers: %d%n", this.adoptionCenters.keySet().size()))
                .append(String.format("Cleansing Centers: %d%n", this.cleansingCenters.keySet().size()))
                .append(String.format("Adopted Animals: %s%n", printSortedByNameAdopted))
                .append(String.format("Cleansed Animals: %s%n", printSortedByNameCleansed))
                .append(String.format("Animals Awaiting Adoption: %d%n", animalsToAdopt))
                .append(String.format("Animals Awaiting Cleansing: %d%n", animalsToCleanse));

        System.out.println(sb.toString());
    }
}
