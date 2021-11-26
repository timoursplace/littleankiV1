package com.littleanki.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class cardSingleSide extends card implements thisIsACard, Serializable {
    private String text;
    protected LocalDateTime timeCardLearned;
    protected LocalDateTime timeCardLastReviewed;
    protected LocalDateTime timeCardWillReview;
    protected LocalDateTime timeCardCreated;
    protected double lastInterval;
    protected double nextInterval;
    boolean cardLearned = false;

    public cardSingleSide(String text) {
        this.text = text;
        back = null;
        timeCardCreated = LocalDateTime.now();
    }

    @Override
    public void changeFront(String front) {
        this.text = front;
    }

    @Override
    public void changeBack(String back) {
    }

    public String getFront() {
        return text;
    }

    @Override
    public String getBack() {
        return back;
    }

    @Override
    public String toString() {
        return "cardSingleSide{" +
                "text='" + text + '\'' +
                ", timeCardLearned=" + timeCardLearned +
                ", timeCardLastReviewed=" + timeCardLastReviewed +
                ", timeCardWillReview=" + timeCardWillReview +
                ", timeCardCreated=" + timeCardCreated +
                ", lastInterval=" + lastInterval +
                ", nextInterval=" + nextInterval +
                ", cardLearned=" + cardLearned +
                '}';
    }
}
