package onehitdungeon.domain.items;

import onehitdungeon.domain.Items;

/**
 * Created by Nino Bonev - 31.8.2018 г., 9:26
 */
public class ArmorItem extends Items implements onehitdungeon.interfaces.ArmorItem {
    public ArmorItem(int battlePower, double priceForUpgrade) {
        super(battlePower, priceForUpgrade);
    }
}
