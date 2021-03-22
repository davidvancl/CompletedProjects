package com.projectAirlines.Tools;

import javax.sound.sampled.*;
import java.io.File;
import java.util.Objects;

public class MusicThread extends Thread {
    private String url = ProjectPath.getMusicPath("invisible.wav");
    private FloatControl floatControl;
    private float actualVolume = -10.0f;

    public void run() {
        try {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(url));
            Clip clip = AudioSystem.getClip();
            clip.open(inputStream);
            this.floatControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            this.floatControl.setValue(Float.parseFloat(Objects.requireNonNull(ConfigFile.loadData("musicVolume"))));
            clip.addLineListener(e -> {
                if (e.getType() == LineEvent.Type.STOP) {
                    //TODO: after and music

                }
            });
            clip.start();
        } catch (Exception ignored) {}
    }

    public void setVolume(float volume){
        this.floatControl.setValue(volume);
        actualVolume = volume;
    }

    public float getMinimumVolume(){
        return (int)this.floatControl.getMinimum();
    }

    public float getMaximumVolume(){
        return (int)this.floatControl.getMaximum();
    }

    public float getActualVolume(){
        return this.actualVolume;
    }
}
