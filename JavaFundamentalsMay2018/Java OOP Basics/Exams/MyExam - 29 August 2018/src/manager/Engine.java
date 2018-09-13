package manager;

import constants.EngineConstants;
import interfaces.InputReader;
import interfaces.OutputWriter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 3.8.2018 г., 15:59
 */
public class Engine implements Runnable {
    private InputReader reader;
    private OutputWriter writer;
    private ManagerImpl manager;

    public Engine(OutputWriter writer, InputReader reader, ManagerImpl manager) {
        this.writer = writer;
        this.reader = reader;
        this.manager = manager;
    }

    @Override
    public void run() {
        String command;

        while (true) {
            command = this.reader.readLine();
            String[] cmdArgs = command.split("\\s+");

            this.dispatchCommand(cmdArgs);
            if (command.equals(EngineConstants.TERMINAL_COMMAND)) {
                break;
            }
        }
    }

    private void dispatchCommand(String[] cmdArgs) {
        String command = cmdArgs[0];
        List<String> params = Arrays.stream(cmdArgs)
                .skip(1)
                .collect(Collectors.toList());

        StringBuilder result = new StringBuilder();
        switch (command) {
            case "CREATE_PROVINCE:":
                result.append(this.manager.createProvince(params).trim())
                .append(System.lineSeparator())
                .append("---");
                break;
            case "SELECT:":
                result.append(this.manager.selectProvince(params).trim())
                        .append(System.lineSeparator())
                        .append("---");
                break;
            case "ADD_HERO:":
                result.append(this.manager.addHero(params).trim())
               .append(System.lineSeparator())
                        .append("---");
                break;
            case "ADD_GUILD:":
                result.append(this.manager.addGuild(params).trim())
                        .append(System.lineSeparator())
                        .append("---");
                break;
            case "REMOVE:":
                if (params.size() == 1){
                    result.append(this.manager.removeGuild(params).trim())
                            .append(System.lineSeparator())
                            .append("---");
                } else {
                    result.append(this.manager.removeHero(params).trim())
                            .append(System.lineSeparator())
                            .append("---");
                }
                break;
            case "DETAILS:":
                if (params.size() == 1) {
                    result.append(this.manager.guildDetails(params).trim())
                            .append(System.lineSeparator())
                            .append("---");
                } else {
                    result.append(this.manager.heroDetails(params).trim())
                            .append(System.lineSeparator())
                            .append("---");
                }
                break;
            case "FIGHT:":
                result.append(this.manager.fight(params).trim())
                        .append(System.lineSeparator())
                        .append("---");
                break;
            case "END":
                result.append(this.manager.end(params).trim());
                break;
        }

        this.writer.println(result.toString());

    }
}
