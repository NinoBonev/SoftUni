package app.entities.colonists.engineer;

import app.utils.Constants;

/**
 * Created by Nino Bonev - 12.7.2018 г., 14:18
 */
public class HardwareEngineer extends Engineer {
    public HardwareEngineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    protected int getPotentialBonuses() {
        int potential = super.getPotentialBonuses();

        if (this.getAge() < Constants.HARDWARE_ENGINEER_AGE_REQUIRED){
            potential += Constants.HARDWARE_ENGINEER_BONUS;
        }

        return potential;
    }
}
