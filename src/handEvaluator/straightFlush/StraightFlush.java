package handEvaluator.straightFlush;

import card.Card;
import hand.Hand;

/**
 * Straight Flush -
 * 5 cards of the same suit with consecutive values.
 * Ranked by the highest card in the hand.
 * If they're both a flush then we rank them by the sum of the mapNum(card number) values.
 * **/
public class StraightFlush implements StraightFlushInterface {
    private Hand hand1;
    private Hand hand2;

    public StraightFlush(Hand hand1, Hand hand2){
        this.hand1 = hand1;
        this.hand2 = hand2;
    }

    public Hand evaluate(){
        Hand winner = null;
        int hand1StraightFlush = 0;
        int hand1NumRanking = 0;
        int hand2StraightFlush = 0;
        int hand2NumRanking = 0;
        //test if white hand has all cards of the same suit
        //we're also adding the values of the number's of each hand (according to the mapNum(card number) value
        //in case each hand is a flush to determine the winner
        for(int i=1; i<5; i++) {
            Card hand1i = (Card) this.hand1.getHand().get(i);
            Card hand1iMinusOne = (Card) this.hand1.getHand().get(i-1);
            Card hand2i = (Card) this.hand2.getHand().get(i);
            Card hand2iMinusOne = (Card) this.hand2.getHand().get(i-1);
            if(hand1i.getSuit() == hand1iMinusOne.getSuit()){
                if(hand1i.enumToInt() == hand1iMinusOne.enumToInt()+1) {
                    hand1StraightFlush ++;
                    if(hand1NumRanking == 0) {
                        hand1NumRanking += hand1iMinusOne.enumToInt();
                    }
                    hand1NumRanking += hand1i.enumToInt();

                }
            }
            if(hand2i.getSuit() == hand2iMinusOne.getSuit()){
                if(hand2i.enumToInt() == hand2iMinusOne.enumToInt()+1) {
                    hand2StraightFlush ++;
                    if(hand2NumRanking == 0) {
                        hand2NumRanking += hand2iMinusOne.enumToInt();
                    }
                    hand2NumRanking += hand1i.enumToInt();
                }
            }
        }
        //if both are straight flushes, then we need to see which hand has a higher card value
        //	else there is no winner
        if(hand1StraightFlush == 4 && hand2StraightFlush == 4) {
            if(hand1NumRanking > hand2NumRanking) {
                winner = this.hand1;
            }else if(hand2NumRanking > hand1NumRanking) {
                winner = this.hand2;
            }
        }else if(hand1StraightFlush == 4) {
            winner = this.hand1;
        } else if(hand2StraightFlush == 4) {
            winner = this.hand2;
        }
        return winner;
    }
}
