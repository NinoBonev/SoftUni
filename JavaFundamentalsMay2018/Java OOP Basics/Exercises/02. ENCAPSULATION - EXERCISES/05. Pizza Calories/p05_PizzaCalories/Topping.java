package p05_PizzaCalories;

/**
 * Created by Nino Bonev - 21.6.2018 г., 23:38
 */
public class Topping {
    private String name;
    private double weight;

    public Topping(String name, double weight) {
        this.setName(name);
        this.setWeight(weight);
    }

    public void setName(String name) {
        if (!(name.equals("Meat") || name.equals("Veggies") || name.equals("Cheese") || name.equals("Sauce"))){
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.%n", name));
        }
        this.name = name;
    }

    public void setWeight(double weight) {
        if (weight < 1 || weight > 50){
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", name));
        }
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }
}
