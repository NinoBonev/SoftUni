package cresla.manager;

import cresla.IdGenerator.IdGenerator;
import cresla.constants.Messages;
import cresla.factories.AbsorbingModuleFactory;
import cresla.factories.EnergyModuleFactory;
import cresla.factories.ReactorFactory;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Manager;
import cresla.interfaces.Reactor;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nino Bonev - 1.8.2018 г., 19:32
 */
public class ManagerImpl implements Manager {
    private Map<Integer, Reactor> reactors;
    private Map<Integer, AbsorbingModule> absorbingModules;
    private Map<Integer, EnergyModule> energyModules;
    private IdGenerator idGenerator;
    private ReactorFactory reactorFactory;
    private AbsorbingModuleFactory absorbingModuleFactory;
    private EnergyModuleFactory energyModuleFactory;

    public ManagerImpl() {
        this.reactors = new LinkedHashMap<>();
        this.absorbingModules = new HashMap<>();
        this.energyModules = new HashMap<>();
        this.idGenerator = new IdGenerator();
        this.reactorFactory = new ReactorFactory();
        this.absorbingModuleFactory = new AbsorbingModuleFactory();
        this.energyModuleFactory = new EnergyModuleFactory();
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        int Id = this.idGenerator.takeId();
        String type = arguments.get(0);
        int additionalParameter = Integer.parseInt(arguments.get(1));
        int moduleCapacity = Integer.parseInt(arguments.get(2));
        Reactor reactor = reactorFactory.createReactor(Id, type, additionalParameter, moduleCapacity);
        this.reactors.put(Id, reactor);
        return String.format(Messages.REACTOR_CREATED, type, Id);
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        int Id = this.idGenerator.takeId();
        int reactorId = Integer.parseInt(arguments.get(0));
        String type = arguments.get(1);
        int additionalParameter = Integer.parseInt(arguments.get(2));
        if (this.reactors.containsKey(reactorId)){
            switch (type){
                case "CryogenRod" :
                    EnergyModule cryogenRod = energyModuleFactory.createEnergyModule(Id, additionalParameter);
                    this.reactors.get(reactorId).addEnergyModule(cryogenRod);
                    this.energyModules.put(Id, cryogenRod);
                    break;
                case "HeatProcessor" :
                    AbsorbingModule heatProcessor = absorbingModuleFactory.createAbsorbingModule(type, Id, additionalParameter);
                    this.reactors.get(reactorId).addAbsorbingModule(heatProcessor);
                    this.absorbingModules.put(Id, heatProcessor);
                    break;
                case "CooldownSystem" :
                    AbsorbingModule coolingSystem = absorbingModuleFactory.createAbsorbingModule(type, Id, additionalParameter);
                    this.reactors.get(reactorId).addAbsorbingModule(coolingSystem);
                    this.absorbingModules.put(Id, coolingSystem);
                    break;
            }
        }
        return String.format(Messages.MODULE_CREATED, type, Id, reactorId);
    }

    @Override
    public String reportCommand(List<String> arguments) {
        int Id = Integer.parseInt(arguments.get(0));
        StringBuilder result = new StringBuilder();
        if (this.reactors.containsKey(Id)){
            result.append(this.reactors.get(Id).toString());
        }
        else if(this.energyModules.containsKey(Id)){
            result.append(this.energyModules.get(Id).toString());
        } else if (this.absorbingModules.containsKey(Id)){
            result.append(this.absorbingModules.get(Id).toString());
        }
        return result.toString();
    }

    @Override
    public String exitCommand(List<String> arguments) {
        int cryoReactorsCount = 0;
        int heatReactors = 0;
        long totalEnergyOutput = 0;
        long totalHeatAbsorbing = 0;
        for (Reactor reactor : reactors.values()) {
            totalEnergyOutput += reactor.getTotalEnergyOutput();
            totalHeatAbsorbing += reactor.getTotalHeatAbsorbing();
            if (reactor.getClass().getSimpleName().equals("CryoReactor")){
                cryoReactorsCount++;
            } if (reactor.getClass().getSimpleName().equals("HeatReactor")){
                heatReactors++;
            }
        }
        return String.format(Messages.EXIT_MESSAGE, cryoReactorsCount, heatReactors,
                this.energyModules.size(), this.absorbingModules.size(),
                totalEnergyOutput, totalHeatAbsorbing);
    }
}
