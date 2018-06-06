import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Nino Bonev - 3.6.2018 г., 19:56
 */
public class SentenceExtractor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputPattern = scanner.nextLine().trim();
        String inputText = scanner.nextLine();
        List<String> text = new ArrayList<>();

        Pattern pattern = Pattern.compile("[^\\.!?]+?\\b[^\\.!?]+?[!?\\.]");
        Matcher matcher = pattern.matcher(inputText);

        while (matcher.find()){
            text.add(matcher.group().trim());
        }

        for (String sentace:
             text) {
            if (sentace.contains(" " + inputPattern + " ")){
                System.out.println(sentace);
            }
        }
    }
}
