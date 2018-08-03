package panzer.manager;

import panzer.constants.Messages;
import panzer.contracts.*;
import panzer.factories.PartFactoryImpl;
import panzer.factories.VehicleFactoryImpl;

import java.util.*;

/**
 * Created by Nino Bonev - 1.8.2018 г., 19:32
 */
public class ManagerImpl implements Manager {
    private final VehicleFactoryImpl vehiclesFactory;
    private final PartFactoryImpl partsFactory;
    private final Map<String, Vehicle> vehicles;
    private final Map<String, Part> parts;
    private final BattleOperator battleOperator;
    private final List<String> defeatedVehicles;

    public ManagerImpl(VehicleFactoryImpl vehiclesFactory,
                       PartFactoryImpl partsFactory, BattleOperator battleOperator) {
        this.vehiclesFactory = vehiclesFactory;
        this.partsFactory = partsFactory;
        this.battleOperator = battleOperator;
        this.vehicles = new LinkedHashMap<>();
        this.parts = new LinkedHashMap<>();
        defeatedVehicles = new ArrayList<>();
    }

    @Override
    public String addVehicle(List<String> arguments) {
        String[] args = arguments.stream().toArray(String[]::new);
        Vehicle vehicle = vehiclesFactory.createVehicle(args);
        this.vehicles.put(vehicle.getModel(), vehicle);
        return String.format(Messages.VEHICLE_CREATED, args[0], vehicle.getModel());
    }

    @Override
    public String addPart(List<String> arguments) {
        //SA-203 Arsenal Cannon-KA2 300 500 450
        String[] args = arguments.stream().toArray(String[]::new);
        String vehicleModel = args[0];
        Part part = partsFactory.createPart(args);
        switch (args[1]) {
            case "Arsenal":
                this.vehicles.get(vehicleModel).addArsenalPart(part);
                break;
            case "Shell":
                this.vehicles.get(vehicleModel).addShellPart(part);
                break;
            case "Endurance":
                this.vehicles.get(vehicleModel).addEndurancePart(part);
                break;
        }
        this.parts.put(part.getModel(), part);
        return String.format(Messages.PART_CREATED, args[1], part.getModel(), vehicleModel);
    }

    @Override
    public String inspect(List<String> arguments) {
        if(this.vehicles.containsKey(arguments.get(0))){
            return this.vehicles.get(arguments.get(0)).toString();
        }else{
            return this.parts.get(arguments.get(0)).toString();
        }
    }

    @Override
    public String battle(List<String> arguments) {
        Vehicle attacker = this.vehicles.get(arguments.get(0));
        Vehicle target = this.vehicles.get(arguments.get(1));
        String winner = this.battleOperator.battle(attacker, target);
        String loser = winner.equals(attacker.getModel()) ? target.getModel() : attacker.getModel();
        this.defeatedVehicles.add(loser);
        this.vehicles.remove(loser);
        return String.format(Messages.BATTLE_WINNER, attacker.getModel(), target.getModel(), winner);
    }

    @Override
    public String terminate(List<String> arguments) {
        String remaining = this.vehicles.isEmpty() ? Messages.NONE :
                this.vehicles.keySet().toString().replaceAll("[\\[\\]]", "");

        String defeated = this.defeatedVehicles.isEmpty() ? Messages.NONE :
                this.defeatedVehicles.toString().replaceAll("[\\[\\]]", "");

        final int[] usedParts = {0};
        this.vehicles.values().forEach(x -> x.getParts().forEach(p -> usedParts[0]++));

        StringBuilder sb = new StringBuilder();
        sb.append(Messages.REMAINING_VEHICLES).append(remaining).append(System.lineSeparator());
        sb.append(Messages.DEFEATED_VEHICLES).append(defeated).append(System.lineSeparator());
        sb.append(Messages.CURRENTLY_USED_PARTS).append(usedParts[0]);

        return sb.toString();

    }
}
