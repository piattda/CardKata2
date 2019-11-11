package test.card;

import card.Card;
import card.SuitEnum;
import card.CardValueEnum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CardTest {


    @Test
    public void getSuit() {
        Card c = new Card(CardValueEnum.JACK, SuitEnum.CLUBS);

        //expected result
        SuitEnum expected = SuitEnum.CLUBS;

        //card's suit
        SuitEnum actual = c.getSuit();

        assertEquals(expected, actual);
    }

    @Test
    public void setSuit() {
        //create a new card and set the suit
        Card d = new Card(CardValueEnum.JACK, SuitEnum.DIAMONDS);

        //expected suit: Diamonds
        SuitEnum expected = SuitEnum.DIAMONDS;

        //actual suit:
        SuitEnum actual = d.getSuit();

        assertEquals(expected, actual);

    }

    @Test
    public void getCardValue() {
        Card c = new Card(CardValueEnum.JACK, SuitEnum.CLUBS);

        //expected result
        CardValueEnum expected = CardValueEnum.JACK;

        //card's suit
        CardValueEnum actual = c.getCardValue();

        assertEquals(expected, actual);
    }

    @Test
    public void setCardValue() {
        Card c = new Card(CardValueEnum.QUEEN, SuitEnum.HEARTS);

        //expected result
        CardValueEnum expected = CardValueEnum.QUEEN;

        //card's suit
        CardValueEnum actual = c.getCardValue();

        assertEquals(expected, actual);
    }

    @Test
    public void cardName() {
        Card c = new Card(CardValueEnum.QUEEN, SuitEnum.HEARTS);

        String expected = "QUEEN HEARTS";

        String actual = c.cardName();

        assertEquals(expected, actual);

    }
}