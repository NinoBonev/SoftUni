package app.entities.colonists.engineer;

import app.entities.colonists.Colonist;
import app.utils.Constants;

/**
 * Created by Nino Bonev - 12.7.2018 г., 13:35
 */
public abstract class Engineer extends Colonist {
    public Engineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    protected int getPotentialBonuses() {
        int potential = Constants.ENGINEER_CLASS_BONUS;

        if (super.getAge() > Constants.ENGINEER_AGE_REQUIRED){
            potential += Constants.ENGINEER_AGE_BONUS;
        }

        return potential;
    }
}
