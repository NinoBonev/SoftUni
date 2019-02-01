package main.java.app;

import main.java.app.contracts.InputReader;
import main.java.app.contracts.OutputWriter;
import main.java.app.io.ConsoleReader;
import main.java.app.io.ConsoleWriter;
import main.java.app.manager.Engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Nino Bonev - 20.1.2019 г., 15:06
 */
public class Application {

    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        OutputWriter writer = new ConsoleWriter();
        InputReader reader = new ConsoleReader(bufferedReader);

        Engine engine = new Engine(writer, reader);

        engine.run();
    }

}
