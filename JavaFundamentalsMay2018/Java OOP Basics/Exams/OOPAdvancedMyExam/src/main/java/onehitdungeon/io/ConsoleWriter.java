package onehitdungeon.io;

import onehitdungeon.interfaces.OutputWriter;

/**
 * Created by Nino Bonev - 3.8.2018 г., 16:02
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
