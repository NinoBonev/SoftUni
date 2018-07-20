package customList;

import java.util.Scanner;

/**
 * Created by Nino Bonev - 13.7.2018 г., 12:41
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomList customList = new CustomList();
        CommandInterpreter commandInterpreter = new CommandInterpreter();

        String command;
        while (!"END".equals(command = scanner.nextLine())){
            String[] currentCommand = command.split(" ");
            commandInterpreter.readCommand(currentCommand, customList);
        }
    }
}
