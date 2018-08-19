package hell.entities.heroes;

import hell.constants.EngineConstants;

/**
 * Created by Nino Bonev - 19.8.2018 г., 11:14
 */
public class Assassin extends BaseHero {
    //String name, long strength, long agility, long intelligence, long hitPoints, long damage
    public Assassin(String name) {
        super(name,
                EngineConstants.ASSASSIN_STRENGTH_DEFAULT,
                EngineConstants.ASSASSIN_AGILITY_DEFAULT,
                EngineConstants.ASSASSIN_INTELLIGENCE_DEFAULT,
                EngineConstants.ASSASSIN_HIT_POINTS_DEFAULT,
                EngineConstants.ASSASSIN_DAMAGE_DEFAULT);
    }
}
