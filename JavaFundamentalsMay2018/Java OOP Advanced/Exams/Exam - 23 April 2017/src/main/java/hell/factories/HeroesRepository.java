package hell.factories;

import hell.interfaces.Hero;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Nino Bonev - 19.8.2018 г., 18:00
 */
public class HeroesRepository {

    public HeroesRepository() {}

    public LinkedHashMap<String, Hero> createMap(){
        return new LinkedHashMap<String, Hero>();
    }
}
