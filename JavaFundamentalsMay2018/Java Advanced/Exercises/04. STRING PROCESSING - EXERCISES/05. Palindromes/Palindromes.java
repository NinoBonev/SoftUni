import java.util.*;

/**
 * Created by Nino Bonev - 3.6.2018 г., 12:07
 */
public class Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] textWords = scanner.nextLine().split("[,\\.?!\\s+]+");

        Set<String> words = new HashSet<>();
        Set<String> palindromes = new TreeSet<>();
        Collections.addAll(words, textWords);

        for (String word:
             words) {
            boolean even = true;

            if (word.length() % 2 != 0){
                even = false;
            }

            if (even) {
                String firstHalf = word.substring(0, word.length() / 2);
                String secondHalf = word.substring(word.length() / 2, word.length());
                String reversedSecondWord = new StringBuilder(secondHalf).reverse().toString();

                if (firstHalf.equals(reversedSecondWord)) {
                    palindromes.add(word);
                }

            } else {
                String firstHalf = word.substring(0, word.length() / 2);
                String secondHalf = word.substring(word.length() / 2 + 1, word.length());
                String reversedSecondWord = new StringBuilder(secondHalf).reverse().toString();

                if (firstHalf.equals(reversedSecondWord)) {
                    palindromes.add(word);
                }
            }
        }

        System.out.println(palindromes);
    }
}
