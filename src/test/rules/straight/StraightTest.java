package test.rules.straight;

import card.Card;
import card.CardValueEnum;
import card.SuitEnum;
import hand.Hand;
import handEvaluator.straight.Straight;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Straight -
 * Hand contains 5 cards with consecutive values.
 * Hands which both contain a straight are ranked by their highest card.
 */
public class StraightTest {

    /**
     * Test for a straight hand.
     * Hand 1: 5 cards of consecutive values
     * Hand 2: Five cards of different suit
     * Expected result: Hand 1 wins
     */
    @Test
    public void straight(){
        //Build hand 1
        ArrayList<Card> hand1ArrayList = new ArrayList<Card>();
        hand1ArrayList.add(new Card(CardValueEnum.SIX, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.SEVEN, SuitEnum.HEARTS));
        hand1ArrayList.add(new Card(CardValueEnum.EIGHT, SuitEnum.CLUBS));
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

        //Instantiate straight object
        Straight straight = new Straight(hand1, hand2);
        //Find winner
        Hand winner = straight.evaluate();
        //See if winner == expected winner
        assertEquals(winner, hand1);
    }

    /**
     * Test for a non-Straight hand.
     * Hand 1: Five cards of different suit
     * Hand 2: Five cards of different suit
     * Expected result: neither hand wins
     */
    @Test
    public void nonStraight(){
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
        Hand hand2 = new Hand(hand2ArrayList, "Hand 2");

        //Instantiate straight object
        Straight straight = new Straight(hand1, hand2);
        //Find winner
        Hand winner = straight.evaluate();
        //See if winner == expected winner
        assertEquals(winner, null);
    }

    /**
     * Both are Straights, one hand has a higher ranking.
     * Hand 1: Five cards of the same ranking.
     * Hand 2: Five cards of the same ranking, but they rank higher than hand 1's.
     * Expected result: neither wins, tie.
     */
    @Test
    public void bothStraight(){
        //Build hand 1
        ArrayList<Card> hand1ArrayList = new ArrayList<Card>();
        hand1ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.THREE, SuitEnum.HEARTS));
        hand1ArrayList.add(new Card(CardValueEnum.FOUR, SuitEnum.CLUBS));
        hand1ArrayList.add(new Card(CardValueEnum.FIVE, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.SIX, SuitEnum.DIAMONDS));
        Hand hand1 = new Hand(hand1ArrayList, "Hand 1");

        //Build hand 2
        ArrayList<Card> hand2ArrayList = new ArrayList<Card>();
        hand2ArrayList.add(new Card(CardValueEnum.THREE, SuitEnum.HEARTS));
        hand2ArrayList.add(new Card(CardValueEnum.FOUR, SuitEnum.CLUBS));
        hand2ArrayList.add(new Card(CardValueEnum.FIVE, SuitEnum.DIAMONDS));
        hand2ArrayList.add(new Card(CardValueEnum.SIX, SuitEnum.SPADES));
        hand2ArrayList.add(new Card(CardValueEnum.SEVEN, SuitEnum.HEARTS));
        Hand hand2 = new Hand(hand2ArrayList, "Hand 2");

        //Instantiate straight object
        Straight straight = new Straight(hand1, hand2);
        //Find winner
        Hand winner = straight.evaluate();
        //See if winner == expected winner
        assertEquals(winner, hand2);
    }
}