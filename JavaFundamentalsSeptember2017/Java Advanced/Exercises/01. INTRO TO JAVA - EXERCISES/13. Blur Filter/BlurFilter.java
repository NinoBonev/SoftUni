import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 2.5.2018 г., 8:45
 */
public class BlurFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<long[]> matrix = new ArrayList<>();

        Integer blurAmount = Integer.parseInt(scanner.nextLine());
        String matrixSize = scanner.nextLine();
        Integer matrixRows = Integer.parseInt(matrixSize.split(" ")[0]);
        Integer matrixColumns = Integer.parseInt(matrixSize.split(" ")[1]);

        for (int i = 0; i < matrixRows; i++) {
            long[] currentRow = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
            matrix.add(currentRow);
        }

        String coordinates = scanner.nextLine();
        Integer coordinatesRow = Integer.parseInt(coordinates.split(" ")[0]);
        Integer coordinatesColumn = Integer.parseInt(coordinates.split(" ")[1]);

        updatedRow(matrix.get(coordinatesRow), coordinatesColumn, blurAmount);
        if (coordinatesRow - 1 >= 0){
            updatedRow(matrix.get(coordinatesRow - 1), coordinatesColumn, blurAmount);
        }
        if (coordinatesRow + 1 < matrix.size()){
            updatedRow(matrix.get(coordinatesRow + 1), coordinatesColumn, blurAmount);
        }

        matrix.forEach(x -> {
            String result = Arrays.toString(x).replaceAll("(^\\[|\\]$)", "").replace(", ", " ");
            System.out.println(result);
        });
    }

    private static void updatedRow(long[] currentRow, int coordinatesColumn, int blur)
    {
        currentRow[coordinatesColumn] += blur;
        if (coordinatesColumn - 1 >= 0){
            currentRow[coordinatesColumn - 1] += blur;
        }
        if (coordinatesColumn + 1 < currentRow.length){
            currentRow[coordinatesColumn + 1] += blur;
        }
    }
}
