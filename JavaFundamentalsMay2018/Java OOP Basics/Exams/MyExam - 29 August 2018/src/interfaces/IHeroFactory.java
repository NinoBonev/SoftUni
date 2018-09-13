package interfaces;

import java.util.List;

/**
 * Created by Nino Bonev - 29.8.2018 г., 10:02
 */
public interface IHeroFactory {

    Hero createHero(List<String> arguments);
}
