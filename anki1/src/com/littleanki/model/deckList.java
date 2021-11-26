package com.littleanki.model;

import java.io.*;
import java.util.ArrayList;

public class deckList {
    private ArrayList<deck> listOfDecks = new ArrayList<>();
    private String listOfDecksFileName = "deckList.ser";
    public deckList() {
        this.readDeckListFile();
        if (listOfDecks.isEmpty() || listOfDecks == null) {
            this.createDeckList();
            this.writeDeckListFile();
            this.readDeckListFile();
        }
        this.printDeckList();
    }
    public void readDeckListFile() {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(listOfDecksFileName);
            in = new ObjectInputStream(fis);
            listOfDecks = (ArrayList<deck>) in.readObject();
            in.close();
            if (!listOfDecks.isEmpty()) {
                System.out.println("There are decks in the deck list");
            }
        } catch (FileNotFoundException fne) {
            System.out.println("File was not found, a new one will be created");
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void createDeckList() {
        deck exampleDeck = new deck();
        card exampleCard = new card("Example Card Front", "Example Card Back");
        exampleDeck.addToDeck(exampleCard);
        listOfDecks.add(exampleDeck);
        System.out.println(listOfDecks);
    }

    public void writeDeckListFile() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(listOfDecksFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(listOfDecks);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void printDeckList() {
        System.out.println("The listOfDecks has these decks:");
        for (int i = 0; i < listOfDecks.size(); i++) {
            System.out.println("Deck " + i +".");
            deck current_deck = listOfDecks.get(i);
            current_deck.printCards();
        }
    }

    public void addDeck (deck d) {
        listOfDecks.add(d);
    }

    public void removeDeck (int i) {
        listOfDecks.remove(i);
    }

    public void editDeck (int i, deck d) {
        listOfDecks.set(i, d);
    }
    public deck getDeck (int i) {
        return listOfDecks.get(i);
    }
    public int deckCount() {
        return listOfDecks.size();
    }
}
