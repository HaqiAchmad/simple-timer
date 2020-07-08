package com.window;

import com.main.Main;
import com.media.Sounds;
import com.time.Times;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 * Class ini digunakan untuk menjalankan timer 
 * 
 * @author Achmad baihaqi
 * @since 08 July 2020
 */
public class WindowTimer extends javax.swing.JFrame {

    /**
     * Constructor ini akan dijalankan ketika user keluar dari window timer dan kembali lagi
     * Constructor ini digunakan untuk mengambil data timer yang berjalan dibackground lalu ditampilkan ke window
     */
    public WindowTimer(){
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Timer ~ " + Main.getAppName()+Main.getAppVersi());
        this.setIconImage(Main.windowIcon());
        
        // saat timer dijalankan maka tombol mulai didisable
        this.btnMulai.setEnabled(false);
        this.btnMulai.setText("");
        
            /* mengecek apakah timer sedang digunakan tetapi user keluar dari window timer atau tidak
               jika sebelumya user keluar dari window timer lalu kembali lagi ke window timer
               maka applikasi akan menampilkan data timer yang sedang berjalan dibackground ke window timer
               ini digunakan agar jika user keluar dari window timer, timer tidak break atau terhenti
            */
            if(Times.timerOnBackground){
                // jika user keluar dari window timer saat timer dipause
                if(Times.timerPause){
                    this.btnPauseAndResume.setEnabled(true);
                    this.btnPauseAndResume.setForeground(new Color(0,114,123));
                    this.btnPauseAndResume.setText("Resume");
                    this.btnReset.setEnabled(true);
                    this.btnReset.setText("Reset");
                    this.btnMulai.setEnabled(false);
                    this.btnMulai.setText("");
                    this.setTimerText(Times.tHari, Times.tJam, Times.tMenit, Times.tDetik); // menampilkan kembali data
                }else{ // jika user keluar dari window timer saat timer tidak dipause
                    
                    // menampilkan kembali data timer yang berjalan dibackground
                    new Thread(new Runnable(){
                        
                        @Override
                        public void run(){
                            try{
                                while(true){
                                    setTimerText(Times.tHari, Times.tJam, Times.tMenit, Times.tDetik);
                                    Thread.sleep(1000);
                                }
                            }catch(InterruptedException iex){
                                Sounds.playSound(Sounds.SOUND_ERROR);
                                JOptionPane.showMessageDialog(null, "Terjadi kesalahan!! \nDi class com.window.WindowTimer.java\n"+iex);
                            }
                        }
                    }).start();
                }
            }
       
        
    }
    
    /**
     * Constructor ini akan dijalankan setelah user melakukan input pada timer
     * 
     * @param hari input hari
     * @param jam input jam
     * @param menit input menit
     * @param detik  input detiki
     */
    public WindowTimer(int hari, int jam, int menit, int detik) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Timer ~ SimpeTimer 1.0");
        this.setIconImage(Main.windowIcon());
        
        // menset timer
        Times.setTimerValue(hari, jam, menit, detik);
        Times.timerStart = true;
        
        // saat timer dijalankan maka tombol mulai didisable
        this.btnMulai.setEnabled(false);
        this.btnMulai.setText("");
            
           // menjalankan timer
            new Thread(new Runnable(){
                
                @Override
                public void run(){
                    Times.timer();
                }
            }).start();
            
