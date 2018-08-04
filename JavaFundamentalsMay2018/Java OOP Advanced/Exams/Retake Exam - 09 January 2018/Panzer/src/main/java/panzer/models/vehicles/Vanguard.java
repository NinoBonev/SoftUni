package panzer.models.vehicles;

import panzer.constants.Messages;
import panzer.contracts.Part;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nino Bonev - 1.8.2018 г., 18:46
 */
public class Vanguard extends BaseVehicle {
    public Vanguard(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        super(model, weight, price, attack, defense, hitPoints);
    }

    @Override
    protected double getWeightModifier() {
        return 2;
    }

    @Override
    protected double getAttackModifier() {
        return 0.75;
    }

    @Override
    protected double getDefenseModifier() {
        return 1.5;
    }

    @Override
    protected double getHitPointsModifier() {
        return 1.75;
    }

    @Override
    protected String getType() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %s\n", this.getType(), super.getModel()))
                .append(String.format("Total Weight: %.3f\n", super.getTotalWeight()))
                .append(String.format("Total Price: %.3f\n", super.getTotalPrice()))
                .append(String.format("Attack: %d\n", super.getTotalAttack()))
                .append(String.format("Defense: %d\n", super.getTotalDefense()))
                .append(String.format("HitPoints: %d\n", super.getTotalHitPoints()))
                .append("Parts: ");
        List<String> parts = new LinkedList<>();
        for (Part part : super.getParts()) {
            parts.add(part.getModel());
        }
        if (parts.size() > 0) {
            String partsToString = String.join(", ", parts);
            sb.append(partsToString).append(System.lineSeparator());
        } else {
            sb.append(Messages.NONE).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
