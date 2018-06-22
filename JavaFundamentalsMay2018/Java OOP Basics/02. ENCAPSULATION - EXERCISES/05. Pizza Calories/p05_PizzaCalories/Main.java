package p05_PizzaCalories;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 21.6.2018 г., 21:48
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Pizza> pizzas = new LinkedHashMap<>();

        try {
            String[] pizza = scanner.nextLine().split(" ");
            String pizzaName = pizza[1];
            Integer numberOfToppings = Integer.parseInt(pizza[2]);

            String[] dough = scanner.nextLine().split(" ");
            String flourType = dough[1];
            String bakingTechnique = dough[2];
            double weightInGrams = Double.parseDouble(dough[3]);
            Pizza pizza1 = new Pizza(numberOfToppings, pizzaName, flourType, bakingTechnique, weightInGrams);
            pizzas.put(pizzaName, pizza1);

            String line;
            while (!"END".equals(line = scanner.nextLine())){
                String[] toppings = line.split(" ");
                pizza1.addTopings(toppings[1], Double.parseDouble(toppings[2]));

            }

            pizzas.entrySet().stream().forEach(x -> System.out.println(x.getValue()));

        } catch (IllegalArgumentException exp){
            System.out.println(exp.getMessage());
        }
    }
}
