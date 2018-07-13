package app.factories;

import app.entities.colonists.Colonist;
import app.entities.colonists.engineer.HardwareEngineer;
import app.entities.colonists.engineer.SoftwareEngineer;
import app.entities.colonists.medics.GeneralPractitioner;
import app.entities.colonists.medics.Surgeon;
import app.entities.colonists.soldiers.Soldier;

/**
 * Created by Nino Bonev - 12.7.2018 г., 17:17
 */
public class ColonistFactory {
    private static final ColonistFactory INSTANCE = new ColonistFactory();

    private ColonistFactory() {
    }

    public static ColonistFactory getInstance() {
        return INSTANCE;
    }

    public static Colonist createColonist(String[] args){
        String type = args[1];
        String colonistId = args[2];
        String familyId = args[3];
        int talent = Integer.parseInt(args[4]);
        int age = Integer.parseInt(args[5]);
        String sign = args.length == 7 ? args[6] : null;

        switch (type){
            case "Soldier" : return new Soldier(colonistId, familyId, talent, age);
            case "Surgeon" : return new Surgeon(colonistId, familyId, talent, age, sign);
            case "GeneralPractitioner" : return new GeneralPractitioner(colonistId, familyId, talent, age, sign);
            case "SoftwareEngineer" : return new SoftwareEngineer(colonistId, familyId, talent, age);
            case "HardwareEngineer" : return new HardwareEngineer(colonistId, familyId, talent, age);
            default: return null;
        }
    }
}
