package handEvaluator.highCard;

import card.Card;
import hand.Hand;

/**
 * High Card -
 * Hands which do not fit any higher category are ranked by the value of their highest card.
 * 	 * If the highest cards have the same value, the hands are ranked by the next highest, and so on.
 */
public class HighCard implements HighCardInterface {
    private Hand hand1;
    private Hand hand2;

    public HighCard(Hand hand1, Hand hand2){
        this.hand1 = hand1;
        this.hand2 = hand2;
    }

    public Hand evaluate(){
        //Initialize winner hand to null
        Hand winner = null;
        //Initialize the rankings for hand1
        int hand1highest = 0;
        int hand1Second = 0;
        int hand1Third = 0;
        int hand1Fourth = 0;
        int hand1Fifth = 0;
        //initialize the rankings for hand2
        int hand2Highest = 0;
        int hand2Second = 0;
        int hand2Third = 0;
        int hand2Fourth = 0;
        int hand2Fifth = 0;
        //Iterate through hand and assign rankings
        for(int i=0; i<5; i++) {
            Card hand1i = (Card) hand1.getHand().get(i);
            Card hand2i = (Card) hand2.getHand().get(i);
            //determine hand 1's values
            if(hand1i.enumToInt() > hand1highest) {
                hand1highest = hand1i.enumToInt();
            }
            else if(hand1i.enumToInt() > hand1Second) {
                hand1Second = hand1i.enumToInt();
            }

            else if(hand1i.enumToInt() > hand1Third) {
                hand1Third = hand1i.enumToInt();
            }

            else if(hand1i.enumToInt() > hand1Fourth) {
                hand1Fourth = hand1i.enumToInt();
            }

            else if(hand1i.enumToInt() > hand1Fifth) {
                hand1Fifth = hand1Fifth;
            }
            //determine hand 2's values
            if(hand2i.enumToInt() > hand2Highest) {
                hand2Highest = hand2i.enumToInt();
            }
            else if(hand2i.enumToInt() > hand2Second) {
                hand2Second = hand2i.enumToInt();
            }
            else if(hand2i.enumToInt() > hand2Third) {
                hand2Third = hand2i.enumToInt();
            }
            else if(hand2i.enumToInt() > hand2Fourth) {
                hand2Fourth = hand2i.enumToInt();
            }
            else if(hand2i.enumToInt() > hand2Fifth) {
                hand2Fifth = hand2i.enumToInt();
            }
        }
        //determine the high card winner
        System.out.println("hand1highest > hand2Highest" + (hand1highest > hand2Highest));
        if(hand1highest > hand2Highest) {
            winner = hand1;
        }else if(hand2Highest > hand1highest) {
            winner = hand2;
        }else if(hand1Second > hand2Second) {
            winner = hand1;
        }else if(hand2Second > hand1Second) {
            winner = hand2;
        }else if(hand1Third > hand2Third) {
            winner = hand1;
        }else if(hand2Third > hand1Third) {
            winner = hand2;
        }else if(hand1Fourth > hand2Fourth) {
            winner = hand1;
        }else if(hand2Fourth > hand1Fourth) {
            winner = hand2;
        }else if(hand1Fifth > hand2Fifth) {
            winner = hand1;
        }else if(hand2Fifth > hand1Fifth) {
            winner = hand2;
        }
        //return winner
        return winner;
    }
}
