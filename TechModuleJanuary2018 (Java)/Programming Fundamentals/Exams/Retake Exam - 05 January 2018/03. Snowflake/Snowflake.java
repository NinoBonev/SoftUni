import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Snowflake {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Pattern surfacePattern = Pattern.compile("^[^A-Za-z0-9]+$");
        Pattern mantlePattern = Pattern.compile("^[\\d_]+$");
        Pattern corePattern = Pattern.compile("^[^A-Za-z0-9]+[\\d_]+(?<core>[a-zA-Z]+)[\\d_]+[^A-Za-z0-9]+$");

        int coreLength = 0;
        boolean isInvalid = false;

        for (int i = 0; i < 5; i++) {

            String line = console.readLine();

            Matcher surfaceMatcher = surfacePattern.matcher(line);
            Matcher mantleMatcher = mantlePattern.matcher(line);
            Matcher coreMatcher = corePattern.matcher(line);

            switch (i) {
                case 0 : {
                    if (!surfaceMatcher.find()) {
                        isInvalid = true;
                        break;
                    }
                    break;
                }
                case 1: {
                    if (!mantleMatcher.find()) {
                        isInvalid = true;
                        break;
                    }
                    break;
                }
                case 2: {
                    if (!coreMatcher.find()) {
                        isInvalid = true;
                        break;
                    } else {
                        coreLength = coreMatcher.group("core").length();
                    }
                    break;
                }
                case 3: {
                    if (!mantleMatcher.find()) {
                        isInvalid = true;
                        break;
                    }
                    break;
                }
                case 4: {
                    if (!surfaceMatcher.find()) {
                        System.out.println("Invalid");
                        break;
                    } else {
                        if (isInvalid) {
                            System.out.println("Invalid");
                        } else {
                            System.out.println("Valid");
                            System.out.println(coreLength);
                        }
                        break;
                    }
                }
            }
        }
    }
}
