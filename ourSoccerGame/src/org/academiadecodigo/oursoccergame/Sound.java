package org.academiadecodigo.oursoccergame;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Sound extends SuperSound{

    //variables
    private Clip clip0;
    private Clip clip1;
    private Clip clip2;
    private Clip clip3;

    public Sound() throws MalformedURLException {

    }

    //methode setfile define the next sound to play passing the position of the array of sounds
    public void setFile0() {
        try {

            InputStream inputStreams0 = getClass().getResourceAsStream("/sound/generalmusic.wav");
            BufferedInputStream bufferedIn0 = new BufferedInputStream(inputStreams0);

            AudioInputStream ais = AudioSystem.getAudioInputStream(bufferedIn0);
            clip0 = AudioSystem.getClip();
            clip0.open(ais);
        } catch (Exception e) {
            e.printStackTrace(); // Print the error for debugging purposes
        }
    }

    //Methode to play the sound choosed in setFile
    public void play0() {
        clip0.start();
        }


    //methode to loop the sound file choosed in setFile
    public void loop0() {
        clip0.loop(Clip.LOOP_CONTINUOUSLY);
        }


    //methode to stop the sound in setFile
    public void stop0() {
        clip0.stop();
        }





    //methode setfile define the next sound to play passing the position of the array of sounds
    public void setFile1() {
        try {


            InputStream inputStreams1 = getClass().getResourceAsStream("/sound/goalsound.wav");
            BufferedInputStream bufferedIn1 = new BufferedInputStream(inputStreams1);

            AudioInputStream ais = AudioSystem.getAudioInputStream(bufferedIn1);
            clip1 = AudioSystem.getClip();
            clip1.open(ais);
        } catch (Exception e) {
            e.printStackTrace(); // Print the error for debugging purposes
        }
    }

    //Methode to play the sound choosed in setFile
    public void play1() {
        clip1.start();
    }


    //methode to loop the sound file choosed in setFile
    public void loop1() {
        clip1.loop(Clip.LOOP_CONTINUOUSLY);
    }


    //methode to stop the sound in setFile
    public void stop1() {
        clip1.stop();
    }





    public void setFile2() {
        try {

            InputStream inputStreams2 = getClass().getResourceAsStream("/sound/kicksound.wav");
            BufferedInputStream bufferedIn2 = new BufferedInputStream(inputStreams2);

            AudioInputStream ais = AudioSystem.getAudioInputStream(bufferedIn2);
            clip2 = AudioSystem.getClip();
            clip2.open(ais);
        } catch (Exception e) {
            e.printStackTrace(); // Print the error for debugging purposes
        }
    }

    //Methode to play the sound choosed in setFile
    public void play2() {
        clip2.start();
    }


    //methode to loop the sound file choosed in setFile
    public void loop2() {
        clip2.loop(Clip.LOOP_CONTINUOUSLY);
    }


    //methode to stop the sound in setFile
    public void stop2() {
        clip2.stop();
    }





    public void setFile3() {
        try {

            InputStream inputStreams3 = getClass().getResourceAsStream("/sound/savedgoal.wav");
            BufferedInputStream bufferedIn3 = new BufferedInputStream(inputStreams3);

            AudioInputStream ais = AudioSystem.getAudioInputStream(bufferedIn3);
            clip3 = AudioSystem.getClip();
            clip3.open(ais);
        } catch (Exception e) {
            e.printStackTrace(); // Print the error for debugging purposes
        }
    }

    //Methode to play the sound choosed in setFile
    public void play3() {
        clip3.start();
    }


    //methode to loop the sound file choosed in setFile
    public void loop3() {
        clip3.loop(Clip.LOOP_CONTINUOUSLY);
    }


    //methode to stop the sound in setFile
    public void stop3() {
        clip3.stop();
    }
}











