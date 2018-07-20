package genericBox;

/**
 * Created by Nino Bonev - 13.7.2018 г., 11:16
 */
public class Box<T extends Comparable<T>> implements Comparable<Box<T>>{
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", value.getClass().getTypeName(), value);
    }

    @Override
    public int compareTo(Box<T> box) {
        return this.value.compareTo(box.getValue());
    }
}
