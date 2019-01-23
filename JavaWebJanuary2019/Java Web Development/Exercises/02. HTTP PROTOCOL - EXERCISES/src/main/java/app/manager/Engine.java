package main.java.app.manager;

import main.java.app.contracts.InputReader;
import main.java.app.contracts.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Nino Bonev - 22.1.2019 г., 19:33
 */
public class Engine {
    private InputReader reader;
    private OutputWriter writer;
    private ManagerImpl manager;

    public Engine(OutputWriter writer, InputReader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    public void run() {
        String line = "";
        List<String> request = new ArrayList<>();

        while ((line = this.reader.readLine()) != null && line.length() > 0){
            request.add(line);
        }

        request.add(System.lineSeparator());

        if ((line = reader.readLine()) != null && line.length() > 0){
            request.add(line);
        }

        this.dispatchCommand(request);
    }

    private void dispatchCommand(List<String> cmdArgs) {
        this.setManager(cmdArgs);
        this.manager.setValidUrls(cmdArgs.get(0));

        this.writer.print(this.manager.validateRequest());

    }

    private void setManager(List<String> data){
        this.manager = new ManagerImpl(data);
    }
}
