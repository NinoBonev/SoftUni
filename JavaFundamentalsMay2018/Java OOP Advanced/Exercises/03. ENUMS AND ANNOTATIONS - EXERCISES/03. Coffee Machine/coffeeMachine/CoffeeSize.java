package coffeeMachine;

/**
 * Created by Nino Bonev - 20.7.2018 г., 13:01
 */
public enum CoffeeSize {
    SMALL(50, 50), NORMAL(100, 75), DOUBLE (200, 100);

    private int dosage;
    private int price;
    CoffeeSize(int dosage, int price) {
        this.dosage = dosage;
        this.price = price;
    }

    public int getDosage() {
        return this.dosage;
    }

    public int getPrice() {
        return this.price;
    }
}
