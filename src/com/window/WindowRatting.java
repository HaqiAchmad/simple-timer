package com.window;

import com.main.Main;
import com.media.Sounds;

import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;

import java.awt.Cursor;
import java.net.Socket;
import java.net.InetSocketAddress;
import java.util.Properties;
import javax.swing.JOptionPane;


/**
 * Digunakan untuk mendapatkan ratting yang diberikan user terhadap applikasi ini
 * Ratting dari user akan dikirimkan lewat gmail
 * 
 * @author Achmad baihaqi
 * @since 08 July 2020
 */
public class WindowRatting extends javax.swing.JFrame {

    /**
     * Ratting yang diberikan user, defaultnya adalah 0
     */
    private int starValue = 0;
    /**
     * Gmail dan password yang akan digunakan untuk mengirimkan ratting dari user
     */
    private static final String GMAIL = "baihaqi.myapps@gmail.com",
                                    PASSWORD = "androidevelopers2020";

    public WindowRatting() {
        initComponents();
        this.lblEmot.setText("");
        
        this.setTitle("Ratting ~ "+Main.getAppName()+Main.getAppVersi());
        this.setIconImage(Main.windowIcon());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
    }
    
    /**
     * Digunakan untuk mengirimkan ratting dari user ke hakiahmad756@gmail.com
     * 
     * @param recipient ratting akan dikirimkan ke hakiahmad756@gmail.com
     * @param subject berisi ratting dari user
     * @param htmlcode berisi masukan dari user
     * @throws Exception 
     */
    public void sendGmail(String recipient, String subject, String htmlcode) throws Exception{
        
        System.out.println("Mengirim email ke " + recipient);
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "SET");
        
