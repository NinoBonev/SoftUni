package hell.manager;

import hell.constants.EngineConstants;
import hell.constants.Messages;
import hell.entities.items.RecipeItem;
import hell.factories.*;
import hell.interfaces.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nino Bonev - 19.8.2018 г., 12:26
 */
public class ManagerImpl implements Manager {
    private CommonItemFactory commonItemFactory;
    private RecipeItemFactory recipeItemFactory;
    private HeroFactory heroFactory;
    private Map<String, Hero> heroes;

    public ManagerImpl(HeroFactory heroFactory, CommonItemFactory commonItemFactory, RecipeItemFactory recipeItemFactory) {
        this.heroes = new LinkedHashMap<>();
        this.heroFactory = heroFactory;
        this.commonItemFactory = commonItemFactory;
        this.recipeItemFactory = recipeItemFactory;
    }

    @Override
    public String createHero(List<String> arguments){
        String name = arguments.get(0);
        String type = arguments.get(1);
        Hero hero = heroFactory.createHero(name, type);
        this.heroes.put(name, hero);
        return String.format(Messages.HERO_CREATED, type, name);
    }

    //name (string), heroName (string), strengthBonus (int), agilityBonus (int), intelligenceBonus (int), hitpointsBonus (int), damageBonus (int)
    @Override
    public String createCommonItem(List<String> arguments){
        String name = arguments.get(0);
        String heroName = arguments.get(1);
        Item item = commonItemFactory.createCommonItem(arguments);
        this.heroes.get(heroName).addItem(item);
        return String.format(Messages.ITEM_ADDED, name, heroName);
    }
    /*
    name (string), heroName (string), strengthBonus (int), agilityBonus (int), intelligenceBonus (int),
     hitpointsBonus (int), damageBonus (int), requiredItem1 (string), requiredItem2 (string). . .
     */
    @Override
    public String createRecipeItem(List<String> arguments){
        String name = arguments.get(0);
        String heroName = arguments.get(1);
        Recipe recipe = recipeItemFactory.createRecipeItem(arguments);
        this.heroes.get(heroName).addRecipe(recipe);
        return String.format(Messages.RECIPE_ADDED, name, heroName);
    }

    @Override
    public String inspectHero(List<String> arguments){
        String name = arguments.get(0);

        if (this.heroes.containsKey(name)) {
            Hero hero = this.heroes.get(name);

            StringBuilder sb = new StringBuilder();
            if (hero.getItems().size() > 0) {
                for (Item item : hero.getItems()) {
                    sb.append(System.lineSeparator())
                            .append(String.format(Messages.ITEM_INFO,
                                    item.getName(),
                                    item.getStrengthBonus(),
                                    item.getAgilityBonus(),
                                    item.getIntelligenceBonus(),
                                    item.getHitPointsBonus(),
                                    item.getDamageBonus()));
                }
            } else {
                sb.append(Messages.ITEMS_NONE);
            }
            return String.format(Messages.INSPECT_HERO,
                    hero.getName(),
                    hero.getClass().getSimpleName(),
                    hero.getHitPoints(),
                    hero.getDamage(),
                    hero.getStrength(),
                    hero.getAgility(),
                    hero.getIntelligence(),
                    sb.toString());
        }
        return "";
    }

    //{hitpoints} - {damage} - {strength} - {agility} - {intelligence} - ({item1Name}, {item2Name}, {item3Name})
   @Override
    public String quitCommand(List<String> arguments){
        StringBuilder print = new StringBuilder();
        final int[] count = new int[]{1};

        heroes.entrySet().stream().sorted((a, b) -> {
            Long heroAPrimaryStats = a.getValue().getStrength() + a.getValue().getAgility() + a.getValue().getIntelligence();
            Long heroBPrimaryStats = b.getValue().getStrength() + b.getValue().getAgility() + b.getValue().getIntelligence();
            Long heroASecondaryStats = a.getValue().getDamage() + a.getValue().getHitPoints();
            Long heroBSecondaryStats = b.getValue().getDamage() + b.getValue().getHitPoints();

            Integer result = Long.compare(heroBPrimaryStats, heroAPrimaryStats);

            if (result == 0){
                result = Long.compare(heroBSecondaryStats, heroASecondaryStats);
            }

            return result;
        }).forEach(x -> {

                StringBuilder items = new StringBuilder();
                String resultItems = "";

                if (x.getValue().getItems().size() > 0){
                    for (Item item : x.getValue().getItems()) {
                        items.append(item.getName()).append(EngineConstants.DELIMITER);
                    }
                    int length = items.length();
                    resultItems = items.toString().substring(0, length - 2);
                } else {
                    items.append(Messages.ITEMS_NONE_NO_SPACE);
                    resultItems = items.toString();
                }

                print.append(String.format(Messages.OVER_MESSAGE,
                        count[0]++,
                        x.getValue().getClass().getSimpleName(),
                        x.getValue().getName(),
                        x.getValue().getHitPoints(),
                        x.getValue().getDamage(),
                        x.getValue().getStrength(),
                        x.getValue().getAgility(),
                        x.getValue().getIntelligence(),
                        resultItems));

        });


        return print.toString();
    }
}
