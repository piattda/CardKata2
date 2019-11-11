package handEvaluator.pair;

import card.Card;
import card.CardValueEnum;
import card.SuitEnum;
import hand.Hand;

/**
 * Pair -
 * 2 of the 5 cards in the hand have the same value.
 * Hands which both contain a pair are ranked by the value of the cards forming the pair.
 * If these values are the same, the hands are ranked by the values of the cards not forming the pair, in decreasing order.
 */

public class Pair implements PairInterface {
    private Hand hand1;
    private Hand hand2;

    public Pair(Hand hand1, Hand hand2){
        this.hand1 = hand1;
        this.hand2 = hand2;
    }

    public Hand evaluate(){
        //Initialize the hand
        Hand winner = null;
        //Initialize highest pair cards
        Card hand1Pair = new Card(CardValueEnum.ZERO, SuitEnum.HEARTS);
        Card hand2Pair = new Card(CardValueEnum.ZERO, SuitEnum.HEARTS);
        // Initialize kickers
        int hand1HighestKicker = 0;
        int hand1SecondKicker = 0;
        int hand1ThirdKicker = 0;
        int hand2HighestKicker = 0;
        int hand2SecondKicker = 0;
        int hand2ThirdKicker = 0;
        //find pairs by seeing if card[i] is the same number as card[i-1]
        for(int i=1; i<5; i++){
            Card hand1i = (Card) hand1.getHand().get(i);
            Card hand1iMinusOne = (Card) hand1.getHand().get(i-1);
            Card hand2i = (Card) hand2.getHand().get(i);
            Card hand2iMinusOne = (Card) hand2.getHand().get(i-1);
            if(hand1i.enumToInt() == hand1iMinusOne.enumToInt()){
                hand1Pair = hand1i;
            }
            if(hand2i.enumToInt() == hand2iMinusOne.enumToInt()){
                hand2Pair = hand2i;
            }
        }
        //Find the kickers in case they are both are pairs
        if(hand1Pair.enumToInt() != 0 && hand2Pair.enumToInt() != 0){
            for(int i=0; i<5; i++){
                Card hand1i = (Card) hand1.getHand().get(i);
                Card hand2i = (Card) hand2.getHand().get(i);
                //Hand 1:
                if(hand1i.enumToInt() != hand1Pair.enumToInt() && hand1i.enumToInt() > hand1HighestKicker){
                    hand1HighestKicker = hand1i.enumToInt();
                }
                if(hand1i.enumToInt() > hand1SecondKicker && hand1i.enumToInt() < hand1HighestKicker){
                    hand1SecondKicker = hand1i.enumToInt();
                }
                if(hand1i.enumToInt() > hand1ThirdKicker && hand1i.enumToInt() < hand1SecondKicker && hand1i.enumToInt() < hand1HighestKicker){
                    hand1ThirdKicker = hand1i.enumToInt();
                }
                //Hand 2:
                if(hand2i.enumToInt() != hand2Pair.enumToInt() && hand2i.enumToInt() > hand2HighestKicker){
                    hand2HighestKicker = hand2i.enumToInt();
                }
                if(hand2i.enumToInt() > hand2SecondKicker && hand2i.enumToInt() < hand2HighestKicker){
                    hand2SecondKicker = hand2i.enumToInt();
                }
                if(hand2i.enumToInt() > hand2ThirdKicker && hand2i.enumToInt() < hand2SecondKicker && hand2i.enumToInt() < hand2HighestKicker){
                    hand2ThirdKicker = hand2i.enumToInt();
                }
            }
        }

        if (hand1Pair.enumToInt() > hand2Pair.enumToInt()) {
            winner = hand1;
        }else if(hand2Pair.enumToInt() > hand1Pair.enumToInt()){
            winner = hand2;
        }else if(hand1HighestKicker > hand2HighestKicker){
            winner = hand1;
        }else if(hand2HighestKicker > hand1HighestKicker){
            winner = hand2;
        }else if(hand1SecondKicker > hand2SecondKicker){
            winner = hand1;
        }else if(hand2SecondKicker > hand1SecondKicker){
            winner = hand2;
        }else if(hand1ThirdKicker > hand2ThirdKicker){
            winner = hand1;
        }else if(hand2ThirdKicker > hand1ThirdKicker){
            winner = hand2;
        }
        return winner;
    }

}
