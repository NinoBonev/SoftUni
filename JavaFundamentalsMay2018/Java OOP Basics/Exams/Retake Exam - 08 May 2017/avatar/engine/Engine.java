package engine;

import io.ConsoleReader;
import io.ConsoleWriter;
import utils.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Nino Bonev - 31.7.2018 г., 20:46
 */
public class Engine {
    private ConsoleReader reader;
    private ConsoleWriter writer;
    private GameManager gameManager;

    public Engine() {
        this.reader = new ConsoleReader();
        this.writer = new ConsoleWriter();
        this.gameManager = new GameManager();
    }

    public void run() throws IOException {
        String command;

        while(true) {
            command = this.reader.readLine();
            String[] cmdArgs = command.split("\\s+");

            this.dispatchCommand(cmdArgs);
            if (command.equals(Constants.TERMINAL_COMMAND)) {
                break;
            }
        }
    }

    private void dispatchCommand(String[] cmdArgs) {
        String command = cmdArgs[0];

        switch (command){
            case "Bender" :
                String benderType = cmdArgs[1];
                String benderName = cmdArgs[2];
                long power = Long.parseLong(cmdArgs[3]);
                double addParam = Double.parseDouble(cmdArgs[4]);
                this.gameManager.createBender(benderType, benderName, power, addParam);
                break;
            case "Monument" :
                String monumentType = cmdArgs[1];
                String monumentName = cmdArgs[2];
                int affinity = Integer.parseInt(cmdArgs[3]);
                this.gameManager.createMonument(monumentType, monumentName, affinity);
                break;
            case "Status" :
                String nation = cmdArgs[1];
                this.writer.writeLine(this.gameManager.getStatus(nation));
                break;
            case "War" :
                this.gameManager.war(cmdArgs[1]);
                break;
            case "Quit" :
                this.writer.writeLine(this.gameManager.quit());
        }
    }
}
