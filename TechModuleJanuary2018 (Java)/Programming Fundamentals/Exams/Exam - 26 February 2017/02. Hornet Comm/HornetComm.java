import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HornetComm {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String seperator = " <-> ";
        List<String> messages = new ArrayList<>();
        List<String> broadcast = new ArrayList<>();

        while (true)
        {
            String input = console.readLine();
            List<String> data = Arrays.asList(input.split(seperator));

            if (input.equals("Hornet is Green"))
            {
                break;
            }

            else if (data.size() >= 2)
            {
                String firstQuery = data.get(0);
                String secondQuery = data.get(1);
                boolean firstIsDigit = firstQuery.trim().matches("[0-9]+");
                boolean secondIsDigitOrLetter = secondQuery.trim().matches("[A-Za-z0-9]+");
                boolean firstIsNoDigit = firstQuery.trim().matches("[^0-9]+");

                if (firstIsDigit && secondIsDigitOrLetter)
                {
                    String reverse = new StringBuffer(firstQuery).reverse().toString();

                    messages.add(MessageFormat.format("{0} -> {1}", reverse, secondQuery));
                }

                else if (firstIsNoDigit && secondIsDigitOrLetter)
                {
                    StringBuilder next = new StringBuilder();
                    for (int i = 0; i < secondQuery.length(); i++)
                    {
                        if (secondQuery.charAt(i) >= 65 && secondQuery.charAt(i) <= 90)
                        {
                            next.append(((char)(secondQuery.charAt(i) + 32)));
                        }
                        else if (secondQuery.charAt(i) >= 97 && secondQuery.charAt(i) <= 122)
                        {
                            next.append((char)(secondQuery.charAt(i) - 32));
                        }
                        else
                        {
                            next.append((char)secondQuery.charAt(i));
                        }
                    }

                    broadcast.add(MessageFormat.format("{0} -> {1}", next, firstQuery));
                }

            }

        }

        System.out.println("Broadcasts:");

        if (broadcast.size() > 0)
        {
            for (String message:
                    broadcast) {
                System.out.println(message);
            }
        }
        else
        {
            System.out.println("None");
        }

        System.out.println("Messages:");

        if (messages.size() > 0)
        {
            for (String message:
                    messages) {
                System.out.println(message);
            }
        }
        else
        {
            System.out.println("None");
        }

    }
}
