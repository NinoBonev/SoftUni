import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 3.6.2018 г., 11:13
 */
public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String word:
             bannedWords) {
            StringBuilder wordReplacement = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                wordReplacement.append('*');
            }
            text = text.replace(word, wordReplacement.toString());
        }

        System.out.println(text);
    }
}
