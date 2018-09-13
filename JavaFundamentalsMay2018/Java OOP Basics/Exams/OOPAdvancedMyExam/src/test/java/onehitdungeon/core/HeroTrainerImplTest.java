package onehitdungeon.core;

import onehitdungeon.interfaces.*;
import org.junit.Assert;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * Created by Nino Bonev - 31.8.2018 г., 13:57
 */
public class HeroTrainerImplTest {
    private HeroTrainer heroTrainer;

    private Hero hero1;
    private WeaponItem weapon;
    private OffhandItem offhandItem;
    private ArmorItem armorItem;

    private Hero hero2;

    @org.junit.Before
    public void setUp() throws Exception {
        this.heroTrainer = new HeroTrainerImpl();

        this.hero1 = Mockito.mock(Hero.class);
        this.hero2 = Mockito.mock(Hero.class);
        this.armorItem = Mockito.mock(ArmorItem.class);
        this.weapon = Mockito.mock(WeaponItem.class);
        this.offhandItem = Mockito.mock(OffhandItem.class);

        //Mockito.when(armorItem.getBattlePower())

        Mockito.when(hero1.getName()).thenReturn("Nino");
        Mockito.when(hero2.getName()).thenReturn("Vesy");
        Mockito.when(hero1.getHeroClass()).thenReturn("Paladin");
        Mockito.when(hero2.getHeroClass()).thenReturn("Mage");
        Mockito.when(hero1.getTotalPriceForUpgrade()).thenReturn(200.0);
        Mockito.when(hero2.getTotalPriceForUpgrade()).thenReturn(100.0);
        Mockito.when(hero1.getGold()).thenReturn(220.0);
        Mockito.when(hero2.getGold()).thenReturn(210.0);
        Mockito.when(hero1.getArmor().getBattlePower()).thenReturn(10);
        Mockito.when(hero2.getArmor().getBattlePower()).thenReturn(10);
        Mockito.when(hero1.getOffhand().getBattlePower()).thenReturn(10);
        Mockito.when(hero2.getOffhand().getBattlePower()).thenReturn(10);
        Mockito.when(hero1.getWeapon().getBattlePower()).thenReturn(10);
        Mockito.when(hero2.getWeapon().getBattlePower()).thenReturn(10);
        Mockito.when(hero1.getWeapon().getPriceForUpgrade()).thenReturn(10.0);
        Mockito.when(hero2.getWeapon().getPriceForUpgrade()).thenReturn(10.0);
        Mockito.when(hero1.getOffhand().getPriceForUpgrade()).thenReturn(10.0);
        Mockito.when(hero2.getOffhand().getPriceForUpgrade()).thenReturn(10.0);
        Mockito.when(hero1.getArmor().getPriceForUpgrade()).thenReturn(10.0);
        Mockito.when(hero2.getArmor().getPriceForUpgrade()).thenReturn(10.0);
    }

    @org.junit.Test
    public void trainHero() {
        this.heroTrainer.trainHero(this.hero1);

        Assert.assertEquals(16, hero1.getWeapon().getBattlePower(), 0.1);
    }
}