import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 13.7.2018 г., 9:28
 */
public class HandScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] handOfCards = scanner.nextLine().split(" ");

        int handScore = 0;
        for (int i = 0; i < handOfCards.length; i++) {
            if (handOfCards[i].length() == 2) {
                if (Character.isDigit(handOfCards[i].charAt(0))) {

                }
            } else {

            }
        }
    }
}
