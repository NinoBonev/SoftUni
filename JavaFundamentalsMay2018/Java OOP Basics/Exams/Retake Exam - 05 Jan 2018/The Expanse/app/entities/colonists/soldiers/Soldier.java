package app.entities.colonists.soldiers;

import app.entities.colonists.Colonist;
import app.utils.Constants;

/**
 * Created by Nino Bonev - 12.7.2018 г., 12:27
 */
public class Soldier extends Colonist {

    public Soldier(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    protected int getPotentialBonuses() {
        int potential = Constants.SOLDIERS_CLASS_BONUS + Constants.SOLDIERS_AGE_BONUS;

        return potential;
    }
}
