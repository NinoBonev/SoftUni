package card;

import java.util.Comparator;

/**
 * Created by Nino Bonev - 20.7.2018 г., 11:59
 */
public class Card implements Comparable<Card> {
    private CardType cardType;
    private CardRanks cardRanks;


    public Card(CardRanks cardRanks, CardType cardType) {
        this.cardRanks = cardRanks;
        this.cardType = cardType;
    }

    public int getCardPower() {
        return this.cardType.getPower() + this.cardRanks.getPower();
    }

    @Override
    public String toString() {
        return String.format("%s of %s", this.cardRanks.name(), this.cardType.name());
    }

    @Override
    public int compareTo(Card card) {
        return this.getCardPower() - card.getCardPower();
    }
}
