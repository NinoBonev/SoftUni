package hell.factories;

import hell.entities.heroes.Assassin;
import hell.entities.heroes.Barbarian;
import hell.entities.heroes.Wizard;
import hell.interfaces.Hero;

/**
 * Created by Nino Bonev - 19.8.2018 г., 13:47
 */
public class HeroFactory {

    public HeroFactory (){}

    public Hero createHero(String name, String type){
        switch (type){
            case "Barbarian" : return new Barbarian(name);
            case "Assassin" : return new Assassin(name);
            case "Wizard" : return new Wizard(name);
            default: return null;
        }
    }
}
