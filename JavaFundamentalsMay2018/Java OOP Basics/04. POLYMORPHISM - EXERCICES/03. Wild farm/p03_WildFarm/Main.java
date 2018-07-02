package p03_WildFarm;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 26.6.2018 г., 10:24
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new LinkedList<>();

        String line;
        while (true){
            if ("End".equals(line = scanner.nextLine())){
                break;
            }
            String[] animalData = line.split(" ");
            Animal animal = createAnimal(animalData);

            String[] foodData = scanner.nextLine().split(" ");
            Food food = createFood(foodData);

            if (animal != null){
                animals.add(animal);
                System.out.println(animal.makeSound());
                if (food != null) {
                    try {
                        animal.eat(food);
                    } catch (IllegalArgumentException exp) {
                        System.out.println(exp.getMessage());
                    }
                }
            }

        }

        animals.forEach(System.out::println);
    }

    private static Animal createAnimal(String[] animalData){
        Animal animal = null;
        String animalType = animalData[0];
        String animalName = animalData[1];
        double animalWeight = Double.parseDouble(animalData[2]);
        String livingRegion = animalData[3];
        String catBreed = "";
        if (animalData.length == 5){
            catBreed = animalData[4];
        }

        switch (animalType){
            case "Mouse" :
                animal = new Mouse(animalName, animalType, animalWeight, livingRegion);
                break;
            case "Cat" :
                animal = new Cat(animalName, animalType, animalWeight, livingRegion, catBreed);
                break;
            case "Zebra" :
                animal = new Zebra(animalName, animalType, animalWeight, livingRegion);
                break;
            case "Tiger" :
                animal = new Tiger(animalName, animalType, animalWeight, livingRegion);
                break;
            default:return null;
        }

        return animal;
    }

    public static Food createFood(String[] foodData){
        Food food = null;
        String foodEaten = foodData[0];
        Integer foodQuantity = Integer.parseInt(foodData[1]);

        switch (foodEaten){
            case "Vegetable" :
                food = new Vegetable(foodQuantity);
                break;
            case "Meat" :
                food = new Meat(foodQuantity);
                break;
            default:return null;
        }
        return food;
    }
}
