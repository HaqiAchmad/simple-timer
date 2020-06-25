package com.time;

import com.media.Sounds;
import com.window.WindowSetTimer;
import com.window.WindowTimeUp;

import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 * Class ini digunakan segala operasi atau proses yang berhubungan dengan watku
 * Kegunaan dari class ini antara lain:
 * 1. untuk mendapatkan jam dan tanggal saat ini
 * 2. untuk menghitung total millis, detik, menit, jam, hari, minggu dan bulan sejak tanggal 1 Jan tahun ini
 * 3. class ini juga digunakan untuk stopwatch dan timer
 *
 * @author Achmad Baihaqi
 * @since 8 July 2020
 */
public class Times {

    /**
     * attribute yang digunakan untuk mendapatkan waktu saat ini seperti jam menit, detik, tanggal, dll
     */
    private static final LocalDateTime lc = LocalDateTime.now();

    /**
     * attribute yang digunakan untuk mengecek suatu kondisi yang terjadi pada stopwatch atau timer
     * stopwatchStart dan timerStart : digunakan untuk mengecek apakah stopwatch atau timer sedang digunakan atau tidak.
     *                                 jika sedang digunakan maka bernilai true jika tidak maka bernilai false.
     * stopwatchPause dan timerPause : digunakan untuk mengecek apakah stopwatch atau timer sedang dipause atau tidak.
     *                                 jika sedang dipause maka bernilai true jika tidak maka bernilai false.
     * stopwatchOnBackground dan timerOnBackground : digunakan untuk mengecek apakah user sedang membuka window stopwath atau timer.
     *                                 jika user sedang membuka window stopwatch atau timer maka bernilai true jika tidak maka akan bernilai false.
     */
    public static boolean stopwatchStart = false, timerStart = false,
                          stopwatchPause = false, timerPause = false,
                          stopwatchOnBackground = false, timerOnBackground = false;

    /**
     * attribute ini digunakan untuk menyimpan atau memproses data yang akan digunakan untuk stopwatch, timer dan jam
     * attribute yang berawalan dengan huruf 's' digunakan untuk stopwatch
     * attribute yang berawalan dengan huruf 't' digunakan untuk timer
     * attribute yang berawalan dengan huruf 'j' digunakan untuk jam dan untuk menghitung total waktu sejak tanggal 1 Jan
     */
    public static int sJam = 0, sMenit = 0, sDetik = 0, sMillis = 0, 
                      tHari = 0, tJam = 0, tMenit = 0, tDetik = 0,
                      jDetikNow, jMenitNow, jJamNow, jTanggalNow, jBulanNow, jTahunNow, jCodeHari,
                      jMenitTotal, jJamTotal, jHariTotal, jMingguTotal, jBulanTotal;

    /**
     * untuk menghitung total millis dan detik sejak tanggal 1 Jan
     * karena nanti nilainya sangat banyak maka attribute ini diatur ke tipe data long
     */
    public static long jMillisTotal, jDetikTotal;

    /**
     * Method ini digunakan untuk mengubah nilai dari jam, menit, detik dan millis pada stopwatch
     *
     * @param jam input jam
     * @param menit input menit
     * @param detik input detik
     * @param milis input millis
     */
    public static void setStopwatchValue(int jam, int menit, int detik, int milis){
        Times.sJam = jam;
        Times.sMenit = menit;
        Times.sDetik = detik;
        Times.sMillis = milis;
    }

    /**
     * Method ini digunakan untuk mengubah nilai dari hari, jam, menit, detik pada timer
     *
     * @param hari input hari
     * @param jam input jam
     * @param menit input menit
     * @param detik input detik
     */
    public static void setTimerValue(int hari, int jam, int menit, int detik){
        Times.tHari = hari;
        Times.tJam = jam;
        Times.tMenit = menit;
        Times.tDetik = detik;
    }

