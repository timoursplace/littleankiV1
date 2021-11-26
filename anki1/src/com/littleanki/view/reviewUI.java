package com.littleanki.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.littleanki.model.*;

public class reviewUI extends JFrame {
    private JPanel mainPanel;
    private JPanel southPanel;
    private JPanel northPanel;
    private JPanel centerPanel;
    private JLabel titleLbl;
    private JButton goodBtn;
    private JButton badBtn;
    private JButton flipBtn;
    private JButton previousBtn;
    private JButton deleteBtn;
    private JButton updateBtn;
    private JLabel cardLbl;
    private int WINDOW_WIDTH = 500;
    private int WINDOW_HEIGHT = 600;
    private deck current_Deck;
    private deckList dl = new deckList();
    private int current_deck_index = 1;
    private int cardState;
    public reviewUI() {
        this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        titleLbl = new JLabel("Review", SwingConstants.CENTER);
        titleLbl.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        cardLbl = new JLabel();
        goodBtn = new JButton("Good");
        badBtn = new JButton("Bad");
        flipBtn = new JButton("Flip");
        previousBtn = new JButton("previous");
        deleteBtn = new JButton("Delete Card");
        updateBtn = new JButton("Edit Card");
        mainPanel = new JPanel(new BorderLayout());
        southPanel = new JPanel();
        northPanel = new JPanel();
        centerPanel = new JPanel(new GridLayout(3,1));
        northPanel.add(updateBtn);
        northPanel.add(titleLbl);
        southPanel.add(previousBtn);
        centerPanel.add(cardLbl);
        southPanel.add(badBtn);
        southPanel.add(goodBtn);
        southPanel.add(flipBtn);
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        previousBtn.setVisible(false);
        goodBtn.setVisible(false);
        badBtn.setVisible(false);
        add(mainPanel);
        flipBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLbl.setText(current_Deck.flip());
                previousBtn.setVisible(true);
                cardState = 1;
                flipBtn.setVisible(false);
                goodBtn.setVisible(true);
                badBtn.setVisible(true);
            }
        });
        previousBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLbl.setText(current_Deck.previous());
                cardState = 0;
                if (cardState == 0) flipBtn.setVisible(true);
                goodBtn.setVisible(false);
                badBtn.setVisible(false);
            }
        });
        goodBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLbl.setText(current_Deck.good());
                cardState = 0;
                if (cardState == 0) flipBtn.setVisible(true);
                goodBtn.setVisible(false);
                badBtn.setVisible(false);
                deckList dl = new deckList();
                dl.editDeck(1, current_Deck);
                dl.writeDeckListFile();
            }
        });
        badBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLbl.setText(current_Deck.bad());
                cardState = 0;
                if (cardState == 0) flipBtn.setVisible(true);
                goodBtn.setVisible(false);
                badBtn.setVisible(false);
                deckList dl = new deckList();
                dl.editDeck(1, current_Deck);
                dl.writeDeckListFile();
            }
        });
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                editUI editingWindow = new editUI(current_Deck);
                editingWindow.setVisible(true);
            }
        });
    }
    public void setCardLbl(String sideofCard, deck deck) {
        cardLbl.setText(sideofCard);
        cardLbl.setFont(new Font("Serif", Font.PLAIN, 30));
        cardLbl.setHorizontalAlignment(SwingConstants.CENTER);
        current_Deck = deck;
        cardState = 0;
    }
    public void updateFile(int i, deck d) {
        deckList dl = new deckList();
        dl.editDeck(current_deck_index, current_Deck);
    }
}
