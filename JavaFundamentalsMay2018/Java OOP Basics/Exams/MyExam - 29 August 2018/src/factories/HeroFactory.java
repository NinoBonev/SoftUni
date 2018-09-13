package factories;

import interfaces.Hero;
import interfaces.IHeroFactory;

import java.util.List;

/**
 * Created by Nino Bonev - 17.8.2018 г., 15:52
 */
public class HeroFactory implements IHeroFactory {

    public HeroFactory(){};

    @Override
    public Hero createHero(List<String> arguments){
        return null;
    }
}
