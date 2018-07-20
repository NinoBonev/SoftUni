package person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 18.7.2018 г., 19:27
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        String line;
        Integer equal = 0;

        while (!"END".equals(line = scanner.nextLine())) {
            String[] data = line.split(" ");
            String name = data[0];
            Integer age = Integer.parseInt(data[1]);
            String town = data[2];
            Person person = new Person(name, age, town);
            people.add(person);

        }

        Integer personToGet = Integer.parseInt(scanner.nextLine());

        if (personToGet >= people.size()) {
            System.out.println("No matches");
        } else {
            Person personToMatch = people.get(personToGet);
            for (Person person :
                    people) {
                if (person.compareTo(personToMatch) == 0) {
                    equal++;
                }
            }

            if (equal > 1) {
                System.out.println(String.format("%d %d %d", equal, people.size() - equal, people.size()));
            } else {
                System.out.println("No matches");
            }
        }


    }
}
