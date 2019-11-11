package handEvaluator.threeOfAKind;

import card.Card;
import hand.Hand;
/**
 * Three of a kind -
 *  A set of three cards of one rank and two cards of two other ranks.
 *  Ranked first by the rank of its triplet.
 *  Then by rank of highest ranking kicker and next highest ranking kicker.
 *  Two hands that differ only by suit are equal.
 */

public class ThreeOfAKind implements ThreeOfAKindInterface {
    private Hand hand1;
    private Hand hand2;

    public ThreeOfAKind(Hand hand1, Hand hand2) {
        this.hand1 = hand1;
        this.hand2 = hand2;
    }

    public Hand evaluate(){
        Hand winner = null;
        int hand1SameValueCounter = 0;
        int hand2SameValueCounter = 0;
        for(int i=1; i<5; i++){
            Card hand1i = (Card) hand1.getHand().get(i);
            Card hand1iMinusOne = (Card) hand1.getHand().get(i-1);
            Card hand2i = (Card) hand2.getHand().get(i);
            Card hand2iMinusOne = (Card) hand2.getHand().get(i-1);
            if(hand1i.enumToInt() == hand1iMinusOne.enumToInt()){
                hand1SameValueCounter ++;
            }
            if(hand2i.enumToInt() == hand2iMinusOne.enumToInt()){
                hand2SameValueCounter ++;
            }
        }
        if(hand1SameValueCounter > 2){
            //if we have more than 3 of the same card in the hand it is not a fourth!
            hand1SameValueCounter = 0;
        }
        if(hand2SameValueCounter > 2) {
            //if we have more than 3 of the same card in the hand it is not a fourth!
            hand2SameValueCounter = 0;
        }
        if(hand1SameValueCounter == 2 && hand2SameValueCounter == 2) {

            //determine which set of three's is of a higher value
            //since it is guaranteed that our decks are sorted lowest to highest we can pull the first card and compare
            Card h1 = (Card) hand1.getHand().get(0);
            Card h2 = (Card) hand2.getHand().get(0);

            if(h1.enumToInt() > h2.enumToInt()) {
                winner = hand1;
            } else if(h2.enumToInt() > h1.enumToInt()) {
                winner = hand2;
            }

        }else if(hand1SameValueCounter ==2 && hand2SameValueCounter != 2) {
            winner = hand1;
        }else if(hand2SameValueCounter == 2 && hand1SameValueCounter != 2) {
            winner = hand2;
        }
        return winner;
    }
}
