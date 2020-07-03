package com.media;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Class ini digunakan untuk proses yang berhubungan dengan audio/suara
 *
 * @author Achmad Baihaqi
 * @since 08 July 2020
 */
public class Sounds{

    /**
     * attribute yang digunakan untuk memutar dan menonaktifkan audio/suara
     */
    private static Player players;
    /**
     * untuk mengecek apakah audio/suara sedang diputar atau tidak
     */
    private static boolean isRunning = false;
    /**
     * directory penyimpanan file audio
     */
    private static String directory = "sounds\\";
    /**
     * nama file dari audio yang akan diputar
     */
    public static final String SOUND_ERROR = "app error.wav", SOUND_NOTIF = "app notif.wav", SOUND_BTN_START = "app btn start.wav",
                               SOUND_TIMEUP_1 = "app time up 1.mp3", SOUND_TIMEUP_2 = "app time up 2.mp3",  SOUND_TIMEUP_3 = "app time up 3.mp3";

    /**
     * Method ini digunakan untuk memutar audio/suara
     * @param filename file audio yang akan diputar
     */
    public static synchronized void playSound(final String filename){

        // mengambil input audio dari user
        try{
            FileInputStream input = new FileInputStream(Sounds.directory+filename);
            players = new Player(input);
        }catch(IOException iex){
            Sounds.playSound(Sounds.SOUND_ERROR);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan!! \nDi class com.media.Sounds.java\n"+iex);
        }catch(JavaLayerException jlex){
            Sounds.playSound(Sounds.SOUND_ERROR);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan!! \nDi class com.media.Sounds.java\n"+jlex);
        }
        
        new Thread(new Runnable(){
            
            @Override
            public void run(){
                try{
                    Sounds.isRunning = true;
                    players.play(); // memutar audio
                    Sounds.isRunning = false;
                }catch(JavaLayerException ex){
                    JOptionPane.showMessageDialog(null, "Terjadi kesalahan!! \n di class com.media.Sounds.java\n" + ex);
                }
            }
        }).start();

    }

    /**
     * Method ini digunakan untuk menonaktifkan audio/suara
     */
    public static synchronized void stopSound(){
        if(isRunning){ // mengecek apakah audio/suara sedang diputar atau tidak
            isRunning = false;
            players.close();
        }

    }


}