package onehitdungeon.manager;

import onehitdungeon.constants.EngineConstants;
import onehitdungeon.interfaces.DungeonManager;
import onehitdungeon.interfaces.InputReader;
import onehitdungeon.interfaces.OutputWriter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 3.8.2018 г., 15:59
 */
public class Engine {
    private InputReader reader;
    private OutputWriter writer;
    private DungeonManager manager;

    public Engine(OutputWriter writer, InputReader reader, DungeonManager manager) {
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
                result = this.manager.hero(params).trim();
                break;
            case "Select":
                result = this.manager.select(params).trim();
                break;
            case "Status":
                result = this.manager.status(params).trim();
                break;
            case "Fight":
                result = this.manager.fight(params).trim();
                break;
            case "Advance":
                result = this.manager.advance(params).trim();
                break;
            case "Train":
                result = this.manager.train(params).trim();
                break;
            case "Quit":
                result = this.manager.quit(params).trim();
                break;
        }

        this.writer.println(result);

    }
}
