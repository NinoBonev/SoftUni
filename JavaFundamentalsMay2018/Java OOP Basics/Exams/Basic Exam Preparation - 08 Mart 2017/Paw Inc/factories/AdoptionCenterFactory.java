package factories;

import centers.AdoptionCenter;

/**
 * Created by Nino Bonev - 18.7.2018 г., 22:34
 */
public class AdoptionCenterFactory {
    private AdoptionCenterFactory(){}

    public static AdoptionCenter createAdoptingCentre(String name){
        return new AdoptionCenter(name);
    }
}
