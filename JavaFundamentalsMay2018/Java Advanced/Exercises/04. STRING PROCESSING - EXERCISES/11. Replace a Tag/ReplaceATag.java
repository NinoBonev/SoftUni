

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Created by Nino Bonev - 3.6.2018 г., 13:19
 */
public class ReplaceATag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        StringBuilder str = new StringBuilder();

        while (!"END".equals(input = scanner.nextLine())) {
            str.append(input);
            str.append("\n");
        }

        Pattern pattern = Pattern.compile("<a\\shref=(.+?)>(.+?)</a>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(str.toString());


        while (matcher.find()) {
            String firstText = matcher.group(1);
            String secondText = matcher.group(2);
            String neededTag = matcher.group();

            int startIndex = str.indexOf(neededTag);
            int endIndex = startIndex + neededTag.length();
            str = str.replace(startIndex, endIndex, "[URL href=" + firstText + "]" + secondText + "[/URL]");
        }

        System.out.println(str.toString());

    }
}

