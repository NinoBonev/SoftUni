package customList;

/**
 * Created by Nino Bonev - 13.7.2018 г., 13:25
 */
public class Sorted {

    public static <T extends Comparable<T>> void sort(CustomList<T> customList){
        customList.sort();
    }
}
