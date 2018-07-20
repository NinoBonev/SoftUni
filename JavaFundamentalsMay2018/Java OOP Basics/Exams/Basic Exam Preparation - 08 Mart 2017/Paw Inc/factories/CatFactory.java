package factories;

import animals.Cat;

/**
 * Created by Nino Bonev - 18.7.2018 г., 22:44
 */
public class CatFactory {
    private CatFactory(){}

    public static Cat createCat(String name, int age, int intelligenceCoefficient){
        return new Cat(name, age, intelligenceCoefficient);
    }
}
