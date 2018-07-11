package p07_Food_Shortage;

import java.util.*;

/**
 * Created by Nino Bonev - 29.6.2018 г., 14:19
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Rebel> rebelMap = new HashMap<>();
        Map<String, Citizen> citizenMap = new HashMap<>();

        Integer num = Integer.parseInt(scanner.nextLine());
        Integer foodBought = 0;

        for (int i = 0; i < num; i++) {
            String[] data = scanner.nextLine().split(" ");
            if (data.length == 3){
                Rebel rebel = new Rebel(data[0], Integer.parseInt(data[1]), data[2]);
                rebelMap.put(data[0], rebel);
            } else {
                Citizen citizen = new Citizen(data[0], Integer.parseInt(data[1]), data[2], data[3]);
                citizenMap.put(data[0], citizen);
            }
        }

        String line;
        while (!"End".equals(line = scanner.nextLine())){
            String name = line;
            if (rebelMap.containsKey(line)){
                rebelMap.get(line).buyFood();
                foodBought += 5;
            } else if (citizenMap.containsKey(line)){
              citizenMap.get(line).buyFood();
              foodBought += 10;
            }
        }

        System.out.println(foodBought);
    }
}
