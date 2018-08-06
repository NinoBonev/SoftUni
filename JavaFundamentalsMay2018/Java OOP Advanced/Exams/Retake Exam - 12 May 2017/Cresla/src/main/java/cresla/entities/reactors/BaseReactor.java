package cresla.entities.reactors;

import cresla.constants.Messages;
import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.*;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by Nino Bonev - 3.8.2018 г., 8:43
 */
public abstract class BaseReactor implements Reactor {
    private int Id;
    private ModuleContainer container;

    BaseReactor(int id, int moduleCapacity) {
        Id = id;
        this.container = new ModuleContainer(moduleCapacity);
    }

    ModuleContainer getContainer() {
        return this.container;
    }

    @Override
    public abstract long getTotalEnergyOutput();

    @Override
    public abstract long getTotalHeatAbsorbing();

    @Override
    public int getModuleCount() {
//        try {
//            Field moduleCount = ModuleContainer.class.getDeclaredField("modulesByInput");
//            moduleCount.setAccessible(true);
//            return ((List<Module>) moduleCount.get(this.container)).size();
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }

        return this.container.getModulesByInput().size();
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        this.container.addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.container.addAbsorbingModule(absorbingModule);
    }

    @Override
    public int getId() {
        return this.Id;
    }

    @Override
    public String toString() {
        return String.format(Messages.REACTOR_STRING, this.getClass().getSimpleName(),
                this.getId(), this.getTotalEnergyOutput(), this.getTotalHeatAbsorbing(), this.getModuleCount());
    }
}
