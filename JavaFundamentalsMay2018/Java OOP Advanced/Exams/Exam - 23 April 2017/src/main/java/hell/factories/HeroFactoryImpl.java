package hell.factories;

import hell.entities.heroes.Assassin;
import hell.entities.heroes.Barbarian;
import hell.entities.heroes.Wizard;
import hell.interfaces.Hero;
import hell.interfaces.HeroFactory;
import hell.interfaces.Inventory;

/**
 * Created by Nino Bonev - 19.8.2018 г., 13:47
 */
public class HeroFactoryImpl implements HeroFactory {
    private InventoryFactory inventoryFactory;

    public HeroFactoryImpl(){}

    @Override
    public Hero createHero(String name, String type){
        this.inventoryFactory = new InventoryFactory();
        Inventory inventory = inventoryFactory.createHeroInventory();
        switch (type){
            case "Barbarian" : return new Barbarian(name, inventory);
            case "Assassin" : return new Assassin(name, inventory);
            case "Wizard" : return new Wizard(name, inventory);
            default: return null;
        }
    }
}
