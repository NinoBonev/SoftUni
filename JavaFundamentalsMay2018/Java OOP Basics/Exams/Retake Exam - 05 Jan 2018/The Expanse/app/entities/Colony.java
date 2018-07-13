package app.entities;

import app.entities.colonists.Colonist;
import app.entities.family.Family;
import app.factories.FamilyFactory;

import java.util.*;

/**
 * Created by Nino Bonev - 12.7.2018 г., 12:08
 */
public class Colony {
    private int maxFamilyCount;
    private int maxFamilyCapacity;
    private Map<String, Family> families;

    public Colony(int maxFamilyCount, int maxFamilyCapacity) {
        this.maxFamilyCount = maxFamilyCount;
        this.maxFamilyCapacity = maxFamilyCapacity;
        this.families = new TreeMap<>();
    }

    public int getMaxFamilyCount() {
        return this.maxFamilyCount;
    }

    public int getMaxFamilyCapacity() {
        return this.maxFamilyCapacity;
    }

    public Map<String, Family> getFamilies() {
        return this.families;
    }

    public void addColonist(Colonist colonist) {
        String familyId = colonist.getFamilyId();

        if (this.families.containsKey(familyId)) {
            if (this.families.get(familyId).getFamilyCapacity() == this.maxFamilyCapacity) {
                throw new IllegalArgumentException(String.format("family is full%n"));
            }
            this.families.get(familyId).addMember(colonist);
        } else {
            if (this.families.keySet().size() == this.maxFamilyCount) {
                throw new IllegalArgumentException(String.format("colony is full%n"));
            }
            families.put(familyId, FamilyFactory.createFamily(familyId));
            families.get(familyId).addMember(colonist);
        }
    }

    public void removeColonist(String familyId, String memberId) {
        if (this.families.containsKey(familyId)) {
            this.families.get(familyId).removeMember(memberId);

            if (this.families.get(familyId).getColonists().isEmpty()) {
                this.removeFamily(familyId);
            }
        }
    }

    public void removeFamily(String familyId) {
            this.families.remove(familyId);
    }

    public List<Colonist> getColonistsByFamilyId(String familyId) {
        if (this.families.containsKey(familyId)) {
            return this.families.get(familyId).getColonists();
        }
        return null;
    }

    public void grow(int years) {
        this.getFamilies().values()
                .stream().forEach(family -> family.getColonists()
                .stream().forEach(colonist -> colonist.grow(years)));
    }

    public int getPotential() {
        return this.families.values().stream()
                .mapToInt(Family::getPotential)
                .sum();
    }

    public String printFamily(String familyId) {
        if (!this.families.containsKey(familyId)) {
            throw new IllegalArgumentException(String.format("family does not exist%n"));
        }
        return this.families.get(familyId).toString();
    }

    public String getCapacity() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("families: %d/%d%n", this.getFamilies().keySet().size(), maxFamilyCount));
        this.families.values().stream()
                .sorted((a, b) -> a.getId().compareTo(b.getId()))
                .forEach(family -> {
                    sb.append(String.format("-%s: %d/%d%n", family.getId(), family.getColonists().size(), maxFamilyCapacity));
                });

        return sb.toString();
    }
}
