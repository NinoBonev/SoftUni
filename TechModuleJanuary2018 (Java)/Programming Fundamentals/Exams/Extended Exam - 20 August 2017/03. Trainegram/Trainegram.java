import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Trainegram {
    public static void main(String[] args) throws IOException{

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (!"Traincode!".equals(line = console.readLine()))
        {
            Pattern trainPattern = Pattern.compile("^(\\<\\[[^A-Za-z0-9]*\\][\\.]{1})+([\\.]{1}\\[[A-Za-z0-9]*\\][\\.]{1})*$");
            Matcher trainMatcher = trainPattern.matcher(line);

            if (trainMatcher.find())
            {
                System.out.println(line);
            }
        }
    }
}