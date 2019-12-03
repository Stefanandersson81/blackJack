/**
 * Created by Stefan Andersson
 * OOP kurs med Mahmud
 * Date :2019-11-23
 * Time :00:15
 * Project-Name : inlämningsuppgift 3
 */
public class Card {

    private Suit suit;
    private Rank rank;
    //public Boolean isFaceUp;

         //Constructor
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
    public String toString(){
        return this.suit.toString()+" "+this.rank.toString();
    }
    public Rank getRank(){
        return this.rank;
    }






/*
    //kolla värdet på korten hos spelaren
    public Rank getRank(){
        return this.rank;
    public int getRank(){
        return rank.getRank();
    }

    public String printRank(){
        return rank.printRank();
    }

    public void flipCard(){
        isFaceUp = !isFaceUp;
    }

    public String toString(){
        String str="";
        if (isFaceUp) {
            str+= rank.printRank() + " of" + suit.printSuit();
        }
        else {
            str= "Face down(nothing to see here)";
        }
        return str;
    }*/
}
