package factories;

import animals.Dog;

/**
 * Created by Nino Bonev - 18.7.2018 г., 22:38
 */
public class DogFactory {
    private DogFactory(){}

    public static Dog createDog(String name, int age, int learnedCommands){
        return new Dog(name, age, learnedCommands);
    }
}
