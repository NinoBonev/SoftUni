package app.entities.colonists.engineer;

import app.utils.Constants;

/**
 * Created by Nino Bonev - 12.7.2018 г., 13:44
 */
public class SoftwareEngineer extends Engineer {
    private int flatBonus = 2;
    public SoftwareEngineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    protected int getPotentialBonuses() {
        return super.getPotentialBonuses() + Constants.SOFTWARE_ENGINEER_BONUS;
    }
}
