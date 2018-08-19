package hell.factories;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Inventory;

/**
 * Created by Nino Bonev - 19.8.2018 г., 17:07
 */
public class InventoryFactory {

    public InventoryFactory (){}

    public Inventory createHeroInventory(){
        return new HeroInventory();
    }
}
