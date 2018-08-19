package hell.io;

import hell.interfaces.OutputWriter;

/**
 * Created by Nino Bonev - 3.8.2018 г., 16:02
 */
public class ConsoleWriter implements OutputWriter {
    public ConsoleWriter() {
    }

    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }

    @Override
    public void writeLine(String format, Object... params) {
        System.out.print(String.format(format, params));
    }
}
