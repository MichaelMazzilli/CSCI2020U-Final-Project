import java.util.*;
import Blackjack.Dealer;
import Blackjack.Deck;
import Blackjack.HumanPlayer;

public class Blackjack {
    public static void main(String[] args) {
        System.out.println("Hello, what is your name?");
        Scanner name = new Scanner(System.in);
        String playerName = name.nextLine();

        Boolean isPlaying = true;
        while (isPlaying) {
            //Initialize a new deck, the human player's hand, and the dealer's hand
            Deck deck = new Deck();
            deck.shuffle();

            HumanPlayer player = new HumanPlayer(deck, playerName);
            System.out.println("Welcome to Blackjack, " + playerName + ". The dealer hands you your cards. You have\n");
            player.hand.showHand();
            System.out.println("Your total card value is " + player.hand.getHandValue());

            Dealer dealer = new Dealer(deck);

            //Ask Player if they want to stand or hit
            System.out.println("\nWould you like to hit or stand? [Hit/Stand]");
            Scanner choice = new Scanner(System.in);
            String choiceHitStand = choice.nextLine();
            choiceHitStand = choiceHitStand.toLowerCase();

            //Player decides to hit
            while (choiceHitStand.equals("hit")) {
                player.hand.hit(deck);

                System.out.println();
                player.hand.showHand();
                System.out.println("Your new total card value is " + player.hand.getHandValue());

                //Check if player is over 21
                if (player.hand.handValue > 21) {
                    System.out.println("You went over. You lose...");
                    break;
                }

                //Check if player has drawn 5 cards without going over
                if (player.hand.handValue > 21 && player.hand.getSize() == 5) {
                    System.out.println("A five card trick! You win!");
                    break;
                }

                //Check if player has blackjack. If so, automatically stand
                if (player.hasBlackjack()) {
                    choiceHitStand = "stand";
                //Otherwise ask if they want to hit again
                } else {
                    //Player may hit as many times as they want
                    System.out.println("\nWould you like to hit or stand? [Hit/Stand]");
                    choiceHitStand = choice.nextLine();
                    choiceHitStand = choiceHitStand.toLowerCase();
                }
            }

            //Player decides to stand
            if (choiceHitStand.equals("stand")) {
                //Dealer begins hitting
                System.out.println();
                dealer.takeTurn(deck);

                //Determine who wins
                if (dealer.hand.getHandValue() > 21) {
                    System.out.println("\nDealer busted! You win!");
                } else {
                    if(player.hand.getHandValue() == dealer.hand.getHandValue()) {
                        System.out.println("You and the dealer tie. It's a push.");
                    } else if(player.hand.getHandValue() > dealer.hand.getHandValue()) {
                        System.out.println("\nYou beat the dealer! You win!");
                    } if(player.hand.getHandValue() < dealer.hand.getHandValue()) {
                        System.out.println("\nThe dealer beats you. You lose...");
                    }
                }
            }

            //Ask player if they wish to continue playing
            System.out.println("Would you like to play again? [Y/n]");
            Scanner choicePlay = new Scanner(System.in);
            String choicePlayAgain = choicePlay.nextLine();
            if (choicePlayAgain.equals("n")) {
                isPlaying = false;
            }
        }
    }
}