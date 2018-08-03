package cresla.io;

import cresla.interfaces.InputReader;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Nino Bonev - 11.7.2018 г., 18:00
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