        Session session = Session.getInstance(properties, new Authenticator(){
        
            @Override 
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(GMAIL, PASSWORD);
            }
        
        });
        
        Message message = prepareMessage(session, recipient, subject, htmlcode);
        Transport.send(message);
        System.out.println("Email sukses terkirim");
        
    }
    
    /**
     * Berfungsi untuk membuat pesan ke hakiahmad756@gmail.com 
     * 
     * @param session
     * @param recipient
     * @param subject
     * @param htmlcode
     * @return 
     */
    private Message prepareMessage(Session session, String recipient, String subject, String htmlcode){
    
        try{
        
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(GMAIL));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subject);
            message.setContent(htmlcode, "text/html");
            return message;
            

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnNanti = new javax.swing.JButton();
        btnKirim = new javax.swing.JButton();
        lblNama = new javax.swing.JLabel();
        lblRating = new javax.swing.JLabel();
        inputNama = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputMasukan = new javax.swing.JTextArea();
        lblMasukan = new javax.swing.JLabel();
        star4 = new javax.swing.JLabel();
        star1 = new javax.swing.JLabel();
        star2 = new javax.swing.JLabel();
        star3 = new javax.swing.JLabel();
        star5 = new javax.swing.JLabel();
        lblEmot = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnNanti.setBackground(new java.awt.Color(193, 193, 193));
        btnNanti.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnNanti.setForeground(new java.awt.Color(5, 5, 5));
        btnNanti.setText("Nanti");
        btnNanti.setBorder(null);
        btnNanti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNantiActionPerformed(evt);
            }
        });

        btnKirim.setBackground(new java.awt.Color(193, 193, 193));
        btnKirim.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnKirim.setForeground(new java.awt.Color(5, 5, 5));
        btnKirim.setText("Kirim");
        btnKirim.setBorder(null);
        btnKirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKirimActionPerformed(evt);
            }
        });

        lblNama.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNama.setText(" Nama kamu");

        lblRating.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblRating.setText(" Ratting");

        inputNama.setBackground(new java.awt.Color(250, 250, 250));
        inputNama.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        inputMasukan.setBackground(new java.awt.Color(250, 250, 250));
        inputMasukan.setColumns(20);
        inputMasukan.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        inputMasukan.setRows(5);
        jScrollPane1.setViewportView(inputMasukan);

        lblMasukan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMasukan.setText(" Masukan");

        star4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        star4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        star4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star.png"))); // NOI18N
        star4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                star4MouseClicked(evt);
            }
        });

        star1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        star1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        star1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star.png"))); // NOI18N
        star1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                star1MouseClicked(evt);
            }
        });

        star2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        star2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        star2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star.png"))); // NOI18N
        star2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                star2MouseClicked(evt);
            }
        });

        star3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        star3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        star3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star.png"))); // NOI18N
        star3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                star3MouseClicked(evt);
            }
        });

        star5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        star5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        star5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star.png"))); // NOI18N
        star5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                star5MouseClicked(evt);
            }
        });

        lblEmot.setText("Sangat Suka");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNama, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                            .addComponent(inputNama)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblRating, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblEmot, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(star1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(star2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(star3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(star4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(star5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(btnNanti, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnKirim, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(14, 14, 14))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(lblMasukan, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 311, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputNama, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRating, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(star1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(star2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(star3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(star4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(star5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmot, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNanti, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKirim, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(61, 61, 61)
                    .addComponent(lblMasukan, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(190, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Digunakan untuk mengecek apakah user tersambung ke inernet atau tidak
     * 
     * @return user tersambung ke inernet atau tidak
     */
    public boolean isConnectInternet(){
        Socket s = new Socket();
        InetSocketAddress inet = new InetSocketAddress("www.google.com", 80);
        
            try{
                s.connect(inet, 1000);
                return true;
            }catch(Exception ex){
                return false;
            }finally{
                try{
                    s.close();
                }catch(Exception ex){

                }
            }
    }
    
    /**
     * Digunakan untuk mengirimkan ratting dari user 
     * Sebelum mengirimkan ratting user harus memenuhi beberapa kriteria untuk mengirimkan ratting antara lain;
     * - input nama tidak boleh kosong
     * - ratting tidak boleh kosong 
     * - user harus terhubung ke internet
     * 
     * @param evt 
     */
    private void btnKirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKirimActionPerformed
        this.setCursor(new java.awt.Cursor(Cursor.WAIT_CURSOR)); // mengset cursor ke wait/loading
        
        if(this.inputNama.getText().length() < 1){ // mengecek apakah input nama kosong atau tidak
            Sounds.playSound(Sounds.SOUND_NOTIF);
            JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong!!");
        }else if(this.starValue == 0){
            Sounds.playSound(Sounds.SOUND_NOTIF); // mengecek apakah ratting kosong atau tidak
            JOptionPane.showMessageDialog(null, "Ratting tidak boleh kosong!!");
            javax.swing.JLabel[] lbls = new javax.swing.JLabel[]{this.star1, this.star2, this.star3, this.star4, this.star5};
            // jika ratting kosong maka input ratting akan diberikan warna merah
            for(javax.swing.JLabel lbl : lbls){
                lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star-kosong.png")));
            }
        }else if(!this.isConnectInternet()){ // mengecek apakah user terhubung ke internet 
            Sounds.playSound(Sounds.SOUND_NOTIF);
            JOptionPane.showMessageDialog(null, "Tidak terhubung ke internet!!");
        }else{ // jika user sudah memehuni semua kriteria yang ditentukan method akan menggirimkan ratting dari user 
            // membuat pesan  yang berisi rattig dan masukan dari user untuk dikirimkan 
            String nama = this.inputNama.getText(),
                   star = Integer.toString(this.starValue),
                   subject = Integer.toString(this.starValue) + " Bintang dari " + this.inputNama.getText() + " <"+Main.getAppName()+">",
                   masukan = "<h2>"+nama+" Memberi bintang " + star+"</h2>"
                            + "<h4>Masukan dari "+nama+":</h4>"
                            + "<h6> >> "+ inputMasukan.getText() + "</h6>" ;
            // mengirimkan ratting dari user ke gmail hakiahmad756@gmail.com
            try {
                this.sendGmail("hakiahmad756@gmail.com", subject, masukan);
                JOptionPane.showMessageDialog(null, "Ratting sukses terkirim...");
                this.btnKirim.setVisible(false); // jika ratting sudah terkirim maka btnKirim akan tidak terlihat dan btnNanti textnya berubah menjadi kembali
                this.btnNanti.setText("Kembali");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Gagal mengirim rating\nError message : " + ex);
            }
        }  
        this.setCursor(new java.awt.Cursor(Cursor.DEFAULT_CURSOR)); // mereset kursor
    }//GEN-LAST:event_btnKirimActionPerformed

    /**
     * Berfungsi untuk kembali ke window jam
     * @param evt 
     */
    private void btnNantiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNantiActionPerformed
        this.dispose();
        java.awt.EventQueue.invokeLater(new Runnable(){
        
            @Override
            public void run(){
                WindowJam m = new WindowJam();
                m.setLocation(getX(), getY());
                m.setVisible(true);
            }
        });
    }//GEN-LAST:event_btnNantiActionPerformed

    /**
     * Jika tombol start1 diklik maka ratting akan diset ke 1/benci
     * 
     * @param evt 
     */
    private void star1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_star1MouseClicked
         this.starValue = 1;
         this.star1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star-filled.png")));
         this.star2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star.png")));
         this.star3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star.png")));
         this.star4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star.png")));
         this.star5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star.png")));
         this.lblEmot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-emot-benci.png")));
         this.lblEmot.setText("Benci!!");
    }//GEN-LAST:event_star1MouseClicked

    /**
     * Jika tombol start2 diklik maka ratting akan diset ke 2/tidak suka
     * 
     * @param evt 
     */
    private void star2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_star2MouseClicked
         this.starValue = 2;
         this.star1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star-filled.png"))); 
         this.star2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star-filled.png"))); 
         this.star3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star.png")));
         this.star4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star.png")));
         this.star5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star.png")));
         this.lblEmot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-emot-tidaksuka.png")));
         this.lblEmot.setText("Tidak suka!");
    }//GEN-LAST:event_star2MouseClicked

    /**
     * Jika tombol start3 diklik maka ratting akan diset ke 3/lumayan
     * 
     * @param evt 
     */
    private void star3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_star3MouseClicked
         this.starValue = 3;
         this.star1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star-filled.png"))); 
         this.star2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star-filled.png")));   
         this.star3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star-filled.png")));   
         this.star4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star.png")));
         this.star5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star.png")));
         this.lblEmot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-emot-lumayan.png")));
         this.lblEmot.setText("Lumayan");
    }//GEN-LAST:event_star3MouseClicked

    /**
     * Jika tombol start4 diklik maka ratting akan diset ke 4/suka
     * 
     * @param evt 
     */
    private void star4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_star4MouseClicked
         this.starValue = 4;
         this.star1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star-filled.png"))); 
         this.star2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star-filled.png"))); 
         this.star3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star-filled.png"))); 
         this.star4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star-filled.png"))); 
         this.star5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star.png")));
         this.lblEmot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-emot-suka.png")));
         this.lblEmot.setText("Suka");
    }//GEN-LAST:event_star4MouseClicked

    /**
     * Jika tombol start5 diklik maka ratting akan diset ke 5/cinta
     * 
     * @param evt 
     */
    private void star5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_star5MouseClicked
         this.starValue = 5;
         this.star1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star-filled.png"))); 
         this.star2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star-filled.png"))); 
         this.star3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star-filled.png"))); 
         this.star4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star-filled.png"))); 
         this.star5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-star-filled.png"))); 
         this.lblEmot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-emot-sangatsuka.png")));
         this.lblEmot.setText("Cinta");
    }//GEN-LAST:event_star5MouseClicked


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WindowRatting().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKirim;
    private javax.swing.JButton btnNanti;
    private javax.swing.JTextArea inputMasukan;
    private javax.swing.JTextField inputNama;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEmot;
    private javax.swing.JLabel lblMasukan;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblRating;
    private javax.swing.JLabel star1;
    private javax.swing.JLabel star2;
    private javax.swing.JLabel star3;
    private javax.swing.JLabel star4;
    private javax.swing.JLabel star5;
    // End of variables declaration//GEN-END:variables
}
