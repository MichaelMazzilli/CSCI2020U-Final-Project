package Blackjack;

//Dealer
public class Dealer extends Player {
    //Constructor
    public Dealer(Deck deck) {
        //Dealer draws two cards, and shows the first
        hand.hit(deck);
        hand.hit(deck);
        System.out.println("Dealer's showing " + hand.cards.get(0).toString());
    }

    //Dealer begins to take turn, either hitting or standing
    public void takeTurn(Deck deck) {
        //Dealer must hit if under 17 in hand value
        while(hand.getHandValue() < 17) {
            System.out.println("The dealer hits.");
            hand.hit(deck);

            //Check if busted after hitting
            if(isBust()) {
                break;
            }
        }
    System.out.print("The dealer stands. They have\n");
    this.hand.showHand();
    System.out.println("The dealer's hand's total value is " + this.hand.getHandValue());
    }
}