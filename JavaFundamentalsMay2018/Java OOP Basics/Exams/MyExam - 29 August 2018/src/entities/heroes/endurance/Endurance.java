package entities.heroes.endurance;

import entities.heroes.Characters;
import interfaces.Hero;

/**
 * Created by Nino Bonev - 29.8.2018 г., 9:27
 */
public  class Endurance extends Characters {
    private double magicResistance;

     Endurance(String name, int magicka, int fatigue, int health, String heroType) {
        super(name, magicka, fatigue, health, heroType);
        this.magicResistance = 0.4 * magicka;
    }

    @Override
    public double getMagicResistance() {
        return this.magicResistance;
    }

    @Override
    public double getOffense() {
        return this.getFatigue();
    }

    @Override
    public double getDefense() {
        return this.getHealth() + 0.6 * this.getFatigue() + this.getMagicResistance();
    }

}
