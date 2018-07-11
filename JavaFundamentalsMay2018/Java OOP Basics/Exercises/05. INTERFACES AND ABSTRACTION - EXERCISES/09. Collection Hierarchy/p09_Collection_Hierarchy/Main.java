package p09_Collection_Hierarchy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Nino Bonev - 1.7.2018 г., 22:27
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int removes = Integer.parseInt(reader.readLine());
        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyList myList = new MyList();
        for (String word: input){
            addCollection.addIndex(addCollection.addToCollection(word));
            addRemoveCollection.addIndex(addRemoveCollection.addToCollection(word));
            myList.addIndex(myList.addToCollection(word));
        }
        for (int i = 0; i < removes; i++){
            addRemoveCollection.addRemoved(addRemoveCollection.removeFromCollection());
            myList.addRemoved(myList.removeFromCollection());
        }
        System.out.println(addCollection.getIndices().toString().replaceAll("[\\[\\],]", ""));
        System.out.println(addRemoveCollection.getIndices().toString().replaceAll("[\\[\\],]", ""));
        System.out.println(myList.getIndices().toString().replaceAll("[\\[\\],]", ""));
        System.out.println(addRemoveCollection.getRemoved().toString().replaceAll("[\\[\\],]", ""));
        System.out.println(myList.getRemoved().toString().replaceAll("[\\[\\],]", ""));
    }
}
