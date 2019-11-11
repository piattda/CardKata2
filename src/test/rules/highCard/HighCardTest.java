package test.rules.highCard;

import card.Card;
import card.CardValueEnum;
import card.SuitEnum;
import hand.Hand;
import handEvaluator.highCard.HighCard;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * High Card -
 * Hands which do not fit any higher category are ranked by the value of their highest card.
 * 	 * If the highest cards have the same value, the hands are ranked by the next highest, and so on.
 */
public class HighCardTest {
    /**
     * Test for a high card hand.
     * Hand 1: Five cards of different rankings,
     *          with the highest ranking higher than hand 2's highest ranking.
     * Hand 2: Five cards of different rankings
     * Expected result: Hand 1 wins
     */
    @Test
    public void highCard(){
        //Build hand 1
        ArrayList<Card> hand1ArrayList = new ArrayList<Card>();
        hand1ArrayList.add(new Card(CardValueEnum.KING, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.FIVE, SuitEnum.HEARTS));
        hand1ArrayList.add(new Card(CardValueEnum.FOUR, SuitEnum.CLUBS));
        hand1ArrayList.add(new Card(CardValueEnum.THREE, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.DIAMONDS));
        Hand hand1 = new Hand(hand1ArrayList, "Hand 1");

        //Build hand 2
        ArrayList<Card> hand2ArrayList = new ArrayList<Card>();
        hand2ArrayList.add(new Card(CardValueEnum.SIX, SuitEnum.HEARTS));
        hand2ArrayList.add(new Card(CardValueEnum.EIGHT, SuitEnum.CLUBS));
        hand2ArrayList.add(new Card(CardValueEnum.NINE, SuitEnum.SPADES));
        hand2ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.HEARTS));
        hand2ArrayList.add(new Card(CardValueEnum.THREE, SuitEnum.DIAMONDS));
        Hand hand2 = new Hand(hand2ArrayList, "Hand 2");

        //Instantiate flush object
        HighCard highCard = new HighCard(hand1, hand2);
        //Find winner
        Hand winner = highCard.evaluate();
        //See if winner == expected winner
        assertEquals(winner, hand1);
    }

    /**
     * Test for a non-HighCard hand.
     * High card is the last possible option.
     * Any hand can be evaluated according to high card's rules.
     * There is no test for a non high card hand.
     */
    @Test
    public void nonHighCard(){
        //N/A
    }

}