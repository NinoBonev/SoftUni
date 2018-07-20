package app;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 18.7.2018 г., 17:36
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListyIterator iterator = null;
        String line;

        while (!"END".equals(line = scanner.nextLine())){
            List<String> commandData = Arrays.stream(line.split(" ")).collect(Collectors.toList());
            String command = commandData.remove(0);
            try {
                switch (command) {
                    case "Create":
                        iterator = new ListyIterator(commandData);
                        break;
                    case "Move":
                        System.out.println(iterator.move());
                        break;
                    case "Print":
                        iterator.print();
                        break;
                    case "HasNext" :
                        System.out.println(iterator.hasNext());
                        break;
                    case "PrintAll" :
                        iterator.printAll();
                        break;
                }
            } catch (IllegalArgumentException exp){
                System.out.println(exp.getMessage());
            }
        }
    }
}