    /**
     * Method ini adalah method yang akan dijalankan saat user menekan tombol mulai pada WindowStopwatch.java.
     * Method ini digunakan untuk melakukan stopwatch.
     *
     */
    public static void stopwatch(){

        // mengupdate nilai pada stopwatch
        new Thread(new Runnable() {
            @Override
            public void run() {

                try{
                    // stopwatch akan dijalankan ketika attribute stopwatchStart bernilai true
                    while(Times.stopwatchStart){

                        sMillis++; // nilainya akan bertambah 1 setiap 1 millisecond
                        if(sMillis >= 1000){ // jika nilai dari millisecond >= 1000 maka detik nilainya akan bertambah 1
                            sDetik++;
                            sMillis = 0;
                        }else if(sDetik > 59){ // jika nilai dari detik > 59 maka menit nilainya akan bertambah 1
                            sMenit++;
                            sDetik = 0;
                            sMillis = 0;
                        }else if(sMenit > 59){ // jika nilai dari menit > 59 maka jam nilainya akan bertambah 1
                            sJam++;
                            sMenit = 0;
                            sDetik = 0;
                            sMillis = 0;
                        }

                        Thread.sleep(1);
        //                System.out.println(""+sJam+":"+sMenit+":"+sDetik+":"+sMillis);

                    }

                }catch(InterruptedException iex){
                    JOptionPane.showMessageDialog(null, "Terjadi kesalahan!! \nDi class com.time.Times.java\n"+iex);
                }

            }
        }).start();
    }

    /**
     * Method ini adalah method yang akan dijalankan saat user menekan tombol mulai pada WindowSetTimer.java.
     * Method ini digunakan untuk melakukan timer.
     *
     */
    public static void timer(){

        // mengupdate nilai pada timer
        new Thread(new Runnable(){
        
            @Override
            public void run(){
                
                try{
                    // timer akan dijalankan ketika attribute timerStart bernilai true
                    while(Times.timerStart){

                        /* mengecek apakah timer sudah berakhir atau belum
                           jika sudah maka timerStart akan bernilai false dan method akan membuka WindowTimeUp.java
                           jika belum maka timer akan diupdate terus sampai habis
                          */
                        if(tDetik == 0 && tMenit == 0 && tJam == 0 && tHari == 0){ // jika sudah
                            Times.timerStart = false;
                            WindowSetTimer.isTimerStart = false;

                            // membuka WindowTimeUp.java
                            java.awt.EventQueue.invokeLater(new Runnable(){
                                
                                @Override
                                public void run(){
                                    new WindowTimeUp().setVisible(true);
                                }
                            });
                            break;

                        }else{ // jika belum

                            tDetik--; // nilainya akan berkurang 1 setiap 1000 milliseceond
                            if(tDetik < 0){ // jika detik nilainya < 0 maka menit nilainya akan berkurang 1
                                tMenit--;
                                tDetik = 59;
                            }else if(tMenit < 0){ // jika menit nilainya < 0 maka jam nilainya akan berkurang 1
                                tJam--;
                                tMenit = 59;
                            }else if(tJam < 0){ // jika jam nilainya < 0 maka hari nilainya akan berkurang 1
                                tHari--;
                                tJam = 23;
                            }else if(tHari == 0){ // jika hari adalah 0 maka hari nilainya akan diset ke 0 (tujuan nya agar nilai hari tidak minus)
                                tHari = 0;
                            }
                        }       

    //                    System.out.println(String.format("%d day %d jam %d menit %d detik\n", tHari, tJam , tMenit, tDetik));
                        Thread.sleep(1000);
                    }
                }catch(InterruptedException iex){
                    Sounds.playSound(Sounds.SOUND_ERROR);
                    JOptionPane.showMessageDialog(null, "Terjadi kesalahan!! \nDi class com.time.Times.java\n"+iex);
                }
            }
        }).start();
        

    }

