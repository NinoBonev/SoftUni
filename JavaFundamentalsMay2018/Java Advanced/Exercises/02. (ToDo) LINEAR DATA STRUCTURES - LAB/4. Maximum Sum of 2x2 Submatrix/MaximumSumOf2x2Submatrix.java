import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 22.6.2018 г., 12:14
 */
public class MaximumSumOf2x2Submatrix {
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

        int bestSum = Integer.MIN_VALUE;
        int resultRow = 0;
        int resultCol = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (sum > bestSum){
                    bestSum = sum;
                    resultRow = row;
                    resultCol = col;
                }
            }
        }
        System.out.printf("%d %d%n", matrix[resultRow][resultCol], matrix[resultRow][resultCol + 1]);
        System.out.printf("%d %d%n", matrix[resultRow + 1][resultCol], matrix[resultRow + 1][resultCol + 1]);
        System.out.println(bestSum);
    }
}
