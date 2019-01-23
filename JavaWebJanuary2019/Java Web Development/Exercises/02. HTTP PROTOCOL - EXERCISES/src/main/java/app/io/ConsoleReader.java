package main.java.app.io;

import main.java.app.contracts.InputReader;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Nino Bonev - 3.8.2018 г., 16:02
 */
public class ConsoleReader implements InputReader {
    private final BufferedReader reader;

    public ConsoleReader(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public String readLine(){
        try {
            return this.reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
