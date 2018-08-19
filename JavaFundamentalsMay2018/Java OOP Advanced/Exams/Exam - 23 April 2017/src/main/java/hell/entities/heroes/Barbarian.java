package hell.entities.heroes;

import hell.constants.EngineConstants;
import hell.factories.InventoryFactory;
import hell.interfaces.Inventory;

/**
 * Created by Nino Bonev - 19.8.2018 г., 11:14
 */
public class Barbarian extends BaseHero {
    //String name, long strength, long agility, long intelligence, long hitPoints, long damage
    public Barbarian(String name, Inventory inventory) {
        super(name, EngineConstants.BARBARIAN_STRENGTH_DEFAULT,
                EngineConstants.BARBARIAN_AGILITY_DEFAULT,
                EngineConstants.BARBARIAN_INTELLIGENCE_DEFAULT,
                EngineConstants.BARBARIAN_HIT_POINTS_DEFAULT,
                EngineConstants.BARBARIAN_DAMAGE_DEFAULT,
                inventory);
    }
}
