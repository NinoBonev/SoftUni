package panzer.models.parts;

import panzer.contracts.AttackModifyingPart;

import java.math.BigDecimal;

/**
 * Created by Nino Bonev - 1.8.2018 г., 19:15
 */
public class ArsenalPart extends BasePart implements AttackModifyingPart {
    private int attackModifier;

    public ArsenalPart(String model, double weight, BigDecimal price, int attackModifier) {
        super(model, weight, price);
        this.attackModifier = attackModifier;
    }

    @Override
    public int getAttackModifier() {
        return this.attackModifier;
    }

    @Override
    public String toString() {
        return String.format("%s+%d Attack\n", super.toString(), this.getAttackModifier());
    }
}
