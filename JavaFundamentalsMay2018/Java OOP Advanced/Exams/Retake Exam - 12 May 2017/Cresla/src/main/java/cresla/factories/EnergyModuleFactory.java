package cresla.factories;

import cresla.entities.modules.CryogenRod;
import cresla.interfaces.EnergyModule;

/**
 * Created by Nino Bonev - 3.8.2018 г., 10:08
 */
public class EnergyModuleFactory {

    public EnergyModuleFactory(){}

    public EnergyModule createEnergyModule(int Id, int additionalParameter){
        return new CryogenRod(Id, additionalParameter);

    }
}
