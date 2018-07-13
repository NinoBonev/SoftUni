package app;

import app.engine.Engine;
import app.entities.Colony;
import app.factories.ColonistFactory;
import app.io.ConsoleReader;

import java.io.IOException;

/**
 * Created by Nino Bonev - 12.7.2018 г., 11:59
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ConsoleReader consoleReader = new ConsoleReader();

        String[] colonyData = consoleReader.readLine().split(" ");
        Integer maxFamilyCount = Integer.parseInt(colonyData[0]);
        Integer maxFamilyCapacity = Integer.parseInt(colonyData[1]);
        Colony colony = new Colony(maxFamilyCount, maxFamilyCapacity);

        Engine engine = new Engine(colony, consoleReader);

        engine.run();
    }
}
