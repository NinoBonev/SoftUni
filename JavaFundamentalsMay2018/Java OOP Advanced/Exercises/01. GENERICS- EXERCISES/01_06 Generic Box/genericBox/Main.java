package genericBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 13.7.2018 г., 11:16
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Box<Double>> boxes = new ArrayList<>();

        Integer count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            Box<Double> box = new Box<>(Double.parseDouble(scanner.nextLine()));
            boxes.add(box);
        }

        Double index2 = Double.parseDouble(scanner.nextLine());
        Box<Double> box = new Box<>(index2);

        System.out.println(countElements(boxes, box));

    }

    public static <T> void swap(List<T> list, int index1, int index2){
        T t1 = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, t1);
    }

    public static <T extends Comparable<T>> Integer countElements(List<T> list, T elementToCompare){
        int count = 0;
        for (T box : list) {
            int result = box.compareTo(elementToCompare);
            if (result > 0){
                count++;
            }
        }

        return count;
    }
}
