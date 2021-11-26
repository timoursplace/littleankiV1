package com.littleanki.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class deck implements Serializable {
    private List<card> myDeck = new ArrayList<card>();
    private String deckName;
    public deck(String deckName) {
        this.deckName = deckName;
    }
    public deck() {
        this.deckName = "deck_name";
    }
    public void addToDeck(card card) {
        myDeck.add(card);
    }
    public int currentLocation = 0;
    public String removedCard;

    @Override
    public String toString() {
        return "deck{" +
                "location in memory=" + this.getClass().getName().hashCode() + " Deck name:" + this.deckName +
                '}';
    }

    public void printCards() {
        int cardNumber = 0;
        for (card item: myDeck) {
            cardNumber++;
            System.out.println(cardNumber + ".\n  Front: " + item.getFront() + "\n Back: " + item.getBack());
        }
    }
    public ArrayList<card> cardsToList() {
        ArrayList<card> someCards = new ArrayList<card>();
        for (card thing: myDeck) {
            someCards.add(thing);
        }
        return someCards;
    }
    public String currentCard() {
        return String.valueOf(myDeck.get(currentLocation).getFront());
    }

    public String nextCard() {
        if (currentLocation<myDeck.size()){currentLocation++;}
        return String.valueOf(myDeck.get(currentLocation).getFront());
    }
    public String flip() {
        return String.valueOf(myDeck.get(currentLocation).getBack());
    }
    public String good() {
        myDeck.get(currentLocation).good();
        return nextCard();
    }
    public String bad() {
        myDeck.get(currentLocation).bad();
        return nextCard();
    }
    public String previous() {
        if (currentLocation == 0) {
            currentLocation= myDeck.size();
        } else if (currentLocation == myDeck.size()) {
            currentLocation = 0;
        } else {
            currentLocation--;
        }
        return myDeck.get(currentLocation).getFront();
    }
    public void deleteCard(int i) {
        removedCard = myDeck.get(i).toString();
        myDeck.remove(i);
    }
    public card getCard(int i) {
        return myDeck.get(i);
    }

    public void setDeckName(String name) {
        deckName = name;
    }

    public String getDeckName() {
        return deckName;
    }
}