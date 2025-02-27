package card;

public enum CardValueEnum {
    ZERO(0),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14);

    private int cardValue;

    private CardValueEnum(int value){
        this.cardValue = value;
    }

    public int getCardValue(){
        return cardValue;
    }

    public int getEnumInt(){
        return this.cardValue;
    }
}

