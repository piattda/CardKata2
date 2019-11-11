package handEvaluator.twoPairs;

import card.Card;
import hand.Hand;

/**
*  Two Pairs -
 * The hand contains 2 different pairs.
 * Hands which both contain 2 pairs are ranked by the value of their highest pair.
 * Hands with the same highest pair are ranked by the value of their other pair.
 * If these values are the same the hands are ranked by the value of the remaining card.
 * **/
public class TwoPairs implements TwoPairsInterface {
    private Hand hand1;
    private Hand hand2;

    public TwoPairs(Hand hand1, Hand hand2) {
        this.hand1 = hand1;
        this.hand2 = hand2;
    }

    public Hand evaluate(){
        Hand winner = null;
        boolean hand12Pairs = false;
        boolean hand22Pairs = false;
        int h1Pair1 = 0;
        int h2Pair1 = 0;
        int h1Pair2 = 0;
        int h2Pair2 = 0;
        for(int i=1; i<5; i++) {
            Card hand1i = (Card) hand1.getHand().get(i);
            Card hand1iMinusOne = (Card) hand1.getHand().get(i-1);
            Card hand2i = (Card) hand2.getHand().get(i);
            Card hand2iMinusOne = (Card) hand2.getHand().get(i-1);
            if(hand1i.enumToInt() == hand1iMinusOne.enumToInt()) {
                if(h1Pair1 == 0) {
                    h1Pair1 = hand1i.enumToInt();
                }else if(h1Pair1 != hand1i.enumToInt()) {
                    h1Pair2 = hand1i.enumToInt();
                }
            }
            if(hand2i.enumToInt() == hand2iMinusOne.enumToInt()) {
                if(h2Pair1 == 0) {
                    h2Pair1 = hand2i.enumToInt();
                }else if(h2Pair1 != hand2i.enumToInt()){
                    h2Pair2 = hand2i.enumToInt();
                }
            }
        }
        //find winner
        //both hands have 2 suits of the same values
        boolean h1Pair1Equalh2Pair1 = h1Pair1 == h2Pair1;
        boolean h1Pair2Equalh2Pair2 = h1Pair2 == h2Pair2;
        boolean h1Pair1Equalh2Pair2 = h1Pair1 == h2Pair2;
        boolean h1Pair2Equalh1Pair1 = h1Pair2 == h2Pair1;
        if((h1Pair1Equalh2Pair1 || h1Pair2Equalh1Pair1) && (h1Pair1Equalh2Pair2 || h1Pair2Equalh2Pair2) && (h1Pair1 > 0) && (h2Pair1 > 0) && (h1Pair2 > 0) && (h2Pair2 > 0)) {

            //lone cards ( 1 1 2 2 A ) -> lone card would be A
            int h1 = 0;
            int h2 = 0;
            //find lone card
            for(int i=1; i<5; i++) {
                Card hand1i = (Card) hand1.getHand().get(i);
                Card hand2i = (Card) hand2.getHand().get(i);
                if(hand1i.enumToInt() != h1Pair1 && hand1i.enumToInt() != h1Pair2) {
                    h1 = hand1i.enumToInt();
                }
                if(hand2i.enumToInt() != h2Pair1 && hand2i.enumToInt() != h2Pair2) {
                    h2 = hand2i.enumToInt();
                }
            }
            if(h1>h2){
                winner = hand1;
            }else if(h2>h1) {
                winner = hand2;
            }else if(h2==h1) {
                int suitCount = 0;
                for(int i=1; i<5; i++) {
                    Card hand1i = (Card) hand1.getHand().get(i);
                    Card hand2i = (Card) hand2.getHand().get(i);
                    if(hand1i.getSuit() == hand2i.getSuit()) {
                        suitCount ++;
                    }
                }
                if(suitCount == 5) {
                    winner = null;
                }
            }

        }
        //One pair is same for both hand so we rank by the other pair that isn't the same with both.
        else if(((h1Pair1Equalh2Pair2 && !h1Pair2Equalh2Pair2) || (!h1Pair1Equalh2Pair1 && h1Pair2Equalh2Pair2) || (h1Pair1Equalh2Pair2 && !h1Pair2Equalh1Pair1) || (h1Pair2Equalh1Pair1 && !h1Pair1Equalh2Pair2)) && (h1Pair1 > 0) && (h2Pair1 > 0) && (h1Pair2 > 0) && (h2Pair2 > 0)) {

            if(h1Pair1 == h2Pair1) {
                if(h1Pair2 > h2Pair2) {
                    winner = hand1;
                }else if(h2Pair2 > h1Pair2) {
                    winner = hand2;
                }
            }else if(h1Pair2 == h2Pair2) {
                if(h1Pair1 > h2Pair1) {
                    winner = hand1;
                }else if(h2Pair1 > h1Pair1) {
                    winner = hand2;
                }
            }else if(h1Pair1 == h2Pair2) {
                if(h1Pair2 > h2Pair1) {
                    winner = hand1;
                }else if(h2Pair1 > h1Pair2) {
                    winner = hand2;
                }
            }else if(h1Pair2 == h2Pair1) {
                if(h1Pair1 > h2Pair2) {
                    winner = hand1;
                }else if(h2Pair2 > h1Pair1) {
                    winner = hand2;
                }
            }
        }
        else if(((h1Pair1 > 0 && h1Pair2 > 0)  && (h2Pair1 == 0 || h2Pair2 ==0)) || ((h2Pair1 > 0 && h2Pair2 > 0) && (h1Pair1 == 0 || h1Pair2 == 0)) && (h1Pair1 > 0) && (h2Pair1 > 0)) {

            if((h1Pair1 > 0 && h1Pair2 > 0)  && (h2Pair1 == 0 || h2Pair2 ==0)) {
                winner = hand1;
            }else if((h2Pair1 > 0 && h2Pair2 > 0) && (h1Pair1 == 0 || h1Pair2 == 0)){
                winner = hand2;
            }
        }

        return winner;
    }
}
