import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Stefan Andersson
 * OOP kurs med Mahmud
 * Date :2019-11-23
 * Time :11:48
 * Project-Name : inlämningsuppgift 3
 */
public class Deck{

    // intance var
    private ArrayList<Card> cards;

    //Constructor
    public Deck(){
        this.cards= new ArrayList<Card>();
    }

    public void createDeckOfCards(){
            //generate the deckOfCards //"Suit" class (hearts,spades,etc)
        for (Suit cardSuit: Suit.values()) { //use for return suits and value in my array and for 52cards.
            for (Rank cardRank: Rank.values()){//13*4=52
                    //add new card to my arraylist
                this.cards.add(new Card(cardRank, cardSuit)); //using the constructor Card
            }
        }
    }

    public void shuffle(){
        ArrayList<Card> tmpDeck=new ArrayList<Card>(); //this is the deck thats gonna be shuffled in the end

            //Use random
        Random random=new Random();
        int randomCardIndex=0;
        int orginalSize=this.cards.size();
        for (int i=0; i<orginalSize;i++){
                //Generate random cardIndex
            randomCardIndex=random.nextInt((this.cards.size()-1-0)+1)+0;
            tmpDeck.add(this.cards.get(randomCardIndex));
                //Removes a card from the orginal Deck
            this.cards.remove(randomCardIndex);
        }
        this.cards=tmpDeck;
    }

    public String toString(){
        String cardListOutPut="";
        for (Card aCard:this.cards) {
            cardListOutPut+= "\n "+aCard.toString();

        }
        return cardListOutPut;
    }
    public void removeCard(int i){
        this.cards.remove(i);
    }

    public Card getCard(int i){
        return this.cards.get(i);
    }

    public void addCard(Card addCard){
        this.cards.add(addCard);
    }
        //Picks/draws card from the deck
    public void draw(Deck comingFrom){
        this.cards.add(comingFrom.getCard(0));
        comingFrom.removeCard(0);
    }

    public void moveAllToDeck(Deck moveTo){
        int thisDeckSize = this.cards.size();

                //put card into moveToDeck
        for (int i = 0; i < thisDeckSize; i++) {
            moveTo.addCard(this.getCard(i));
        }
        for (int i = 0; i <deckSize() ; i++) {
            this.removeCard(0);
        }
    }

    public int deckSize(){
        return this.cards.size();
    }
            //return total value of the cards in deck
    public int cardsValue(){
        int totalValue=0;
        int aces=0;

        for (Card aCard:this.cards) {
            switch (aCard.getRank()){
                case DEUCE: totalValue+=2; break;
                case THREE: totalValue+=3;break;
                case FOUR: totalValue=4;break;
                case FIVE: totalValue+=5;break;
                case SIX: totalValue +=6;break;
                case SEVEN:totalValue+=7;break;
                case EIGHT: totalValue+=8;break;
                case NINE: totalValue+=9;break;
                case TEN: totalValue+=10;break;
                case JACK: totalValue+=10;break;
                case QUEEN:totalValue +=10;break;
                case KING: totalValue+=10;break;
                case ACE: aces +=1;break;
            }
        }
        for (int i = 0; i < aces; i++) {
            if (totalValue>10){
                totalValue +=1;
            }
            else {
                totalValue +=11;
            }
        }
        return totalValue;
    }
/*

     public void shuffle(){
        for (int i= cards.size() -1; i>0;i--) {
            //blanda korten från start till slut
            //man borde kunna förmiska denna kod
            int pick = rand.nextInt(i);
            Card lastCard = cards.get(i);
            Card randCard = cards.get(pick);
            cards.set(pick, lastCard);
            cards.set(i, randCard);
        }
     }

     public void deal(Hand[]hands,int perHand){
        for (int i=0; i<perHand; i++){
            for (int j = 0; j < hands.length; j++) {
                this.give(cards.get(0),hands[j]);
            }
        }
     }
     public void deal(Hand hand,int perhand){
        //delar till dealern
         for (int i = 0; i < perhand; i++) {
             this.give(cards.get(0,hand));
         }
     }
     public void flipCard(Card c){
        c.flipCard();
     }
     //dela kortleken på mitten typ?*/
}
