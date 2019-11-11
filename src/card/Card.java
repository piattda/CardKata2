package card;

public class Card implements CardInterface {
    private SuitEnum suit;
    private CardValueEnum cardValue;

    public Card(CardValueEnum cardValue, SuitEnum suit){
        this.cardValue = cardValue;
        this.suit = suit;
    }

    public SuitEnum getSuit(){
        return suit;
    }

    public void setSuit(SuitEnum suit){
        this.suit = suit;
    }

    public CardValueEnum getCardValue(){
        return cardValue;
    }

    public void setCardValue(CardValueEnum cardValue){
        this.cardValue = cardValue;
    }

    public String cardName(){
        return getCardValue().toString() + " " + getSuit();
    }

    public int enumToInt(){
        int toReturn = cardValue.getEnumInt();
        return toReturn;
    }
}

