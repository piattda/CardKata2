package com.company;

import deck.Deck;
import hand.Hand;
import handEvaluator.HandEvaluator;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();

        Hand hand1 = new Hand(deck, "Hand 1");
        Hand hand2 = new Hand(deck, "Hand 2");
        System.out.println("Hand 1: " + hand1.printHand());
        System.out.println("Hand 2: " + hand2.printHand());
        HandEvaluator judge = new HandEvaluator();
        System.out.println(judge.evaluate(hand1, hand2).getHandName() + " wins!");
    }
}
