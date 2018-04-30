import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnonymousVox {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String text = console.readLine();
        String placeholdersInput = console.readLine();
        List<String> placeholders = new ArrayList<>();

        Pattern placeholdersPattern = Pattern.compile("\\{(\\s*([a-zA-Z][^\\{|\\}|\\s][a-zA-z]*)\\s*)\\}");
        Matcher placeholdersMatcher = placeholdersPattern.matcher(placeholdersInput);

        while (placeholdersMatcher.find())
        {
            placeholders.add(placeholdersMatcher.group(1));
        }


        Pattern pattern = Pattern.compile("(?<start>[a-zA-Z]+)(?<placeholder>.*)(?<end>\\1)");
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        String result = "";

        while (matcher.find())
        {
            if (count > placeholders.size() - 1)
            {
                break;
            }

            String placeholder = placeholders.get(count);
            result = text.replace(matcher.group("placeholder"), placeholder);
            text = result;
            count++;
        }

        System.out.println(result);
    }
}
