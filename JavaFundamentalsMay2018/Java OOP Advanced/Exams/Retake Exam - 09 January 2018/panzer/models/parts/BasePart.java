package panzer.models.parts;

import panzer.contracts.Part;

import java.math.BigDecimal;

/**
 * Created by Nino Bonev - 1.8.2018 г., 19:13
 */
public abstract class BasePart implements Part {
    private String model;
    private double weight;
    private BigDecimal price;

    public BasePart(String model, double weight, BigDecimal price) {
        this.model = model;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s Part - %s\n", this.getClass().getSimpleName(), this.getModel()));
        return sb.toString();
    }
}
