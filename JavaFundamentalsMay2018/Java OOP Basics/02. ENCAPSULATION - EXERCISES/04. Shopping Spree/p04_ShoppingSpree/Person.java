package p04_ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nino Bonev - 21.6.2018 г., 16:08
 */
public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public double getMoney() {
        return this.money;
    }

    public void setName(String name) {
        if (name.trim().isEmpty() || name.contains("\\W+")){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setMoney(double money) {
        if (money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void addProducts(Product product) {
        this.getProducts().add(product);
    }

    public void buyProduct(Product product){
        if (this.money >= product.getCost()){
            this.getProducts().add(product);
            this.money -= product.getCost();
            System.out.printf("%s bought %s%n", this.name, product.getName());
        } else {
            System.out.printf("%s can't afford %s%n", this.name, product.getName());
        }
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        print.append(this.name + " - ");
        int[] any = new int[]{this.getProducts().size()};
        if (any[0] > 0){
            for (Product product:
                    this.getProducts()) {
                if (any[0] > 1){
                    print.append(product.getName() + ", ");
                    any[0]--;
                } else {
                    print.append(product.getName());
                }
            }
        } else {
            print.append("Nothing bought");
        }

        return print.toString();
    }
}