package app.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 11.7.2018 г., 18:00
 */
public class ConsoleReader {
    private BufferedReader reader;

    public ConsoleReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String nextLine() {
        String result = null;

        try {
            return this.reader.readLine();
        } catch (IOException e){}

        return result;
    }
}
