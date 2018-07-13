package app.factories;

import app.entities.family.Family;

/**
 * Created by Nino Bonev - 12.7.2018 г., 15:06
 */
public class FamilyFactory {

    private FamilyFactory(){}

    public static Family createFamily(String familyId){
        return new Family(familyId);
    }
}
