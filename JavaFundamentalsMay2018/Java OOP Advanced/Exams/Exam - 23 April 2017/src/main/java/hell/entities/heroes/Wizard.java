package hell.entities.heroes;

import hell.constants.EngineConstants;

/**
 * Created by Nino Bonev - 19.8.2018 г., 11:14
 */
public class Wizard extends BaseHero {
    //String name, long strength, long agility, long intelligence, long hitPoints, long damage
    public Wizard(String name) {
        super(name,
                EngineConstants.WIZARD_STRENGTH_DEFAULT,
                EngineConstants.WIZARD_AGILITY_DEFAULT,
                EngineConstants.WIZARD_INTELLIGENCE_DEFAULT,
                EngineConstants.WIZARD_HIT_POINTS_DEFAULT,
                EngineConstants.WIZARD_DAMAGE_DEFAULT);
    }
}
