package com.window;

import com.main.Main;
import com.media.Sounds;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 * Class akan dijalankan ketika timer sudah berakhir 
 * 
 * @author Achmad Baihaqi
 * @since 08 July 2020
 */
public class WindowTimeUp extends javax.swing.JFrame {

    private static int codePengigatTimer;
    private int detik = 0, menit = 0, jam = 0;
    
    public WindowTimeUp() {
        initComponents();
        
        this.setTitle("Timer berakhir ~ "+Main.getAppName()+Main.getAppVersi());
        this.setLocationRelativeTo(null);
        this.setIconImage(Main.windowIcon());
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); // digunakan agar jika user menutup window timeup maka tidak akan menutup window utama juga 
        
        this.runPengingat(); // menjalankan pengingat sesuai yang diatur user sebelumnya
        this.lblTopEfek(); // memberi efek text pada lblTop
        this.timeup(); // menjalankan time up
    }

    /**
     * Berfungsi untuk mengatur pengingat saat timer berakhir sesuai yang diinginkan user
     * Kode pengingat hanya terdiri dari angka 0 sampai 4 saja
     * 0 - berarti tidak ada pengingat yang dijalankan saat timer berakhir
     * 1 - memutar audio sound_timeup_1 saat timer berakhir
     * 2 - memutar audio sound_timeup_2 saat timer berakhir
     * 3 - memutar audio sound_timeup_3 saat timer berakhir
     * 4 - akan menutup aplikasi saat timer berakhir
     * 
     * @param code input pengingat 
     */
    public static void setPengingat(final int code){
        codePengigatTimer = code;
    }
    
    /**
     * Berfungsi untuk menjalankan pengingat sesuai yang disetting oleh user
     */
    private void runPengingat(){
        switch(codePengigatTimer){
            case 0: System.out.println("Timer berakhir"); break;
            case 1: Sounds.playSound(Sounds.SOUND_TIMEUP_1); break;
            case 2: Sounds.playSound(Sounds.SOUND_TIMEUP_2); break;
            case 3: Sounds.playSound(Sounds.SOUND_TIMEUP_3); break;
            case 4: System.exit(0); break;
            default: JOptionPane.showMessageDialog(null, "Pengingat Error!!!"); break;
        }
    }
    
    /**
     * Berfungsi untuk menghitung detik, menit dan jam sejak timer berakhir
     */
    public void timeup(){
        
        
            new Thread(new Runnable(){
            
                @Override
                public void run(){
                    try{
                        while(true){
                            detik++;
                            if(detik > 59){
                                detik = 0;
                                menit++;
                                if(menit > 59){
                                    menit = 0;
                                    jam++;
                                }
                            }
                            Thread.sleep(1000);
                            lblTimeUp.setText(String.format("%,02d : %,02d : %,02d", jam, menit, detik));
                        }
                    }catch(InterruptedException iex){
                        JOptionPane.showMessageDialog(null, "Terjadi kesalahan!! \nDi class com.window.WindowTimeUp.java\n"+iex);
                    }
                }
            }).start();
    }
    
    /**
     * Berfungsi untuk memberi efek text pada lblTop
     */
    public void lblTopEfek(){
        
        new Thread(new Runnable(){
        
            @Override
            public void run(){
                try{
                    while(true){
                        lblTop.setText("Timer beakhir");
                        Thread.sleep(300);
                        lblTop.setText("Timer beakhir.");
                        Thread.sleep(300);
                        lblTop.setText("Timer beakhir..");
                        Thread.sleep(300);
                        lblTop.setText("Timer beakhir...");
                        Thread.sleep(300);
                    }
                }catch(InterruptedException iex){
                    
                }
            }
        }).start();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        lblTop = new javax.swing.JLabel();
        lblTimeUp = new javax.swing.JLabel();
        btnClose = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));

        lblTop.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTop.setText("Timer berakhir");

        lblTimeUp.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblTimeUp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimeUp.setText("00 : 00 : 00");
        lblTimeUp.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btnClose.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 0, 0));
        btnClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-windowtimeup-close.png"))); // NOI18N
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblTimeUp, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
            .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addComponent(lblTop, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTimeUp, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Saat user keluar dari window time up maka audio/suara yang sedang diputar akan dinonaktifkan
     * @param evt 
     */
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Sounds.stopSound();
    }//GEN-LAST:event_formWindowClosed

    /**
     * Saat user menutup window time up maka audio/suara yang sedang diputar akan dinonaktifkan
     * @param evt 
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Sounds.stopSound();
        dispose();
    }//GEN-LAST:event_formWindowClosing

    /**
     * Saat user mengklik tombol close maka audio/suara yang sedang diputar akan dinonaktifkan
     * @param evt 
     */
    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
       Sounds.stopSound();
       dispose();
    }//GEN-LAST:event_btnCloseMouseClicked

    public static void main(String args[])throws Exception{
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WindowTimeUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnClose;
    private javax.swing.JLabel lblTimeUp;
    private javax.swing.JLabel lblTop;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
}
