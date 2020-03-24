package Blackjack;

import java.util.ArrayList;
import java.util.List;

//Hand
public class Hand {
    public List<Card> cards = new ArrayList<>();
    public int handValue = 0;

    public int getHandValue() {
        return this.handValue;
    }

    public int getSize() {
        return this.cards.size();
    }

    //Calculate and update hand's value
    public void setHandValue() {
        int handValue = 0;
        int numOfAces = 0;

        for (int i = 0; i < this.cards.size(); i++) {
            handValue += cards.get(i).getValue();
            if (cards.get(i).getValue() == 11) {
                numOfAces++;
            }
            //Determine whether aces (if present) should be counted as 11 or 1
            while (numOfAces > 0 && handValue > 21) {
                handValue -= 10;
                numOfAces--;
            }
        }
        this.handValue = handValue;
    }

    //Take a random card from the deck and update the hand's value
    public void hit(Deck deck) {
        this.cards.add(deck.drawCard());
        setHandValue();
    }

    //Display hand
    public void showHand() {
        for (int i = 0; i < this.cards.size(); i++) {
            System.out.println(this.cards.get(i).toString());
        }
    }
}