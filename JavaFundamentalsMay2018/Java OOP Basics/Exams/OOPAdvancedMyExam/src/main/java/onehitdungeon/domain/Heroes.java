package onehitdungeon.domain;

import onehitdungeon.constants.EngineConstants;
import onehitdungeon.interfaces.ArmorItem;
import onehitdungeon.interfaces.Hero;
import onehitdungeon.interfaces.OffhandItem;
import onehitdungeon.interfaces.WeaponItem;

/**
 * Created by Nino Bonev - 31.8.2018 г., 11:01
 */
public abstract class Heroes implements Hero {
    private String name;
    private double gold;

    protected Heroes(String name) {
        this.name = name;
        this.gold = EngineConstants.DEFAULT_RATING;
    }

    @Override
    public abstract String getHeroClass();

    @Override
    public Double getGold(){
        return this.gold;
    }

    @Override
    public void earnGold(Double gold){
        this.gold += gold;
    };

    @Override
    public void payGold(Double gold){
        this.gold -= gold;
    };

    @Override
    public abstract WeaponItem getWeapon();

    @Override
    public abstract OffhandItem getOffhand();

    @Override
    public abstract ArmorItem getArmor();

    @Override
    public abstract Integer getTotalBattlePower();

    @Override
    public abstract Double getTotalPriceForUpgrade();

    @Override
    public String getName() {
        return this.name;
    }
}
