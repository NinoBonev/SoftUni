package p08_PokemonTrainer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nino Bonev - 17.6.2018 г., 10:58
 */
public class Trainer {
    private String name;
    private Integer badges;
    private List<Pokemon> pokemons;


    public Trainer() {
    }

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBadges() {
        return badges;
    }

    public void setBadges(Integer badges) {
        this.badges = badges;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public void addPokemons(String name, String element, Integer health) {
        Pokemon pokemon = new Pokemon(name, element, health);
        this.getPokemons().add(pokemon);
    }
}
