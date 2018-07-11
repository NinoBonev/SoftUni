package p04_Telephony;

import java.util.Scanner;

/**
 * Created by Nino Bonev - 29.6.2018 г., 13:08
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(" ");
        String[] URLs = scanner.nextLine().split(" ");

        Smartphone smartphone = new Smartphone();

        for (String number :
                numbers) {
            try {
                smartphone.callNumber(number);
            } catch (IllegalArgumentException exp){
                System.out.println(exp.getMessage());
            }
        }
        for (String URL :
                URLs) {
            try {
                smartphone.browseURL(URL);
            } catch (IllegalArgumentException exp){
                System.out.println(exp.getMessage());
            }
        }
    }
}
