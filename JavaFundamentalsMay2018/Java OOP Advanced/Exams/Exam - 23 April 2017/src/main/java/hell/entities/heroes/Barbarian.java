package hell.entities.heroes;

import hell.constants.EngineConstants;

/**
 * Created by Nino Bonev - 19.8.2018 г., 11:14
 */
public class Barbarian extends BaseHero {
    //String name, long strength, long agility, long intelligence, long hitPoints, long damage
    public Barbarian(String name) {
        super(name,
                EngineConstants.BARBARIAN_STRENGTH_DEFAULT,
                EngineConstants.BARBARIAN_AGILITY_DEFAULT,
                EngineConstants.BARBARIAN_INTELLIGENCE_DEFAULT,
                EngineConstants.BARBARIAN_HIT_POINTS_DEFAULT,
                EngineConstants.BARBARIAN_DAMAGE_DEFAULT);
    }
}
