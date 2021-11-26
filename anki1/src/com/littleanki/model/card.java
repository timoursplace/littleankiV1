package com.littleanki.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class card implements thisIsACard, Serializable {
    protected String front;
    protected String back;
    protected Calendar cl;
    protected Date date;
    protected Calendar timeCardLearned;
    protected Calendar timeCardLastReviewed = Calendar.getInstance();
    protected Calendar timeCardWillReview = Calendar.getInstance();
    protected Calendar timeCardCreated = Calendar.getInstance();
    protected String cardInterval = "minute";
    protected int lastInterval;
    protected double nextInterval;
    boolean cardLearned = false;
    public card(String front, String back) {
        timeCardCreated.getTime();
        date = new Date();
        cl = Calendar.getInstance();
        cl.setTime(date);
        this.front = front;
        this.back = back;
        timeCardWillReview = timeCardCreated;
        timeCardWillReview.add(Calendar.MINUTE,30);
        lastInterval = 30;
    }
    public card() {
        timeCardCreated.getTime();
        date = new Date();
        cl = Calendar.getInstance();
        cl.setTime(date);
        this.front = "front";
        this.back = "back";
        timeCardWillReview = timeCardCreated;
        timeCardWillReview.add(Calendar.HOUR,1);
        lastInterval = 60;
    }

    @Override
    public String toString() {
        return ("Front: "+front+"\nBack: "+back+
                "\nTime card created: "+timeCardCreated+"\nObject location in memory: "+this.getClass().getName().hashCode());
    }

    public String getFront() {
        return front;
    }

    public String getBack() {
        return back;
    }

    public Date getTimeCardLastReviewed() {
        return timeCardLastReviewed.getTime();
    }

    public Date getTimeCardWillReview() {
        return timeCardWillReview.getTime();
    }

    public String getTimeCardCreated() {
        return timeCardCreated.toString();
    }

    public void changeFront(String front) {
        this.front = front;
    }
    public void changeBack(String back) {
        this.back = back;
    }
    public void good() {
        timeCardLastReviewed.setTime(Date.from(Instant.now()));
        if (lastInterval == 30) {
            nextInterval = lastInterval * 4;
            timeCardWillReview.add(Calendar.HOUR, (int) nextInterval);
        }
        else if (lastInterval > 30 && lastInterval < 10080) {
            nextInterval = lastInterval * 3;
            timeCardWillReview.add(Calendar.HOUR, Math.round(((int) nextInterval)/60));
        }
        else {
            nextInterval = lastInterval * 2;
            timeCardWillReview.add(Calendar.HOUR, Math.round(((int) nextInterval)/60));
        }
    }
    public void bad() {
        int originalHours = (int) nextInterval;
        nextInterval = lastInterval * 0.8;
        timeCardWillReview.roll(Calendar.HOUR, (int) (originalHours-nextInterval));
    }
}
