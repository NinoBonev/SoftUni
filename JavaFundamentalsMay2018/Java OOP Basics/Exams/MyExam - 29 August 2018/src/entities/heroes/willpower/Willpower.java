package entities.heroes.willpower;

import entities.heroes.Characters;
import interfaces.Hero;

/**
 * Created by Nino Bonev - 29.8.2018 г., 9:28
 */
public class Willpower extends Characters {
    private double spellPentration;

    Willpower(String name, int magicka, int fatigue, int health, String heroType) {
        super(name, magicka, fatigue, health, heroType);
        this.spellPentration = 0.2 * fatigue;
    }

    @Override
    public double getOffense() {
        return 1.8 * this.getMagicka() + this.spellPentration;
    }

    @Override
    public double getDefense() {
        return this.getHealth();
    }

}
