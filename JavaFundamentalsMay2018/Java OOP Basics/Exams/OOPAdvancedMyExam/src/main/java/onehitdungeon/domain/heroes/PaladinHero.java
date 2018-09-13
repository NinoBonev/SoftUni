package onehitdungeon.domain.heroes;

import onehitdungeon.constants.Messages;
import onehitdungeon.domain.Heroes;
import onehitdungeon.domain.items.ArmorItem;
import onehitdungeon.domain.items.OffhandItem;
import onehitdungeon.domain.items.WeaponItem;


/**
 * Created by Nino Bonev - 31.8.2018 г., 9:32
 */
public class PaladinHero extends Heroes {
    private WeaponItem weapon;
    private ArmorItem armor;
    private OffhandItem offhandItem;

    public PaladinHero(String name) {
        super(name);
        this.setWeapon();
        this.setArmor();
        this.setOffhandItem();
    }

    private void setWeapon() {
        this.weapon = new WeaponItem(20, 10.0);
    }

    private void setArmor() {
        this.armor = new ArmorItem(25, 20.0);
    }

    private void setOffhandItem() {
        this.offhandItem = new OffhandItem(10, 10.0);
    }

    @Override
    public String getHeroClass() {
        return Messages.PALADIN;
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

    @Override
    public Integer getTotalBattlePower() {
        return ((this.armor.getBattlePower() + this.offhandItem.getBattlePower() + this.weapon.getBattlePower()) * 4) / 9;
    }


    @Override
    public Double getTotalPriceForUpgrade() {
        return this.armor.getPriceForUpgrade() + this.weapon.getPriceForUpgrade() + this.offhandItem.getPriceForUpgrade();
    }

}
