package handEvaluator.flush;

import card.Card;
import hand.Hand;
import handEvaluator.fourOfAKind.FourOfAKindInterface;

/**
 * A flush is when a hand contains five cards of the same suit.
 * Hands which are both flushes are ranked using the rules for high card.
 */
public class Flush implements FlushInterface {
    private Hand hand1;
    private Hand hand2;

    public Flush(Hand hand1, Hand hand2){
        this.hand1 = hand1;
        this.hand2 = hand2;
    }

    public Hand evaluate(){
        //initialize the winner
        Hand winner = null;
        //initialize the flush counter (five of the same kind == flush)
        int hand1FlushCounter = 0;
        int hand2FlushCounter = 0;
        //initialize booleans that tell if a hand is a flush or not
        boolean hand1Flush = false;
        boolean hand2Flush = false;
        //If both hands are flush then we see which hand has the higher value
        //this is consistent with the HighCard evaluation method and will be substituted
        //with HighCard in the future. TODO substitute with high card
        int hand1Value = ((Card) (hand1.getHand().get(0))).enumToInt();
        int hand2Value = ((Card) (hand2.getHand().get(0))).enumToInt();
        /**
         * Iterate through each hand.
         * Compare hand[i] with hand[i-1]
         */
        for(int i=1; i<5; i++){
            // pull card at hand1[i]
            Card h1i = (Card)(hand1.getHand().get(i));
            // pull card at hand1[i-1]
            Card h1iMinusOne = (Card)(hand1.getHand().get(i-1));
            // pull card at hand2[i]
            Card h2i = (Card)(hand2.getHand().get(i));
            //pull card at hand2[i-1]
            Card h2iMinusOne = (Card)(hand2.getHand().get(i-1));
            //count the suits to see if there is a flush
            if(h1i.getSuit() == h1iMinusOne.getSuit()){
                hand1FlushCounter ++;
            }
            if(h2i.getSuit() == h2iMinusOne.getSuit()){
                hand2FlushCounter ++;
            }
            //Add the hand values in case we need a HighCard evaluation
            hand1Value += ((Card) (hand1.getHand().get(i))).enumToInt();
            hand2Value += ((Card) (hand2.getHand().get(i))).enumToInt();
        }
        if(hand1FlushCounter == 4){
            hand1Flush = true;
        }
        if(hand2FlushCounter == 4){
            hand2Flush = true;
        }
        if(hand1Flush && hand2Flush){
            if(hand1Value > hand2Value){
                winner = hand1;
            }else if(hand2Value > hand1Value){
                winner = hand2;
            }
        }else if(hand1Flush){
            winner = hand1;
        }else if(hand2Flush){
            winner = hand2;
        }
        return winner;
    }
}
