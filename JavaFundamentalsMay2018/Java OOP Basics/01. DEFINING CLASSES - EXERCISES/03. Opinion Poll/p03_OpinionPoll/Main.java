package p03_OpinionPoll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 16.6.2018 г., 8:09
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer peopleCount = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < peopleCount; i++) {
            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            Integer age = Integer.parseInt(data[1]);

            Person person = new Person(name, age);
            people.add(person);
        }

        people.stream()
                .sorted((a, b) -> a.getName().compareTo(b.getName()))
                .filter(e -> e.getAge() > 30)
                .forEach(x -> System.out.printf("%s - %d%n", x.getName(), x.getAge()));
    }
}
