import java.util.Scanner;

public class AverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Double x = scanner.nextDouble();
        Double y = scanner.nextDouble();
        Double z = scanner.nextDouble();
        Double average = (x + y + z) / 3;

        System.out.printf("%.2f", average);
    }
}
