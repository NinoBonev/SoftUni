import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 13.9.2018 г., 14:35
 */
public class PathsInLabyrinth {
    private static List<Character> path = new LinkedList<>();
    private static String[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        matrix = new String[rows][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new String[cols];
            String[] data = scanner.nextLine().split("");

            for (int j = 0; j < data.length; j++) {
                matrix[i][j] = data[j];
            }
        }

        FindPath(0, 0, 'S');
    }

    private static void FindPath(int row, int col, char direction){
        if (!IsInBound(row, col)){
            return;
        }

        path.add(direction);

        if (IsExit(row, col)){
            PrintPath();
        } else if (!IsVisited(row, col) && IsFree(row, col)){
            Mark(row, col);
            FindPath(row, col + 1, 'R');
            FindPath(row + 1, col, 'D');
            FindPath(row, col - 1, 'L');
            FindPath(row - 1, col, 'U');
            Unmark(row, col);
        }

        path.remove(path.size() - 1);
    }

    private static void Unmark(int row, int col) {
        matrix[row][col] = "-";
    }

    private static void Mark(int row, int col) {
        matrix[row][col] = "v";
    }

    private static boolean IsFree(int row, int col) {
        return matrix[row][col].equals("-");
    }

    private static boolean IsVisited(int row, int col) {
        return matrix[row][col].equals("v");
    }

    private static void PrintPath() {
        StringBuilder print = new StringBuilder();
        for (int i = 1; i < path.size(); i++) {
            print.append(path.get(i));
        }
        System.out.println(print.toString());
    }

    private static boolean IsExit(int row, int col) {
            return matrix[row][col].equals("e");
    }

    private static boolean IsInBound(int row, int col) {
        boolean isInBound = false;
        if (matrix.length > row && row >= 0 && matrix[0].length > col && col >= 0){
            isInBound = true;
        }
        return isInBound;
    }
}
