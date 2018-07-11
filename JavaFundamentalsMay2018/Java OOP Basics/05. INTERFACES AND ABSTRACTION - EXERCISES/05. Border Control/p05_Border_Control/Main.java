package p05_Border_Control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 29.6.2018 г., 13:37
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<ID> IDs = new ArrayList<>();

        String line;
        while (!"End".equals(line = scanner.nextLine())){
            String[] data = line.split(" ");
            if (data.length == 3){
                ID citizen = new Citizents(data[0], Integer.parseInt(data[1]), data[2]);
                IDs.add(citizen);
            } else {
                ID robot = new Robots(data[0], data[1]);
                IDs.add(robot);
            }
        }

        String endsWithCheck = scanner.nextLine();

        for (ID id :
                IDs) {
            if (id.idToCkeck().endsWith(endsWithCheck)){
                System.out.println(id.idToCkeck());
            }
        }
    }
}
