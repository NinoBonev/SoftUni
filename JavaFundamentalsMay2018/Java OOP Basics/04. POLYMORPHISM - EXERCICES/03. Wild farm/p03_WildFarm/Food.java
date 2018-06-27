package p03_WildFarm;

/**
 * Created by Nino Bonev - 26.6.2018 г., 10:27
 */
public abstract class Food {
    private Integer quantity;

    public Food(Integer quantity) {
        this.quantity = quantity;
    }

    protected Integer getQuantity() {
        return quantity;
    }
}
