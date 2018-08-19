package hell.entities.miscellaneous;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Nino Bonev - 19.8.2018 г., 21:28
 */
public class InventoryTest {
    private Inventory inventory;

    private Item item1;
    private Item item2;
    private Recipe recipe1;
    private Recipe recipe2;

    @Before
    public void setUp() throws Exception {
        this.inventory = new HeroInventory();

        this.item1 = Mockito.mock(Item.class);
        this.item2 = Mockito.mock(Item.class);
        this.recipe1 = Mockito.mock(Recipe.class);
        this.recipe2 = Mockito.mock(Recipe.class);

        Mockito.when(item1.getAgilityBonus()).thenReturn((Integer.MAX_VALUE / 2) - 1);
        Mockito.when(item1.getDamageBonus()).thenReturn(Integer.MAX_VALUE / 2 - 1);
        Mockito.when(item1.getHitPointsBonus()).thenReturn(Integer.MAX_VALUE / 2 - 1);
        Mockito.when(item1.getIntelligenceBonus()).thenReturn(Integer.MAX_VALUE / 2 - 1);
        Mockito.when(item1.getStrengthBonus()).thenReturn((Integer.MAX_VALUE / 2) - 1);
        Mockito.when(item1.getName()).thenReturn("First");

        Mockito.when(item2.getAgilityBonus()).thenReturn((Integer.MAX_VALUE / 2) - 1);
        Mockito.when(item2.getDamageBonus()).thenReturn(Integer.MAX_VALUE / 2 - 1);
        Mockito.when(item2.getHitPointsBonus()).thenReturn(Integer.MAX_VALUE / 2 - 1);
        Mockito.when(item2.getIntelligenceBonus()).thenReturn(Integer.MAX_VALUE / 2 - 1);
        Mockito.when(item2.getStrengthBonus()).thenReturn((Integer.MAX_VALUE / 2) - 1);
        Mockito.when(item2.getName()).thenReturn("Second");

        Mockito.when(recipe1.getAgilityBonus()).thenReturn(Integer.MAX_VALUE / 2 - 1);
        Mockito.when(recipe1.getDamageBonus()).thenReturn(Integer.MAX_VALUE / 2 - 1);
        Mockito.when(recipe1.getHitPointsBonus()).thenReturn(Integer.MAX_VALUE / 2 - 1);
        Mockito.when(recipe1.getIntelligenceBonus()).thenReturn(Integer.MAX_VALUE / 2 - 1);
        Mockito.when(recipe1.getStrengthBonus()).thenReturn(Integer.MAX_VALUE / 2 - 1);
        Mockito.when(recipe1.getName()).thenReturn("Third");
        Mockito.when(recipe1.getRequiredItems()).thenReturn(new ArrayList<String>(){{add("name");}});

        Mockito.when(recipe2.getAgilityBonus()).thenReturn(Integer.MAX_VALUE / 2 - 1);
        Mockito.when(recipe2.getDamageBonus()).thenReturn(Integer.MAX_VALUE / 2 - 1);
        Mockito.when(recipe2.getHitPointsBonus()).thenReturn(Integer.MAX_VALUE / 2 - 1);
        Mockito.when(recipe2.getIntelligenceBonus()).thenReturn(Integer.MAX_VALUE / 2 - 1);
        Mockito.when(recipe2.getStrengthBonus()).thenReturn(Integer.MAX_VALUE / 2 - 1);
        Mockito.when(recipe2.getName()).thenReturn("Fourth");
        Mockito.when(recipe2.getRequiredItems()).thenReturn(new ArrayList<String>(){{
            add("First");
            add("Second");
        }});

    }

    @Test
    public void instantiatingInventoryShouldNotThrowException() {
        Inventory inventory1 = new HeroInventory();
    }

    @Test
    public void emptyCollectionShouldReturnZero() {
        Assert.assertEquals(0, this.inventory.getTotalStrengthBonus());
        Assert.assertEquals(0, this.inventory.getTotalAgilityBonus());
        Assert.assertEquals(0, this.inventory.getTotalIntelligenceBonus());
        Assert.assertEquals(0, this.inventory.getTotalHitPointsBonus());
        Assert.assertEquals(0, this.inventory.getTotalDamageBonus());
    }

