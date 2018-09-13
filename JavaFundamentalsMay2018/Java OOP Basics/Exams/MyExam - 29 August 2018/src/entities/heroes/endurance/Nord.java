package entities.heroes.endurance;

/**
 * Created by Nino Bonev - 29.8.2018 г., 9:18
 */
public class Nord extends Endurance {
    public Nord(String name, int magicka, int fatigue, int health, String heroType) {
        super(name, magicka, fatigue, health, heroType);
        super.setHeroType("NORD");
    }
}
