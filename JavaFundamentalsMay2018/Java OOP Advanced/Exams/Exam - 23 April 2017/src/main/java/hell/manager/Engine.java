package hell.manager;

import hell.constants.EngineConstants;
import hell.interfaces.InputReader;
import hell.interfaces.OutputWriter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 3.8.2018 г., 15:59
 */
public class Engine {
    private Manager manager;
    private InputReader reader;
    private OutputWriter writer;
    //private MissionManager manager;

    public Engine(OutputWriter writer, InputReader reader, Manager manager) {
        this.writer = writer;
        this.reader = reader;
        this.manager = manager;
    }

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

        String result = "";
        switch (command) {
            case "Hero":
                result = this.manager.createHero(params).trim();
                break;
            case "Item":
                result = this.manager.createCommonItem(params).trim();
                break;
            case "Recipe":
                result = this.manager.createRecipeItem(params).trim();
                break;
            case "Inspect":
                result = this.manager.inspectHero(params).trim();
                break;
            case "Quit":
                result = this.manager.quitCommand(params).trim();
                break;
        }

        this.writer.writeLine(result);

    }
}
