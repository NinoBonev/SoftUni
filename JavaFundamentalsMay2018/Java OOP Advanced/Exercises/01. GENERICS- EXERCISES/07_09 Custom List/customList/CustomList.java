package customList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Nino Bonev - 13.7.2018 г., 12:42
 */
public class CustomList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T element){
        this.list.add(element);
    }

    public T remove(int index){
        return this.list.remove(index);
    }

    public boolean contains(T element){
        return this.list.contains(element);
    }

    public void swap(int index1, int index2){
        T t1 = this.list.get(index1);
        this.list.set(index1, this.list.get(index2));
        this.list.set(index2, t1);
    }

    public Integer countGreaterThan(T elementToCompare){
        int count = 0;
        for (T element : this.list) {
            int result = element.compareTo(elementToCompare);
            if (result > 0){
                count++;
            }
        }

        return count;
    }

    public T getMax(){
        T max = this.list.stream().max((a, b) -> a.compareTo(b)).get();

        return max;
    }

    public T getMin(){
        T min = this.list.stream().min((a, b) -> a.compareTo(b)).get();

        return min;
    }

    public void sort(){
        this.list.sort(Comparator.naturalOrder());
    }

    @Override
    public Iterator<T> iterator() {
        return this.list.iterator();
    }
}
