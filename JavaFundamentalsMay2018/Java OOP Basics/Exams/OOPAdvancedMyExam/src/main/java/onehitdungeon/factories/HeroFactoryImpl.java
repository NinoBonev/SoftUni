package onehitdungeon.factories;

import onehitdungeon.domain.heroes.MageHero;
import onehitdungeon.domain.heroes.PaladinHero;
import onehitdungeon.interfaces.Hero;
import onehitdungeon.myinterfaces.HeroFactory;

/**
 * Created by Nino Bonev - 31.8.2018 г., 9:22
 */
public class HeroFactoryImpl implements HeroFactory {

    public HeroFactoryImpl (){}

    @Override
    public Hero createHero(String type, String name) {
        switch (type){
            case "Paladin" : return new PaladinHero(name);
            case "Mage" : return new MageHero(name);
            default: return null;
        }
    }
}
