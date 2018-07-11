package p11_CatLady;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nino Bonev - 19.6.2018 г., 11:36
 */
public class Cat {
    private List<Cymric> cymrics;
    private List<Siamese> siamese;
    private  List<StreetExtraordinaire> streetExtraordinaires;

    public Cat() {
        this.cymrics = new ArrayList<>();
        this.siamese = new ArrayList<>();
        this.streetExtraordinaires = new ArrayList<>();
    }

    public List<Cymric> getCymrics() {
        return this.cymrics;
    }

    public void addCymrics(String name, double furLength) {
        Cymric cymric = new Cymric(name, furLength);
        this.getCymrics().add(cymric);
    }

    public List<Siamese> getSiamese() {
        return this.siamese;
    }

    public void addSiamese(String name, double earSize) {
        Siamese siamese = new Siamese(name, earSize);
        this.getSiamese().add(siamese);
    }

    public List<StreetExtraordinaire> getStreetExtraordinaires() {
        return this.streetExtraordinaires;
    }

    public void addStreetExtraordinaires(String name, double decibelsOfMeows) {
        StreetExtraordinaire streetExtraordinaire = new StreetExtraordinaire(name, decibelsOfMeows);
        this.getStreetExtraordinaires().add(streetExtraordinaire);
    }
}
