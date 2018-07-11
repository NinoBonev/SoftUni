package p05_PizzaCalories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nino Bonev - 21.6.2018 г., 23:11
 */
public class Pizza {
    private String name;
    private String flourType;
    private String bakingMethod;
    private double doughWeight;
    private Integer toppingNumber;
    private List<Topping> toppings;

    public Pizza(Integer toppingNumber, String name, String flourType, String bakingMethod, double doughWeight) {
        this.setToppingNumber(toppingNumber);
        this.setName(name);
        this.setFlourType(flourType);
        this.setBakingMethod(bakingMethod);
        this.setDoughWeight(doughWeight);
        this.toppings = new ArrayList<>();
    }

    private void setToppingNumber(Integer toppingNumber) {
        if (toppingNumber > 10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppingNumber = toppingNumber;
    }

    private void setName(String name) {
        if ((name == null || name.trim().isEmpty()) || name.length() > 15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private void setFlourType(String flourType) {
        if (!(flourType.equals("White") || flourType.equals("Wholegrain"))){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingMethod(String bakingMethod) {
        if (!(bakingMethod.equals("Crispy") || bakingMethod.equals("Chewy") || bakingMethod.equals("Homemade"))){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingMethod = bakingMethod;
    }

    private void setDoughWeight(double doughWeight) {
        if (doughWeight < 1 || doughWeight > 200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.doughWeight = doughWeight;
    }

    public List<Topping> getToppings() {
        return this.toppings;
    }

    public void addTopings(String name, double weight){
        Topping topping = new Topping(name, weight);
        this.getToppings().add(topping);
    }

    private double getDoughWeight() {
        return doughWeight;
    }

    private String getFlourType() {
        return flourType;
    }

    private String getBakingMethod() {
        return bakingMethod;
    }

    public double calculateCalories(){
        double totalCalories = 0;
        double flourCalories = 0;
        double bakingCalories = 0;
        double toppingCalories = 0;
        double allToppingCalories = 0;

        switch (this.getFlourType()){
            case "White" :
                flourCalories = 1.5;
                break;
            case "Wholegrain" :
                flourCalories = 1;
                break;
        }
        switch (this.getBakingMethod()){
            case "Crispy" :
                bakingCalories = 0.9;
                break;
            case "Chewy" :
                bakingCalories = 1.1;
                break;
            case "Homemade" :
                bakingCalories = 1;
                break;
        }
        for (Topping topping:
             this.getToppings()) {
            switch (topping.getName()){
                case "Meat" :
                    toppingCalories = 1.2;
                    break;
                case "Veggies" :
                    toppingCalories = 0.8;
                    break;
                case "Cheese" :
                    toppingCalories = 1.1;
                    break;
                case "Sauce" :
                    toppingCalories = 0.9;
                    break;
            }
            allToppingCalories += 2 * topping.getWeight() * toppingCalories;
        }
        totalCalories = 2 * this.getDoughWeight() * flourCalories * bakingCalories + allToppingCalories;
        return totalCalories;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.name, calculateCalories());
    }
}
