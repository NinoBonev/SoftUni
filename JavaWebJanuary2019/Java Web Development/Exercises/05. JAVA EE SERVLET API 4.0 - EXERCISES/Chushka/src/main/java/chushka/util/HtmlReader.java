package chushka.util;

import java.io.*;

/**
 * Created by Nino Bonev - 5.2.2019 г., 23:51
 */
public class HtmlReader {

    public String readHtmlFile(String htmlPathFile) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(
                                new File(htmlPathFile))));
        StringBuilder htmlFileContent = new StringBuilder();
        String line;
        while ((line=reader.readLine()) != null && line.length()>0){
            htmlFileContent.append(line).append(System.lineSeparator());
        }
        return htmlFileContent.toString();
    }
}
