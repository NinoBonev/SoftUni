package panzer.models.vehicles;

import panzer.constants.Messages;
import panzer.contracts.Assembler;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.models.miscellaneous.VehicleAssembler;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nino Bonev - 1.8.2018 г., 18:49
 */
public abstract class BaseVehicle implements Vehicle{
    private String model;
    private double weight;
    private BigDecimal price;
    private int attack;
    private int defense;
    private int hitPoints;
    private Assembler assembler;

    public BaseVehicle(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        this.model = model;
        this.weight = weight;
        this.price = price;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
        this.assembler = new VehicleAssembler();
    }

    protected double getPriceModifier() {
        return 1.0;
    }

    protected double getWeightModifier() {
        return 1.0;
    }

    protected double getAttackModifier() {
        return 1.0;
    }

    protected double getDefenseModifier() {
        return 1.0;
    }

    protected double getHitPointsModifier() {
        return 1.0;
    }

    protected abstract String getType();

    @Override
    public double getTotalWeight() {
        return this.assembler.getTotalWeight() + this.weight * this.getWeightModifier();
    }

    @Override
    public BigDecimal getTotalPrice() {
        return this.price.multiply(BigDecimal.valueOf(this.getPriceModifier())).add(this.assembler.getTotalPrice());
    }

    @Override
    public long getTotalAttack() {
        return this.assembler.getTotalAttackModification() + (long)(this.attack * this.getAttackModifier());
    }

    @Override
    public long getTotalDefense() {
        return this.assembler.getTotalDefenseModification() + (long)(this.defense * this.getDefenseModifier());
    }

    @Override
    public long getTotalHitPoints() {
        return this.assembler.getTotalHitPointModification() + (long)(this.hitPoints * this.getHitPointsModifier());
    }

    @Override
    public void addArsenalPart(Part arsenalPart) {
        this.assembler.addArsenalPart(arsenalPart);
    }

    @Override
    public void addShellPart(Part shellPart) {
        this.assembler.addShellPart(shellPart);
    }

    @Override
    public void addEndurancePart(Part endurancePart) {
        this.assembler.addEndurancePart(endurancePart);
    }

    @Override
    public Iterable<Part> getParts() {
        try {
            Field allParts = VehicleAssembler.class.getDeclaredField("allParts");
            allParts.setAccessible(true);
            return (List<Part>) allParts.get(this.assembler);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %s\n", this.getType(), this.getModel()))
                .append(String.format("Total Weight: %.3f\n", this.getTotalWeight()))
                .append(String.format("Total Price: %.3f\n", this.getTotalPrice()))
                .append(String.format("Attack: %d\n", this.getTotalAttack()))
                .append(String.format("Defense: %d\n", this.getTotalDefense()))
                .append(String.format("HitPoints: %d\n", this.getTotalHitPoints()))
                .append("Parts: ");
        List<String> parts = new LinkedList<>();
        for (Part part : this.getParts()) {
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
