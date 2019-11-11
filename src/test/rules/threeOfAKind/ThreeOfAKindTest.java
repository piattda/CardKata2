package test.rules.threeOfAKind;

import card.Card;
import card.CardValueEnum;
import card.SuitEnum;
import hand.Hand;
import handEvaluator.threeOfAKind.ThreeOfAKind;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Three of a kind -
 *  A set of three cards of one rank and two cards of two other ranks.
 *  Ranked first by the rank of its triplet.
 *  Then by rank of highest ranking kicker and next highest ranking kicker.
 *  Two hands that differ only by suit are equal.
 */

public class ThreeOfAKindTest {
    /**
     * Test for a three of a kind hand.
     * Hand 1: 3 cards of the same value
     * Hand 2: Five cards of different suit and values
     * Expected result: Hand 1 wins
     */
    @Test
    public void threeOfAKind(){
        //Build hand 1
        ArrayList<Card> hand1ArrayList = new ArrayList<Card>();
        hand1ArrayList.add(new Card(CardValueEnum.SIX, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.SIX, SuitEnum.HEARTS));
        hand1ArrayList.add(new Card(CardValueEnum.SIX, SuitEnum.CLUBS));
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

        //Instantiate three of a kind object
        ThreeOfAKind threeOfAKind = new ThreeOfAKind(hand1, hand2);
        //Find winner
        Hand winner = threeOfAKind.evaluate();
        //See if winner == expected winner
        assertEquals(winner, hand1);
    }

    /**
     * Test for a non-Three of a kind hand.
     * Hand 1: Five cards of different suit
     * Hand 2: Five cards of different suit
     * Expected result: neither hand wins
     */
    @Test
    public void nonThreeOfAKind(){
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

        //Instantiate three of a kind object
        ThreeOfAKind threeOfAKind = new ThreeOfAKind(hand1, hand2);
        //Find winner
        Hand winner = threeOfAKind.evaluate();
        //See if winner == expected winner
        assertEquals(winner, null);
    }

    /**
     * Both are three of a kinds, one hand has a higher ranking.
     * Hand 1: Three cards of the same ranking with higher kickers than hand 2.
     * Hand 2: Three cards of the same ranking, with kickers that rank lower than hand 1's.
     * Expected result: neither wins, tie.
     */
    @Test
    public void bothThreeOFAKind(){
        //Build hand 1
        ArrayList<Card> hand1ArrayList = new ArrayList<Card>();
        hand1ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.ACE, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.SIX, SuitEnum.DIAMONDS));
        Hand hand1 = new Hand(hand1ArrayList, "Hand 1");

        //Build hand 2
        ArrayList<Card> hand2ArrayList = new ArrayList<Card>();
        hand2ArrayList.add(new Card(CardValueEnum.THREE, SuitEnum.HEARTS));
        hand2ArrayList.add(new Card(CardValueEnum.THREE, SuitEnum.HEARTS));
        hand2ArrayList.add(new Card(CardValueEnum.THREE, SuitEnum.HEARTS));
        hand2ArrayList.add(new Card(CardValueEnum.SIX, SuitEnum.HEARTS));
        hand2ArrayList.add(new Card(CardValueEnum.SEVEN, SuitEnum.HEARTS));
        Hand hand2 = new Hand(hand2ArrayList, "Hand 2");

        //Instantiate Three of a kind object
        ThreeOfAKind threeOfAKind = new ThreeOfAKind(hand1, hand2);
        //Find winner
        Hand winner = threeOfAKind.evaluate();
        //See if winner == expected winner
        assertEquals(winner, hand2);
    }
}