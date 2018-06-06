import java.util.Scanner;

/**
 * Created by Nino Bonev - 3.6.2018 г., 19:29
 */
public class MelrahShake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine().trim());
        StringBuilder pattern = new StringBuilder(scanner.nextLine());

        Boolean canShake = true;

        while (canShake)
        {
            int indxFirst = input.indexOf(pattern.toString());
            int indxLast = input.lastIndexOf(pattern.toString());
            if (indxFirst > -1 && indxLast > -1 && pattern.length() > 0)
            {

                indxFirst = input.indexOf(pattern.toString());
                input.delete(indxFirst, indxFirst + pattern.length());
                indxLast = input.lastIndexOf(pattern.toString());
                input.delete(indxLast, indxLast + pattern.length());
                System.out.printf("Shaked it.%n");
                if (pattern.length() > 0)
                {
                    pattern = pattern.delete(pattern.length() / 2, pattern.length() / 2 + 1);
                }

            }
            else
            {
                System.out.printf("No shake.%n");
                canShake = false;
                System.out.println(input);
                break;
            }
        }
    }
}
