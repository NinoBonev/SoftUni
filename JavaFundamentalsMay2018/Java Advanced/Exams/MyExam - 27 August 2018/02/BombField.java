import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 27.8.2018 г., 7:49
 */
public class BombField {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer num = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");

        String[][] field = new String[num][];

        int startRow = 0;
        int startCol = 0;
        int bombCount = 0;
        for (int i = 0; i < num; i++) {
            field[i] = new String[num];
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < num; j++) {
                field[i][j] = line[j];
                if (line[j].equals("s")) {
                    startRow = i;
                    startCol = j;
                }
                if (line[j].equals("B")) {
                    bombCount++;
                }
            }
        }

        boolean exitReached = false;
        boolean foundAll = false;
        int bombsFound = 0;


        for (int i = 0; i < commands.length; i++) {
            if (exitReached || foundAll){
                break;
            }
            String command = commands[i];

            String current;
            switch (command) {
                case "left":
                    if (startCol - 1 >= 0) {
                        current = field[startRow][startCol - 1];
                        if (current.equals("B")) {
                            bombsFound++;
                            System.out.println("You found a bomb!");
                            if (bombCount == bombsFound){
                                foundAll = true;
                                break;
                            }
                            field[startRow][startCol - 1] = "+";
                        }
                        if (current.equals("e")) {
                            exitReached = true;
                            break;
                        }
                        startCol--;
                    }
                    break;
                case "right":
                    if (startCol + 1 < num){
                        current = field[startRow][startCol + 1];
                        if (current.equals("B")) {
                            bombsFound++;
                            System.out.println("You found a bomb!");
                            if (bombCount == bombsFound){
                                foundAll = true;
                                break;
                            }
                            field[startRow][startCol + 1] = "+";
                        }
                        if (current.equals("e")) {
                            exitReached = true;
                            break;
                        }
                        startCol++;
                    }
                    break;
                case "up":
                    if (startRow - 1 >= 0){
                        current = field[startRow - 1][startCol];
                        if (current.equals("B")) {
                            bombsFound++;
                            System.out.println("You found a bomb!");
                            if (bombCount == bombsFound){
                                foundAll = true;
                                break;
                            }
                            field[startRow - 1][startCol] = "+";
                        }
                        if (current.equals("e")) {
                            exitReached = true;
                            break;
                        }
                        startRow--;
                    }
                    break;
                case "down":
                    if (startRow  + 1 < num){
                        current = field[startRow + 1][startCol];
                        if (current.equals("B")) {
                            bombsFound++;
                            System.out.println("You found a bomb!");
                            if (bombCount == bombsFound){
                                foundAll = true;
                                break;
                            }
                            field[startRow + 1][startCol] = "+";
                        }
                        if (current.equals("e")) {
                            exitReached = true;
                            break;
                        }
                        startRow++;
                    }
                    break;
            }
        }

        if (foundAll){
            System.out.println("Congratulations! You found all bombs!");
        } else if (exitReached){
            System.out.println(String.format("END! %d bombs left on the field", bombCount - bombsFound));
        } else {
            System.out.println(String.format("%d bombs left on the field. Sapper position: (%d,%d)",
                    bombCount - bombsFound,
                    startRow,
                    startCol));
        }

    }
}
