package com.littleanki.model;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class cardAudio extends card implements thisIsACard, Serializable {
    private String audioFilePath;
    private Clip clip;
    private AudioInputStream audioInputStream;
    public cardAudio(String front, String back, String audioFilePath) {
        super(front, back);
        this.audioFilePath = audioFilePath;
    }

    public String getAudioFilePath() {
        return audioFilePath;
    }

    public void playAudio() throws LineUnavailableException, IOException, UnsupportedAudioFileException, InterruptedException {
            // create AudioInputStream object
        audioInputStream = AudioSystem.getAudioInputStream(new File(audioFilePath).getAbsoluteFile());

        // create clip reference
        clip = AudioSystem.getClip();

            // open audioInputStream to the clip
        clip.open(audioInputStream);
        clip.start();
        do {
            Thread.sleep(15);
        } while (clip.isRunning());
    }

    @Override
    public String toString() {
        return "Front: "+ front + "\nBack: " + back + "\nAudio File: " + audioFilePath;
    }

    public void changeAudioFilePath(String filePath) {
        this.audioFilePath = filePath;
    }
}
