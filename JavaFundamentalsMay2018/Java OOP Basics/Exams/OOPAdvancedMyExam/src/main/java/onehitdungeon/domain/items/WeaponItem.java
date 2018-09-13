package onehitdungeon.domain.items;

import onehitdungeon.domain.Items;

/**
 * Created by Nino Bonev - 31.8.2018 г., 9:26
 */
public class WeaponItem extends Items implements onehitdungeon.interfaces.WeaponItem {
    public WeaponItem(int battlePower, double priceForUpgrade) {
        super(battlePower, priceForUpgrade);
    }

}
