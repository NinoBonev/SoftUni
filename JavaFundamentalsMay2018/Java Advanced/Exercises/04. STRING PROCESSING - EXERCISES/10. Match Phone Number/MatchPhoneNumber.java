import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Nino Bonev - 3.6.2018 г., 13:12
 */
public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^\\+359([ -])2\\1\\d{3}\\1\\d{4}$";
        String phone;
        while (!"end".equals(phone = scanner.nextLine())){
            if (Pattern.matches(regex, phone)){
                System.out.println(phone);
            }
        }
    }
}
