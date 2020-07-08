package com.window;

import com.main.Main;
import com.media.Sounds;
import com.time.Times;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 * Class ini digunakan untuk menampilkan data seperti info cuaca, lokasi jam dan tanggal saat ini.
 * Class juga digunakan untuk menampilkan total milis, detik, menit, jam, hari, minggu, dan bulan sejak tanggal 1 Jan hingga saat ini
 *
 * @author Achmad Baihaqi
 * @since 08 July 2020
 */
public class WindowJam extends javax.swing.JFrame {

    public WindowJam() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setTitle("Jam ~ "+ Main.getAppName()+Main.getAppVersi());
        this.setIconImage(Main.windowIcon());

        // digunakan untuk mengatur text pada label 
        this.lblJumlahBulan.setText(lblJumlahBulan.getText()+Times.jTahunNow);
        this.lblJumlahMinggu.setText(lblJumlahMinggu.getText()+Times.jTahunNow);
        this.lblJumlahHari.setText(lblJumlahHari.getText()+Times.jTahunNow);
        this.lblJumlahJam.setText(lblJumlahJam.getText()+Times.jTahunNow);
        this.lblJumlahMenit.setText(lblJumlahMenit.getText()+Times.jTahunNow);
        this.lblJumlahDetik.setText(lblJumlahDetik.getText()+Times.jTahunNow);
        this.lblJumlahMilis.setText(lblJumlahMilis.getText()+Times.jTahunNow);
        this.lblUcapan.setText(Times.ucapanSelamat());
        this.randomCuaca(); // untuk mendapatkan info random tentang cuaca dan suhu
        
            // digunkan untuk mendapatkan data jam dan tanggal saat ini dan menampilkan datanya ke window
            new Thread(new Runnable(){
            
                @Override
                public void run(){
                    try{
                        // akan mengupdate data sampai aplikasi diclose
                        while(true){
                            lblTanggal.setText(Times.getTanggalValue());
                            lblJam.setText(Times.getJamValue());
                            Thread.sleep(500); // data jam dan tanggal akan diupdate setiap 500 millisecond
                        }
                    }catch(InterruptedException iex){
                        Sounds.playSound(Sounds.SOUND_ERROR);
                        JOptionPane.showMessageDialog(null, "Terjadi kesalahan!! \nDi class com.window.WindowJam.java\n"+iex);
                    }
                }
            }).start();
           
