package deck;

import card.Card;
import card.CardValueEnum;
import card.SuitEnum;

import java.util.ArrayList;
import java.util.Collections;

public class Deck implements DeckInterface {
    private ArrayList deck;

    public Deck(){
        this.deck = new ArrayList<Card>();
        for(int i=1; i<14; i++){
            CardValueEnum value = CardValueEnum.values()[i];
            for(int j=0; j<4; j++){
                Card card = new Card(value, SuitEnum.values()[j]);
                this.deck.add(card);
            }
        }
        Collections.shuffle(deck);
    }

    public ArrayList getDeck(){
        return this.deck;
    }

    //TODO use this instead of the weird (Card) thing
    public Card getCardFromDeck(int index){
        return (Card) this.deck.get(index);
    }
}
