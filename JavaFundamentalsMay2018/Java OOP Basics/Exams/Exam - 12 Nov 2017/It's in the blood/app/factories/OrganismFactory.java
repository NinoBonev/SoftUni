package app.factories;

import app.entities.Organism;

/**
 * Created by Nino Bonev - 11.7.2018 г., 23:59
 */
public final class OrganismFactory {

    private OrganismFactory(){}

    public static Organism createOrganism(String name){
        return new Organism(name);
    }
}
