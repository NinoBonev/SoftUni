package cresla.entities.modules;

import cresla.constants.Messages;
import cresla.interfaces.AbsorbingModule;

/**
 * Created by Nino Bonev - 3.8.2018 г., 8:59
 */
public abstract class BaseAbsorbing extends BaseModule implements AbsorbingModule{
    private int heatAbsorbing;

    BaseAbsorbing(int id, int energyOutput) {
        super(id);
        this.heatAbsorbing = energyOutput;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator())
                .append(String.format(Messages.ABSORBING_MODULE_STRING, this.getHeatAbsorbing()));
        return sb.toString();
    }

    @Override
    public int getHeatAbsorbing() {
        return this.heatAbsorbing;
    }
}
