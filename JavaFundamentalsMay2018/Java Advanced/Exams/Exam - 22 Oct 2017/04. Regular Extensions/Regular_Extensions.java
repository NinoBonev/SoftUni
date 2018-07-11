import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Nino Bonev - 2.7.2018 г., 12:06
 */
public class Regular_Extensions {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

        String input = scanner.readLine();
        String line;

        while (!"Print".equals(line = scanner.readLine())){
            String[] inputs = line.split("%", -1);
            for (int i = 0; i < inputs.length; i++) {
                inputs[i] = Pattern.quote(inputs[i]);
            }

            Pattern pattern = Pattern.compile(String.join("\\S*", inputs));
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()){
                String currentWord = matcher.group();
                StringBuilder reversed = new StringBuilder(currentWord).reverse();
                input = input.replace(currentWord, reversed.toString());
            }
        }

        System.out.println(input);

    }
}
