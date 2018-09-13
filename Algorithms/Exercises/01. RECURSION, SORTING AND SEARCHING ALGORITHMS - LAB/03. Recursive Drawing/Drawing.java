import java.util.Scanner;

/**
 * Created by Nino Bonev - 13.9.2018 г., 12:34
 */
public class Drawing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int elements = Integer.parseInt(scanner.nextLine());

        Draw(elements);
    }

    private static void Draw(int elements){
        if (elements == 0){
            return;
        }

        StringBuilder print = new StringBuilder();
        for (int i = 0; i < elements; i++) {
             print.append("*");
        }

        System.out.println(print.toString());

        Draw(elements - 1);

        StringBuilder printAfter = new StringBuilder();
        for (int i = 0; i < elements; i++) {
            printAfter.append("#");
        }

        System.out.println(printAfter.toString());

    }
}
