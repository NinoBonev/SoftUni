import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 25.5.2018 г., 16:58
 */
public class EncryptSortPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer namesCount = Integer.parseInt(scanner.nextLine());
        String[] names = new String[namesCount];
        for (int i = 0; i < namesCount; i++) {
            names[i] = scanner.nextLine();
        }

        List<Integer> result = new ArrayList<>();

        for (String name :
                names) {
            result.add(sumNameChars(name));
        }

        Collections.sort(result);
        result.forEach(System.out::println);

    }

    private static int sumNameChars(String name) {
        int sumNameChars = 0;
        for (int i = 0; i < name.length(); i++) {
            if (charIsVowel(name.charAt(i))) {
                sumNameChars += (int) name.charAt(i) * name.length();
            } else {
                sumNameChars += (int) name.charAt(i) / name.length();
            }
        }

        return sumNameChars;
    }

    private static boolean charIsVowel(Character charr) {
        boolean isVowel = false;
        if (charr == 'a' || charr == 'e' || charr == 'i' || charr == 'o' || charr == 'u'
                || charr == 'A' || charr == 'E' || charr == 'I' || charr == 'O' || charr == 'U') {
            isVowel = true;
        }

        return isVowel;
    }
}
