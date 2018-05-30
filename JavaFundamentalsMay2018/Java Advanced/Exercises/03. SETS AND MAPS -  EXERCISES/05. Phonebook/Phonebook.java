import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 28.5.2018 г., 7:35
 */
public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();

        String line;
        while (!"search".equals(line=scanner.nextLine()))
        {
            phonebook.putIfAbsent(line.split("-")[0], "");
            phonebook.replace(line.split("-")[0], line.split("-")[1]);
        }

        while (!"stop".equals(line=scanner.nextLine()))
        {
            if (phonebook.keySet().contains(line)){
                System.out.printf("%s -> %s%n", line ,phonebook.get(line));
            } else {
                System.out.printf("Contact %s does not exist.%n", line);
            }
        }
    }
}
