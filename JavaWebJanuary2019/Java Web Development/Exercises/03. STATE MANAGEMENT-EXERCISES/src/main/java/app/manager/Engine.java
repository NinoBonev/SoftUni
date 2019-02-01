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

        // Those were needed for the previous Lab, but seems to be not needed for this one !!!

//        request.add(System.lineSeparator());
//
//        if ((line = reader.readLine()) != null && line.length() > 0){
//            request.add(line);
//        }
//
        this.dispatchCommand(request);
    }

    private void dispatchCommand(List<String> cmdArgs) {
        this.setManager(cmdArgs);
        /*I disabled this validation, because it's not been required for this task
         and all the Inputs are with no 'Authorization' header and it's returning
         Unauthorized message - not the cookies !!!

        */
        //this.manager.setValidUrls(cmdArgs.get(0));

        //this.writer.print(this.manager.validateRequest());
        this.writer.print(this.manager.printCookies());
    }

    private void setManager(List<String> data){
        this.manager = new ManagerImpl(data);
    }
}
