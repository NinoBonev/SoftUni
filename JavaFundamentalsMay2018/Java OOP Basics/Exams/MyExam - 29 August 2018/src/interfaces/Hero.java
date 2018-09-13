package interfaces;

/**
 * Created by Nino Bonev - 29.8.2018 г., 9:06
 */
public interface Hero {
    /*
    String getName() – returns the name of the hero.
int getHealth() – returns the health of the hero.
double getOffense() – returns the offense of the hero.
 double getDefense() – returns the defense of the hero.
 double getTotalPoints() – returns the total points of the hero.
 boolean isDead() - returns “true” if the hero is dead.
 void attack(Hero hero) - attack another character.
 void receiveDamage(double amount) – receive damage equal to the double amount.

     */
    String getName();

    int getHealth();

    int getMagicka();

    int getFatigue();

    String getHeroType();

    double getMagicResistance();

    double getMagicDamage();

    double getOffense();

    double getDefense();

    double getTotalPoints();

    boolean isDead();

    void attack(Hero hero);

    void receiveDamage(double amount);

}
