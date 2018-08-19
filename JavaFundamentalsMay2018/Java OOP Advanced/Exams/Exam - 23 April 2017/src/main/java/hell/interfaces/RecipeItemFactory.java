package hell.interfaces;

import hell.entities.items.RecipeItem;

import java.util.List;

/**
 * Created by Nino Bonev - 19.8.2018 г., 19:06
 */
public interface RecipeItemFactory {

    public RecipeItem createRecipeItem(List<String> arguments);
}
