package coffeeMachine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nino Bonev - 20.7.2018 г., 13:00
 */
public class CoffeeMachine {
    private List<Coffee> coffees;
    private List<Coin> coins;

    public CoffeeMachine() {
        this.coffees = new ArrayList<>();
        this.coins = new ArrayList<>();
    }

    public void buyCoffee(String size, String type){
        Coffee coffee = new Coffee(size, type);
        int totalCoins = this.coins.stream().mapToInt(Coin::getCoin).sum();
        if (totalCoins > coffee.getPrice()){
            this.coffees.add(coffee);
            this.coins.clear();
        }
    }

    public void insertCoin(String coin){
        this.coins.add(Coin.valueOf(coin.toUpperCase()));
    }

    public Iterable<Coffee> coffeesSold() {
        return this.coffees;
    }
}
