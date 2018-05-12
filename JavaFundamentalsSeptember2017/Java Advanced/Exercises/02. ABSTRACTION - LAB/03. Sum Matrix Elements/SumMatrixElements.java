import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 12.5.2018 г., 14:50
 */
public class SumMatrixElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String dimensions = scanner.nextLine();
        Integer rows = Integer.parseInt(dimensions.split(", ")[0]);
        Integer columns = Integer.parseInt(dimensions.split(", ")[1]);
        //int[][] matrix = new int[rows][columns];
        Integer sum = 0;

        for (int i = 0; i < rows; i++) {
            String thisRow = scanner.nextLine();
            int[] rowInts = Arrays.stream(thisRow.split(", ")).mapToInt(Integer::parseInt).toArray();
            sum += Arrays.stream(rowInts).sum();
        }

        System.out.println(rows);
        System.out.println(columns);
        System.out.println(sum);
    }
}