    @Test
    public void addingItemShouldGiveAllCorrectResults() {

        this.inventory.addCommonItem(item1);

        Assert.assertEquals(Integer.MAX_VALUE / 2 - 1, this.inventory.getTotalStrengthBonus());
        Assert.assertEquals(Integer.MAX_VALUE / 2 - 1, this.inventory.getTotalAgilityBonus());
        Assert.assertEquals(Integer.MAX_VALUE / 2 - 1, this.inventory.getTotalIntelligenceBonus());
        Assert.assertEquals(Integer.MAX_VALUE / 2 - 1, this.inventory.getTotalHitPointsBonus());
        Assert.assertEquals(Integer.MAX_VALUE / 2 - 1, this.inventory.getTotalDamageBonus());
    }

    @Test
    public void getTotalStrengthBonus() {
        Assert.assertEquals(0, this.inventory.getTotalStrengthBonus());

        this.inventory.addCommonItem(this.item1);
        this.inventory.addCommonItem(this.item2);

        Assert.assertEquals((long) ((Integer.MAX_VALUE / 2) - 1) * 2, this.inventory.getTotalStrengthBonus());
    }

    @Test
    public void getTotalAgilityBonus() {
        Assert.assertEquals(0, this.inventory.getTotalAgilityBonus());

        this.inventory.addCommonItem(this.item1);
        this.inventory.addCommonItem(this.item2);

        Assert.assertEquals((long) ((Integer.MAX_VALUE / 2) - 1) * 2, this.inventory.getTotalAgilityBonus());
    }

    @Test
    public void getTotalIntelligenceBonus() {
        Assert.assertEquals(0, this.inventory.getTotalIntelligenceBonus());

        this.inventory.addCommonItem(this.item1);
        this.inventory.addCommonItem(this.item2);

        Assert.assertEquals((long) ((Integer.MAX_VALUE / 2) - 1) * 2, this.inventory.getTotalIntelligenceBonus());
    }

    @Test
    public void getTotalHitPointsBonus() {
        Assert.assertEquals(0, this.inventory.getTotalHitPointsBonus());

        this.inventory.addCommonItem(this.item1);
        this.inventory.addCommonItem(this.item2);

        Assert.assertEquals((long) ((Integer.MAX_VALUE / 2) - 1) * 2, this.inventory.getTotalHitPointsBonus());
    }

    @Test
    public void getTotalDamageBonus() {
        Assert.assertEquals(0, this.inventory.getTotalDamageBonus());

        this.inventory.addCommonItem(this.item1);
        this.inventory.addCommonItem(this.item2);

        Assert.assertEquals((long) ((Integer.MAX_VALUE / 2) - 1) * 2, this.inventory.getTotalDamageBonus());
    }

    @Test
    public void CommonItemsAreNullOnInitialization() throws NoSuchFieldException, IllegalAccessException {
        Field commonItems = this.inventory.getClass().getDeclaredField("commonItems");
        commonItems.setAccessible(true);
        Map<String, Item> commonMap = (Map<String, Item>) commonItems.get(this.inventory);

        Assert.assertEquals(0, commonMap.size());
    }

    @Test
    public void CommonItemsAreAdding() throws NoSuchFieldException, IllegalAccessException {
        this.inventory.addCommonItem(item1);
        Field commonItems = this.inventory.getClass().getDeclaredField("commonItems");
        commonItems.setAccessible(true);
        Map<String, Item> commonMap = (Map<String, Item>) commonItems.get(this.inventory);

        Assert.assertEquals(1, commonMap.size());
    }

    @Test
    public void RecipeItemsAreNullOnInitialization() throws NoSuchFieldException, IllegalAccessException {
        Field recipeItems = this.inventory.getClass().getDeclaredField("recipeItems");
        recipeItems.setAccessible(true);
        Map<String, Recipe> recipeMap = (Map<String, Recipe>) recipeItems.get(this.inventory);

        Assert.assertEquals(0, recipeMap.size());
    }

