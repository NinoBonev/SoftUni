import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 25.5.2018 г., 17:31
 */
public class SplitByWordCasing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("[,;:.!()\"'\\\\\\/\\[\\]\\s]+");
        List<String> lowerCase = new LinkedList<>();
        List<String> upperCase = new LinkedList<>();
        List<String> mixedCase = new LinkedList<>();

        for (int i = 0; i < input.length; i++) {
            Boolean lowerCaseChars = true;
            Boolean upperCaseChars = true;

            for (int j = 0; j < input[i].length(); j++) {
                if (Character.isLowerCase(input[i].charAt(j)) && Character.isAlphabetic(input[i].charAt(j))){
                    upperCaseChars = false;
                } else if (Character.isUpperCase(input[i].charAt(j)) && Character.isAlphabetic(input[i].charAt(j))){
                    lowerCaseChars = false;
                } else {
                    upperCaseChars = false;
                    lowerCaseChars = false;
                }
            }

            if (upperCaseChars){
                    upperCase.add(input[i]);
            } else if (lowerCaseChars) {
                    lowerCase.add(input[i]);
            } else {
                    mixedCase.add(input[i]);
            }
        }

        System.out.print("Lower-case: ");
        String lowerCasePrint = String.join(", ", lowerCase);
        System.out.println(lowerCasePrint);
        System.out.print("Mixed-case: ");
        String mixedCasePrint = String.join(", ", mixedCase);
        System.out.println(mixedCasePrint);
        System.out.print("Upper-case: ");
        String upperCasePrint = String.join(", ", upperCase);
        System.out.println(upperCasePrint);
    }
}
