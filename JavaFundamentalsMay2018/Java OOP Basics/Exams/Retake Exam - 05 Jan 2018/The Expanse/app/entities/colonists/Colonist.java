package app.entities.colonists;

/**
 * Created by Nino Bonev - 12.7.2018 г., 12:21
 */
public abstract class Colonist {
    private String id;
    private String familyId;
    private int talent;
    private int age;

    public Colonist(String id, String familyId, int talent, int age) {
        this.id = id;
        this.familyId = familyId;
        this.talent = talent;
        this.age = age;
    }

    public String getId() {
        return this.id;
    }

    public String getFamilyId() {
        return this.familyId;
    }

    public int getTalent() {
        return this.talent;
    }

    public int getAge() {
        return this.age;
    }

    public int getPotential() {
        return this.talent + this.getPotentialBonuses();
    }

    public void grow(int years){
        this.age += years;
    }

    abstract protected int getPotentialBonuses();
}
