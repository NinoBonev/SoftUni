package factories;

import centers.CleansingCenter;

/**
 * Created by Nino Bonev - 18.7.2018 г., 22:28
 */
public class CleansingCentreFactory {
    private CleansingCentreFactory(){}

    public static CleansingCenter createCleansingCentre(String name){
        return new CleansingCenter(name);
    }


}
