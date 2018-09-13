package entities.heroes.strength;

import entities.heroes.Characters;
import interfaces.Hero;

/**
 * Created by Nino Bonev - 29.8.2018 г., 9:27
 */
public class Strength extends Characters {
    private double magicDamage;

    Strength(String name, int magicka, int fatigue, int health, String heroType) {
        super(name, magicka, fatigue, health, heroType);
        this.magicDamage = 0.5 * magicka;
    }

    public double getMagicDamage() {
        return magicDamage;
    }

    @Override
    public double getOffense() {
        return 1.25 * this.getFatigue() + 0.3 * this.getHealth() + this.magicDamage;
    }

    @Override
    public double getDefense() {
        return this.getHealth() + 0.1 * this.getFatigue();
    }

}
