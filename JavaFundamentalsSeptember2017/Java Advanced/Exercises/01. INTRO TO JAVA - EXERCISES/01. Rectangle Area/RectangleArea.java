import java.util.Scanner;

/**
 * Created by Nino Bonev - 1.5.2018 г., 13:28
 */
public class RectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sideA = scanner.nextDouble();
        double sideB = scanner.nextDouble();

        double rectangleArea = sideA * sideB;

        System.out.printf("%.2f", rectangleArea);
    }
}
