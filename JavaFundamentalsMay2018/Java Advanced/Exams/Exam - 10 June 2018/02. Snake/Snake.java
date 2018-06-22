import java.util.Scanner;

/**
 * Created by Nino Bonev - 22.6.2018 г., 22:12
 */
public class Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        String[] commands = scanner.nextLine().split(", ");
        Integer snakeRowPosition = 0;
        Integer snakeColPosition = 0;
        Integer snakeLength = 1;
        Integer foodCount = 0;

        for (int row = 0; row < size; row++) {
            String[] rowElements = scanner.nextLine().split(" ");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = rowElements[col];
                if (rowElements[col].equals("s")){
                    snakeRowPosition = row;
                    snakeColPosition = col;
                } else if (rowElements[col].equals("f")){
                    foodCount++;
                }
            }
        }

        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]){
                case "down" :
                  snakeRowPosition = moveDown(snakeRowPosition, size);
                  int result1 = checkNewPosition(snakeRowPosition, snakeColPosition, matrix, snakeLength);
                  if (result1 == -1){
                      System.out.println("You lose! Killed by an enemy!");
                      foodCount = -1;
                      i = commands.length - 1;
                  } else {
                      if (result1 > snakeLength){
                          snakeLength = result1;
                          foodCount--;
                      }
                  }
                  break;
                case "up" :
                    snakeRowPosition = moveUp(snakeRowPosition, size);
                    int result2 = checkNewPosition(snakeRowPosition, snakeColPosition, matrix, snakeLength);
                    if (result2 == -1){
                        System.out.println("You lose! Killed by an enemy!");
                        foodCount = -1;
                        i = commands.length - 1;
                    } else {
                        if (result2 > snakeLength){
                            snakeLength = result2;
                            foodCount--;
                        }
                    }
                    break;
                case "left" :
                    snakeColPosition = moveLeft(snakeColPosition, size);
                    int result3 = checkNewPosition(snakeRowPosition, snakeColPosition, matrix, snakeLength);
                    if (result3 == -1){
                        System.out.println("You lose! Killed by an enemy!");
                        foodCount = -1;
                        i = commands.length - 1;
                    } else {
                        if (result3 > snakeLength){
                            snakeLength = result3;
                            foodCount--;
                        }
                    }
                    break;
                case "right" :
                    snakeColPosition = moveRight(snakeColPosition, size);
                    int result4 = checkNewPosition(snakeRowPosition, snakeColPosition, matrix, snakeLength);
                    if (result4 == -1){
                        System.out.println("You lose! Killed by an enemy!");
                        foodCount = -1;
                        i = commands.length - 1;
                    } else {
                        if (result4 > snakeLength){
                            snakeLength = result4;
                            foodCount--;
                        }
                    }
                    break;
            }
        }

        if (foodCount >= 0){
            if (foodCount == 0){
                System.out.printf("You win! Final snake length is %d", snakeLength);
            } else {
                System.out.printf("You lose! There is still %d food to be eaten.", foodCount);
            }
        }
    }

    private static int moveDown(int snakePosition, int size){
        int newPosition = 0;
        if (snakePosition + 1 < size){
            newPosition = snakePosition + 1;
        }
        return newPosition;
    }

    private static int moveUp(int snakePosition, int size){
        int newPosition = size - 1;
        if (snakePosition - 1 >= 0){
            newPosition = snakePosition - 1;
        }
        return newPosition;
    }

    private static int moveLeft(int snakePosition, int size){
        int newPosition = size - 1;
        if (snakePosition - 1 >= 0){
            newPosition = snakePosition - 1;
        }
        return newPosition;
    }

    private static int moveRight(int snakePosition, int size){
        int newPosition = 0;
        if (snakePosition + 1 < size){
            newPosition = snakePosition + 1;
        }
        return newPosition;
    }

    private static int checkNewPosition(int row, int col, String[][] matrix, int snakeLength){
        String positionElement = matrix[row][col];
        switch (positionElement){
            case "*" :
                break;
            case "f" :
                snakeLength++;
                break;
            case "e" :
                snakeLength = -1;
                break;
        }
        return snakeLength;
    }
}
