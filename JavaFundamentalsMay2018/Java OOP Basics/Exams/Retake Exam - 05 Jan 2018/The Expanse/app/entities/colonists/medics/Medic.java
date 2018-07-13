package app.entities.colonists.medics;

import app.entities.colonists.Colonist;
import app.utils.Constants;

/**
 * Created by Nino Bonev - 12.7.2018 г., 14:22
 */
public abstract class Medic extends Colonist {
    private String sign;

    public Medic(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age);
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    @Override
    protected int getPotentialBonuses() {
        return Constants.MEDIC_BONUS;
    }
}
