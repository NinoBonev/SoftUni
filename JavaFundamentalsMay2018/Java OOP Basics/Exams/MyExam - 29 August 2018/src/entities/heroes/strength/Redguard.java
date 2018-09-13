package entities.heroes.strength;

/**
 * Created by Nino Bonev - 29.8.2018 г., 9:17
 */
public class Redguard extends Strength {
    public Redguard(String name, int magicka, int fatigue, int health, String heroType) {
        super(name, magicka, fatigue, health, heroType);
        super.setHeroType("REDGUARD");
    }
}
