package p09_Collection_Hierarchy;

import java.util.List;

/**
 * Created by Nino Bonev - 1.7.2018 г., 22:35
 */
public interface IAddCollection {
    int addToCollection(String item);
    void addIndex(int index);
    List<Integer> getIndices();
}
