package test.rules.straightFlush;

import card.Card;
import card.CardValueEnum;
import card.SuitEnum;
import hand.Hand;
import handEvaluator.straightFlush.StraightFlush;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
/**
 * Straight Flush -
 * 5 cards of the same suit with consecutive values.
 * Ranked by the highest card in the hand.
 * If they're both a flush then we rank them by the sum of the values.
 * **/
public class StraightFlushTest {
    /**
     * Test for a straight flush hand.
     * Hand 1: 5 cards of consecutive values with same suit
     * Hand 2: Five cards of different suit and values
     * Expected result: Hand 1 wins
     */
    @Test
    public void straightFlush(){
        //Build hand 1
        ArrayList<Card> hand1ArrayList = new ArrayList<Card>();
        hand1ArrayList.add(new Card(CardValueEnum.SIX, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.SEVEN, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.EIGHT, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.NINE, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.TEN, SuitEnum.DIAMONDS));
        Hand hand1 = new Hand(hand1ArrayList, "Hand 1");

        //Build hand 2
        ArrayList<Card> hand2ArrayList = new ArrayList<Card>();
        hand2ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.HEARTS));
        hand2ArrayList.add(new Card(CardValueEnum.THREE, SuitEnum.CLUBS));
        hand2ArrayList.add(new Card(CardValueEnum.FOUR, SuitEnum.SPADES));
        hand2ArrayList.add(new Card(CardValueEnum.KING, SuitEnum.HEARTS));
        hand2ArrayList.add(new Card(CardValueEnum.QUEEN, SuitEnum.DIAMONDS));
        Hand hand2 = new Hand(hand2ArrayList, "Hand 2");

        //Instantiate straight flush object
        StraightFlush straightFlush = new StraightFlush(hand1, hand2);
        //Find winner
        Hand winner = straightFlush.evaluate();
        //See if winner == expected winner
        assertEquals(winner, hand1);
    }

    /**
     * Test for a non-Straight Flush hand.
     * Hand 1: Five cards of different suit
     * Hand 2: Five cards of different suit
     * Expected result: neither hand wins
     */
    @Test
    public void nonStraightFlush(){
        //Build hand 1
        ArrayList<Card> hand1ArrayList = new ArrayList<Card>();
        hand1ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.THREE, SuitEnum.SPADES));
        hand1ArrayList.add(new Card(CardValueEnum.FOUR, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.KING, SuitEnum.CLUBS));
        hand1ArrayList.add(new Card(CardValueEnum.JACK, SuitEnum.DIAMONDS));
        Hand hand1 = new Hand(hand1ArrayList, "Hand 1");

        //Build hand 2
        ArrayList<Card> hand2ArrayList = new ArrayList<Card>();
        hand2ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.HEARTS));
        hand2ArrayList.add(new Card(CardValueEnum.THREE, SuitEnum.CLUBS));
        hand2ArrayList.add(new Card(CardValueEnum.FOUR, SuitEnum.SPADES));
        hand2ArrayList.add(new Card(CardValueEnum.KING, SuitEnum.HEARTS));
        hand2ArrayList.add(new Card(CardValueEnum.QUEEN, SuitEnum.DIAMONDS));
        Hand hand2 = new Hand(hand1ArrayList, "Hand 2");

        //Instantiate straight flush object
        StraightFlush straightFlush = new StraightFlush(hand1, hand2);
        //Find winner
        Hand winner = straightFlush.evaluate();
        //See if winner == expected winner
        assertEquals(winner, null);
    }

    /**
     * Both are Straight flushes, one hand has a higher ranking.
     * Hand 1: Five cards of the same ranking.
     * Hand 2: Five cards of the same ranking, but they rank higher than hand 1's.
     * Expected result: neither wins, tie.
     */
    @Test
    public void bothStraightFlush(){
        //Build hand 1
        ArrayList<Card> hand1ArrayList = new ArrayList<Card>();
        hand1ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.THREE, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.FOUR, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.FIVE, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.SIX, SuitEnum.DIAMONDS));
        Hand hand1 = new Hand(hand1ArrayList, "Hand 1");

        //Build hand 2
        ArrayList<Card> hand2ArrayList = new ArrayList<Card>();
        hand2ArrayList.add(new Card(CardValueEnum.THREE, SuitEnum.HEARTS));
        hand2ArrayList.add(new Card(CardValueEnum.FOUR, SuitEnum.HEARTS));
        hand2ArrayList.add(new Card(CardValueEnum.FIVE, SuitEnum.HEARTS));
        hand2ArrayList.add(new Card(CardValueEnum.SIX, SuitEnum.HEARTS));
        hand2ArrayList.add(new Card(CardValueEnum.SEVEN, SuitEnum.HEARTS));
        Hand hand2 = new Hand(hand2ArrayList, "Hand 2");

        //Instantiate straight flush object
        StraightFlush straightFlush = new StraightFlush(hand1, hand2);
        //Find winner
        Hand winner = straightFlush.evaluate();
        //See if winner == expected winner
        assertEquals(winner, hand2);
    }
}