            // menampilkan data dari timer ke window timer
            new Thread(new Runnable(){
                
                @Override
                public void run(){
                    try{
                        while(Times.timerStart){ // data akan ditampikan selama timer aktif
                            setTimerText(Times.tHari, Times.tJam, Times.tMenit, Times.tDetik);
                            Thread.sleep(500);
                        }
                    }catch(InterruptedException iex){
                        Sounds.playSound(Sounds.SOUND_ERROR);
                        JOptionPane.showMessageDialog(null, "Terjadi kesalahan!! \nDi class com.window.WindowTimer.java\n"+iex);
                    }
                }
            }).start();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTop = new javax.swing.JPanel();
        btnTimer = new javax.swing.JLabel();
        btnJam = new javax.swing.JLabel();
        btnStopwatch = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        pnlMain = new javax.swing.JPanel();
        lblTimer = new javax.swing.JLabel();
        lblHariValue = new javax.swing.JLabel();
        lblJamValue = new javax.swing.JLabel();
        lblTimer1 = new javax.swing.JLabel();
        lblMenitValue = new javax.swing.JLabel();
        lblTimer2 = new javax.swing.JLabel();
        lblDetikValue = new javax.swing.JLabel();
        lblTimer3 = new javax.swing.JLabel();
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
        btnStopwatch.setForeground(new java.awt.Color(255, 255, 255));
        btnStopwatch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnStopwatch.setText("Stopwatch");
        btnStopwatch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStopwatchMouseClicked(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout pnlTopLayout = new javax.swing.GroupLayout(pnlTop);
        pnlTop.setLayout(pnlTopLayout);
        pnlTopLayout.setHorizontalGroup(
            pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopLayout.createSequentialGroup()
                .addComponent(btnJam, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStopwatch, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTopLayout.setVerticalGroup(
            pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator3)
            .addComponent(btnJam, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(btnStopwatch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnTimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));

        lblTimer.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTimer.setForeground(new java.awt.Color(38, 220, 59));
        lblTimer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTimer.setText("Day");
        lblTimer.setMaximumSize(new java.awt.Dimension(60, 62));
        lblTimer.setMinimumSize(new java.awt.Dimension(60, 62));
        lblTimer.setPreferredSize(new java.awt.Dimension(60, 62));

        lblHariValue.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        lblHariValue.setForeground(new java.awt.Color(18, 15, 15));
        lblHariValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHariValue.setText("16");
        lblHariValue.setMaximumSize(new java.awt.Dimension(60, 62));
        lblHariValue.setMinimumSize(new java.awt.Dimension(60, 62));
        lblHariValue.setPreferredSize(new java.awt.Dimension(60, 62));

        lblJamValue.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        lblJamValue.setForeground(new java.awt.Color(18, 15, 15));
        lblJamValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJamValue.setText("07");
        lblJamValue.setMaximumSize(new java.awt.Dimension(60, 62));
        lblJamValue.setMinimumSize(new java.awt.Dimension(60, 62));
        lblJamValue.setPreferredSize(new java.awt.Dimension(60, 62));

        lblTimer1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTimer1.setForeground(new java.awt.Color(36, 104, 204));
        lblTimer1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTimer1.setText("Hour");
        lblTimer1.setMaximumSize(new java.awt.Dimension(60, 62));
        lblTimer1.setMinimumSize(new java.awt.Dimension(60, 62));
        lblTimer1.setPreferredSize(new java.awt.Dimension(60, 62));

        lblMenitValue.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        lblMenitValue.setForeground(new java.awt.Color(18, 15, 15));
        lblMenitValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenitValue.setText("56");
        lblMenitValue.setMaximumSize(new java.awt.Dimension(60, 62));
        lblMenitValue.setMinimumSize(new java.awt.Dimension(60, 62));
        lblMenitValue.setPreferredSize(new java.awt.Dimension(60, 62));

        lblTimer2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTimer2.setForeground(new java.awt.Color(214, 34, 41));
        lblTimer2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTimer2.setText("Min");
        lblTimer2.setMaximumSize(new java.awt.Dimension(60, 62));
        lblTimer2.setMinimumSize(new java.awt.Dimension(60, 62));
        lblTimer2.setPreferredSize(new java.awt.Dimension(60, 62));

        lblDetikValue.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        lblDetikValue.setForeground(new java.awt.Color(18, 15, 15));
        lblDetikValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDetikValue.setText("16");
        lblDetikValue.setMaximumSize(new java.awt.Dimension(60, 62));
        lblDetikValue.setMinimumSize(new java.awt.Dimension(60, 62));
        lblDetikValue.setPreferredSize(new java.awt.Dimension(60, 62));

        lblTimer3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTimer3.setForeground(new java.awt.Color(77, 84, 102));
        lblTimer3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTimer3.setText("Sec");
        lblTimer3.setMaximumSize(new java.awt.Dimension(60, 62));
        lblTimer3.setMinimumSize(new java.awt.Dimension(60, 62));
        lblTimer3.setPreferredSize(new java.awt.Dimension(60, 62));

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblHariValue, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblJamValue, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTimer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMenitValue, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTimer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDetikValue, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTimer3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTimer3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDetikValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTimer2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMenitValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTimer1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJamValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHariValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
     * Digunakan untuk mengatur text pada label hari, jam, menit dan detik 
     * 
     * @param hari input hari
     * @param jam input jam
     * @param menit input menti
     * @param detik input detik
     */
    private void setTimerText(int hari, int jam, int menit, int detik){
        this.lblHariValue.setText(Integer.toString(hari));
        this.lblJamValue.setText(String.format("%02d", jam));
        this.lblMenitValue.setText(String.format("%02d", menit));
        this.lblDetikValue.setText(String.format("%02d", detik));
    }
    
    
    private void btnMulaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMulaiMouseClicked

    }//GEN-LAST:event_btnMulaiMouseClicked


    /**
     * Berfungsi untuk pause dan resume timer
     * Ada 2 kemungkinan yang akan terjadi jika user menekan tombol ini
     * 1. Jika sebelumnya timer dipause maka timer akan diresume
     * 2. Jika sebelumnya timer tidak dipause maka timer akan dipause
     * 
     * @param evt 
     */
    private void btnPauseAndResumeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPauseAndResumeMouseClicked
        if(!Times.timerPause){ // jika timer tidak dipause
            Times.timerPause = true; // timer dipause
            Times.timerStart = false;
            this.btnPauseAndResume.setForeground(new Color(0,114,123));
            this.btnPauseAndResume.setText("Resume");
            this.setTimerText(Times.tHari, Times.tJam, Times.tMenit, Times.tDetik);
        }else{ // jika timer dipause
            Times.timerPause = false; // timer diresume
            Times.timerStart = true;
            this.btnPauseAndResume.setForeground(new Color(32,55,185));
            this.btnPauseAndResume.setText("Pause");
                
                // mengupdate timer
                new Thread(new Runnable(){
                    
                    @Override
                    public void run(){
                        Times.timer();
                    }
                }).start();
                
                // menampilkan data timer ke window
                new Thread(new Runnable(){
                
                    @Override
                    public void run(){
                        try{
                            while(Times.timerStart){
                                setTimerText(Times.tHari, Times.tJam, Times.tMenit, Times.tDetik);
                                Thread.sleep(1000);
                            }
                            
                        }catch(InterruptedException iex){
                            Sounds.playSound(Sounds.SOUND_ERROR);
                            JOptionPane.showMessageDialog(null, "Terjadi kesalahan!! \nDi class com.window.WindowTimer.java\n"+iex);
                        }
                    }
                }).start();
        }

    }//GEN-LAST:event_btnPauseAndResumeMouseClicked

    /**
     * Berfungsi untuk mereset timer
     * 
     * @param evt 
     */
    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        // digunakan untuk mereset timer saat timer sedang berjalan atau dipause
        if(Times.timerStart || Times.timerPause){
            Times.timerStart = false;
            Times.timerPause = false;
            Times.timerOnBackground = false;
            WindowSetTimer.isTimerStart = false;
                // membuka window setTimer
                java.awt.EventQueue.invokeLater(new Runnable(){

                    @Override
                    public void run(){
                        WindowSetTimer setTimer = new WindowSetTimer();
                        setTimer.setLocation(getX(), getY());
                        setTimer.setVisible(true);
                        dispose();
                    }
                });
        }else{ // digunakan untuk kembali ke window setTiemer saat timer sudah berakhir
                
                // membuka window setTimer
                java.awt.EventQueue.invokeLater(new Runnable(){

                    @Override
                    public void run(){
                        WindowSetTimer setTimer = new WindowSetTimer();
                        setTimer.setLocation(getX(), getY());
                        setTimer.setVisible(true);
                        dispose();
                    }
                });
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

    /**
     * Untuk membuka stopwatch jam saat tombol stopwatch diklik
     * @param evt 
     */
    private void btnStopwatchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStopwatchMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable(){
        
            @Override
            public void run(){
                WindowStopwatch stopwatch = new WindowStopwatch();
                stopwatch.setLocation(getX(), getY());
                stopwatch.setVisible(true);
                dispose();
            }
        });
    }//GEN-LAST:event_btnStopwatchMouseClicked

    private void btnTimerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimerMouseClicked

        
    }//GEN-LAST:event_btnTimerMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    /**
     * mengaktifkan timer agar berjalan dibackground
     * @param evt 
     */
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(Times.timerStart){
            Times.timerOnBackground = true;
        }
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
      
    }//GEN-LAST:event_formWindowClosing


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable(){
        
            @Override
            public void run(){
                new WindowTimer(365,7,3,59).setVisible(true);
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblDetikValue;
    private javax.swing.JLabel lblHariValue;
    private javax.swing.JLabel lblJamValue;
    private javax.swing.JLabel lblMenitValue;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JLabel lblTimer1;
    private javax.swing.JLabel lblTimer2;
    private javax.swing.JLabel lblTimer3;
    private javax.swing.JPanel pnlBottom;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlTop;
    // End of variables declaration//GEN-END:variables
}
