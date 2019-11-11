package hand;

import card.Card;

import java.util.ArrayList;

public interface HandInterface {
    public String getHandName();
    public ArrayList getHand();
    public String printHand();
    public void add(int index, Card c);
}
