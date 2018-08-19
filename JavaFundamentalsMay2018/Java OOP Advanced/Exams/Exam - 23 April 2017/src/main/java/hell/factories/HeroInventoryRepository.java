package hell.factories;

import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.util.LinkedHashMap;

/**
 * Created by Nino Bonev - 19.8.2018 г., 18:19
 */
public class HeroInventoryRepository {

    public HeroInventoryRepository (){}

    public LinkedHashMap<String, Item> itemsMap(){
        return new LinkedHashMap<>();
    }

    public LinkedHashMap<String, Recipe> recipeMap(){
        return new LinkedHashMap<>();
    }
}
