package com.littleanki.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class timer {
    private LocalDateTime timeNow;
    private LocalDate dateNow;
    public timer(){
        timeNow = LocalDateTime.now();
        dateNow = LocalDate.now();
    }

    @Override
    public String toString() {
        return "timer{" +
                "timeNow=" + timeNow +
                ", dateNow=" + dateNow +
                ", locationInMemory=" + this.getClass().getName().hashCode() +
                '}';
    }

    public LocalDateTime getTimeNow() {
        return timeNow;
    }
}
