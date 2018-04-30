import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Regexmon {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String input = console.readLine();

        Pattern patternBojomon = Pattern.compile("[\\w]+-[\\w]+");
        Matcher matcherBojomon = patternBojomon.matcher(input);

        Pattern patternDidimon = Pattern.compile("[^a-zA-Z\\-]+");
        Matcher matcherDidimon = patternDidimon.matcher(input);


        int index = 0;
        while (true)
        {
            if (matcherDidimon.find(index))
            {
                System.out.println(matcherDidimon.group());
                index = matcherDidimon.end();
            } else {
                break;
            }

            if (matcherBojomon.find(index))
            {
                System.out.println(matcherBojomon.group());
                index = matcherBojomon.end();
            } else {
                break;
            }
        }
    }
}