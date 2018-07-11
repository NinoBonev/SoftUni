package p09_Collection_Hierarchy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nino Bonev - 1.7.2018 г., 22:35
 */
public class MyList implements IMyList {
    private ArrayDeque<String> collection;
    private List<Integer> indices;
    private List<String> removed;
    private int used;

    public MyList() {
        this.setCollection(new ArrayDeque<>());
        this.setIndices(new ArrayList<>());
        this.setRemoved(new ArrayList<>());
        this.setUsed(0);
    }

    private void setUsed(int used) {
        this.used = used;
    }

    @Override
    public List<String> getRemoved() {
        return removed;
    }

    private void setRemoved(List<String> removed) {
        this.removed = removed;
    }

    public ArrayDeque<String> getCollection() {
        return collection;
    }

    private void setCollection(ArrayDeque<String> collection) {
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
        this.collection.addFirst(item);
        this.setUsed(this.getCollection().size());
        return 0;
    }

    @Override
    public void addIndex(int index){
        this.indices.add(index);
    }
    @Override
    public void addRemoved(String item){
        this.removed.add(item);
    }

    @Override
    public String removeFromCollection() {
        String removed = this.collection.pollFirst();
        this.setUsed(this.getCollection().size());
        return removed;
    }

    @Override
    public int getUsed() {
        return this.used;
    }
}
