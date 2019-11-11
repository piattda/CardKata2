package card;

public interface CardInterface {
    public SuitEnum getSuit();
    public void setSuit(SuitEnum suit);
    public CardValueEnum getCardValue();
    public void setCardValue(CardValueEnum cardValue);
    public String cardName();
    public int enumToInt();
}
