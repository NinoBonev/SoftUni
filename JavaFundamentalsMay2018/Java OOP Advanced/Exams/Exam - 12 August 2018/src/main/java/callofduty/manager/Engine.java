package callofduty.manager;


import callofduty.constants.EngineConstants;
import callofduty.interfaces.InputReader;
import callofduty.interfaces.MissionManager;
import callofduty.interfaces.OutputWriter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 3.8.2018 г., 15:59
 */
public class Engine {
    private InputReader reader;
    private OutputWriter writer;
    private MissionManager manager;

    public Engine(OutputWriter writer, InputReader reader, MissionManager manager) {
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
            case "Agent":
                result = this.manager.agent(params).trim();
                break;
            case "Request":
                result = this.manager.request(params).trim();
                break;
            case "Complete":
                result = this.manager.complete(params).trim();
                break;
            case "Status":
                result = this.manager.status(params).trim();
                break;
            case "Over":
                result = this.manager.over(params).trim();
                break;
        }

        this.writer.println(result);

    }
}
