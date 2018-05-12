import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 2.5.2018 г., 10:56
 */
public class CalculateTriangleAreaMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        Double base = scanner.nextDouble();
        Double height = scanner.nextDouble();

        System.out.printf("Area = %.2f", calculateTriangleArea(base, height));
    }

    private static double calculateTriangleArea(double base, double height) {
        Double area = base * height / 2;
        return area;
    }
}
