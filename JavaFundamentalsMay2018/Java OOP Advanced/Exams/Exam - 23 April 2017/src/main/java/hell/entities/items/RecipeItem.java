package hell.entities.items;

import hell.interfaces.Recipe;

import java.util.List;

/**
 * Created by Nino Bonev - 19.8.2018 г., 11:15
 */
public class RecipeItem extends BaseItem implements Recipe {
    private List<String> requiredItems;

    public RecipeItem(String name, Integer strengthBonus, Integer agilityBonus, Integer intelligenceBonus, Integer hitPointsBonus, Integer damageBonus, List<String> requiredItems) {
        super(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
        this.requiredItems = requiredItems;
    }


    @Override
    public List<String> getRequiredItems() {
        return this.requiredItems;
    }
}
