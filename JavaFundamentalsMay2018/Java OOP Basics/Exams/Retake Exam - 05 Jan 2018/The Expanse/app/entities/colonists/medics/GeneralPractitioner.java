package app.entities.colonists.medics;

import app.utils.Constants;

/**
 * Created by Nino Bonev - 12.7.2018 г., 14:38
 */
public class GeneralPractitioner extends Medic {
    public GeneralPractitioner(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    protected int getPotentialBonuses() {
        int potential = 0;

        if (super.getAge() > Constants.GP_AGE_REQUIRED){
            potential += Constants.GP_AGE_BONUS;
        }
        if (super.getSign().equals(Constants.GP_CARING_SIGN_REQUIRED)){
            potential += Constants.GP_CARING_SIGN_BONUS;
        } else if (super.getSign().equals(Constants.GP_CARELESS_SIGN_REQUIRED)){
            potential += Constants.GP_CARELESS_SIGN_BONUS;
        }

        return super.getPotentialBonuses() + potential;
    }
}
