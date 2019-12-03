/**
 * Created by Stefan Andersson
 * OOP kurs med Mahmud
 * Date :2019-11-23
 * Time :13:07
 * Project-Name : inlämningsuppgift 3
 */
public enum Suit { //An enum is a special "class" that represents a group of constants
    // (unchangeable variables, like final variables).
    //tog detta ifrån w3schools.

    HEARTS("Hearts"),
    SPADES("Spades"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs");

    private final  String suitText;

    private Suit(String suitText){
        this.suitText= suitText;
    }
    public String printSuit(){
        return suitText;
    }
}