            // digunkan untuk mendapatkan data total millis, detik, menit, jam, hari, minggu dan bulan sejak 1 jan ke window
            new Thread(new Runnable() {
                
                @Override
                public void run(){
                    try{
                        // akan mengupdate data sampai applikasi diclose
                        while(true){
                            // menampilkan data ke window
                            lblJumlahBulanValue.setText(String.format("%,d", Times.jBulanTotal));
                            lblJumlahMingguValue.setText(String.format("%,d", Times.jMingguTotal));
                            lblJumlahHariValue.setText(String.format("%,d", Times.jHariTotal));
                            lblJumlahJamValue.setText(String.format("%,d", Times.jJamTotal));
                            lblJumlahMenitValue.setText(String.format("%,d", Times.jMenitTotal));
                            lblJumlahDetikValue.setText(String.format("%,d", Times.jDetikTotal));
                            lblJumlahMilisValue.setText(String.format("%,d", Times.jMillisTotal));

                            Thread.sleep(10); // data akan diupdate setiap 1 millisecond
                        }
                    }catch(InterruptedException iex){
                        Sounds.playSound(Sounds.SOUND_ERROR);
                        JOptionPane.showMessageDialog(null, "Terjadi kesalahan!! \nDi class com.window.WindowTimer.java\n"+iex);
                    }
                    
                }
            }).start();
    }

    /**
     * Method ini digunakan untuk mendapatkan informasi cuaca secara random.
     * Cuaca pada applikasi ini terdari dari 10 jenis antara lain:
     * Berangin, Berawan, Cerah, Cerah berawan, Gerimis, Hujan, Hujan lebat, Hujan salju, Hujan petir, Tornaso
     */
    private void randomCuaca(){

       Random rand = new Random();
       int rands = -1;
       String direktori = "/com/media/icons/"; // directory icon cuaca
       // nama file icon cuaca pada siang hari, dan malam hari
       String[] cuacaSiang = new String[]{"ic-windowjam-cuaca-berangin-siang", "ic-windowjam-cuaca-berawan-siang", "ic-windowjam-cuaca-cerah-siang",
                                          "ic-windowjam-cuaca-cerahberawan-siang", "ic-windowjam-cuaca-gerimis-siang", "ic-windowjam-cuaca-hujan-siang",
                                          "ic-windowjam-cuaca-hujanlebat-siang", "ic-windowjam-cuaca-hujansalju-siang", "ic-windowjam-cuaca-petir-siang", "ic-windowjam-cuaca-tornado-siang"
                                        },
                cuacaMalam = new String[]{"ic-windowjam-cuaca-berangin-malam", "ic-windowjam-cuaca-berawan-malam", "ic-windowjam-cuaca-cerah-malam",
                                          "ic-windowjam-cuaca-cerahberawan-malam", "ic-windowjam-cuaca-gerimis-malam", "ic-windowjam-cuaca-hujan-malam",
                                          "ic-windowjam-cuaca-hujanlebat-malam", "ic-windowjam-cuaca-hujansalju-malam", "ic-windowjam-cuaca-petir-malam", "ic-windowjam-cuaca-tornado-malam"
                                        };
            // merandom cuaca
            for(int i = 0; i < Times.jDetikNow+1; i++){
               rands = rand.nextInt(10);
           }
          
            // digunakan untuk mengatur icon sesuai dari hasil random
            if(Times.jJamNow >= 6 && Times.jJamNow < 19){
                this.lblCuaca.setIcon(new javax.swing.ImageIcon(getClass().getResource(direktori+cuacaSiang[rands]+".png")));
            }else if(Times.jJamNow >= 19 && Times.jJamNow > 0 || Times.jJamNow <6){
                this.lblCuaca.setIcon(new javax.swing.ImageIcon(getClass().getResource(direktori+cuacaMalam[rands]+".png")));
            }else{
                this.lblCuaca.setIcon(null);
                this.lblCuaca.setText("ERROR");
            }
            
            // mendapatkan nama cuaca sesuai dari hasil random
            switch(rands){
                case 0: this.lblKetCuaca.setText("Berangin"); this.lblSuhu.setText("23° C"); break;
                case 1: this.lblKetCuaca.setText("Berawan"); this.lblSuhu.setText("20° C"); break;
                case 2: this.lblKetCuaca.setText("Cerah"); this.lblSuhu.setText("27° C"); break;
                case 3: this.lblKetCuaca.setText("Cerah Berawan"); this.lblSuhu.setText("25° C"); break;
                case 4: this.lblKetCuaca.setText("Gerimis"); this.lblSuhu.setText("19° C"); break;
                case 5: this.lblKetCuaca.setText("Hujan"); this.lblSuhu.setText("18° C"); break;
                case 6: this.lblKetCuaca.setText("Hujan Deras"); this.lblSuhu.setText("15° C"); break;    
                case 7: this.lblKetCuaca.setText("Hujan Salju"); this.lblSuhu.setText("5° C"); break;
                case 8: this.lblKetCuaca.setText("Hujan Petir"); this.lblSuhu.setText("12° C"); break;
                case 9: this.lblKetCuaca.setText("Tornado"); this.lblSuhu.setText("7° C"); break;
                default : this.lblKetCuaca.setText("ERROR"); this.lblSuhu.setText("ERROR° ERROR"); break;
            }
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
        lblTanggal = new javax.swing.JLabel();
        lblLokasi = new javax.swing.JLabel();
        lblJam = new javax.swing.JLabel();
        lblCuaca = new javax.swing.JLabel();
        line1 = new javax.swing.JSeparator();
        lblSuhu = new javax.swing.JLabel();
        lblKetCuaca = new javax.swing.JLabel();
        lblJumlahMinggu = new javax.swing.JLabel();
        lblJumlahHari = new javax.swing.JLabel();
        lblJumlahJam = new javax.swing.JLabel();
        lblJumlahMenit = new javax.swing.JLabel();
        lblJumlahDetik = new javax.swing.JLabel();
        lblJumlahMilis = new javax.swing.JLabel();
        lblHelp1 = new javax.swing.JLabel();
        lblJumlahMingguValue = new javax.swing.JLabel();
        lblHelp2 = new javax.swing.JLabel();
        lblJumlahHariValue = new javax.swing.JLabel();
        lblHelp3 = new javax.swing.JLabel();
        lblJumlahJamValue = new javax.swing.JLabel();
        lblHelp4 = new javax.swing.JLabel();
        lblJumlahMenitValue = new javax.swing.JLabel();
        lblHelp5 = new javax.swing.JLabel();
        lblJumlahDetikValue = new javax.swing.JLabel();
        lblHelp6 = new javax.swing.JLabel();
        lblJumlahMilisValue = new javax.swing.JLabel();
        lblJumlahBulan = new javax.swing.JLabel();
        lblHelp8 = new javax.swing.JLabel();
        lblJumlahBulanValue = new javax.swing.JLabel();
        lblCopyright = new javax.swing.JLabel();
        lblUcapan = new javax.swing.JLabel();
        lblRatting = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

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

        lblTanggal.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        lblTanggal.setText("Senin, 04 Agustus 2003");

        lblLokasi.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblLokasi.setForeground(new java.awt.Color(28, 28, 28));
        lblLokasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-windowjam-lokasi.png"))); // NOI18N
        lblLokasi.setText("Jatim, Indonesia");

        lblJam.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblJam.setForeground(new java.awt.Color(23, 22, 22));
        lblJam.setText("07:30:00");

        lblCuaca.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCuaca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-windowjam-cuaca-hujansalju-siang.png"))); // NOI18N

        line1.setBackground(new java.awt.Color(0, 0, 0));
        line1.setForeground(new java.awt.Color(0, 0, 0));
        line1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblSuhu.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblSuhu.setForeground(new java.awt.Color(208, 54, 54));
        lblSuhu.setText("-2° C");

        lblKetCuaca.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblKetCuaca.setForeground(new java.awt.Color(25, 97, 200));
        lblKetCuaca.setText("Hujan salju");

        lblJumlahMinggu.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblJumlahMinggu.setForeground(new java.awt.Color(14, 24, 28));
        lblJumlahMinggu.setText("Jumlah minggu sejak 1 Jan ");

        lblJumlahHari.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblJumlahHari.setForeground(new java.awt.Color(14, 24, 28));
        lblJumlahHari.setText("Jumlah hari sejak  1 Jan ");

        lblJumlahJam.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblJumlahJam.setForeground(new java.awt.Color(14, 24, 28));
        lblJumlahJam.setText("Jumlah jam sejak 1 Jan ");

        lblJumlahMenit.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblJumlahMenit.setForeground(new java.awt.Color(14, 24, 28));
        lblJumlahMenit.setText("Jumlah menit sejak 1 Jan ");

        lblJumlahDetik.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblJumlahDetik.setForeground(new java.awt.Color(14, 24, 28));
        lblJumlahDetik.setText("Jumlah detik sejak 1 Jan ");

        lblJumlahMilis.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblJumlahMilis.setForeground(new java.awt.Color(14, 24, 28));
        lblJumlahMilis.setText("Jumlah milis sejak 1 Jan ");

        lblHelp1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblHelp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHelp1.setText(":");

        lblJumlahMingguValue.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblJumlahMingguValue.setForeground(new java.awt.Color(14, 24, 28));
        lblJumlahMingguValue.setText("12");

        lblHelp2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblHelp2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHelp2.setText(":");

        lblJumlahHariValue.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblJumlahHariValue.setForeground(new java.awt.Color(14, 24, 28));
        lblJumlahHariValue.setText("84");

        lblHelp3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblHelp3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHelp3.setText(":");

        lblJumlahJamValue.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblJumlahJamValue.setForeground(new java.awt.Color(14, 24, 28));
        lblJumlahJamValue.setText("2,016");

        lblHelp4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblHelp4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHelp4.setText(":");

        lblJumlahMenitValue.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblJumlahMenitValue.setForeground(new java.awt.Color(14, 24, 28));
        lblJumlahMenitValue.setText("120,960");

        lblHelp5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblHelp5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHelp5.setText(":");

        lblJumlahDetikValue.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblJumlahDetikValue.setForeground(new java.awt.Color(14, 24, 28));
        lblJumlahDetikValue.setText("7,257,600");

        lblHelp6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblHelp6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHelp6.setText(":");

        lblJumlahMilisValue.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblJumlahMilisValue.setForeground(new java.awt.Color(14, 24, 28));
        lblJumlahMilisValue.setText("7,257,600,000");

        lblJumlahBulan.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblJumlahBulan.setForeground(new java.awt.Color(14, 24, 28));
        lblJumlahBulan.setText("Jumlah bulan sejak 1 Jan ");

        lblHelp8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblHelp8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHelp8.setText(":");

        lblJumlahBulanValue.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblJumlahBulanValue.setForeground(new java.awt.Color(14, 24, 28));
        lblJumlahBulanValue.setText("6");

        lblCopyright.setForeground(new java.awt.Color(76, 92, 126));
        lblCopyright.setText("Copyright@ achmad baihaqi 2020.");

        lblUcapan.setForeground(new java.awt.Color(3, 2, 2));
        lblUcapan.setText("Selamat Pagi...");
        lblUcapan.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblRatting.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblRatting.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRatting.setText("Beri nilai applikasi??");
        lblRatting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRattingMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlMainLayout.createSequentialGroup()
                                        .addComponent(lblCuaca, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblKetCuaca, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblSuhu, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(lblLokasi, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblJam, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblUcapan, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblCopyright)
                        .addGap(7, 7, 7)))
                .addComponent(line1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblJumlahMinggu, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(lblJumlahHari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblJumlahJam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblJumlahMenit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblJumlahDetik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblJumlahMilis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblJumlahBulan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addComponent(lblHelp2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblJumlahHariValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                                .addComponent(lblHelp3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblJumlahJamValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                                .addComponent(lblHelp4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblJumlahMenitValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                                .addComponent(lblHelp5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblJumlahDetikValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                                .addComponent(lblHelp6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblJumlahMilisValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblHelp1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblHelp8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlMainLayout.createSequentialGroup()
                                        .addComponent(lblJumlahBulanValue, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(lblJumlahMingguValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblRatting, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(line1)
                        .addContainerGap())
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblJam, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblLokasi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addComponent(lblSuhu)
                                .addGap(11, 11, 11)
                                .addComponent(lblKetCuaca))
                            .addComponent(lblCuaca))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUcapan, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCopyright))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblHelp8)
                        .addComponent(lblJumlahBulanValue))
                    .addComponent(lblJumlahBulan, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJumlahMinggu)
                    .addComponent(lblHelp1)
                    .addComponent(lblJumlahMingguValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJumlahHari)
                    .addComponent(lblHelp2)
                    .addComponent(lblJumlahHariValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJumlahJam)
                    .addComponent(lblHelp3)
                    .addComponent(lblJumlahJamValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJumlahMenit)
                    .addComponent(lblHelp4)
                    .addComponent(lblJumlahMenitValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJumlahDetik)
                    .addComponent(lblHelp5)
                    .addComponent(lblJumlahDetikValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJumlahMilis)
                    .addComponent(lblHelp6)
                    .addComponent(lblJumlahMilisValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRatting)
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    private void btnJamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnJamMouseClicked

        
    }//GEN-LAST:event_btnJamMouseClicked

    /**
     * Untuk membuka window stopwatch saat tombol stopwatch diklik
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
                if(WindowSetTimer.isTimerStart){ // jika timer sedang aktif
                    WindowTimer timer = new WindowTimer();
                    timer.setLocation(getX(), getY());
                    timer.setVisible(true);
                    dispose();
                }else{  // jika timer tidak aktif
                    WindowSetTimer setTimer = new WindowSetTimer();
                    setTimer.setLocation(getX(), getY());
                    setTimer.setVisible(true);
                    dispose();
                }
            }
        });
                

        
    }//GEN-LAST:event_btnTimerMouseClicked
    /**
     * Untuk membuka window ratting saat tombol ratting diklik
     * @param evt 
     */
    private void lblRattingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRattingMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable(){
        
            @Override
            public void run(){
                WindowRatting r = new WindowRatting();
                r.setLocation(getX(), getY());
                r.setVisible(true);
                dispose();
            }
        });
    }//GEN-LAST:event_lblRattingMouseClicked


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable(){
        
            @Override
            public void run(){
                new WindowJam().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnJam;
    private javax.swing.JLabel btnStopwatch;
    private javax.swing.JLabel btnTimer;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblCopyright;
    private javax.swing.JLabel lblCuaca;
    private javax.swing.JLabel lblHelp1;
    private javax.swing.JLabel lblHelp2;
    private javax.swing.JLabel lblHelp3;
    private javax.swing.JLabel lblHelp4;
    private javax.swing.JLabel lblHelp5;
    private javax.swing.JLabel lblHelp6;
    private javax.swing.JLabel lblHelp8;
    private javax.swing.JLabel lblJam;
    private javax.swing.JLabel lblJumlahBulan;
    private javax.swing.JLabel lblJumlahBulanValue;
    private javax.swing.JLabel lblJumlahDetik;
    private javax.swing.JLabel lblJumlahDetikValue;
    private javax.swing.JLabel lblJumlahHari;
    private javax.swing.JLabel lblJumlahHariValue;
    private javax.swing.JLabel lblJumlahJam;
    private javax.swing.JLabel lblJumlahJamValue;
    private javax.swing.JLabel lblJumlahMenit;
    private javax.swing.JLabel lblJumlahMenitValue;
    private javax.swing.JLabel lblJumlahMilis;
    private javax.swing.JLabel lblJumlahMilisValue;
    private javax.swing.JLabel lblJumlahMinggu;
    private javax.swing.JLabel lblJumlahMingguValue;
    private javax.swing.JLabel lblKetCuaca;
    private javax.swing.JLabel lblLokasi;
    private javax.swing.JLabel lblRatting;
    private javax.swing.JLabel lblSuhu;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JLabel lblUcapan;
    private javax.swing.JSeparator line1;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlTop;
    // End of variables declaration//GEN-END:variables
}
