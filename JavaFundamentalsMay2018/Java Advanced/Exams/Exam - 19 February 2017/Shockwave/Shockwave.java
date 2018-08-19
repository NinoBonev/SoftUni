import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 18.8.2018 г., 8:18
 */
public class Shockwave {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        Integer rows = Integer.parseInt(input[0]);
        Integer cols = Integer.parseInt(input[1]);

        Integer[][] matrix = new Integer[rows][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new Integer[cols];
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = 0;
            }
        }

        String line;
        while (!"Here We Go".equals(line = scanner.nextLine())){
            Integer X1 = Integer.parseInt(line.split(" ")[0]);
            Integer Y1 = Integer.parseInt(line.split(" ")[1]);
            Integer X2 = Integer.parseInt(line.split(" ")[2]);
            Integer Y2 = Integer.parseInt(line.split(" ")[3]);

            for (int i = X1; i <= X2; i++) {
                for (int j = Y1; j <= Y2; j++) {
                    matrix[i][j]++;
                }
            }
        }

        for (Integer[] arr : matrix) {
            System.out.println(Arrays.toString(arr)
                    .replace("]", "")
            .replace("[", "")
            .replace(",", ""));
        }
    }
}
