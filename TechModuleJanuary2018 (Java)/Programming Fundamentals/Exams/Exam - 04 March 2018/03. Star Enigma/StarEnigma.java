import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) throws IOException{

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        short num = Short.parseShort(console.readLine());

        String [] encriptedMessages = new String[num];
        List<String> realMessages = new ArrayList<>();
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        for (int i = 0; i < num; i++)
        {
            String encriptedMessage = console.readLine();
            encriptedMessages[i] = encriptedMessage;
        }

        for (String message:
             encriptedMessages) {

            int count = 0;
            StringBuilder newMessage = new StringBuilder();

            for (int i = 0; i < message.length(); i++)
            {
                if (message.toLowerCase().charAt(i) == 's' || message.toLowerCase().charAt(i) == 't'
                        || message.toLowerCase().charAt(i) == 'a' || message.toLowerCase().charAt(i) == 'r')
                {
                    count++;
                }
            }

            for (int i = 0; i < message.length(); i++)
            {
                newMessage.append((char)(message.charAt(i) - count));
            }

            realMessages.add(newMessage.toString());
        }

        String stringPattern = "@([A-Za-z]+)[^@\\-!:>]*:([0-9]+)[^@\\-!:>]*!(A|D)![^@\\-!:>]*->([0-9]+)";
        Pattern pattern = Pattern.compile(stringPattern);

        for (String message:
             realMessages) {

            Matcher matcher = pattern.matcher(message);

            while (matcher.find())
            {
                String planet = matcher.group(1).replace("@", "");
                String type = matcher.group(3).replace("!", "");


                if (type.equals("A"))
                {
                    attackedPlanets.add(planet);
                }
                else if (type.equals("D"))
                {
                    destroyedPlanets.add(planet);
                }
            }
        }

        Collections.sort(attackedPlanets);
        Collections.sort(destroyedPlanets);
        System.out.printf("Attacked planets: %d%n", attackedPlanets.size());
        for (String attackedPlanet:
             attackedPlanets) {
            if (attackedPlanets.size() > 0)
            {

                System.out.printf("-> %s%n", attackedPlanet);
            }
        }
        System.out.printf("Destroyed planets: %d%n", destroyedPlanets.size());
        for (String destroyedPlanet:
                destroyedPlanets) {
            if (destroyedPlanets.size() > 0)
            {
                System.out.printf("-> %s%n", destroyedPlanet);
            }
        }

    }
}
