package handEvaluator.fullHouse;

import card.Card;
import hand.Hand;

/**
 * Full House
 * 3 cards of the hand have the same value, the 2 remaining cards form a pair.
 * They're ranked by the value of the 3 cards. Then by the value of the pairs.
 * If they differ by suit alone then they are equal.
 * TODO can I combine for loops?
 */
public class FullHouse implements FullHouseInterface {
    private Hand hand1;
    private Hand hand2;

    public FullHouse(Hand hand1, Hand hand2){
        this.hand1 = hand1;
        this.hand2 = hand2;
    }

    public Hand evaluate(){
        Hand winner = null;
        int hand1FirstRank = 0;
        int hand1SecondRank = 0;
        int hand2FirstRank = 0;
        int hand2SecondRank = 0;
        //determine the first ranks
        for(int i=0; i<3; i++){
            Card hand1i = (Card) hand1.getHand().get(i);
            Card hand2i = (Card) hand2.getHand().get(i);
            int hand1CardCount = 0;
            int hand2CardCount = 0;
            for(int k=0; k<5; k++){
                Card hand1k = (Card) hand1.getHand().get(k);
                Card hand2k = (Card) hand2.getHand().get(k);
                if(hand1k.enumToInt() == hand1i.enumToInt()){
                    hand1CardCount ++;
                }
                if(hand2k.enumToInt() == hand2i.enumToInt()){
                    hand2CardCount ++;
                }
                if(hand1CardCount == 3){
                    hand1FirstRank = hand1i.enumToInt();
                }
                if(hand2CardCount == 3){
                    hand2FirstRank = hand2i.enumToInt();
                }
            }
        }
        //determine our second ranks
        for(int i=0; i<5; i++){
            Card hand1i = (Card) hand1.getHand().get(i);
            Card hand2i = (Card) hand2.getHand().get(i);
            int hand1CardCount = 0;
            int hand2CardCount = 0;
            if(hand1i.enumToInt() == hand2i.enumToInt() && (hand1i.enumToInt() != hand1FirstRank)){
                hand1CardCount ++;
            }
            if(hand2i.enumToInt() == hand2i.enumToInt() && (hand2i.enumToInt() != hand2FirstRank)){
                hand2CardCount ++;
            }
            if(hand1CardCount == 2){
                hand1SecondRank = hand1i.enumToInt();
            }
            if(hand2CardCount == 2){
                hand2SecondRank = hand2i.enumToInt();
            }
        }
        //Determine the winner
        int hand1Score = hand1FirstRank * 3;
        hand1Score += hand1SecondRank * 2;
        int hand2Score = hand2FirstRank * 3;
        hand2Score += hand2SecondRank * 2;
        if(hand1Score > hand2Score && hand1FirstRank != 0){
            winner = this.hand1;
        }else if(hand2Score > hand1Score && hand2FirstRank != 0){
            winner = this.hand2;
        }
        return winner;
    }
}
