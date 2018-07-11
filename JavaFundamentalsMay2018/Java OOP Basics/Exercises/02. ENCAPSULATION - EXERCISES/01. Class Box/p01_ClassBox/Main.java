package p01_ClassBox;

import java.util.Scanner;

/**
 * Created by Nino Bonev - 21.6.2018 г., 11:30
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        try {
            Box box = new Box(length, width, height);
            System.out.println(box);
        } catch (IllegalArgumentException exp){
            System.out.println(exp.getMessage());
        }
    }
}
