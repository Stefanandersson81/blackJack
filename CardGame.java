import java.util.Scanner;

/**
 * Created by Stefan Andersson
 * OOP kurs med Mahmud
 * Date :2019-11-23
 * Time :00:10
 * Project-Name : inlämningsuppgift 3
 */
public class CardGame {
    public static void main(String[] args) {

        /*
         *skapa kortlek =Deck
         * Skapa klass for enskilda kort =Cards
         * Skapa Spelare
         * skapa spelar hand
         * skapar dealers hand
         * dela ut korten
         * dela 2 kort till dealern
         * visa spelarens hand
         * vänd dealerns första kort
         * visa dealerns första kort
         * gör så att ess är 1 eller 10
         * klätt kort och ess är black jack
         * dealern vinner om båda får lika mellan 17-21
         * */

        System.out.println("*********Welcome to my game of BlackJack!*********");

        //create deck
        Deck playingDeck = new Deck();
        playingDeck.createDeckOfCards();
        playingDeck.shuffle();

        //Creating a deck for the player and the dealer
        Deck playerDeck = new Deck();
        Deck dealerDeck = new Deck();

        double playerMoney = 100.00;

        Scanner userInput = new Scanner(System.in);

        //creating the gameLoop,taking bet
        while (playerMoney > 0) {
            System.out.println("You have " + playerMoney + "€ to play with, how much do you wanna bet?");
            double playerBet = userInput.nextDouble();
            if (playerBet > playerMoney) {
                System.out.println("Are you trying to fool me? Get out of my casino, NOW!!");
                break;
            }
            boolean endRound = false;

            //starts dealing, player gets 2 cards,
            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);

            dealerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);

            while (true) {
                System.out.println("Your hand: ");
                System.out.println(playerDeck.toString());
                System.out.println("Your hand is valued at: " + playerDeck.cardsValue());

                //Display the dealer hand
                System.out.println("the dealer hand is :" + dealerDeck.getCard(0).toString() +
                        "and [hidden]");

                //what wants the player to do next
                System.out.println("Would you like to (1)HIT or (2)STAND ?");
                int response = userInput.nextInt();

                //if HIT
                if (response == 1)
                {
                    playerDeck.draw(playingDeck);                                               //-1 för att få rätt indx
                    System.out.println("You draw :" + playerDeck.getCard(playerDeck.deckSize() - 1).toString());
                    if (playerDeck.cardsValue() > 21) ;
                    {
                        System.out.println("BUST, you pushed you luck to far this time" + "\n" +
                                "Your hand is : " + playerDeck.cardsValue());
                        playerMoney -= playerBet;
                        endRound = true;
                        break;
                    }
                }
                if (response == 2) {
                    break;
                }
            }

            //reveal the dealers card
            System.out.println("dealers card :" + dealerDeck.toString());

            //Dealers draw att 16 but stand at 17
            while ((dealerDeck.cardsValue() < 17) && endRound == false) {
                dealerDeck.draw(playerDeck);
                System.out.println("Dealer draws :" + dealerDeck.getCard(dealerDeck.deckSize() - 1).toString());
            }

            //Display total value for dealer
            System.out.println("the dealers hand is :" + dealerDeck.cardsValue());
            //determine if the delaer is busted
            if ((dealerDeck.cardsValue() > 21) && endRound == false) {
                System.out.println("Dealer is FAT, congrats You win!!");
                playerMoney += playerBet;
                endRound = true;
            }
            //if the game is PUSH(equals)
            if ((playerDeck.cardsValue() == dealerDeck.cardsValue())) {
                System.out.println("Push, its a tie");
                endRound = true;
            }
            if ((playerDeck.cardsValue() > dealerDeck.cardsValue())) {
                System.out.println("Congratualations, YOU WIN!!");
                playerMoney += playerBet;
                endRound = true;
            }
            //see if the dealer has more points then the player
            if ((dealerDeck.cardsValue() > playerDeck.cardsValue()) && endRound == false) {
                System.out.println("The dealers wins, you loose baby!!");
                playerMoney -= playerBet;
                endRound = true;
            }
        }

        System.out.println("Sorry, your game has ended because of insufficient funds, This game is now over!");
        userInput.close();
    }
}



