package com.littleanki.view;

import javax.swing.*;
import com.littleanki.model.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cardDetailUI extends JFrame {
    private int WINDOW_WIDTH = 500;
    private int WINDOW_HEIGHT = 600;
    private deck currentDeck;
    private JPanel mainPanel;
    private JPanel centerPanel;
    private JPanel southPanel;
    private JLabel frontLbl;
    private JTextArea frontTF;
    private JLabel backLbl;
    private JTextArea backTF;
    private JLabel lastReviewedLbl;
    private JLabel timeCreatedLbl;
    private JButton applyBtn;
    public cardDetailUI(card c, deck d) {
        this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        currentDeck = d;
        frontLbl = new JLabel("Front:");
        frontTF = new JTextArea(10, 10);
        frontTF.setText(c.getFront());
        frontTF.setEditable(true);
        backLbl = new JLabel("Back:");
        backTF = new JTextArea(10,10);
        backTF.setText(c.getBack());
        backTF.setEditable(true);
        lastReviewedLbl = new JLabel("Last Reviewed: "+c.getTimeCardLastReviewed());
        timeCreatedLbl = new JLabel("Time Card Created: "+c.getTimeCardCreated());
        applyBtn = new JButton("Apply");
        applyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.changeFront(frontTF.getText());
                c.changeBack(backTF.getText());
                setVisible(false);
                deckList dl = new deckList();
                dl.editDeck(1,currentDeck);
                dl.writeDeckListFile();
                editUI editing = new editUI(currentDeck);
                editing.setVisible(true);
            }
        });
        mainPanel = new JPanel(new BorderLayout());
        centerPanel = new JPanel(new GridLayout(2,2));
        centerPanel.add(frontLbl);
        centerPanel.add(frontTF);
        centerPanel.add(backLbl);
        centerPanel.add(backTF);
        southPanel = new JPanel(new GridLayout(3,1));
        southPanel.add(lastReviewedLbl);
        southPanel.add(timeCreatedLbl);
        southPanel.add(applyBtn);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        add(mainPanel);
    }
}
