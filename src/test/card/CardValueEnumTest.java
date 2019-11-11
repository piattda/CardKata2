package test.card;

import card.Card;
import card.CardValueEnum;
import card.SuitEnum;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardValueEnumTest {

    @Test
    public void getCardValue() {
        Card c = new Card(CardValueEnum.ACE, SuitEnum.HEARTS);
        CardValueEnum expected = CardValueEnum.ACE;
        CardValueEnum actual = c.getCardValue();
        assertEquals(expected, actual);
    }
}