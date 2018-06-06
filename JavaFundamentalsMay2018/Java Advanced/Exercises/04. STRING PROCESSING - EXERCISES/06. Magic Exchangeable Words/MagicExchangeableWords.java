import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 3.6.2018 г., 12:33
 */
public class MagicExchangeableWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        String firstWord = input[0];
        String secondWord = input[1];
        int lenMin = Math.min(firstWord.length(), secondWord.length());


        boolean result = true;

        Map<Character, Character> shortWordChars = new HashMap<>();
        String rest = "";


        for (int i = 0; i < lenMin; i++) {

            if (!shortWordChars.containsKey(firstWord.charAt(i))) {
                if (!shortWordChars.containsValue(secondWord.charAt(i))) {
                    shortWordChars.put(firstWord.charAt(i), secondWord.charAt(i));
                } else {
                    result = false;
                    break;
                }
            } else {
                if (shortWordChars.get(firstWord.charAt(i)) != secondWord.charAt(i)) {
                    result = false;
                    break;
                }
            }
        }

        if (firstWord.length() > secondWord.length()) {
            rest = firstWord.substring(lenMin, firstWord.length());
        } else {
            rest = secondWord.substring(lenMin, secondWord.length());
        }

        for (int i = 0; i < rest.length(); i++) {
            if (!shortWordChars.containsKey(rest.charAt(i)) && !shortWordChars.containsValue(rest.charAt(i))) {
                result = false;
            }
        }

        System.out.println(result);

    }
}
