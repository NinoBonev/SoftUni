package cresla.entities.reactors;

/**
 * Created by Nino Bonev - 3.8.2018 г., 8:41
 */
public class CryoReactor extends BaseReactor {
    private int cryoProductionIndex;

    public CryoReactor(int id, int cryoProductionIndex,  int moduleCapacity) {
        super(id, moduleCapacity);
        this.cryoProductionIndex = cryoProductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        long energyOutput = super.getContainer().getTotalEnergyOutput() * this.cryoProductionIndex;
        if (energyOutput > this.getTotalHeatAbsorbing()) {
            return 0;
        }
        return energyOutput;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return this.getContainer().getTotalHeatAbsorbing();
    }
}