    /**
     * Method ini digunakan untuk mendapatkan waktu saat ini memalui class LocalDateTime lalu nilainya akan diupdate disini
     */
    public static void startTime(){
        // mendapatkan waktu saat ini
        Times.jDetikNow = lc.getSecond();
        Times.jMenitNow = lc.getMinute();
        Times.jJamNow = lc.getHour();
        Times.jCodeHari = lc.getDayOfWeek().getValue();
        Times.jTanggalNow = lc.getDayOfMonth();
        Times.jBulanNow = lc.getMonthValue();
        Times.jTahunNow = lc.getYear();
        
            try{

                /*
                    mengupdate nilai pada waktu seperti detik, menit, jam tanggal saat ini
                    nilai akan terus diupdate sampai aplikasi diclose
                 */
                while(true){

                    Times.jDetikNow++; // detik akan bertambah 1 setiap 1000 millisecond

                    if(jDetikNow > 59){ // jika detik nilainya > 59 maka menit akan bertambah 1
                        jMenitNow++;
                        jDetikNow = 0;
                    }else if(jMenitNow  > 59){ // jika menit nilainya > 59 maka jam akan bertambah 1
                        jJamNow++;
                        jMenitNow = 0;
                    }else if(jJamNow > 23){ // jika jam nilainya > 23 maka tanggal akan bertambah 1
                        jTanggalNow++;
                        jCodeHari++;
                        jJamNow = 0;
                            if(jCodeHari > 7){ // jika kode hari > 7 maka nilainya akan direset ke 1
                                jCodeHari = 1;
                            }
                    }else if(jTanggalNow > Times.getHariDalamSeblulan(jBulanNow)){ // jika tanggal > dari total hari dalam bulan ini maka bulan akan bertambah 1
                        jBulanNow++;
                        jTanggalNow = 1;
                    }else if(jBulanNow > 12){ // jika bulan nilainya > 12 maka tahun akan bertambah 1
                        jTahunNow++;
                        jBulanNow = 1;
                        // mereset nilai saat tahun bertambah 1
                        Times.jMillisTotal = 0;
                        Times.jDetikTotal = 0;
                        Times.jMenitTotal = 0;
                        Times.jJamTotal = 0;
                        Times.jHariTotal = 1;
                        Times.jMingguTotal = 0;
                        Times.jBulanTotal = 1;
                    }
                    Thread.sleep(1000);
                    
                }
                
            }catch(InterruptedException iex){
                Sounds.playSound(Sounds.SOUND_ERROR);
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan!! \nDi class com.time.Times.java\n"+iex);
            }
    }

    /**
     * Method ini digunakan untuk mendapatkan total hari dalam bulan tertentu seperti april, mei, juni dll
     *
     * @param bulanValue input kode bulan, kode hanya terdiri dari 1 - 12 saja
     * @return total hari dalam bulan tertentu
     */
    private static int getHariDalamSeblulan(final int bulanValue){
        
        switch(bulanValue){
            case 1: return 31;
            case 2: return 28;
            case 3: return 31;
            case 4: return 30;
            case 5: return 31;
            case 6: return 30;
            case 7: return 31;
            case 8: return 31;
            case 9: return 30;
            case 10: return 31;
            case 11: return 30;
            case 12: return 31;
            default: return -1;
                
        }
        
    }

    /**
     * Method ini digunakan untuk mendapatkan nama hari saat ini seperti senin, selasa, rabu dll
     *
     * @param code input kode hari, kode hanya terdiri dari 1 - 7 saja
     * @return nama hari saat ini
     */
    private static String getNamaHari(final int code){
        switch(code){
            case 1: return "Senin";
            case 2: return "Selasa";
            case 3: return "Rabu";
            case 4: return "Kamis";
            case 5: return "Jum'at";
            case 6: return "Sabtu";
            case 7: return "Minggu";
            default : return "ERROR";
        }
     
    }

    /**
     * Method ini digunakan untuk mendapatkan nama bulan saat ini seperti januari, februari, maret dll
     *
     * @param code input kode bulan, kode hanya terdiri dari 1 - 12 saja
     * @return nama bulan saat ini
     */
    private static String getNamaBulan(final int code){
        switch(code){
            case 1: return "Januari";
            case 2: return "Februari";
            case 3: return "Maret";
            case 4: return "April";
            case 5: return "Mei";
            case 6: return "Juni";
            case 7: return "Juli";
            case 8: return "Agustus";
            case 9: return "September";
            case 10: return "Oktober";
            case 11: return "November";
            case 12: return "Desember";
            default : return "ERROR";
        }
    }

    /**
     * Method ini digunakan untuk mendapatkan jam saat ini dalam bentuk String
     * Contoh outputnya : 07:32:56
     *
     * @return jam saat ini
     */
    public static String getJamValue(){
        return String.format("%02d:%02d:%02d", Times.jJamNow, Times.jMenitNow, Times.jDetikNow);
    }

    /**
     * Method ini digunakan untuk mendapatkan tanggal saat ini dalam bentuk String
     * Contoh outputnya : Rabu, 08 Juli 2020
     *
     * @return tanggal saat ini
     */
    public static String getTanggalValue(){
        return String.format("%s, %02d %s %02d",
                Times.getNamaHari(Times.jCodeHari), Times.jTanggalNow, Times.getNamaBulan(Times.jBulanNow), Times.jTahunNow
        );
    }

