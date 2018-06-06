import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Nino Bonev - 3.6.2018 г., 17:55
 */
public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] usernames = scanner.nextLine().split("[\\s+/(),\\\\]+");
        String regex = "^[a-zA-Z][\\w\\d_]+$";
        List<String> validUserNames = new ArrayList<>();

        for (String user:
             usernames) {
            if (user.length() >= 3 && user.length() <= 25 && Pattern.matches(regex, user)){
                validUserNames.add(user);
            }
        }

        Integer maxSum = 0;
        Integer index = -1;
        for (int i = 0; i < validUserNames.size() - 1; i++) {
            Integer thisSum = validUserNames.get(i).length() + validUserNames.get(i + 1).length();
            if (thisSum > maxSum){
                maxSum = thisSum;
                index = i;
            }
        }
        System.out.println(validUserNames.get(index));
        System.out.println(validUserNames.get(index + 1));
    }
}
