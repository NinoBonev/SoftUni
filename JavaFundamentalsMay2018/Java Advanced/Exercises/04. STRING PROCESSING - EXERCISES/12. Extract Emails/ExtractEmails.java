import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Nino Bonev - 3.6.2018 г., 18:38
 */
public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String emails;
        StringBuilder str = new StringBuilder();

        while (!"end".equals(emails = scanner.nextLine())){
            str.append(emails);
        }
        Pattern pattern = Pattern.compile("(?<!\\S)[a-z][a-z0-9\\.\\-_]+[a-z0-9]*@[a-z][a-z\\-]+(\\.[a-z]+)+");
        Matcher matches = pattern.matcher(str.toString());

        while (matches.find()){
            System.out.println(matches.group());
        }
    }
}
