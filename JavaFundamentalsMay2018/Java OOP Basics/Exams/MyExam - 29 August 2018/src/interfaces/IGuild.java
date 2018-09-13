package interfaces;

/**
 * Created by Nino Bonev - 29.8.2018 г., 9:54
 */
public interface IGuild {

    String addHero(Hero hero);

    String removeHero(Hero hero);

    Hero getHeroByName(String heroName);

    Long getGuildSize();

    double getGuildPower();

    String getGuildSpecialization();


}
