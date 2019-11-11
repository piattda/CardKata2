package handEvaluator;

import hand.Hand;

import handEvaluator.flush.Flush;
import handEvaluator.fullHouse.FullHouse;
import handEvaluator.highCard.HighCard;
import handEvaluator.pair.Pair;
import handEvaluator.straight.Straight;
import handEvaluator.straightFlush.StraightFlush;
import handEvaluator.threeOfAKind.ThreeOfAKind;
import handEvaluator.twoPairs.TwoPairs;

/**
 * HandEvaluator is called on both hands.
 * HandEvaluator tests in order of poker rules
 */
public class HandEvaluator {
    private Hand hand1;
    private Hand hand2;

    public HandEvaluator(){ }

    private void setHands(Hand hand1, Hand hand2){
        this.hand1 = hand1;
        this.hand2 = hand2;
    }

    private void unSetHands(){
        this.hand1 = null;
        this.hand2 = null;
    }

    public Hand evaluate(Hand hand1, Hand hand2){
        Hand winner = null;
        //Set hands
        setHands(hand1, hand2);
        StraightFlush straightFlush = new StraightFlush(this.hand1, this.hand2);
        if(straightFlush.evaluate() != null){
            winner = straightFlush.evaluate();
            System.out.println("Straight Flush");
        }
        //TODO How can I do this better!?
        handEvaluator.fourOfAKind.FourOfAKind fourOfAKind = new handEvaluator.fourOfAKind.FourOfAKind(this.hand1, this.hand2);
        FullHouse fullHouse = new FullHouse(this.hand1, this.hand2);
        Flush flush = new Flush(this.hand1, this.hand2);
        Straight straight = new Straight(this.hand1, this.hand2);
        ThreeOfAKind threeOfAKind = new ThreeOfAKind(this.hand1, this.hand2);
        TwoPairs twoPairs = new TwoPairs(this.hand1, this.hand2);
        Pair pair = new Pair(this.hand1, this.hand2);
        HighCard highCard = new HighCard(this.hand1, this.hand2);

        if(fourOfAKind.evaluate() != null){
            winner = fourOfAKind.evaluate();
            System.out.println("Four of a kind");
        }else if(fullHouse.evaluate() != null){
            winner = fullHouse.evaluate();
            System.out.println("Full house");
        }else if(flush.evaluate() != null){
            winner = flush.evaluate();
            System.out.println("Flush");
        }else if(straight.evaluate() != null){
            winner = straight.evaluate();
            System.out.println("Straight");
        }else if(threeOfAKind.evaluate() != null){
            winner = threeOfAKind.evaluate();
            System.out.println("Three of a kind");
        }else if(twoPairs.evaluate() != null){
            winner = twoPairs.evaluate();
            System.out.println("Two Pairs");
        }else if(pair.evaluate() != null){
            winner = pair.evaluate();
            System.out.println("Pair");
        }else if(highCard.evaluate() != null){
            winner = highCard.evaluate();
            System.out.println("High card");
        }
        return winner;
    }
}
