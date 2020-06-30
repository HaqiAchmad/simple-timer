package com.main;

import com.time.Times;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Class ini akan dijalankan pertama kali saat aplikasi dibuka
 * Class ini juga digunakan untuk mendapatkan nama, versi dan icon yang dipakai aplikasi
 *
 * @author Achmad Baihaqi
 * @since 08 July 2020
 */
public class Main {

    /**
     * Nama dan versi aplikasi
     */
    private static final  String appName = "Simple Timer ",
                          appVersi = "1.0";
    /**
     * Icon yang akan digunakan pada window
     */
    private static final ImageIcon image = new ImageIcon("src/com/media/icons/window-icon.png");

    /**
     * Untuk mendapatkan icon yang akan digunakan pada window
     *
     * @return icon window
     */
    public static Image windowIcon(){
        return image.getImage();
    }

    /**
     * Untuk mendapatkan nama dari applikasi
     *
     * @return nama aplikasi
     */
    public static String getAppName(){
        return appName;
    }

    /**
     * Untuk mendapatkan versi dari aplikasi
     *
     * @return versi aplikasi
     */
    public static String getAppVersi(){
        return appVersi;
    }

    /**
     * Pada method main ini digunakan untuk menjalankan method startJam dan updateTotalWaktu pada class Times
     * Method ini juga digunakan untuk membuka window di WindowJam.java
     * @param args
     */
    public static void main(String[] args) {

        // digunakan untuk mendapatkan jam atau tanggal saat ini lalu akan ditampilkan pada WindowJam.java
        new Thread(new Runnable(){
            
            @Override
            public void run(){
                Times.startTime();
            }
        
        }).start();

        /*
         digunakan untuk mendapatkan total millis, detik, menit, jam, hari, minggu, bulan sejak tanggal 1 Jan sampai sekarang
         lalu datanya akan ditampilkan pada WindowJam.java
          */
        new Thread(new Runnable(){
            
            @Override
            public void run(){
                Times.updateTotalWaktu();
            }
        }).start();

        /*
         digunakan untuk membuka form WindowJam.java
         */
        java.awt.EventQueue.invokeLater(new Runnable(){
            
            @Override
            public void run(){
                new com.window.WindowJam().setVisible(true);
            }
        });
        
    }

}
