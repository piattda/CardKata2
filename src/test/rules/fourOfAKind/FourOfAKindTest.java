package test.rules.fourOfAKind;

import card.Card;
import card.CardValueEnum;
import card.SuitEnum;
import hand.Hand;

import handEvaluator.fourOfAKind.FourOfAKind;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
/**
 * Four of a kind -
 * four cards of one rank (number) one card of another rank.
 * Ranked first by the rank of its quadruplet then by the rank of its kicker.
 *  Four of a kinds that differ by suit alone are equal.
 */
public class FourOfAKindTest {
    /**
     * Test for a four of a kind hand.
     * Hand 1: Four cards of same rank (number).
     * Hand 2: Five cards that are not four of a kind.
     * Expected result: Hand 1 wins.
     */
    @Test
    public void fourOfAKind(){
        //Build hand 1
        ArrayList<Card> hand1ArrayList = new ArrayList<Card>();
        hand1ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.CLUBS));
        hand1ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.HEARTS));
        hand1ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.SPADES));
        hand1ArrayList.add(new Card(CardValueEnum.KING, SuitEnum.DIAMONDS));
        Hand hand1 = new Hand(hand1ArrayList, "Hand 1");

        //Build hand 2
        ArrayList<Card> hand2ArrayList = new ArrayList<Card>();
        hand2ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.HEARTS));
        hand2ArrayList.add(new Card(CardValueEnum.THREE, SuitEnum.CLUBS));
        hand2ArrayList.add(new Card(CardValueEnum.FOUR, SuitEnum.SPADES));
        hand2ArrayList.add(new Card(CardValueEnum.KING, SuitEnum.HEARTS));
        hand2ArrayList.add(new Card(CardValueEnum.QUEEN, SuitEnum.DIAMONDS));
        Hand hand2 = new Hand(hand2ArrayList, "Hand 2");

        //Instantiate fourOfAKind object
        FourOfAKind fourOfAKind = new FourOfAKind(hand1, hand2);
        //Find winner
        Hand winner = fourOfAKind.evaluate();
        //See if winner == expected winner
        assertEquals(winner, hand1);
    }

    /**
     * Test for a non-fourOfAKind hand.
     * Hand 1: Five cards that aren't the same ranking.
     * Hand 2: Five cards that aren't the same ranking.
     * Expected result: neither hand wins
     */
    @Test
    public void nonFourOfAKind(){
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

        //Instantiate fourOfAKind object
        FourOfAKind fourOfAKind = new FourOfAKind(hand1, hand2);
        //Find winner
        Hand winner = fourOfAKind.evaluate();
        //See if winner == expected winner
        assertEquals(winner, null);
    }

    /**
     * Both hands are Four of a kind. One hand has a higher kicker.
     * Hand 1: Four cards of the same suit. The kicker is higher than hand two's kicker.
     * Hand 2: Four cards of same suit that isn't hand 1's, and a lower kicker than hand 1's.
     * However hand 2 has a higher rank for it's four of a kind.
     * Expected result: Hand 2 wins
     */
    @Test
    public void kickerFourOfAKind(){
        //Build hand 1
        ArrayList<Card> hand1ArrayList = new ArrayList<Card>();
        hand1ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.HEARTS));
        hand1ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.CLUBS));
        hand1ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.SPADES));
        hand1ArrayList.add(new Card(CardValueEnum.SIX, SuitEnum.DIAMONDS));
        Hand hand1 = new Hand(hand1ArrayList, "Hand 1");

        //Build hand 2
        ArrayList<Card> hand2ArrayList = new ArrayList<Card>();
        hand2ArrayList.add(new Card(CardValueEnum.THREE, SuitEnum.HEARTS));
        hand2ArrayList.add(new Card(CardValueEnum.THREE, SuitEnum.DIAMONDS));
        hand2ArrayList.add(new Card(CardValueEnum.THREE, SuitEnum.CLUBS));
        hand2ArrayList.add(new Card(CardValueEnum.THREE, SuitEnum.SPADES));
        hand2ArrayList.add(new Card(CardValueEnum.FIVE, SuitEnum.HEARTS));
        Hand hand2 = new Hand(hand2ArrayList, "Hand 2");

        //Instantiate fourOfAKind object
        FourOfAKind fourOfAKind = new FourOfAKind(hand1, hand2);
        //Find winner
        Hand winner = fourOfAKind.evaluate();
        System.out.println(winner);
        //See if winner == expected winner
        assertEquals(winner, hand2);
    }
}