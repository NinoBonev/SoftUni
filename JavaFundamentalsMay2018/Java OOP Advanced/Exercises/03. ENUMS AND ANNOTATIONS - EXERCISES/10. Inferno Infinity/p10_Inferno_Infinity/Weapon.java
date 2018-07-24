package p10_Inferno_Infinity;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by Nino Bonev - 24.7.2018 г., 16:49
 */
@MyAnnotation(author = "Pesho", revision = 3, description = "Used for Java OOP Advanced course - Enumerations and Annotations."
        , reviewers = {"Pesho", "Svetlio"})
public class Weapon implements Comparable<Weapon>{
    private String name;
    private WeaponType weaponType;
    private Gem[] gems;


    public Weapon(WeaponType weaponType, String name) {
        this.name = name;
        this.weaponType = weaponType;
        this.gems = new Gem[weaponType.getSockets()];
    }

    public void addGem(int socketIndex, Gem gemType){
        if (socketIndex < this.gems.length && socketIndex >= 0) {
            this.gems[socketIndex] = gemType;
        }
    }

    public void removeGem(int socketIndex){
        if (socketIndex < this.gems.length && socketIndex >= 0) {
            this.gems[socketIndex] = null;
        }
    }

    public int getMinDamage(){
        int minDamage = this.weaponType.getMinDamage();
      for (Gem gem :
              this.gems) {
          if (gem != null) {
              minDamage += gem.getStrength() * 2;
              minDamage += gem.getAgility();
          }
      }
      return minDamage;
    }

    public int getMaxDamage(){
        int maxDamage = this.weaponType.getMaxDamage();
        for (Gem gem :
                this.gems) {
            if (gem != null) {
                maxDamage += gem.getStrength() * 3;
                maxDamage += gem.getAgility() * 4;
            }
        }
        return maxDamage;
    }

    public int getStrength(){
        int strength = 0;
        for (Gem gem :
                this.gems) {
            if (gem != null) {
                strength += gem.getStrength();
            }
        }
        return strength;
    }

    public int getAgility(){
        int agility = 0;
        for (Gem gem :
                this.gems) {
            if (gem != null) {
                agility += gem.getAgility();
            }
        }
        return agility;
    }

    public int getVitality(){
        int vitality = 0;
        for (Gem gem :
                this.gems) {
            if (gem != null) {
                vitality += gem.getVitality();
            }
        }
        return vitality;
    }

    public Double getItemLevel(){
        Double itemLevel = ((this.getMinDamage() + this.getMaxDamage()) / 2.0)
                + this.getAgility() + this.getStrength() + this.getVitality();
        return itemLevel;
    }

    public void compare(){

    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
        this.name, this.getMinDamage(), this.getMaxDamage(),
                this.getStrength(), this.getAgility(), this.getVitality());
    }

    public String print(){
        return String.format(Locale.ROOT, "%s (Item Level: %.1f)", this.toString(), this.getItemLevel());
    }

    @Override
    public int compareTo(Weapon weapon) {
        return Double.compare(this.getItemLevel(), weapon.getItemLevel());
    }
}
