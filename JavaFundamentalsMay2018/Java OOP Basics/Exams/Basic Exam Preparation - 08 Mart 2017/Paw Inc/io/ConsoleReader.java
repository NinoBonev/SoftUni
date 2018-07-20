package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Nino Bonev - 11.7.2018 г., 18:00
 */
public class ConsoleReader {
    private BufferedReader scanner;

    public ConsoleReader() {
        this.scanner = new BufferedReader(new InputStreamReader(System.in));
    }

    public String nextLine() throws IOException {
        return this.scanner.readLine();
    }
}
