package com.littleanki.control;

import com.littleanki.model.card;
import com.littleanki.model.cardAudio;
import com.littleanki.model.cardSingleSide;
import com.littleanki.model.deck;
import com.littleanki.view.reviewUI;
import com.littleanki.model.deckList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;

public class CardCntl {
    public deck netflixWords;
    public card Shinu;
    public cardAudio Oishii;
    public cardSingleSide Intro;
    public CardCntl() {
//        Shinu = new card("死ぬ","to die");
//        Oishii = new cardAudio("美味しい", "delicious", "D:\\programming\\anki1\\Oishii.wav");
//        Intro = new cardSingleSide("DO EVERY DAY");
//        netflixWords = new deck("Words from Netflix");
//        netflixWords.addToDeck(Shinu);
//        netflixWords.addToDeck(Oishii);
//        netflixWords.addToDeck(Intro);
//        netflixWords.printCards();
        deckList dl = new deckList();
        dl.printDeckList();
        dl.writeDeckListFile();
        reviewUI reviews = new reviewUI();
        reviews.setCardLbl(dl.getDeck(0).currentCard(), dl.getDeck(0));
        reviews.setVisible(true);
    }
}
