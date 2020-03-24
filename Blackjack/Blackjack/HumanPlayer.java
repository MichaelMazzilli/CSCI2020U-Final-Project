package Blackjack;

//Dealer
public class HumanPlayer extends Player {
    String name = "Player";
    //Constructor
    public HumanPlayer(Deck deck, String name) {
        hand.hit(deck);
        hand.hit(deck);
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
    System.out.print("The dealer stands.");
    }
}