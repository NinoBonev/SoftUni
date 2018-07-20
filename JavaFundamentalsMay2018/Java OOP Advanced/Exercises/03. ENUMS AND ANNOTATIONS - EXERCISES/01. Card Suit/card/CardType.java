package card;

/**
 * Created by Nino Bonev - 20.7.2018 г., 11:49
 */
@MyAnnotation(category = "Suit", description = "Provides suit constants for a Card class.")
public enum CardType {
    CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);

    private int power;

    CardType(int power){
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