    @Test
    public void RecipeItemsAreAdding() throws NoSuchFieldException, IllegalAccessException {
        this.inventory.addRecipeItem(recipe1);
        Field recipeItems = this.inventory.getClass().getDeclaredField("recipeItems");
        recipeItems.setAccessible(true);
        Map<String, Recipe> recipeMap = (Map<String, Recipe>) recipeItems.get(this.inventory);

        Assert.assertEquals(1, recipeMap.size());
    }

    @Test (expected = NullPointerException.class)
    public void addingRecipeItemWithNoParamsShouldThrowError(){
        this.inventory.addRecipeItem(null);
    }

    @Test (expected = NullPointerException.class)
    public void addingCommonItemWithNoParamsShouldThrowError(){
        this.inventory.addCommonItem(null);
    }

    @Test
    public void addingTheSameRecipeItemTwiceShouldNotIncreaseCollectionSize() throws NoSuchFieldException, IllegalAccessException {
        this.inventory.addRecipeItem(recipe1);
        this.inventory.addRecipeItem(recipe1);
        Field field = this.inventory.getClass().getDeclaredField("recipeItems");
        field.setAccessible(true);
        Map<String, Recipe> recipeMap = (Map<String, Recipe>) field.get(this.inventory);
        Assert.assertEquals("Incorrect items count", 1, recipeMap.size());
    }

    @Test
    public void addingTheSameCommonItemTwiceShouldNotIncreaseCollectionSize() throws NoSuchFieldException, IllegalAccessException {
        this.inventory.addCommonItem(item1);
        this.inventory.addCommonItem(item1);
        Field field = this.inventory.getClass().getDeclaredField("commonItems");
        field.setAccessible(true);
        Map<String, Recipe> commonMap = (Map<String, Recipe>) field.get(this.inventory);
        Assert.assertEquals("Incorrect items count", 1, commonMap.size());
    }

    @Test
    public void addingCommonElementShouldGetTheSameElementFromCollection() throws NoSuchFieldException, IllegalAccessException {
        this.inventory.addCommonItem(item1);
        Field field = this.inventory.getClass().getDeclaredField("commonItems");
        field.setAccessible(true);
        Map<String, Item> commonMap = (Map<String, Item>) field.get(this.inventory);
        Assert.assertSame("Incorrect items count", item1, commonMap.get(item1.getName()));
    }


    @Test
    public void addingRecipeElementShouldGetTheSameElementFromCollection() throws NoSuchFieldException, IllegalAccessException {
        this.inventory.addRecipeItem(recipe1);
        Field field = this.inventory.getClass().getDeclaredField("recipeItems");
        field.setAccessible(true);
        Map<String, Recipe> recipeMap = (Map<String, Recipe>) field.get(this.inventory);
        Assert.assertSame(recipe1, recipeMap.get(recipe1.getName()));
    }

    @Test
    public void addingRecipeShouldNotIncreaseStats() {
        this.inventory.addRecipeItem(recipe1);
        Assert.assertEquals(0, this.inventory.getTotalStrengthBonus());
        Assert.assertEquals(0, this.inventory.getTotalAgilityBonus());
        Assert.assertEquals(0, this.inventory.getTotalIntelligenceBonus());
        Assert.assertEquals(0, this.inventory.getTotalHitPointsBonus());
        Assert.assertEquals(0, this.inventory.getTotalDamageBonus());
    }

    @Test
    public void completingRecipeCheck() {
        this.inventory.addRecipeItem(recipe2);
        this.inventory.addCommonItem(item1);
        this.inventory.addCommonItem(item2);
        Assert.assertEquals((Integer.MAX_VALUE / 2) - 1, this.inventory.getTotalStrengthBonus());
        Assert.assertEquals((Integer.MAX_VALUE / 2) - 1, this.inventory.getTotalAgilityBonus());
        Assert.assertEquals((Integer.MAX_VALUE / 2) - 1, this.inventory.getTotalIntelligenceBonus());
        Assert.assertEquals((Integer.MAX_VALUE / 2) - 1, this.inventory.getTotalHitPointsBonus());
        Assert.assertEquals((Integer.MAX_VALUE / 2) - 1, this.inventory.getTotalDamageBonus());
    }
}