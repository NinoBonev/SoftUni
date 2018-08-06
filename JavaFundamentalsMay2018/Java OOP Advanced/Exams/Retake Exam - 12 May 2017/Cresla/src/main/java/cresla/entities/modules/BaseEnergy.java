package cresla.entities.modules;

import cresla.constants.Messages;
import cresla.interfaces.EnergyModule;

/**
 * Created by Nino Bonev - 3.8.2018 г., 9:01
 */
public abstract class BaseEnergy extends BaseModule implements EnergyModule {
    private int energyOutput;

    BaseEnergy(int id, int energyOutput) {
        super(id);
        this.energyOutput = energyOutput;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator())
                .append(String.format(Messages.ENERGY_MODULE_STRING, this.getEnergyOutput()));
        return sb.toString();
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput;
    }
}
