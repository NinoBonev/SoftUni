package app.io;

import java.util.Scanner;

/**
 * Created by Nino Bonev - 11.7.2018 г., 18:00
 */
public class ConsoleReader {
    private Scanner scanner;

    public ConsoleReader() {
        this.scanner = new Scanner(System.in);
    }

    public String nextLine() {
        return this.scanner.nextLine();
    }
}
