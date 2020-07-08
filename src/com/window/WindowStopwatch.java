package com.window;

import com.main.Main;
import com.media.Sounds;
import com.time.Times;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 * Class ini digunakan untuk melakukan stopwatch
 * 
 * @author Achmad Baihaqi
 * @since 08 July 2020
 */
public class WindowStopwatch extends javax.swing.JFrame {
    
    public WindowStopwatch() {
        initComponents();
        
        this.setTitle("Stopwatch ~ SimpeTimer 1.0");
        this.setLocationRelativeTo(null);
        this.setIconImage(Main.windowIcon());
        
        // jika stopwatch sedang tidak digunakan maka tombol resume, pause dan reset dinonaktifkan
        this.btnPauseAndResume.setEnabled(false);
        this.btnReset.setEnabled(false);
        this.btnPauseAndResume.setText("");
        this.btnReset.setText("");
        
            /* mengecek apakah stopwatch sedang digunakan tetapi user keluar dari window stopwatch atau tidak
               jika sebelumya user keluar dari window stopwatch lalu kembali lagi ke window stopwatch
               maka applikasi akan menampilkan data stopwatch yang sedang berjalan dibackground ke window stopwatch
               ini digunakan agar jika user keluar dari window stopwatch, stopwatch tidak break atau terhenti
            */
            if(Times.stopwatchOnBackground){ 
                // jika user keluar dari window stopwatch saat stopwatch dipause
                if(Times.stopwatchPause){
                    this.btnMulai.setEnabled(false);
                    this.btnMulai.setText("");
                    this.btnPauseAndResume.setEnabled(true);
                    this.btnPauseAndResume.setForeground(new Color(0,114,123));
                    this.btnPauseAndResume.setText("Resume");
                    this.btnReset.setEnabled(true);
                    this.btnReset.setText("Reset");
                    this.lblTimer.setText(String.format( // menampilkan kembali data
                                          "%,02d : %02d : %02d . %02d", Times.sJam, Times.sMenit, Times.sDetik, Times.sMillis/10   
                    ));
                }else{ // jika user keluar dari window stopwatch saat stopwatch tidak dipause
                    this.btnMulai.setEnabled(false);
                    this.btnMulai.setText("");
                    this.btnPauseAndResume.setEnabled(true);
                    this.btnPauseAndResume.setForeground(new Color(32,55,185));
                    this.btnPauseAndResume.setText("Pause");
                    this.btnReset.setEnabled(true);
                    this.btnReset.setText("Reset");
                    
                    // menampilkan kembali data stopwatch yang berjalan dibackground
                        new Thread(new Runnable(){

                            @Override
                            public void run(){
                                while(Times.stopwatchStart){
                                    try{// menampilkan data ke window
                                        lblTimer.setText(String.format(
                                            "%,02d : %02d : %02d . %02d",Times.sJam, Times.sMenit, Times.sDetik, Times.sMillis/10
                                        ));  
                                        Thread.sleep(1);
                                    }catch(java.lang.InterruptedException iex){
                                        Sounds.playSound(Sounds.SOUND_ERROR);
                                        JOptionPane.showMessageDialog(null, "Terjadi kesalahan!! \nDi class com.window.WindowStopwatch.java\n"+iex);
                                    }
                                }
                            }
                        }).start();
                        
                }
            }
  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTop = new javax.swing.JPanel();
        btnTimer = new javax.swing.JLabel();
        btnJam = new javax.swing.JLabel();
        btnStopwatch = new javax.swing.JLabel();
        line1 = new javax.swing.JSeparator();
        line2 = new javax.swing.JSeparator();
        pnlMain = new javax.swing.JPanel();
        lblTimer = new javax.swing.JLabel();
        pnlBottom = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnPauseAndResume = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnMulai = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnReset = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlTop.setBackground(new java.awt.Color(65, 135, 235));

        btnTimer.setBackground(new java.awt.Color(0, 0, 0));
        btnTimer.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnTimer.setForeground(new java.awt.Color(255, 255, 255));
        btnTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTimer.setText("TImer");
        btnTimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimerMouseClicked(evt);
            }
        });

        btnJam.setBackground(new java.awt.Color(238, 241, 33));
        btnJam.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnJam.setForeground(new java.awt.Color(255, 255, 255));
        btnJam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnJam.setText("Jam");
        btnJam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnJamMouseClicked(evt);
            }
        });

        btnStopwatch.setBackground(new java.awt.Color(0, 0, 0));
        btnStopwatch.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnStopwatch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnStopwatch.setText("Stopwatch");
        btnStopwatch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStopwatchMouseClicked(evt);
            }
        });

        line1.setBackground(new java.awt.Color(0, 0, 0));
        line1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        line2.setBackground(new java.awt.Color(0, 0, 0));
        line2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout pnlTopLayout = new javax.swing.GroupLayout(pnlTop);
        pnlTop.setLayout(pnlTopLayout);
        pnlTopLayout.setHorizontalGroup(
            pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopLayout.createSequentialGroup()
                .addComponent(btnJam, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStopwatch, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTopLayout.setVerticalGroup(
            pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(line1)
            .addComponent(line2)
            .addComponent(btnJam, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(btnStopwatch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnTimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));

        lblTimer.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        lblTimer.setForeground(new java.awt.Color(18, 15, 15));
        lblTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimer.setText("00 : 00 : 00 . 00");

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pnlBottom.setBackground(new java.awt.Color(131, 150, 163));
        pnlBottom.setLayout(new javax.swing.BoxLayout(pnlBottom, javax.swing.BoxLayout.LINE_AXIS));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setMaximumSize(new java.awt.Dimension(100, 36));
        pnlBottom.add(jLabel5);

        btnPauseAndResume.setBackground(new java.awt.Color(18, 18, 18));
        btnPauseAndResume.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnPauseAndResume.setForeground(new java.awt.Color(32, 55, 185));
        btnPauseAndResume.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPauseAndResume.setText("Pause");
        btnPauseAndResume.setMaximumSize(new java.awt.Dimension(100, 36));
        btnPauseAndResume.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPauseAndResumeMouseClicked(evt);
            }
        });
        pnlBottom.add(btnPauseAndResume);

        jLabel7.setBackground(new java.awt.Color(18, 18, 18));
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setMaximumSize(new java.awt.Dimension(100, 36));
        pnlBottom.add(jLabel7);

        btnMulai.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnMulai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMulai.setText("Mulai");
        btnMulai.setMaximumSize(new java.awt.Dimension(100, 36));
        btnMulai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMulaiMouseClicked(evt);
            }
        });
        pnlBottom.add(btnMulai);

        jLabel10.setBackground(new java.awt.Color(18, 18, 18));
        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setMaximumSize(new java.awt.Dimension(100, 36));
        pnlBottom.add(jLabel10);

        btnReset.setBackground(new java.awt.Color(18, 18, 18));
        btnReset.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(165, 27, 27));
        btnReset.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnReset.setText("Reset");
        btnReset.setMaximumSize(new java.awt.Dimension(100, 36));
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });
        pnlBottom.add(btnReset);

        jLabel12.setBackground(new java.awt.Color(18, 18, 18));
        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setMaximumSize(new java.awt.Dimension(100, 36));
        pnlBottom.add(jLabel12);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Digunakan untuk memulai stopwatch saat tombol mulai pada window ditekan
     * 
     * @param evt 
     */
    private void btnMulaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMulaiMouseClicked
        
        // mengecek apakah stopwach sedang digunakan atau tidak jika false maka stopwatch akan dijalankan
        if(!Times.stopwatchStart){
            Times.stopwatchStart = true;
            Sounds.playSound(Sounds.SOUND_BTN_START);
            this.btnMulai.setEnabled(false);
            this.btnMulai.setText("");
            this.btnPauseAndResume.setEnabled(true);
            this.btnPauseAndResume.setText("Pause");
            this.btnReset.setEnabled(true);
            this.btnReset.setText("Reset");
                
            // digunakan untuk menampilkan data dari stopwatch ke window
                new Thread(new Runnable(){
                    
                    @Override
                    public void run(){
                        // data akan ditampilkan saat stopwatchStart bernilai true
                        while(Times.stopwatchStart){
                            try{
                                lblTimer.setText(String.format(
                                    "%,02d : %02d : %02d . %02d",Times.sJam, Times.sMenit, Times.sDetik, Times.sMillis/10
                                ));  
                                Thread.sleep(10);
                            }catch(java.lang.InterruptedException iex){
                                Sounds.playSound(Sounds.SOUND_ERROR);
                                JOptionPane.showMessageDialog(null, "Terjadi kesalahan!! \nDi class com.window.WindowStopwatch.java\n"+iex);
                            }
                        }
                    }
                }).start();
            
                // berfungsi untuk menjalankan stopwatch
                new Thread(new Runnable(){
                    
                    @Override
                    public void run(){
                        Times.stopwatch();
                    }
                }).start();
        }
    }//GEN-LAST:event_btnMulaiMouseClicked


    /**
     * Berfungsi untuk pause dan resume stopwatch
     * Ada 2 kemungkinan yang akan terjadi jika user menekan tombol ini
     * 1. Jika sebelumnya stopwatch dipause maka stopwatch akan diresume
     * 2. Jika sebelumnya stopwatch tidak dipause maka stopwatch akan dipause
     * 
     * @param evt 
     */
    private void btnPauseAndResumeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPauseAndResumeMouseClicked
        if(!Times.stopwatchPause){ // jika stopwatch tidak dipause
            Times.stopwatchPause = true; // stopwatch dipause
            Times.stopwatchStart = false;
            this.btnPauseAndResume.setForeground(new Color(0,114,123));
            this.btnPauseAndResume.setText("Resume");
        }else{ // jika stopwatch di pause
            Times.stopwatchPause = false; // stopwatch diresume
            Times.stopwatchStart = true;
            this.btnPauseAndResume.setForeground(new Color(32,55,185));
            this.btnPauseAndResume.setText("Pause");
               
                // menampilkan data dari stopwatch ke window
                 new Thread(new Runnable(){
                    
                    @Override
                    public void run(){
                        while(Times.stopwatchStart){
                            try{
                                lblTimer.setText(String.format(
                                    "%,02d : %02d : %02d . %02d",Times.sJam, Times.sMenit, Times.sDetik, Times.sMillis/10
                                ));  
                                Thread.sleep(1);
                            }catch(java.lang.InterruptedException iex){
                                Sounds.playSound(Sounds.SOUND_ERROR);
                                JOptionPane.showMessageDialog(null, "Terjadi kesalahan!! \nDi class com.window.WindowStopwatch.java\n"+iex);
                            }
                        }
                    }
                }).start();
                
                 // mengupdate data stopwatch 
                new Thread(new Runnable(){
                    
                    @Override
                    public void run(){
                        Times.stopwatch();
                    }
                }).start();
            
        }
    }//GEN-LAST:event_btnPauseAndResumeMouseClicked

    /**
     * Berfungsi untuk mereset stopwatch
     * @param evt 
     */
    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        if(Times.stopwatchStart || Times.stopwatchPause){
            Times.stopwatchStart = false;
            Times.stopwatchPause = false;
            Times.stopwatchOnBackground = false;
            Times.setStopwatchValue(0, 0, 0, 0);
            lblTimer.setText(String.format( // text akan diset ke default
                "%,02d : %02d : %02d . %02d", 0, 0, 0, 0
            )); 
            this.btnMulai.setEnabled(true);
            this.btnMulai.setText("Mulai");
            this.btnPauseAndResume.setEnabled(false);
            this.btnPauseAndResume.setText("");
            this.btnReset.setEnabled(false);
            this.btnReset.setText("");
            
        }
    }//GEN-LAST:event_btnResetMouseClicked

    /**
     * Untuk membuka window jam saat tombol stopwatch diklik
     * @param evt 
     */
    private void btnJamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnJamMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable(){
        
            @Override
            public void run(){
           
                WindowJam jam = new WindowJam();
                jam.setLocation(getX(), getY());
                jam.setVisible(true);
                dispose();
            }
        });
        
    }//GEN-LAST:event_btnJamMouseClicked

    private void btnStopwatchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStopwatchMouseClicked

    }//GEN-LAST:event_btnStopwatchMouseClicked
    
    /**
     * Untuk membuka window timer dan window setTimer saat tombol timer diklik
     * Jika timer sedang aktif maka akan membuka window timer
     * Jika timer tidak aktif maka akan membuka window setTimer
     * @param evt 
     */
    private void btnTimerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimerMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable(){
        
            @Override
            public void run(){
                if(WindowSetTimer.isTimerStart){ // membuka window setTimer
                    WindowTimer timer = new WindowTimer();
                    timer.setLocation(getX(), getY());
                    timer.setVisible(true);
                    dispose();
                }else{ // membuka window timer
                    WindowSetTimer setTimer = new WindowSetTimer();
                    setTimer.setLocation(getX(), getY());
                    setTimer.setVisible(true);
                    dispose();
                }
            }
        });
    }//GEN-LAST:event_btnTimerMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened


    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       
    }//GEN-LAST:event_formWindowClosing

    /**
     * mengaktifkan stopwatch agar berjalan dibackground
     * @param evt 
     */
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

         if(Times.stopwatchStart){
            Times.stopwatchOnBackground = true;
        }
    }//GEN-LAST:event_formWindowClosed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WindowStopwatch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnJam;
    private javax.swing.JLabel btnMulai;
    private javax.swing.JLabel btnPauseAndResume;
    private javax.swing.JLabel btnReset;
    private javax.swing.JLabel btnStopwatch;
    private javax.swing.JLabel btnTimer;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JSeparator line1;
    private javax.swing.JSeparator line2;
    private javax.swing.JPanel pnlBottom;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlTop;
    // End of variables declaration//GEN-END:variables
}
