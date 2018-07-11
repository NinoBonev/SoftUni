package p09_Collection_Hierarchy;

import java.util.List;

/**
 * Created by Nino Bonev - 1.7.2018 г., 22:36
 */
public interface IAddRemoveCollection extends IAddCollection{
    String removeFromCollection();
    void addRemoved(String item);
    List<String> getRemoved();
}
