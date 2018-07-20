package frogg;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Nino Bonev - 18.7.2018 г., 18:46
 */
public class Lake implements Iterable<Integer> {
    private List<Integer> numbers;
    private int index;

    public Lake(List<Integer> numbers) {
        this.numbers = numbers;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<Integer>{
        private int counter;

        public Frog() {
            this.counter = 0;
        }

        @Override
        public boolean hasNext() {
            return numbers.size() > counter;
        }

        @Override
        public Integer next() {
            counter += 2;
            int element = numbers.get(counter - 2);
            if (counter % 2 == 0 && counter >= numbers.size()) {
                counter = 1;
            }
            return element;
        }
    }
}
