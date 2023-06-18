package cardDeck;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Deck {
    private List<Card> cardList = new ArrayList<>();

    public Deck() {
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public void shuffle() {
        int randomIndex;
        Card temp;
        int n = getCardList().size();
        for (int i = 0; i < n; i++) {
            randomIndex = (int) ((Math.random() * (n - i)) + i);
            temp = getCardList().get(randomIndex);
            getCardList().set(randomIndex, getCardList().get(i));
            getCardList().set(i, temp);
        }
    }

    public boolean isFlush(List<Card> cardList) {
        String firstCardSuit = cardList.get(0).getSuit();
        for (Card card : cardList) {
            if (!card.getSuit().equals(firstCardSuit)) {
                return false;
            }
        }
        return true;
    }
    public boolean isStraight(List<Card> cards, Map<String,Integer>rankOrder){
        cards.sort((a,b)->rankOrder.get(a.getRank())-rankOrder.get((b.getRank())));

//        for (int i = 0; i < cards.size(); i++) {
//            System.out.println(cards.get(i));
//        }

        if(rankOrder.get(cards.get(4).getRank())-rankOrder.get(cards.get(0).getRank())==12){
            return true;
        }
        for (int i = 0; i < 4; i++) {
            if(rankOrder.get(cards.get(i+1).getRank())!=rankOrder.get(cards.get(i).getRank())+1){
                return false;
            }
        }
        return true;
    }


}
