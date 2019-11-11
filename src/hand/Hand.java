package hand;

import card.Card;
import card.CardValueEnum;
import deck.Deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hand {
    private ArrayList hand = new ArrayList<Card>(5);
    private String handName = new String();

    public Hand(Deck deck, String handName){
        this.handName = handName;
        for(int i=0; i<5; i++){
            Card c = deck.getCardFromDeck((int) (Math.random() * 52));
            this.hand.add(c);
        }
        Collections.sort(this.hand, (Comparator<Card>) (o1, o2) -> {
            if(o1.enumToInt() == o2.enumToInt()){
                return ((Integer) (o1.enumToInt())).compareTo(o2.enumToInt());
            } else {
                return ((Integer) (o1.enumToInt())).compareTo(o2.enumToInt());
            }
        });
    }

    //This constructor is for testing purposes. We don't want a random hand.
    public Hand(ArrayList<Card> hand, String handName){
        this.handName = handName;
        this.hand = hand;
    }

    public String getHandName(){
        return this.handName;
    }

    public ArrayList getHand(){
        return hand;
    }

    public String printHand(){
        String toPrint = "";
        for(int i=0; i<hand.size(); i++){
            Card c = (Card) hand.get(i);
            toPrint += c.cardName();
            toPrint += "; ";
        }
        return toPrint;
    }

    public void add(int index, Card c){
        this.hand.add(index, c);
    }
}
