package hell.entities.items;

import hell.interfaces.Item;

/**
 * Created by Nino Bonev - 19.8.2018 г., 11:15
 */
public abstract class BaseItem implements Item {
    /*
    •	Name – a string, indicating the name of the item.
•	StrengthBonus – an integer, indicating the strength bonus of the item.
•	AgilityBonus – an integer, indicating the agility bonus of the item.
•	IntelligenceBonus – an integer, indicating the intelligence bonus of the item.
•	HitPointsBonus – an integer, indicating the hit points bonus of the item.
•	DamageBonus – an integer, indicating the damage bonus of the item.

     */
    private String name;
    private int strengthBonus;
    private int agilityBonus;
    private int intelligenceBonus;
    private int hitPointsBonus;
    private int damageBonus;

    BaseItem(String name, Integer strengthBonus, Integer agilityBonus, Integer intelligenceBonus, Integer hitPointsBonus, Integer damageBonus) {
        this.name = name;
        this.strengthBonus = strengthBonus;
        this.agilityBonus = agilityBonus;
        this.intelligenceBonus = intelligenceBonus;
        this.hitPointsBonus = hitPointsBonus;
        this.damageBonus = damageBonus;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrengthBonus() {
        return this.strengthBonus;
    }

    @Override
    public int getAgilityBonus() {
        return this.agilityBonus;
    }

    @Override
    public int getIntelligenceBonus() {
        return this.intelligenceBonus;
    }

    @Override
    public int getHitPointsBonus() {
        return this.hitPointsBonus;
    }

    @Override
    public int getDamageBonus() {
        return this.damageBonus;
    }
}
