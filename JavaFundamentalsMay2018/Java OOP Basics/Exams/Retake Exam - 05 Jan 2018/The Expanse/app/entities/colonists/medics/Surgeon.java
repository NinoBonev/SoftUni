package app.entities.colonists.medics;

import app.utils.Constants;

/**
 * Created by Nino Bonev - 12.7.2018 г., 14:48
 */
public class Surgeon extends Medic {
    public Surgeon(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    protected int getPotentialBonuses() {
        int potential = 0;

        if (super.getAge() > Constants.SURGEON_MIN_AGE_REQUIRED && super.getAge() < Constants.SURGEON_MAX_AGE_REQUIRED){
            potential += Constants.SURGEON_AGE_BONUS;
        }
        if (super.getSign().equals(Constants.SURGEON_PRECISE_SIGN_REQUIRED)){
            potential += Constants.SURGEON_PRECISE_SIGN_BONUS;
        } else if (super.getSign().equals(Constants.SURGEON_BUTCHER_SIGN_REQUIRED)){
            potential += Constants.SURGEON_BUTCHER_SIGN_BONUS;
        }

        return super.getPotentialBonuses() + potential;
    }
}
