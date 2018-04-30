import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpyGram {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int[] privateKey = Arrays.stream(console.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        Map<String, List<String>> messages = new TreeMap<>();

        String line;
        while (!"END".equals(line = console.readLine()))
        {
            Pattern pattern = Pattern.compile("TO: (?<recipient>[A-Z]+); MESSAGE: (?<message>.+);");
            Matcher matcher = pattern.matcher(line);

            while (matcher.find())
            {
                String recipient = matcher.group("recipient");
                String message = matcher.group("message");

                StringBuilder encryptedMessage = new StringBuilder();
                for (int i = 0; i < line.length(); i++) {
                    Character current = line.charAt(i);
                    Character encrypted = (char)(current + privateKey[i % privateKey.length]);
                    encryptedMessage.append(encrypted);

                }

                messages.putIfAbsent(recipient, new ArrayList<>());
                messages.get(recipient).add(encryptedMessage.toString());
            }
        }

        //messages.entrySet().forEach(x -> System.out.println(x.getValue()));
        messages.forEach((key, value) -> System.out.println(value));
    }
}

