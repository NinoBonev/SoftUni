package engine;

import io.ConsoleReader;
import io.ConsoleWriter;
import utils.Constants;

import java.io.IOException;


/**
 * Created by Nino Bonev - 18.7.2018 г., 22:18
 */
public class Engine {
    private ConsoleReader reader;
    private ConsoleWriter writer;
    private AnimalCenterManager manager;

    public Engine() {
        this.reader = new ConsoleReader();
        this.writer = new ConsoleWriter();
        this.manager = new AnimalCenterManager();
    }

    public void run() throws IOException {
        String command = this.reader.nextLine();
        while (!Constants.TERMINAL_COMMAND.equals(command)) {
            String[] cmdArgs = command.split(" \\| ");

            switch (cmdArgs[0]) {
                case "RegisterCleansingCenter" :
                    this.manager.registerCleansingCenter(cmdArgs[1]);
                    break;
                case "RegisterAdoptionCenter" :
                    this.manager.registerAdoptionCenter(cmdArgs[1]);
                    break;
                case "RegisterDog" :
                    this.manager.registerDog(cmdArgs[1], Integer.parseInt(cmdArgs[2]), Integer.parseInt(cmdArgs[3]), cmdArgs[4]);
                    break;
                case "RegisterCat" :
                    this.manager.registerCat(cmdArgs[1], Integer.parseInt(cmdArgs[2]), Integer.parseInt(cmdArgs[3]), cmdArgs[4]);
                    break;
                case "SendForCleansing" :
                    this.manager.sendForCleansing(cmdArgs[1], cmdArgs[2]);
                    break;
                case "Cleanse" :
                    this.manager.cleanse(cmdArgs[1]);
                    break;
                case "Adopt" :
                    this.manager.adopt(cmdArgs[1]);
                    break;
            }

            command = this.reader.nextLine();
        }

        this.manager.printStatistics();
    }

}
