package hell.constants;

/**
 * Created by Nino Bonev - 3.8.2018 г., 16:01
 */
public class Messages {

    public static final String HERO_CREATED = "Created %s - %s"; //{type}, {name}
    public static final String ITEM_ADDED = "Added item - %s to Hero - %s";//{itemName} - {heroName}
    public static final String RECIPE_ADDED = "Added recipe - %s to Hero - %s";//{recipeName} - {heroName}
    //{heroName} - {heroType} - {hitpoints} - {damage} - {strength} - {agility} - {intelligence} - Items:
    public static final String INSPECT_HERO = "Hero: %s, Class: %s\n" +
            "HitPoints: %d, Damage: %d\n" +
            "Strength: %s\n" +
            "Agility: %s\n" +
            "Intelligence: %s\n" +
            "Items:%s";
    public static final String ITEMS_NONE = " None\n";
    public static final String ITEMS_NONE_NO_SPACE = "None\n";
    //{itemName} - {strengthBonus} - {agilityBonus} - {intelligenceBonus} - {hitpointsBonus} - {damageBonus}
    public static final String ITEM_INFO = "###Item: %s\n" +
            "###+%d Strength\n" +
            "###+%d Agility\n" +
            "###+%d Intelligence\n" +
            "###+%d HitPoints\n" +
            "###+%d Damage\n";
    //{counter} - {heroType} - {heroName}
    //{hitpoints} - {damage} - {strength} - {agility} - {intelligence} - ({item1Name}, {item2Name}, {item3Name})
    public static final String OVER_MESSAGE = "%d. %s: %s\n" +
            "###HitPoints: %d\n" +
            "###Damage: %d\n" +
            "###Strength: %d\n" +
            "###Agility: %d\n" +
            "###Intelligence: %d\n" +
            "###Items: %s\n";
}
