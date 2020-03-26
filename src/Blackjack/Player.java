package Blackjack;

//Player
public abstract class Player {
    public Hand hand = new Hand();

    //Check a hand for blackjack
    public boolean hasBlackjack() {
        if (this.hand.getHandValue() == 21) {
            return true;
        } else {
            return false;
        }
    }

    //Check a hand for a bust
    public boolean isBust() {
        if (this.hand.getHandValue() > 21) {
            return true;
        } else {
            return false;
        }
    }
}