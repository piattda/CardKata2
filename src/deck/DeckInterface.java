package deck;

import card.Card;

import java.util.ArrayList;

public interface DeckInterface {
    public ArrayList getDeck();
    public Card getCardFromDeck(int index);
}
