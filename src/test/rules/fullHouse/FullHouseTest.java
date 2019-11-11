package test.rules.fullHouse;

import card.Card;
import card.CardValueEnum;
import card.SuitEnum;
import hand.Hand;
import handEvaluator.fullHouse.FullHouse;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Full House
 * 3 cards of the hand have the same value, the 2 remaining cards form a pair.
 * They're ranked by the value of the 3 cards. Then by the value of the pairs.
 * If they differ by suit alone then they are equal.
 */
public class FullHouseTest {
    /**
     * Test for a full house hand.
     * Hand 1: Three cards of same suit
     * Hand 2: Five cards of different suit
     * Expected result: Hand 1 wins
     */
    @Test
    public void fullHouse(){
        //Build hand 1
        ArrayList<Card> hand1ArrayList = new ArrayList<Card>();
        hand1ArrayList.add(new Card(CardValueEnum.SIX, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.SIX, SuitEnum.HEARTS));
        hand1ArrayList.add(new Card(CardValueEnum.SIX, SuitEnum.CLUBS));
        hand1ArrayList.add(new Card(CardValueEnum.KING, SuitEnum.DIAMONDS));
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

        //Instantiate full house object
        FullHouse fullHouse = new FullHouse(hand1, hand2);
        //Find winner
        Hand winner = fullHouse.evaluate();
        //See if winner == expected winner
        assertEquals(winner, hand1);
    }

    /**
     * Test for a non-FullHouse hand.
     * Hand 1: Five cards of different suit
     * Hand 2: Five cards of different suit
     * Expected result: neither hand wins
     */
    @Test
    public void nonFullHouse(){
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

        //Instantiate full house object
        FullHouse fullHouse = new FullHouse(hand1, hand2);
        //Find winner
        Hand winner = fullHouse.evaluate();
        //See if winner == expected winner
        assertEquals(winner, null);
    }

    /**
     * Both hands can be a full hosue, however there will be no tie as
     * We can't have two of the same hands as we are limited to 4 suites.
     */
    @Test
    public void bothFullHouse(){

    }

    /**
     * Both hands are full house. One has a higher kicker.
     * Hand 1: Five cards of same suit. It's kicker ranks higher than hand 2's.
     * Hand 2: Five cards of same suit that isn't hand 1's
     * Expected result: Hand 1 wins
     */
    @Test
    public void kickerFullHouse(){
        //Build hand 1
        ArrayList<Card> hand1ArrayList = new ArrayList<Card>();
        hand1ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.HEARTS));
        hand1ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.CLUBS));
        hand1ArrayList.add(new Card(CardValueEnum.FIVE, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.SIX, SuitEnum.DIAMONDS));
        Hand hand1 = new Hand(hand1ArrayList, "Hand 1");

        //Build hand 2
        ArrayList<Card> hand2ArrayList = new ArrayList<Card>();
        hand2ArrayList.add(new Card(CardValueEnum.THREE, SuitEnum.HEARTS));
        hand2ArrayList.add(new Card(CardValueEnum.THREE, SuitEnum.CLUBS));
        hand2ArrayList.add(new Card(CardValueEnum.THREE, SuitEnum.SPADES));
        hand2ArrayList.add(new Card(CardValueEnum.FOUR, SuitEnum.HEARTS));
        hand2ArrayList.add(new Card(CardValueEnum.FIVE, SuitEnum.HEARTS));
        Hand hand2 = new Hand(hand2ArrayList, "Hand 2");

        //Instantiate full house object
        FullHouse fullHouse = new FullHouse(hand1, hand2);
        //Find winner
        Hand winner = fullHouse.evaluate();
        //See if winner == expected winner
        assertEquals(winner, hand2);
    }
}