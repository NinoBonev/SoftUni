import java.util.Scanner;

/**
 * Created by Nino Bonev - 2.7.2018 г., 12:06
 */
public class Regular_Extensions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer x = Integer.parseInt(scanner.nextLine());
        String y = "";
        String z = "";

        if (x % 2 == 0){
            y = "yes";
        } else {
            y = "no";
        }

        z = x % 2 == 0 ? "yes" : "no";
        System.out.println(z);

    }
}
