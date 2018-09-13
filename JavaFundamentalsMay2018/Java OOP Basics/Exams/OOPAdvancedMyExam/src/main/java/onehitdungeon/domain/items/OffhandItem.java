package onehitdungeon.domain.items;


import onehitdungeon.domain.Items;

/**
 * Created by Nino Bonev - 31.8.2018 г., 9:26
 */
public class OffhandItem extends Items implements onehitdungeon.interfaces.OffhandItem {
    public OffhandItem(int battlePower, double priceForUpgrade) {
        super(battlePower, priceForUpgrade);
    }
}
