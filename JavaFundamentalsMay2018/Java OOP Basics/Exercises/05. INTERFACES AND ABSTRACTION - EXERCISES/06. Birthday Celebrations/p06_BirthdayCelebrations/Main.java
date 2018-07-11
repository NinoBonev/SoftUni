package p06_BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 29.6.2018 г., 14:19
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthday> birthdays = new ArrayList<>();

        String line;
        while (!"End".equals(line = scanner.nextLine())){
            String[] data = line.split(" ");
            switch (data[0]){
                case "Citizen" :
                    Birthday citizen = new Citizen(data[1], Integer.parseInt(data[2]), data[3], data[4]);
                    birthdays.add(citizen);
                    break;
                case "Robot" :
                    Birthday robot = new Robot(data[1], data[2]);
                    break;
                case "Pet" :
                    Birthday pet = new Pet(data[1], data[2]);
                    birthdays.add(pet);
            }
        }

        String yearToSearch = scanner.nextLine();

        for (Birthday birthday :
                birthdays) {
            if (birthday.getBirthday().endsWith(yearToSearch)){
                System.out.println(birthday.getBirthday());
            }
        }
    }
}
