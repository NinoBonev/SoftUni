import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Nino Bonev - 3.6.2018 г., 13:06
 */
public class MatchFullName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^[A-Z][a-z]+ [A-Z][a-z]+$";
        String text;

        while (!"end".equals(text = scanner.nextLine())){
            if (Pattern.matches(regex, text)){
                System.out.println(text);
            }
        }
    }
}
