package fdmc.utils;

import java.io.IOException;

/**
 * Created by Nino Bonev - 1.2.2019 г., 13:33
 */
public interface HtmlReader {

    String readHtmlFile(String htmlFilePath) throws IOException;
}
