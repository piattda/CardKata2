package test.deck;

import card.Card;
import deck.Deck;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DeckTest {

    //Does deck return an ArrayList of cards?
    @Test
    public void deckSize() {
        Deck d = new Deck();
        ArrayList m = d.getDeck();
        int deckSize = 52;
        assertEquals(m.size(), deckSize);

    }

    /**
     * Iterate over the deck
     * If any of the cards aren't type card then
     *      flip the boolean.
     * At the end ensure that the boolean is false.
     */
    @Test
    public void arrayOfCards() {
        Deck d = new Deck();
        ArrayList m = d.getDeck();
        int deckSize = 52;
        boolean notCard = false;
        for(int i=0; i<deckSize; i++){
            if(m.get(i).getClass() != card.Card.class){
                notCard = true;
            }
        }
        assertEquals(notCard, false);

    }

    //Make sure that the returned card is in fact a card.
    @Test
    public void getCardFromDeck() {
        Deck d = new Deck();
        int randomIndex = (int) (Math.random() * 52);
        Card m = d.getCardFromDeck(randomIndex);
        assertEquals(m.getClass(), card.Card.class);
    }
}