package hell.factories;

import hell.entities.items.CommonItem;

import java.util.List;

/**
 * Created by Nino Bonev - 19.8.2018 г., 14:11
 */
public class CommonItemFactory {

    public CommonItemFactory(){}

    //name (string), heroName (string), strengthBonus (int), agilityBonus (int), intelligenceBonus (int), hitpointsBonus (int), damageBonus (int)
    public CommonItem createCommonItem(List<String> arguments){
        String name = arguments.get(0);
        Integer strengthBonus = Integer.parseInt(arguments.get(2));
        Integer agilityBonus = Integer.parseInt(arguments.get(3));
        Integer intelligenceBonus = Integer.parseInt(arguments.get(4));
        Integer hitpointsBonus = Integer.parseInt(arguments.get(5));
        Integer damageBonus = Integer.parseInt(arguments.get(6));

        return new CommonItem(name, strengthBonus, agilityBonus, intelligenceBonus, hitpointsBonus, damageBonus);
    }
}
