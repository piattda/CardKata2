package test.rules.twoPairs;

import card.Card;
import card.CardValueEnum;
import card.SuitEnum;
import hand.Hand;
import handEvaluator.twoPairs.TwoPairs;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
/**
 *  Two Pairs -
 *  The hand contains 2 different pairs.
 *  Hands which both contain 2 pairs are ranked by the value of their highest pair.
 *  Hands with the same highest pair are ranked by the value of their other pair.
 *  If these values are the same the hands are ranked by the value of the remaining card.
 * **/
public class TwoPairsTest {
    /**
     * Test for a two pair hand hand.
     * Hand 1: 2 sets of cards that have the same ranking, one kicker of different rank.
     * Hand 2: Five cards of different suit and values
     * Expected result: Hand 1 wins
     */
    @Test
    public void twoPairs(){
        //Build hand 1
        ArrayList<Card> hand1ArrayList = new ArrayList<Card>();
        hand1ArrayList.add(new Card(CardValueEnum.SIX, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.SIX, SuitEnum.HEARTS));
        hand1ArrayList.add(new Card(CardValueEnum.EIGHT, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.EIGHT, SuitEnum.HEARTS));
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

        //Instantiate two pairs object
        TwoPairs straightFlush = new TwoPairs(hand1, hand2);
        //Find winner
        Hand winner = straightFlush.evaluate();
        //See if winner == expected winner
        assertEquals(hand1, winner);
    }

    /**
     * Test for a non-two pair hand.
     * Hand 1: Five cards of different suit
     * Hand 2: Five cards of different suit
     * Expected result: neither hand wins
     */
    @Test
    public void nonTwoPair(){
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

        //Instantiate two pair object
        TwoPairs straightFlush = new TwoPairs(hand1, hand2);
        //Find winner
        Hand winner = straightFlush.evaluate();
        //See if winner == expected winner
        assertEquals(winner, null);
    }

    /**
     * Both are two pairs, one hand has a higher ranking.
     * Hand 1: Two pairs of the same ranking. One kicker that's higher than H2's.
     * Hand 2: Two pairs of the same ranking. One kicker that's lower than H2's.
     * Expected result: neither wins, tie.
     */
    @Test
    public void bothTwoPairs(){
        //Build hand 1
        ArrayList<Card> hand1ArrayList = new ArrayList<Card>();
        hand1ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.HEARTS));
        hand1ArrayList.add(new Card(CardValueEnum.THREE, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.THREE, SuitEnum.HEARTS));
        hand1ArrayList.add(new Card(CardValueEnum.SIX, SuitEnum.DIAMONDS));
        Hand hand1 = new Hand(hand1ArrayList, "Hand 1");

        //Build hand 2
        ArrayList<Card> hand2ArrayList = new ArrayList<Card>();
        hand2ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.CLUBS));
        hand2ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.SPADES));
        hand2ArrayList.add(new Card(CardValueEnum.THREE, SuitEnum.CLUBS));
        hand2ArrayList.add(new Card(CardValueEnum.THREE, SuitEnum.SPADES));
        hand2ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.HEARTS));
        Hand hand2 = new Hand(hand2ArrayList, "Hand 2");

        //Instantiate two pairs object
        TwoPairs straightFlush = new TwoPairs(hand1, hand2);
        //Find winner
        Hand winner = straightFlush.evaluate();
        //See if winner == expected winner
        assertEquals(winner, hand1);
    }
}