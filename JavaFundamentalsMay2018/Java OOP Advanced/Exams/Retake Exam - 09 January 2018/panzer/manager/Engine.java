package panzer.manager;

import panzer.constants.EngineConstants;
import panzer.contracts.InputReader;
import panzer.contracts.Manager;
import panzer.contracts.OutputWriter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 1.8.2018 г., 19:31
 */
public class Engine{
    private InputReader reader;
    private OutputWriter writer;
    private Manager manager;

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
            case "Vehicle":
                result = this.manager.addVehicle(params);
                break;
            case "Part":
                result = this.manager.addPart(params);
                break;
            case "Inspect":
                result = this.manager.inspect(params).trim();
                break;
            case "Battle":
                result = this.manager.battle(params);
                break;
            case "Terminate":
                result = this.manager.terminate(params);
                break;
        }

        this.writer.println(result);

    }
}
