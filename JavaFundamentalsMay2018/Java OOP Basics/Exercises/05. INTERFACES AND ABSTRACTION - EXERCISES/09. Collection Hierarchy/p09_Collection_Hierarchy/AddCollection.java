package p09_Collection_Hierarchy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nino Bonev - 1.7.2018 г., 22:34
 */
public class AddCollection implements IAddCollection{
    private List<String> collection;
    private List<Integer> indices;

    public AddCollection() {
        this.setCollection(new ArrayList<>());
        this.setIndices(new ArrayList<>());
    }

    public List<String> getCollection() {
        return collection;
    }

    private void setCollection(List<String> collection) {
        this.collection = collection;
    }
    @Override
    public List<Integer> getIndices() {
        return indices;
    }

    private void setIndices(List<Integer> indices) {
        this.indices = indices;
    }

    @Override
    public int addToCollection(String item) {
        this.collection.add(item);
        return this.collection.size() - 1;
    }

    @Override
    public void addIndex(int index){
        this.indices.add(index);
    }
}
