package p03_AnimalFarm;

import java.util.Scanner;

/**
 * Created by Nino Bonev - 21.6.2018 г., 12:02
 */
public class Main {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        Integer age = Integer.parseInt(scanner.nextLine());

        try {
            Chicken chicken = new Chicken(name, age);
            System.out.println(chicken);
        } catch (IllegalArgumentException exp){
            System.out.println(exp.getMessage());
        }
    }
}
