package card;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * Created by Nino Bonev - 20.7.2018 г., 11:48
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Card> cardsQueue = new ArrayDeque<>();
        for (CardType cardType:
             CardType.values()) {
            for (CardRanks cardRank:
                 CardRanks.values()) {
                Card card = new Card(cardRank, cardType);
                cardsQueue.offer(card);
            }
        }

        while (cardsQueue.size() > 0){
            System.out.println(cardsQueue.poll());
        }

    }
}
