package cresla.manager;

import cresla.constants.EngineConstants;
import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;

import java.util.Arrays;
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
            case "Reactor":
                result = manager.reactorCommand(params);
                break;
            case "Module":
                result = manager.moduleCommand(params);;
                break;
            case "Report":
                result = manager.reportCommand(params);
                break;
            case "Exit":
                result = manager.exitCommand(params);
                break;
        }

        this.writer.writeLine(result);

    }
}
