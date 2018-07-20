package coffeeMachine;

import java.util.Scanner;

/**
 * Created by Nino Bonev - 20.7.2018 г., 13:00
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        String line;
        while (!"END".equals(line = scanner.nextLine())){
            String[] command = line.split(" ");
            if (command.length == 1){
                coffeeMachine.insertCoin(command[0]);
            } else {
                coffeeMachine.buyCoffee(command[0], command[1]);
            }
        }

        for (Coffee coffee : coffeeMachine.coffeesSold()) {
            System.out.println(coffee);
        }
    }
}
