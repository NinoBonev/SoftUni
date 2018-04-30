import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class NetherRealms {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<Integer, Double>> demons = new TreeMap<>();

        List<String> demonNames = Arrays.asList(console.readLine().replace(" ", "").split(","));

        for (String demonName:
                demonNames) {

            Pattern patternDemonDamage = Pattern.compile("[\\-\\+]?[\\d]+(?:[\\.]*[\\d]+|[\\d]*)");
            Matcher matcherDemonDamage = patternDemonDamage.matcher(demonName);
            int damageMultiplier = 0;
            int damageDevidier = 0;
            Double thisDemonDamage = 0.0;

            Pattern patternDemonHealth = Pattern.compile("([^0-9*\\.\\+\\-\\/]+)");
            Matcher matcherDemonHealth = patternDemonHealth.matcher(demonName);
            Integer thisDemonHealth = 0;

            while (matcherDemonDamage.find())
            {
                double currentDemonDamage = Double.parseDouble(matcherDemonDamage.group());
                thisDemonDamage += currentDemonDamage;
            }
            while (matcherDemonHealth.find())
            {
                for (int i = 0; i < matcherDemonHealth.group().length(); i++)
                {
                    int currentDemonHelath = matcherDemonHealth.group().charAt(i);
                    thisDemonHealth += currentDemonHelath;
                }
            }
            for (int i = 0; i< demonName.length(); i++)
            {
                if (demonName.charAt(i) == '*')
                {
                    damageMultiplier ++;
                }
                else if (demonName.charAt(i) == '/')
                {
                    damageDevidier ++;
                }
            }
            if (damageDevidier > 0)
            {
                thisDemonDamage = thisDemonDamage / Math.pow(2, damageDevidier);
            }
            if (damageMultiplier > 0)
            {
                thisDemonDamage = thisDemonDamage * Math.pow(2, damageMultiplier);
            }

            demons.putIfAbsent(demonName, new TreeMap<>());
            demons.get(demonName).put(thisDemonHealth, thisDemonDamage);

        }

        demons.entrySet().stream().forEach(x -> {
            x.getValue().entrySet().stream().forEach(y -> {
                System.out.printf("%s - %d health, %.2f damage%n", x.getKey(), y.getKey(), y.getValue());
            });
        });
    }
}