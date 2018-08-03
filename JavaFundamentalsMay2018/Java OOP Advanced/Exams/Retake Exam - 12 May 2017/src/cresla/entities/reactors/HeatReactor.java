package cresla.entities.reactors;

/**
 * Created by Nino Bonev - 3.8.2018 г., 8:42
 */
public class HeatReactor extends BaseReactor{
    private int heatReductionIndex;

    public HeatReactor(int id, int heatReductionIndex,  int moduleCapacity) {
        super(id, moduleCapacity);
        this.heatReductionIndex = heatReductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        long energyOutput = super.getContainer().getTotalEnergyOutput();
        if (energyOutput > this.getTotalHeatAbsorbing()){
            return 0;
        }
        return energyOutput;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return this.getContainer().getTotalHeatAbsorbing() + this.heatReductionIndex;
    }
}
