package customList;

import java.util.List;

/**
 * Created by Nino Bonev - 13.7.2018 г., 13:04
 */
public class CommandInterpreter {

    public <T extends Comparable<T>> void readCommand(String[] commandData, CustomList<T> list){
        String command = commandData[0];

        switch (command){
            case "Add" :
                list.add((T) commandData[1]);
                break;
            case "Remove" :
                list.remove(Integer.parseInt(commandData[1]));
                break;
            case "Contains" :
                System.out.println(list.contains((T) commandData[1]));
                break;
            case "Swap" :
                list.swap(Integer.parseInt(commandData[1]), Integer.parseInt(commandData[2]));
                break;
            case "Greater" :
                System.out.println(list.countGreaterThan((T) commandData[1]));
                break;
            case "Max" :
                System.out.println(list.getMax());
                break;
            case "Min" :
                System.out.println(list.getMin());
                break;
            case "Print" :
                list.forEach(System.out::println);
                break;
            case "Sort" :
                list.sort();
                break;
        }
    }
}
