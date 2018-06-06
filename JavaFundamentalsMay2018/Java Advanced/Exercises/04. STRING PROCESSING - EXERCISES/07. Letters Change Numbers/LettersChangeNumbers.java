import java.util.Scanner;

/**
 * Created by Nino Bonev - 3.6.2018 г., 19:12
 */
public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split("[,\\s\t]+");
        double total = 0.00;

        for (String word :
                input)
        {
            int number = Integer.parseInt(word.substring(1, word.length() - 1));
            char firstLetter = word.charAt(0);
            char lastLetter = word.charAt(word.length() - 1);
            double sum = 0.00;

            if (Character.isUpperCase(firstLetter))
            {
                sum += number / FirstLetterPosition(word);
            }
            else
            {
                sum += number * FirstLetterPosition(word);
            }

            if (Character.isUpperCase(lastLetter))
            {
                sum -= LastLetterPosition(word);
            }
            else
            {
                sum += LastLetterPosition(word);
            }

            total += sum;
        }

        System.out.printf("%.2f", total);
    }

    private static double FirstLetterPosition(String input)
    {
        input = input.toUpperCase();
        int position = input.charAt(0) - 64;
        return position;
    }

    private static double LastLetterPosition(String input)
    {
        input = input.toUpperCase();
        int position = input.charAt(input.length() - 1) - 64;
        return position;
    }
}
