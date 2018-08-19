package callofduty.io;

import callofduty.interfaces.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Nino Bonev - 3.8.2018 г., 16:02
 */
public class ConsoleReader implements InputReader {
    private final BufferedReader reader;

    public ConsoleReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
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
