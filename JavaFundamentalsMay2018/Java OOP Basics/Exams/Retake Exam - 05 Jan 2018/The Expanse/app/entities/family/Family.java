package app.entities.family;

import app.entities.colonists.Colonist;

import java.util.*;

/**
 * Created by Nino Bonev - 12.7.2018 г., 12:09
 */
public class Family {
    private String id;
    private Map<String, Colonist> colonists;

    public Family(String id) {
        this.id = id;
        this.colonists = new TreeMap<>();
    }

    public void setId(String id) {
        this.id = id;
    }


    public List<Colonist> getColonists() {
        return Collections.unmodifiableList(new ArrayList<>(this.colonists.values()));
    }

    public String getId() {
        return this.id;
    }

    public int getFamilyCapacity() {
        return this.getColonists().size();
    }

    public void removeMember(String id) {
        this.colonists.remove(id);

    }

    public void addMember(Colonist colonist) {
        this.colonists.put(colonist.getId(), colonist);
    }

    public int getPotential() {
        return this.colonists.values().stream()
                .mapToInt(Colonist::getPotential)
                .sum();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.id + ":")
                .append(System.lineSeparator());
        this.colonists.values().stream()
                .sorted((a, b) -> a.getId().compareTo(b.getId()))
                .forEach(colonist -> {
                    sb.append(String.format("-%s: %d%n", colonist.getId(), colonist.getPotential()));
                });

        return sb.toString();
    }
}
