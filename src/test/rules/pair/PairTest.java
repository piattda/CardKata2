package test.rules.pair;

import card.Card;
import card.CardValueEnum;
import card.SuitEnum;
import hand.Hand;
import handEvaluator.pair.Pair;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
/**
 * Pair -
 * 2 of the 5 cards in the hand have the same value.
 * Hands which both contain a pair are ranked by the value of the cards forming the pair.
 * If these values are the same, the hands are ranked by the values of the cards not forming the pair, in decreasing order.
 */
public class PairTest {
    /**
     * Test for a pair hand.
     * Hand 1: two cards of same suit
     * Hand 2: Five cards of different suit
     * Expected result: Hand 1 wins
     */
    @Test
    public void pair(){
        //Build hand 1
        ArrayList<Card> hand1ArrayList = new ArrayList<Card>();
        hand1ArrayList.add(new Card(CardValueEnum.SIX, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.SIX, SuitEnum.HEARTS));
        hand1ArrayList.add(new Card(CardValueEnum.SEVEN, SuitEnum.CLUBS));
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

        //Instantiate pair object
        Pair pair = new Pair(hand1, hand2);
        //Find winner
        Hand winner = pair.evaluate();
        //See if winner == expected winner
        assertEquals(winner, hand1);
    }

    /**
     * Test for a non-Pair hand.
     * Hand 1: Five cards of different suit
     * Hand 2: Five cards of different suit
     * Expected result: neither hand wins
     */
    @Test
    public void nonPair(){
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

        //Instantiate pair object
        Pair pair = new Pair(hand1, hand2);
        //Find winner
        Hand winner = pair.evaluate();
        //See if winner == expected winner
        assertEquals(winner, null);
    }

    /**
     * Both are Pairs, both with 2 of the same ranking and the kickers of the same ranking.
     * Hand 1: Two cards of the same ranking and 3 kickers.
     * Hand 2: Two cards of the same ranking and 3 kickers that are the same as hand 1's kickers.
     * Expected result: neither wins, tie.
     */
    @Test
    public void bothPair(){
        //Build hand 1
        ArrayList<Card> hand1ArrayList = new ArrayList<Card>();
        hand1ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.HEARTS));
        hand1ArrayList.add(new Card(CardValueEnum.FOUR, SuitEnum.CLUBS));
        hand1ArrayList.add(new Card(CardValueEnum.FIVE, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.SIX, SuitEnum.DIAMONDS));
        Hand hand1 = new Hand(hand1ArrayList, "Hand 1");

        //Build hand 2
        ArrayList<Card> hand2ArrayList = new ArrayList<Card>();
        hand2ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.SPADES));
        hand2ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.CLUBS));
        hand2ArrayList.add(new Card(CardValueEnum.FOUR, SuitEnum.DIAMONDS));
        hand2ArrayList.add(new Card(CardValueEnum.FIVE, SuitEnum.SPADES));
        hand2ArrayList.add(new Card(CardValueEnum.SIX, SuitEnum.HEARTS));
        Hand hand2 = new Hand(hand2ArrayList, "Hand 2");

        //Instantiate pair object
        Pair pair = new Pair(hand1, hand2);
        //Find winner
        Hand winner = pair.evaluate();
        //See if winner == expected winner
        assertEquals(winner, null);
    }

    /**
     * Both hands are pairs. One has a higher kicker.
     * Hand 1: A pair with three kickers. The pair being equal to Hand 2's pair.
     *              The kicker being higher than H2's.
     * Hand 2: Five cards of same suit that isn't hand 1's. Smaller kicker than H1's.
     * Expected result: Hand 1 wins
     */
    @Test
    public void kickerPair(){
        //Build hand 1
        ArrayList<Card> hand1ArrayList = new ArrayList<Card>();
        hand1ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.HEARTS));
        hand1ArrayList.add(new Card(CardValueEnum.THREE, SuitEnum.CLUBS));
        hand1ArrayList.add(new Card(CardValueEnum.FIVE, SuitEnum.DIAMONDS));
        hand1ArrayList.add(new Card(CardValueEnum.SIX, SuitEnum.DIAMONDS));
        Hand hand1 = new Hand(hand1ArrayList, "Hand 1");

        //Build hand 2
        ArrayList<Card> hand2ArrayList = new ArrayList<Card>();
        hand2ArrayList.add(new Card(CardValueEnum.THREE, SuitEnum.HEARTS));
        hand2ArrayList.add(new Card(CardValueEnum.THREE, SuitEnum.CLUBS));
        hand2ArrayList.add(new Card(CardValueEnum.TWO, SuitEnum.SPADES));
        hand2ArrayList.add(new Card(CardValueEnum.FOUR, SuitEnum.HEARTS));
        hand2ArrayList.add(new Card(CardValueEnum.FIVE, SuitEnum.HEARTS));
        Hand hand2 = new Hand(hand2ArrayList, "Hand 2");

        //Instantiate pair object
        Pair pair = new Pair(hand1, hand2);
        //Find winner
        Hand winner = pair.evaluate();
        //See if winner == expected winner
        assertEquals(winner, hand2);
    }
}