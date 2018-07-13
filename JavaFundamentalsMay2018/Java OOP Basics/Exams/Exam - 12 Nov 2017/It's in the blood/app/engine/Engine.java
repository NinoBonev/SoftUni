package app.engine;


import app.io.ConsoleReader;
import app.io.ConsoleWriter;
import app.utils.Constants;

/**
 * Created by Nino Bonev - 11.7.2018 г., 17:57
 */
public class Engine {
    private ConsoleReader reader;
    private ConsoleWriter writer;
    private HealthManager healthManager;

    public Engine() {
        this.reader = new ConsoleReader();
        this.writer = new ConsoleWriter();
        this.healthManager = new HealthManager();
    }

    public void run(){

        String command = this.reader.nextLine();
        while (!Constants.TERMINAL_COMMAND.equals(command)){
            String[] cmdArgs = command.split("\\s+");

            String commandResult = null;
            String organismName = null;
            String clusterId = null;
            int row = -1;
            int col = -1;

            switch (cmdArgs[0]){
                case "checkCondition" :
                    commandResult = this.healthManager.checkCondition(cmdArgs[1]);
                    if (!Constants.EMPTY_STRING.equals(commandResult)){
                        this.writer.writeLine(commandResult);
                    }
                    break;
                case "createOrganism" :
                    this.writer.writeLine(this.healthManager.createOrganism(cmdArgs[1]));
                    break;
                case "addCluster" :
                    organismName = cmdArgs[1];
                    clusterId = cmdArgs[2];
                    row = Integer.parseInt(cmdArgs[3]);
                    col = Integer.parseInt(cmdArgs[4]);

                    commandResult = this.healthManager.addCluster(organismName, clusterId, row, col);

                    if (!Constants.EMPTY_STRING.equals(commandResult)){
                        this.writer.writeLine(commandResult);
                    }
                    break;
                case "addCell" :
                    organismName = cmdArgs[1];
                    clusterId = cmdArgs[2];
                    String cellType = cmdArgs[3];
                    String cellId = cmdArgs[4];
                    int health = Integer.parseInt(cmdArgs[5]);
                    row = Integer.parseInt(cmdArgs[6]);
                    col = Integer.parseInt(cmdArgs[7]);
                    int addProperty = Integer.parseInt(cmdArgs[8]);

                    commandResult = this.healthManager.addCell(organismName, clusterId,
                            cellType, cellId, health, row, col, addProperty);
                    if (!Constants.EMPTY_STRING.equals(commandResult)){
                        this.writer.writeLine(commandResult);
                    }
                    break;
                case "activateCluster" :
                    organismName = cmdArgs[1];
                    commandResult = this.healthManager.activateCluster(cmdArgs[1]);
                    if (!Constants.EMPTY_STRING.equals(commandResult)){
                        this.writer.writeLine(commandResult);
                    }
                    break;
            }

            command = this.reader.nextLine();
        }
    }
}
