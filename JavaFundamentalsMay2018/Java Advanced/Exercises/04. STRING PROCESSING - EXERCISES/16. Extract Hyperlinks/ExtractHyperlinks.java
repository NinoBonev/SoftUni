import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Nino Bonev - 3.6.2018 г., 22:53
 */
public class ExtractHyperlinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine;
        StringBuilder sb = new StringBuilder();
        while (!"END".equals(inputLine = scanner.nextLine())) {
            sb.append(inputLine);
        }
        String text = sb.toString();

        Pattern pattern = Pattern.compile("<a[\\s\\S]*?\\s+href\\s*={0,1}\\s*([\"'])?([\\s\\S]*?)(?:>|class|\\1)[\\s\\S]*?<\\/a>");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            System.out.println(matcher.group(2));
        }
    }
}
