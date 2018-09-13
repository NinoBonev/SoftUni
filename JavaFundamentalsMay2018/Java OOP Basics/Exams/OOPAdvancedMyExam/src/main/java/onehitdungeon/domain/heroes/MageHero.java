package onehitdungeon.domain.heroes;

import onehitdungeon.constants.Messages;
import onehitdungeon.domain.Heroes;
import onehitdungeon.domain.items.ArmorItem;
import onehitdungeon.domain.items.OffhandItem;
import onehitdungeon.domain.items.WeaponItem;

/**
 * Created by Nino Bonev - 31.8.2018 г., 9:32
 */
public class MageHero extends Heroes {
    private onehitdungeon.interfaces.WeaponItem weapon;
    private onehitdungeon.interfaces.ArmorItem armor;
    private onehitdungeon.interfaces.OffhandItem offhandItem;

     public MageHero(String name) {
        super(name);
         this.setWeapon();
         this.setArmor();
         this.setOffhandItem();
     }

    private void setWeapon() {
        this.weapon = new WeaponItem(45, 15.0);
    }

    private void setArmor() {
        this.armor = new ArmorItem(10, 25.0);
    }

    private void setOffhandItem() {
        this.offhandItem = new OffhandItem(25, 20.0);
    }

    @Override
    public String getHeroClass() {
        return Messages.MAGE;
    }

    @Override
    public onehitdungeon.interfaces.WeaponItem getWeapon() {
        return this.weapon;
    }

    @Override
    public onehitdungeon.interfaces.OffhandItem getOffhand() {
        return this.offhandItem;
    }

    @Override
    public onehitdungeon.interfaces.ArmorItem getArmor() {
        return this.armor;
    }

    //((weaponBattlePower + armorBattlePower - offhandBattlePower) * 3) / 4
    @Override
    public Integer getTotalBattlePower() {
        return ((this.weapon.getBattlePower() + this.armor.getBattlePower() - this.offhandItem.getBattlePower()) * 3) / 4;
    }

    @Override
    public Double getTotalPriceForUpgrade() {
        return this.armor.getPriceForUpgrade() + this.weapon.getPriceForUpgrade() + this.offhandItem.getPriceForUpgrade();
    }

}
