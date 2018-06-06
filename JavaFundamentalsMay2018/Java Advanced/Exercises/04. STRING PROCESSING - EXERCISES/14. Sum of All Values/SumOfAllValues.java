import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Nino Bonev - 3.6.2018 г., 20:48
 */
public class SumOfAllValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String keyString = scanner.nextLine();
        String textString = scanner.nextLine();

        Pattern keyStringPattern = Pattern.compile("(?<=^)([A-Za-z_]+)(?=\\d).*(?<=\\d)([A-Za-z_]+)(?=$)");
        Matcher keyMatcher = keyStringPattern.matcher(keyString);

        if (keyMatcher.find()){
            String start = keyMatcher.group(1);
            String end = keyMatcher.group(2);

            Pattern textStringPattern = Pattern.compile(start + "(\\d*(?:\\.\\d+)?)" + end);
            Matcher textMatcher = textStringPattern.matcher(textString);

            double sum = 0.00;
            while (textMatcher.find() && !textMatcher.group(1).isEmpty()){
                Double thisSum = Double.parseDouble(textMatcher.group(1));
                sum += thisSum;
            }

            if (sum != 0d){
                if (sum == (int) sum) {
                    System.out.printf("<p>The total value is: <em>%d</em></p>%n", (int) sum);
                } else {
                    System.out.printf("<p>The total value is: <em>%.2f</em></p>%n", sum);
                }
            } else {
                System.out.println("<p>The total value is: <em>nothing</em></p>");
            }
        } else {
            System.out.println("<p>A key is missing</p>");
        }
    }
}
