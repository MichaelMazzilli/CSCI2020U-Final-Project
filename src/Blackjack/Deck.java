package Blackjack;
import java.util.ArrayList;
import java.util.Collections;

//Deck
public class Deck {
    private ArrayList<Card> deck = new ArrayList<Card>();
    //Constructor
    //Create deck of 52 cards (4 suites, 13 cards)
    public Deck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                this.deck.add(new Card(i, j));
            }
        }
    }

    //Randomize order of cards in deck
    public void shuffle() {
        Collections.shuffle(deck);
    }

    //Draw and remove a card from the deck
    public Card drawCard() {
        return this.deck.remove(0);
    }
}