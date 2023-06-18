package cardDeck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

// Consider a standard deck of 52 distinct cards used in poker. Assuming that the only things
// you need to know from each card are:
//      i) rank - (A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K)
//      ii) suit - (Hearts, Diamonds, Clubs, Spades)
//  a) Design two data structures/types to represent a card and a deck. Make your priority
//     that it should be easy to create algorithms and data structures around these two types,
//     without compromising (too much) mem ory or processing time.
//  b) Implement a method ‘ shuffle ’ to randomize all the cards in a deck.
//  c) Implement a method ‘ isFlush ’ that checks if all cards passed as parameters have the
//     same suit.
//  d) Implement a method ‘isStraight’ that checks if all 5 cards passed as a parameter
//     have consecutive ranks. Example:
//      i) A,5,2,3,4 is a straight
//      ii) A,5,3,4,6 is NOT a straight
//      iii) 6,7,10,9,8 is a straight
//      iv) 10,K,A,J,Q is a straight

        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        Deck deck = new Deck();
        for (String rank : ranks) {
            for (String suit : suits) {
                deck.getCardList().add(new Card(rank, suit));
            }
        }

        for (int i = 0; i < deck.getCardList().size(); i++) {
            System.out.println(deck.getCardList().get(i));
        }

        deck.shuffle();

        for (int i = 0; i < deck.getCardList().size(); i++) {
            System.out.println(deck.getCardList().get(i));
        }


        List<Card> flushCards = new ArrayList<>();
        flushCards.add(new Card("J", "Hearts"));
        flushCards.add(new Card("2", "Hearts"));
        flushCards.add(new Card("5", "Hearts"));
        flushCards.add(new Card("K", "Hearts"));

        System.out.println("Is flush: " + deck.isFlush(flushCards));


        List<Card> straightCards = new ArrayList<>();
        straightCards.add(new Card("J", "Hearts"));
        straightCards.add(new Card("10", "Clubs"));
        straightCards.add(new Card("K", "Diamonds"));
        straightCards.add(new Card("9", "Hearts"));
        straightCards.add(new Card("Q", "Spades"));

        Map<String, Integer> rankOrderMap = new HashMap<>();
        rankOrderMap.put("2", 0);
        rankOrderMap.put("3", 1);
        rankOrderMap.put("4", 2);
        rankOrderMap.put("5", 3);
        rankOrderMap.put("6", 4);
        rankOrderMap.put("7", 5);
        rankOrderMap.put("8", 6);
        rankOrderMap.put("9", 7);
        rankOrderMap.put("10", 8);
        rankOrderMap.put("J", 9);
        rankOrderMap.put("Q", 10);
        rankOrderMap.put("K", 11);
        rankOrderMap.put("A", 12);

        System.out.println("Is straight: " + deck.isStraight(straightCards, rankOrderMap));

    }


}
