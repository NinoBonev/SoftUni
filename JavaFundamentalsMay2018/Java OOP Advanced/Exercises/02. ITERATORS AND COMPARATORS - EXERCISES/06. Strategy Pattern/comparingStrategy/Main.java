package comparingStrategy;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Nino Bonev - 18.7.2018 г., 20:32
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Person> peopleByName = new TreeSet<>(new ComparatorByNameLength());
        Set<Person> peopleByAge = new TreeSet<>(new ComparatorByAge());

        Integer dataCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < dataCount; i++) {
            String[] data = scanner.nextLine().split(" ");
            Person person = new Person(data[0], Integer.parseInt(data[1]));
            peopleByName.add(person);
            peopleByAge.add(person);
        }

        peopleByName.forEach(System.out::println);
        peopleByAge.forEach(System.out::println);
    }
}
