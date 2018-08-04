package panzer;

import panzer.contracts.*;
import panzer.manager.Engine;
import panzer.manager.ManagerImpl;
import panzer.core.PanzerBattleOperator;
import panzer.factories.PartFactoryImpl;
import panzer.factories.VehicleFactoryImpl;
import panzer.io.ConsoleReader;
import panzer.io.ConsoleWriter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        VehicleFactoryImpl vehicleFactory = new VehicleFactoryImpl();
        PartFactoryImpl partFactory = new PartFactoryImpl();
        BattleOperator battleOperator = new PanzerBattleOperator();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        OutputWriter writer = new ConsoleWriter();
        InputReader reader = new ConsoleReader(bufferedReader);
        Manager manager = new ManagerImpl(vehicleFactory, partFactory, battleOperator);

        Engine engine = new Engine(writer, reader, manager);

        engine.run();

    }
}
