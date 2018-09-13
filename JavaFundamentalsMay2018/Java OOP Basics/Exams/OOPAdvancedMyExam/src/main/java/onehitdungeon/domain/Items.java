package onehitdungeon.domain;

import onehitdungeon.interfaces.Item;

/**
 * Created by Nino Bonev - 31.8.2018 г., 9:27
 */
public abstract class Items implements Item {
    private int battlePower;
    private double priceForUpgrade;

    protected Items(int battlePower, double priceForUpgrade) {
        this.battlePower = battlePower;
        this.priceForUpgrade = priceForUpgrade;
    }

    @Override
    public Integer getBattlePower() {
        return this.battlePower;
    }

    @Override
    public Double getPriceForUpgrade() {
        return this.priceForUpgrade;
    }
}
