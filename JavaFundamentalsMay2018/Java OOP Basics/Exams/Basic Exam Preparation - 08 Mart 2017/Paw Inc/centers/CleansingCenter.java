package centers;

import animals.Animal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nino Bonev - 18.7.2018 г., 21:26
 */
public class CleansingCenter extends Center {
    private Map<String, List<Animal>> animals;

    public CleansingCenter(String name) {
        super(name);
        this.animals = new LinkedHashMap<>();
    }

    public Map<String, List<Animal>> getAnimals() {
        return this.animals;
    }

    public void addAnimals(String name, Animal animal) {
        this.animals.putIfAbsent(name, new ArrayList<>());
        this.animals.get(name).add(animal);
    }

    public long getAnimalsForCleansingCount(){
        long[] result = new long[]{0};
        this.animals.values().stream().forEach(z -> {
            result[0] += z.stream().filter(x -> !x.isCleansingStatus()).count();
        });
        return result[0];
    }

    public void cleanse(){

    }
}
