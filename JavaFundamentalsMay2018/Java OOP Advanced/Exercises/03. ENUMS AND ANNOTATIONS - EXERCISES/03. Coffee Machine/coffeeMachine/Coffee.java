package coffeeMachine;

/**
 * Created by Nino Bonev - 20.7.2018 г., 13:10
 */
public class Coffee {
    private CoffeeSize size;
    private CoffeeType type;

    public Coffee(String size, String type) {
        this.size = CoffeeSize.valueOf(size.toUpperCase());
        this.type = CoffeeType.valueOf(type.toUpperCase());
    }

    public int getPrice(){
        return this.size.getPrice();
    }
}
