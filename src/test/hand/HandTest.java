package test.hand;

import card.Card;
import deck.Deck;
import hand.Hand;
import org.junit.Test;

import java.util.ArrayList;

import static javax.swing.UIManager.get;
import static org.junit.Assert.*;

public class HandTest {

    //ensure that the hand has the name we give it
    @Test
    public void getHandName() {
        Deck d = new Deck();
        Hand h = new Hand(d, "White Hand");
        String expectedName = "White Hand";
        String actualName = h.getHandName();
        assertEquals(expectedName, actualName);

    }

    //ensure the hand is 5 cards long
    @Test
    public void handLength() {
        Deck d = new Deck();
        Hand h = new Hand(d, "White Hand");
        int expectedLength = 5;
        int actualLength = h.getHand().size();
        assertEquals(expectedLength, actualLength);
    }

    //ensure that the hand is made of cards
    @Test
    public void handIsCards() {
        Deck d = new Deck();
        Hand h = new Hand(d, "White Hand");
        ArrayList<Card> hand = h.getHand();
        boolean notCard = false;
        for(int i=0; i<5; i++){
            if(hand.get(i).getClass() != card.Card.class){
                notCard = true;
            }
        }
        assertEquals(notCard, false);
    }

}