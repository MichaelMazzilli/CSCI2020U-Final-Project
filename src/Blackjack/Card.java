package Blackjack;

//Card
public class Card {
    private String name;
    private static String[] names = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
    private String suit;
    private static String[] suits = {"Clubs","Diamonds","Hearts","Spades"};
    private int value;

    //Contructor
    public Card(int suit, int value) {
        this.name = names[value];
        this.suit = suits[suit];
        this.value = value + 1;
    }

    //Getter for card value
    public int getValue() {
        //Face cards (11-13) are worth 10
        if (value > 10) {
            return 10;
        //Aces are worth 11 (but may change to 1 in a hand)
        } else if (value == 1) {
            return 11;
        } else {
            return this.value;
        }
    }

    //Return a string representation of card
    public String toString() {
        return (name + "Of" + suit);
    }
}