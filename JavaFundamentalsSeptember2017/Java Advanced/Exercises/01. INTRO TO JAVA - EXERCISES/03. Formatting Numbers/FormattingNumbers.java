import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 1.5.2018 г., 14:03
 */
public class FormattingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH); // В България по подразбиране разделитенлия символ е запетая (","),
                                            // затова трябва да се зададе регион, където по принцип символа е точка (".")
        int numberA = scanner.nextInt();
        double numberB = scanner.nextDouble();
        double numberC = scanner.nextDouble();

        System.out.printf("|%-10s|%s|%10.2f|%-10.3f|", Integer.toHexString(numberA).toUpperCase(), String.format("%10s", Integer.toBinaryString(numberA)).replace(' ', '0'), numberB, numberC);
    }
}
