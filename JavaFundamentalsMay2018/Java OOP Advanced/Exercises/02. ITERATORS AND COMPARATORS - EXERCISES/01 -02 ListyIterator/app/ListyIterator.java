package app;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Nino Bonev - 18.7.2018 г., 17:36
 */
public class ListyIterator implements Iterable<String>{
    private List<String> list;
    private int index;

    public ListyIterator(List<String> input) {
        this.list = input;
    }

    public void print(){
        if (list.isEmpty()){
            throw new IllegalArgumentException("Invalid Operation!");
        }
        System.out.println(list.get(this.index));
    }

    public void printAll(){
        System.out.println(String.join(" ", this.list));
    }

    public boolean move(){
        if (this.index + 1 < this.list.size()){
            index++;
            return true;
        }
        return false;
    }

    public boolean hasNext(){
        if (this.index < this.list.size() - 1){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.join(", ", list);
    }

    @Override
    public Iterator<String> iterator() {
        return new CustomIterator();
    }

    private final class CustomIterator implements Iterator<String>{
        private int count = 0;

        @Override
        public boolean hasNext() {
            return count < list.size();
        }

        @Override
        public String next() {
            return list.get(count++);
        }
    }
}
