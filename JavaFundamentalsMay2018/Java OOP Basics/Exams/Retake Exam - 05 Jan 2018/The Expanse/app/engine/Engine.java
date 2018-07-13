package app.engine;

import app.entities.Colony;
import app.entities.colonists.Colonist;
import app.factories.ColonistFactory;
import app.io.ConsoleReader;
import app.io.ConsoleWriter;
import app.utils.Constants;

import java.io.IOException;

/**
 * Created by Nino Bonev - 12.7.2018 г., 12:03
 */
public class Engine {
    private final Colony colony;
    private final ConsoleReader reader;
    private final ConsoleWriter writer;

    public Engine(Colony colony, ConsoleReader reader) {
        this.colony = colony;
        this.reader = reader;
        this.writer = new ConsoleWriter();
    }

    public void run() throws IOException {

        String command = this.reader.readLine();
        while (!Constants.TERMINAL_COMMAND.equals(command)) {
            String[] cmdArgs = command.split("\\s+");

            try {
                switch (cmdArgs[0]) {
                    case "insert":
                        insertCommand(cmdArgs);
                        break;
                    case "remove":
                        removeCommand(cmdArgs);
                        break;
                    case "grow":
                        Integer growAge = Integer.parseInt(cmdArgs[1]);
                        this.colony.grow(growAge);
                        break;
                    case "potential":
                        writer.writeLine(String.format("potential: %d%n", this.colony.getPotential()));
                        break;
                    case "capacity":
                        writer.writeLine(this.colony.getCapacity());
                        break;
                    case "family":
                        String familyId = cmdArgs[1];
                        writer.writeLine(this.colony.printFamily(familyId));
                        break;
                }
            } catch (IllegalArgumentException exp){
                writer.writeLine(exp.getMessage());
            }

            command = this.reader.readLine();
        }
    }

    private void removeCommand(String[] cmdArgs) {
        String modificator = cmdArgs[1];
        if (modificator.equals("family")){
            this.colony.removeFamily(cmdArgs[2]);
        } else if (modificator.equals("colonist")){
            this.colony.removeColonist(cmdArgs[2], cmdArgs[3]);
        }
    }

    private void insertCommand(String[] cmdArgs) {
        Colonist colonist = ColonistFactory.createColonist(cmdArgs);
        if (colonist != null) {
            this.colony.addColonist(colonist);
        }
    }
}
