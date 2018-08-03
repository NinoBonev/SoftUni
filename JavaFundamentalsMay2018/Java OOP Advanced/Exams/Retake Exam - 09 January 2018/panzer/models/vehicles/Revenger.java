package panzer.models.vehicles;

import panzer.constants.Messages;
import panzer.contracts.Part;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nino Bonev - 1.8.2018 г., 18:46
 */
public class Revenger extends BaseVehicle {

    public Revenger(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        super(model, weight, price, attack, defense, hitPoints);
    }

    @Override
    protected double getPriceModifier() {
        return 1.5;
    }

    @Override
    protected double getAttackModifier() {
        return 2.5;
    }

    @Override
    protected double getDefenseModifier() {
        return 0.5;
    }

    @Override
    protected double getHitPointsModifier() {
        return 0.5;
    }

    @Override
    protected String getType() {
        return this.getClass().getSimpleName();
    }


}
