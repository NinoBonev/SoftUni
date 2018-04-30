import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Raincast {
    public static void main(String[] args) throws IOException{

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> result = new LinkedHashMap<>();

        String lookingFor = "type";
        String currentType = "";
        String currentSource = "";
        String currentForecast = "";

        String line;
        while (!"Davai Emo".equals(line = console.readLine()))
        {
            Pattern typePattern = Pattern.compile("^Type:\\s(?<type>Normal|Warning|Danger)$");
            Pattern sourcePattern = Pattern.compile("^Source:\\s(?<source>[a-zA-Z0-9]+)$");
            Pattern forecastPattern = Pattern.compile("^Forecast:\\s(?<forecast>[^,!\\.\\?]*)$");

            Matcher typeMatcher = typePattern.matcher(line);
            Matcher sourceMatcher = sourcePattern.matcher(line);
            Matcher forecastMatcher = forecastPattern.matcher(line);

            if (typeMatcher.find() && lookingFor.equals("type") )
            {
                currentType = typeMatcher.group("type");
                lookingFor = "source";
            }
            if (sourceMatcher.find() && lookingFor.equals("source"))
            {
                currentSource = sourceMatcher.group("source");
                lookingFor = "forecast";
            }
            if (forecastMatcher.find()&& lookingFor.equals("forecast"))
            {
                currentForecast = forecastMatcher.group("forecast");

                String sourceForecast = currentForecast + " ~ " + currentSource;
                result.putIfAbsent(currentType, sourceForecast);
                currentType = "";
                currentSource = "";
                currentForecast = "";
                lookingFor = "type";
            }
        }

        result.entrySet().stream().forEach(z -> System.out.printf("(%s) %s%n", z.getKey(), z.getValue()));
    }
}
