package handEvaluator.straight;

import card.Card;
import hand.Hand;

/**
 * Straight -
 * Hand contains 5 cards with consecutive values.
 * Hands which both contain a straight are ranked by their highest card.
 */
public class Straight implements StraightInterface {
    private Hand hand1;
    private Hand hand2;

    public Straight(Hand hand1, Hand hand2){
        this.hand1 = hand1;
        this.hand2 = hand2;
    }

    public Hand evaluate(){
        Hand winner = null;
        int hand1StraightCounter =0;
        int hand2StraightCounter =0;
        int hand1HihestValue =((Card) hand1.getHand().get(0)).enumToInt();
        int hand2HighestValue = ((Card) hand2.getHand().get(1)).enumToInt();
        //Determine if hand1 and 2 are straight
        for(int i=1; i<5; i++){
            Card hand1i = (Card) hand1.getHand().get(i);
            Card hand1iMinusOne = (Card) hand1.getHand().get(i-1);
            Card hand2i = (Card) hand2.getHand().get(i);
            Card hand2iMinusOne = (Card) hand2.getHand().get(i-1);
            //Is each hand a straight?
            if(hand1i.enumToInt() == hand1iMinusOne.enumToInt()+1){
                hand1StraightCounter ++;
            }
            if(hand2i.enumToInt() == hand2iMinusOne.enumToInt()+1){
                hand2StraightCounter ++;
            }
            //what is the highest value in each hand?
            if(hand1i.enumToInt() > hand1iMinusOne.enumToInt()){
                hand1HihestValue = hand1i.enumToInt();
            }
            if(hand2i.enumToInt() > hand2iMinusOne.enumToInt()){
                hand2HighestValue = hand2i.enumToInt();
            }
        }
        //evaluate for winner
        if(hand1StraightCounter == 4 && hand2StraightCounter ==4){
           if(hand1HihestValue > hand2HighestValue){
               winner = hand1;
           }else if(hand2HighestValue > hand1HihestValue){
               winner = hand2;
           }
        }else if(hand1StraightCounter == 4){
            winner = hand1;
        }else if(hand2StraightCounter == 4){
            winner = hand2;
        }
        return winner;
    }
}
