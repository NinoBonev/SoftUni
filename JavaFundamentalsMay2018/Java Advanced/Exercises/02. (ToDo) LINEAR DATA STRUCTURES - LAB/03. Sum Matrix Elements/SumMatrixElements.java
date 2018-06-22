import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 22.6.2018 г., 12:00
 */
public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(", ");
        Integer rows = Integer.parseInt(dimensions[0]);
        Integer cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] row = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = row[j];
            }
        }
        
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }
        System.out.printf("%d%n%d%n%d%n", rows, cols, sum);
    }
}
