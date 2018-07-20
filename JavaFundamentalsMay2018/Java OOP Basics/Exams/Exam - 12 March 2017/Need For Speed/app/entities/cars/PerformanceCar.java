package app.entities.cars;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nino Bonev - 14.7.2018 г., 8:57
 */
public class PerformanceCar extends Car {
    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction,
                          int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.setIndexes();
        this.addOns = new ArrayList<>();
    }

    public List<String> getAddOns() {
        return addOns;
    }

    public void setAddOns(List<String> addOns) {
        this.addOns = addOns;
    }

    private void setIndexes() {
        this.setHorsepower(this.getHorsepower() + (this.getHorsepower() * 50) / 100);
        this.setSuspension(this.getSuspension() - (this.getSuspension() * 25) / 100);
    }

    @Override
    public void tune(int tuneIndex, String tuneAddOn) {
        super.tune(tuneIndex, tuneAddOn);
        this.addOns.add(tuneAddOn);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String addOns;
        if (this.addOns.isEmpty()){
            addOns = "None";
        } else {
            addOns = String.join(", ", this.addOns);
        }
        sb.append(String.format("%sAdd-ons: %s%n", super.toString(), addOns));
        return sb.toString().trim();
    }
}
