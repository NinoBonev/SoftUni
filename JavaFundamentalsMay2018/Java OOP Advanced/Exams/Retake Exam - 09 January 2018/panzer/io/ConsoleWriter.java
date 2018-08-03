package panzer.io;

import panzer.contracts.OutputWriter;

/**
 * Created by Nino Bonev - 11.7.2018 г., 18:06
 */
public class ConsoleWriter implements OutputWriter {

    public ConsoleWriter() {
    }

    @Override
    public void println(String output) {
        System.out.println(output);
    }

    @Override
    public void print(String output) {
        System.out.print(output);
    }
}
