import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WormIpsum {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        Pattern sentencePattern = Pattern.compile("^[A-Z][^.]+.$");

        String line;
        while (!"Worm Ipsum".equals(line = console.readLine()))
        {
            Matcher sentenceMatcher = sentencePattern.matcher(line);

            if (sentenceMatcher.find())
            {
                String[] words = line.split("[\\s\\.]+");
                StringBuilder newString = new StringBuilder();

                for (String word:
                     words) {

                    Map<Character, Integer> chars = new LinkedHashMap<>();

                    for (int i = 0; i < word.length(); i++){
                        if (!chars.containsKey(word.charAt(i)))
                        {
                            chars.put(word.charAt(i), 1);
                        } else {
                            int current = chars.get(word.charAt(i));
                            chars.replace(word.charAt(i), current, current+1);
                        }
                    }

                    Map<Character, Integer> mostUsedChar = chars.entrySet().stream()
                            .filter(a -> a.getValue() > 1)
                            .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                            .limit(1)
                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                    (oldValue, newValue) -> oldValue, LinkedHashMap::new));

                    if (mostUsedChar.size() == 0)
                    {
                        newString.append(word + " ");
                    } else {
                        for (Map.Entry<Character, Integer> a:
                                mostUsedChar.entrySet()) {

                            StringBuilder newWord = new StringBuilder();
                            Character replacement = a.getKey();

                            for (int i = 0; i < word.length(); i++)
                            {
                                newWord.append(replacement);
                            }

                            newString.append(newWord + " ");
                        }
                    }
                }

                System.out.println(newString.deleteCharAt(newString.length() - 1) + ".");
            }
        }
    }
}
