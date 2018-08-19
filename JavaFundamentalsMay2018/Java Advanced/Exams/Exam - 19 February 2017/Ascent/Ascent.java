import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Nino Bonev - 18.8.2018 г., 10:15
 */
public class Ascent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> keys = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("([,|_]{1})([a-zA-Z]+)([0-9])");

        String line;
        while (!"Ascend".equals(line = scanner.nextLine())){
            for (Map.Entry<String, String> entry : keys.entrySet()) {
                if (line.contains(entry.getKey())){
                    line = line.replaceAll(entry.getKey(), entry.getValue());
                }
            }

            Matcher matcher = pattern.matcher(line);

            while (matcher.find()){
                StringBuilder currentString = new StringBuilder();
                Integer num = Integer.parseInt(matcher.group(3));

                switch (matcher.group(1)){
                    case "," :
                        for (int i = 0; i < matcher.group(2).length(); i++) {
                            Character charr = (char)((matcher.group(2)).charAt(i) + num);
                            currentString.append(charr);
                        }
                        break;
                    case "_" :
                        for (int i = 0; i < matcher.group(2).length(); i++) {
                            Character charr = (char)((matcher.group(2)).charAt(i) - num);
                            currentString.append(charr);
                        }
                        break;
                }

                keys.putIfAbsent(matcher.group(), currentString.toString());
                line = line.replaceAll(matcher.group(), currentString.toString());

            }

            System.out.println(line);
        }
    }
}
