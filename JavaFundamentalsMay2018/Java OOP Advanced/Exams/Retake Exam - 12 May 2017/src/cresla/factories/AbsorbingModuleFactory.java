package cresla.factories;

import cresla.entities.modules.CooldownSystem;
import cresla.entities.modules.HeatProcessor;
import cresla.interfaces.AbsorbingModule;

/**
 * Created by Nino Bonev - 3.8.2018 г., 9:52
 */
public class AbsorbingModuleFactory {

    public AbsorbingModuleFactory(){}

    public AbsorbingModule createAbsorbingModule(String type, int Id, int additionalParameter){
        switch (type){
            case "HeatProcessor" :return new HeatProcessor(Id, additionalParameter);
            case "CooldownSystem" :return new CooldownSystem(Id, additionalParameter);
                default: return null;
        }
    }
}
