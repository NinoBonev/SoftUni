package cresla.io;

import cresla.interfaces.OutputWriter;

/**
 * Created by Nino Bonev - 11.7.2018 г., 18:06
 */
public class ConsoleWriter implements OutputWriter {

    public ConsoleWriter() {
    }

    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }

    @Override
    public void write(String output) {
        System.out.print(output);
    }
}
