import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) throws IOException{

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<String> tickets = Arrays.asList(console.readLine().replace(",", "").split("\\s+"));
        String patternString = "[$]{6,10}|[@]{6,10}|[#]{6,10}|[\\^]{6,10}";
        Pattern pattern = Pattern.compile(patternString);

        for (String ticket:
             tickets) {

            if (ticket.length() == 20)
            {
                String leftTicketSide = ticket.substring(0, 10);
                String rightTicketSide = ticket.substring(10, 20);

                Matcher matcherLeft = pattern.matcher(leftTicketSide);
                Matcher matcherRight = pattern.matcher(rightTicketSide);

                if (matcherLeft.find() && matcherRight.find())
                {
                    if ((matcherLeft.group().length() == 10 && matcherRight.group().length() == 10)
                            && matcherLeft.group().charAt(0) == matcherRight.group().charAt(0))
                    {
                        System.out.printf("ticket \"%s\" - 10%c Jackpot!%n", ticket, matcherLeft.group().charAt(0));
                    }
                    else if ((matcherLeft.group().length() < 10 && matcherRight.group().length() <= 10)
                            && matcherLeft.group().charAt(0) == matcherRight.group().charAt(0))
                    {
                        Integer realMatch = Math.min(matcherLeft.group().length(), matcherRight.group().length());
                        System.out.printf("ticket \"%s\" - %d%c%n", ticket, realMatch, matcherLeft.group().charAt(0));
                    }
                    else if ((matcherLeft.group().length() <= 10 && matcherRight.group().length() < 10)
                            && matcherLeft.group().charAt(0) == matcherRight.group().charAt(0))
                    {
                        Integer realMatch = Math.min(matcherLeft.group().length(), matcherRight.group().length());
                        System.out.printf("ticket \"%s\" - %d%c%n", ticket, realMatch, matcherLeft.group().charAt(0));
                    }
                }
                else
                {
                    System.out.printf("ticket \"%s\" - no match%n", ticket);
                }
            }
            else
            {
                System.out.println("invalid ticket");
            }
        }

    }
}
