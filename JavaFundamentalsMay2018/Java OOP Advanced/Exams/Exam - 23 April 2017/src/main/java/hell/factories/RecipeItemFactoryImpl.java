package hell.factories;

import hell.entities.items.RecipeItem;
import hell.interfaces.RecipeItemFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nino Bonev - 19.8.2018 г., 14:21
 */
public class RecipeItemFactoryImpl implements RecipeItemFactory {

    public RecipeItemFactoryImpl(){}

    /*
    name (string), heroName (string), strengthBonus (int), agilityBonus (int), intelligenceBonus (int),
     hitpointsBonus (int), damageBonus (int), requiredItem1 (string), requiredItem2 (string). . .
     */
    @Override
    public RecipeItem createRecipeItem(List<String> arguments){
        String name = arguments.get(0);
        Integer strengthBonus = Integer.parseInt(arguments.get(2));
        Integer agilityBonus = Integer.parseInt(arguments.get(3));
        Integer intelligenceBonus = Integer.parseInt(arguments.get(4));
        Integer hitpointsBonus = Integer.parseInt(arguments.get(5));
        Integer damageBonus = Integer.parseInt(arguments.get(6));
        List<String> requiredItems = new ArrayList<>();
        for (int i = 7; i < arguments.size(); i++) {
             requiredItems.add(arguments.get(i));
        }

        return new RecipeItem(name, strengthBonus, agilityBonus, intelligenceBonus, hitpointsBonus, damageBonus, requiredItems);
    }
}
