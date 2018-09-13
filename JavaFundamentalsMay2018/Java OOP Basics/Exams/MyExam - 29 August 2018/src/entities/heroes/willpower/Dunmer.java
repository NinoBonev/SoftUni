package entities.heroes.willpower;

/**
 * Created by Nino Bonev - 29.8.2018 г., 9:18
 */
public class Dunmer extends Willpower {
    public Dunmer(String name, int magicka, int fatigue, int health, String heroType) {
        super(name, magicka, fatigue, health, heroType);
        super.setHeroType("DUNMER");
    }
}
