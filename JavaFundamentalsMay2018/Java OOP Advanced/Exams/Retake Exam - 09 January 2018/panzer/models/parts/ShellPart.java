package panzer.models.parts;

import panzer.contracts.DefenseModifyingPart;

import java.math.BigDecimal;

/**
 * Created by Nino Bonev - 1.8.2018 г., 19:15
 */
public class ShellPart extends BasePart implements DefenseModifyingPart {
    private int defenseModifier;

    public ShellPart(String model, double weight, BigDecimal price, int defenseModifier) {
        super(model, weight, price);
        this.defenseModifier = defenseModifier;
    }

    @Override
    public int getDefenseModifier() {
        return this.defenseModifier;
    }

    @Override
    public String toString() {
        return String.format("%s+%d Defense\n", super.toString(), this.getDefenseModifier());
    }
}
