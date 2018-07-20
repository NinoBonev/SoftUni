package comparingStrategy;

import java.util.Comparator;

/**
 * Created by Nino Bonev - 18.7.2018 г., 20:44
 */
public class ComparatorByAge implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        return Integer.compare(person1.getAge(), person2.getAge());
    }
}
