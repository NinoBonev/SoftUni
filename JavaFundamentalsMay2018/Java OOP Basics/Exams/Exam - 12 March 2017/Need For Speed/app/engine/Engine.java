package app.engine;

import app.entities.cars.Car;
import app.factories.CarFactory;
import app.io.ConsoleReader;
import app.io.ConsoleWriter;
import app.utils.Constants;

import java.io.IOException;

/**
 * Created by Nino Bonev - 14.7.2018 г., 9:19
 */
public class Engine {
    private ConsoleReader reader;
    private ConsoleWriter writer;
    private CarManager carManager;

    public Engine() {
        this.reader = new ConsoleReader();
        this.writer = new ConsoleWriter();
        this.carManager = new CarManager();
    }

    public void run() {
        String command = this.reader.nextLine();
        while (!Constants.TERMINAL_COMMAND.equals(command)) {
            String[] cmdArgs = command.split("\\s+");
            switch (cmdArgs[0]){
                case "register" :
                    this.carManager.register(Integer.parseInt(cmdArgs[1]), cmdArgs[2], cmdArgs[3], cmdArgs[4], Integer.parseInt(cmdArgs[5]),
                            Integer.parseInt(cmdArgs[6]), Integer.parseInt(cmdArgs[7]),
                            Integer.parseInt(cmdArgs[8]), Integer.parseInt(cmdArgs[9]));
                    break;
                case "check" :
                    this.writer.writeLine(this.carManager.check(Integer.parseInt(cmdArgs[1])));
                    break;
                case "open" :
                    this.carManager.open(Integer.parseInt(cmdArgs[1]),cmdArgs[2],
                            Integer.parseInt(cmdArgs[3]), cmdArgs[4], Integer.parseInt(cmdArgs[5]));
                    break;
                case "participate" :
                    this.carManager.participate(Integer.parseInt(cmdArgs[1]), Integer.parseInt(cmdArgs[2]));
                    break;
                case "start" :
                    this.writer.writeLine(this.carManager.start(Integer.parseInt(cmdArgs[1])));
                    break;
                case "park" :
                    this.carManager.park(Integer.parseInt(cmdArgs[1]));
                    break;
                case "unpark" :
                    this.carManager.unpark(Integer.parseInt(cmdArgs[1]));
                    break;
                case "tune" :
                    this.carManager.tune(Integer.parseInt(cmdArgs[1]), cmdArgs[2]);
                    break;
            }

            command = this.reader.nextLine();

        }
    }
}
