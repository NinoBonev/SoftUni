package entities.heroes.endurance;

/**
 * Created by Nino Bonev - 29.8.2018 г., 9:18
 */
public class Orc extends Endurance {
    public Orc(String name, int magicka, int fatigue, int health, String heroType) {
        super(name, magicka, fatigue, health, heroType);
        super.setHeroType("ORSIMER");
    }

    @Override
    public double getDefense() {
        return 1.1 * super.getDefense();
    }
}
