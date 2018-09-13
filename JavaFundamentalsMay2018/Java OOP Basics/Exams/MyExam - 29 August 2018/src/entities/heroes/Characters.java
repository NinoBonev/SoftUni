package entities.heroes;

import interfaces.Hero;

/**
 * Created by Nino Bonev - 29.8.2018 г., 9:14
 */
public abstract class Characters implements Hero {
    private String name;
    private int magicka;
    private int fatigue;
    private int health;
    private String heroType;

    public Characters(String name, int magicka, int fatigue, int health, String heroType) {
        this.name = name;
        this.magicka = magicka;
        this.fatigue = fatigue;
        this.health = health;
        this.heroType = heroType;
    }

    public int getMagicka() {
        return magicka;
    }

    public int getFatigue() {
        return fatigue;
    }

    public String getHeroType() {
        return heroType;
    }


    protected void setHeroType(String heroType) {
        this.heroType = heroType;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public abstract double getOffense();

    @Override
    public abstract double getDefense();

    @Override
    public double getTotalPoints() {
        return this.getOffense() + this.getDefense();
    }

    @Override
    public boolean isDead() {
        boolean isReally = this.getHealth() < 1;
        return this.getHealth() < 1;
    }

    @Override
    public void attack(Hero hero) {
        hero.receiveDamage(Math.floor(this.getOffense()));
    }

    @Override
    public void receiveDamage(double amount) {
        this.health -= Math.floor(amount);
    }

    public double getMagicResistance() {
        return 0.0;
    }

    public double getMagicDamage() {
        return 0.0;
    }
}
