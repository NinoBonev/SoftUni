import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 28.5.2018 г., 7:55
 */
public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emails = new LinkedHashMap<>();

        String line;
        while (!"stop".equals(line=scanner.nextLine()))
        {
            String email = scanner.nextLine();
            emails.putIfAbsent(line, "");
            emails.replace(line, email);
        }

        for (Map.Entry<String, String> email:
             emails.entrySet()) {
            String endsWith = email.getValue().split("\\.")[1];
            if (endsWith.equals("us") || endsWith.equals("uk") || endsWith.equals("com")){
                continue;
            } else {
                System.out.printf("%s -> %s%n", email.getKey(), email.getValue());
            }
        }
    }
}
