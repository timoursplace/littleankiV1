package com.littleanki.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.littleanki.model.deck;
import com.littleanki.model.card;
import com.littleanki.model.deckList;

public class editUI extends JFrame {
    private JPanel tablePanel;
    private JPanel buttonPanel;
    private JTable table;
    private JScrollPane tableScroller;
    private JButton applyBtn;
    private JButton newCardBtn;
    private JButton deleteBtn;
    private JButton exitBtn;
    private deck currentDeck;
    public editUI(deck d) {
        currentDeck = d;
        table = new JTable(new editTableModel(d.cardsToList()));
        tableScroller = new JScrollPane(table);
        tablePanel = new JPanel();
        tablePanel.add(tableScroller);
        buttonPanel = new JPanel(new GridLayout(1,4));
        newCardBtn = new JButton("New Card");
        deleteBtn = new JButton("Delete");
        applyBtn = new JButton("Apply");
        exitBtn = new JButton("Go Back");
        buttonPanel.add(newCardBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(applyBtn);
        buttonPanel.add(exitBtn);
        this.setSize(500,600);
        this.setLocationRelativeTo(null);
        this.setContentPane(new JPanel(new BorderLayout()));
        this.getContentPane().add(tablePanel, BorderLayout.CENTER);
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                deckList dl = new deckList();
                dl.editDeck(1, currentDeck);
                dl.writeDeckListFile();
                reviewUI reviews = new reviewUI();
                reviews.setCardLbl(currentDeck.currentCard(), currentDeck);
                reviews.setVisible(true);

            }
        });
        newCardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card c = new card();
                currentDeck.addToDeck(c);
                cardDetailUI creating = new cardDetailUI(c, currentDeck);
                setVisible(false);
                creating.setVisible(true);
            }
        });
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                cardDetailUI detailsUI = new cardDetailUI(currentDeck.getCard(table.getSelectedRow()), currentDeck);
                detailsUI.setVisible(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
