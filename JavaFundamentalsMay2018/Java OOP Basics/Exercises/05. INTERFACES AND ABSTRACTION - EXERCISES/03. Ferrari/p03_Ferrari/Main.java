package p03_Ferrari;

import java.lang.instrument.IllegalClassFormatException;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 29.6.2018 г., 12:58
 */
public class Main {
    public static void main(String[] args) throws IllegalClassFormatException {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        Ferrari ferrari = new Ferrari(name);

        System.out.println(ferrari);

        String ferrariName = Ferrari.class.getSimpleName();
        String carInterface = Car.class.getSimpleName();
        boolean isCreated = Car.class.isInterface();
        if (!isCreated) {
            throw new IllegalClassFormatException("No interface created!");
        }
    }
}
