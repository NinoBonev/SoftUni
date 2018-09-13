package onehitdungeon.myinterfaces;

import onehitdungeon.interfaces.Hero;

import java.util.List;

/**
 * Created by Nino Bonev - 31.8.2018 г., 9:21
 */
public interface HeroFactory {

    public Hero createHero(String type, String name);
}
