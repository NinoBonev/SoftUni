import java.util.Scanner;

/**
 * Created by Nino Bonev - 1.5.2018 г., 13:53
 */
public class TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A_X = scanner.nextInt();
        int A_Y = scanner.nextInt();
        int B_X = scanner.nextInt();
        int B_Y = scanner.nextInt();
        int C_X = scanner.nextInt();
        int C_Y = scanner.nextInt();

        double area = Math.abs((A_X * (B_Y - C_Y) + B_X * (C_Y - A_Y) + C_X * (A_Y - B_Y)) / 2);

        System.out.printf("%.0f", area);
    }
}
