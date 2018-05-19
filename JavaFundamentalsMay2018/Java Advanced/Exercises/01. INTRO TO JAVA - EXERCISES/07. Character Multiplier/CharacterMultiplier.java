import java.util.Scanner;

/**
 * Created by Nino Bonev - 1.5.2018 г., 14:21
 */
public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split(" ");
        String first = strings[0];
        String second = strings[1];
        Integer sum = 0;

        if (first.length() >= second.length()){
            for (int i = 0; i < second.length(); i++) {
                sum += (int)first.charAt(i) * (int)second.charAt(i);
            }
            for (int i = second.length(); i < first.length(); i++) {
                sum += (int)first.charAt(i);
            }
        } else {
            for (int i = 0; i < first.length(); i++) {
                sum += (int) first.charAt(i) * (int) second.charAt(i);
            }
            for (int i = first.length(); i < second.length(); i++) {
                sum += (int) second.charAt(i);
            }
        }

        System.out.println(sum);
    }
}
