import java.util.Scanner;

/**
 * Created by Nino Bonev - 1.5.2018 г., 15:47
 */
public class GameOfNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        String winnerName = "";
        Integer winnerScore = Integer.MIN_VALUE;

        for (int i = 0; i < count; i++) {
            String name = scanner.nextLine();
            Integer initialScore = Integer.parseInt(scanner.nextLine());
            Integer totalScore = initialScore;

            for (int j = 0; j < name.length(); j++) {
                if ((int)name.charAt(j) % 2 == 0){
                    totalScore += (int)name.charAt(j);
                } else {
                    totalScore -= (int)name.charAt(j);
                }
            }

            if (totalScore > winnerScore){
                winnerScore = totalScore;
                winnerName = name;
            }
        }

        System.out.printf("The winner is %s - %d points", winnerName, winnerScore);
    }
}