    /**
     * Method ini digunakan untuk mendapatkan total millis, detik, menit, jam, hari, minggu, dan bulan sejak 1 Jan tahun ini lalu diupdate
     */
    public static void updateTotalWaktu(){

        // digunakan untuk mengupdate total waktu
        int dayOfYear = lc.getDayOfYear()-1, milis = 0, detik = Times.jDetikNow, menit = Times.jMenitNow,
                        jam = Times.jJamNow, hari = Times.jTanggalNow, minggu = 0, bulan = Times.jBulanNow;
        
        // digunakan untuk mendapatkan total millis detik dan menit pada hari ini sejak jam 00
        long milisHariIni = (1000L*60L*60L*Times.jJamNow) + (1000L*60L*Times.jMenitNow) + (1000L*Times.jDetikNow),
             detikHariIni = (60*60*Times.jJamNow) + (60*Times.jMenitNow) + Times.jDetikNow, 
             menitHariIni = (60*Times.jJamNow) + Times.jMenitNow;

        // menghitung total waktu sejak tanggal 1 Jan sampai kemarin lalu akan ditabahkan dengan total waktu hari ini
        Times.jMillisTotal = 1000L*60L*60L*24L*dayOfYear + milisHariIni;
        Times.jDetikTotal = 60L*60L*24L*dayOfYear + detikHariIni;
        Times.jMenitTotal = 60*24*dayOfYear + (int)menitHariIni;
        Times.jJamTotal = 24*dayOfYear + Times.jJamNow;
        Times.jHariTotal = dayOfYear+=1;
        Times.jMingguTotal = dayOfYear / 7;
        Times.jBulanTotal = lc.getMonthValue();

            /*
               mengupdate nilai. nilai akan diupdate terus sampai aplikasi diclose
             */
            while(true){
                try{
                    milis+=1;
                    Times.jMillisTotal+=1;
                    if(milis > 1000){
                        milis = 0;
                        detik++;
                        Times.jDetikTotal++;
                    }else if(detik > 59){
                        detik = 0;
                        menit++;
                        Times.jMenitTotal++;
                    }else if(menit > 59){
                        menit = 0;
                        jam++;
                        Times.jJamTotal++;
                    }else if(jam > 23){
                        jam = 0;
                        hari++;
                        Times.jHariTotal++;
                    }else if(hari > 7){
                        hari = 0;
                        minggu++;
                        Times.jMingguTotal++;
                    }else if (Times.jTanggalNow > Times.getHariDalamSeblulan(Times.jBulanNow)){
                        Times.jTanggalNow = 1;
                        Times.jBulanTotal++;
                    }

                    Thread.sleep(1);
                }catch(InterruptedException iex){
                    Sounds.playSound(Sounds.SOUND_ERROR);
                    JOptionPane.showMessageDialog(null, "Terjadi kesalahan!! \nDi class com.time.Times.java\n"+iex);
                }
            }

    }

    /**
     * Method ini digunakan untuk mendapatkan ucapan selamat pagi, siang, sore, petang atau malam
     * Selamat pagi     : dimulai pada jam 5 sampai jam 10
     * Selamat siang    : dimulai pada jam 11 sampai jam 14
     * Selamat sore     : dimulai  pada jam 15 sampai jam 17
     * Selamat petang   : dimulai pada jam 18 sampai jam 19
     * Selamat malam    : dimulai pada jam 20 sampai jam 4
     *
     * @return ucapan selamat pagi, siang, sore, petang atau malam
     */
    public static String ucapanSelamat(){
        
        if(Times.jJamNow > 4 && Times.jJamNow <= 10){
            return "Selamat Pagi...";
        }else if(Times.jJamNow > 10 && Times.jJamNow <= 14){
            return "Selamat Siang...";
        }else if(Times.jJamNow > 14 && Times.jJamNow <= 17){
            return "Selamat Sore...";
        }else if(Times.jJamNow > 17 && Times.jJamNow <= 19){
            return "Selamat Petang...";
        }else if(Times.jJamNow > 19 && Times.jJamNow <= 23 || Times.jJamNow < 5){
            return "Selamat Malam...";
        }
        return "ERRROR";
    }
    

}