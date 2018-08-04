package panzer.models.parts;

import panzer.contracts.HitPointsModifyingPart;

import java.math.BigDecimal;

/**
 * Created by Nino Bonev - 1.8.2018 г., 19:15
 */
public class EndurancePart extends BasePart implements HitPointsModifyingPart {
    private int hitPointsModifier;

    public EndurancePart(String model, double weight, BigDecimal price, int hitPointsModifier) {
        super(model, weight, price);
        this.hitPointsModifier = hitPointsModifier;
    }

    @Override
    public int getHitPointsModifier() {
        return this.hitPointsModifier;
    }

    @Override
    public String toString() {
        return String.format("%s+%d HitPoints\n", super.toString(), this.getHitPointsModifier()).trim();
    }
}
