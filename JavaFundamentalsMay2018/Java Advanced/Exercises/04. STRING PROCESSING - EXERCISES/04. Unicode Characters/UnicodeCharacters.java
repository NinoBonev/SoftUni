import java.util.Scanner;

/**
 * Created by Nino Bonev - 3.6.2018 г., 11:37
 */
public class UnicodeCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder uniCode = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {


            uniCode.append("\\u00" + Integer.toHexString(input.charAt(i)));
        }

        System.out.println(uniCode.toString());
    }
}
