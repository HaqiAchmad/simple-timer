package com.window;

import com.main.Main;
import com.media.Sounds;
import com.time.Times;

import javax.swing.JOptionPane;

/**
 * Class ini digunakan untuk mengambil input timer dari user
 * 
 * @author Achmad Baihaqi
 * @since 08 July 2020
 */
public class WindowSetTimer extends javax.swing.JFrame {

    /**
     * Digunakan untuk mengecek apakah timer sedang aktif atau tidak
     */
    public static boolean isTimerStart = false;
    /**
     * Digunakan untuk mengecek apakah data valid atau tidak dan untuk mengecek apakah audio sedang aktif atau nonaktif
     */
    private boolean isValidData = false, speakerOn = false;
    /**
     * Digunakan untuk menyimpan input dari user
     */
    private int hari = 0, jam = 0, menit = 0, detik = 0;
    
    public WindowSetTimer() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setTitle("Atur Timer ~ "+Main.getAppName()+Main.getAppVersi());
        this.setIconImage(Main.windowIcon());
        
        this.btnPauseAndResume.setText("");
        this.btnReset.setText("");
        this.lblErrorJam.setText("");
        this.lblErrorMenit.setText("");
        this.lblErrorDetik.setText("");
        
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
        lblTimer1 = new javax.swing.JLabel();
        inputJam = new javax.swing.JTextField();
        lineHour = new javax.swing.JSeparator();
        inputMenit = new javax.swing.JTextField();
        lineMenit = new javax.swing.JSeparator();
        lblTimer4 = new javax.swing.JLabel();
        inputDetik = new javax.swing.JTextField();
        lineDetik = new javax.swing.JSeparator();
        lblTimer5 = new javax.swing.JLabel();
        lblErrorJam = new javax.swing.JLabel();
        lblErrorMenit = new javax.swing.JLabel();
        lblErrorDetik = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        inputPengingat = new javax.swing.JComboBox();
        lblPengingat = new javax.swing.JLabel();
        lblSpeaker = new javax.swing.JLabel();
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

        lblTimer1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTimer1.setForeground(new java.awt.Color(36, 104, 204));
        lblTimer1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTimer1.setText("Hour");
        lblTimer1.setMaximumSize(new java.awt.Dimension(60, 62));
        lblTimer1.setMinimumSize(new java.awt.Dimension(60, 62));
        lblTimer1.setPreferredSize(new java.awt.Dimension(60, 62));

        inputJam.setFont(new java.awt.Font("Dialog", 0, 32)); // NOI18N
        inputJam.setForeground(new java.awt.Color(18, 15, 15));
        inputJam.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputJam.setBorder(null);
        inputJam.setCaretColor(new java.awt.Color(20, 19, 19));
        inputJam.setMaximumSize(new java.awt.Dimension(60, 62));
        inputJam.setScrollOffset(3);
        inputJam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputJamKeyTyped(evt);
            }
        });

        lineHour.setBackground(new java.awt.Color(0, 0, 0));

        inputMenit.setFont(new java.awt.Font("Dialog", 0, 32)); // NOI18N
        inputMenit.setForeground(new java.awt.Color(18, 15, 15));
        inputMenit.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputMenit.setBorder(null);
        inputMenit.setCaretColor(new java.awt.Color(20, 19, 19));
        inputMenit.setMaximumSize(new java.awt.Dimension(60, 62));
        inputMenit.setScrollOffset(3);
        inputMenit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputMenitKeyTyped(evt);
            }
        });

        lineMenit.setBackground(new java.awt.Color(0, 0, 0));

        lblTimer4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTimer4.setForeground(new java.awt.Color(214, 34, 41));
        lblTimer4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTimer4.setText("Min");
        lblTimer4.setMaximumSize(new java.awt.Dimension(60, 62));
        lblTimer4.setMinimumSize(new java.awt.Dimension(60, 62));
        lblTimer4.setPreferredSize(new java.awt.Dimension(60, 62));

        inputDetik.setFont(new java.awt.Font("Dialog", 0, 32)); // NOI18N
        inputDetik.setForeground(new java.awt.Color(18, 15, 15));
        inputDetik.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputDetik.setBorder(null);
        inputDetik.setCaretColor(new java.awt.Color(20, 19, 19));
        inputDetik.setMaximumSize(new java.awt.Dimension(60, 62));
        inputDetik.setScrollOffset(3);
        inputDetik.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputDetikKeyTyped(evt);
            }
        });

        lineDetik.setBackground(new java.awt.Color(0, 0, 0));

        lblTimer5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTimer5.setForeground(new java.awt.Color(77, 84, 102));
        lblTimer5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTimer5.setText("Sec");
        lblTimer5.setMaximumSize(new java.awt.Dimension(60, 62));
        lblTimer5.setMinimumSize(new java.awt.Dimension(60, 62));
        lblTimer5.setPreferredSize(new java.awt.Dimension(60, 62));

        lblErrorJam.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lblErrorJam.setForeground(new java.awt.Color(204, 48, 48));
        lblErrorJam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblErrorJam.setText("Harus dalam bentuk number");

        lblErrorMenit.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lblErrorMenit.setForeground(new java.awt.Color(204, 48, 48));
        lblErrorMenit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblErrorMenit.setText("Harus dalam bentuk number");

        lblErrorDetik.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lblErrorDetik.setForeground(new java.awt.Color(204, 48, 48));
        lblErrorDetik.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblErrorDetik.setText("Harus dalam bentuk number");

        jLabel1.setForeground(new java.awt.Color(76, 92, 126));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Copyright@ achmad baihaqi 2020.");

        inputPengingat.setBackground(new java.awt.Color(253, 241, 241));
        inputPengingat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tidak ada", "Suara 1", "Suara 2", "Suara 3", "Tutup Aplikasi" }));
        inputPengingat.setMaximumSize(new java.awt.Dimension(110, 32767));
        inputPengingat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputPengingatMouseClicked(evt);
            }
        });

        lblPengingat.setText(" Setel Pengingat");

        lblSpeaker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-windowsettimer-noaudio.png"))); // NOI18N
        lblSpeaker.setMaximumSize(new java.awt.Dimension(54, 14));
        lblSpeaker.setMinimumSize(new java.awt.Dimension(54, 14));
        lblSpeaker.setPreferredSize(new java.awt.Dimension(44, 24));
        lblSpeaker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSpeakerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblPengingat, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inputPengingat, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSpeaker, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lineHour)
                            .addComponent(inputJam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblTimer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblErrorJam, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lineMenit)
                            .addComponent(inputMenit, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblTimer4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblErrorMenit, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lineDetik)
                            .addComponent(inputDetik, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblTimer5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblErrorDetik, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTimer5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(inputDetik, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lineDetik, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTimer1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addComponent(inputJam, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lineHour, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTimer4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addComponent(inputMenit, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lineMenit, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblErrorJam, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblErrorMenit, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblErrorDetik, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPengingat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputPengingat, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lblSpeaker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1))
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
        btnReset.setText("Stop");
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
     * Digunakan untuk mengecek apakah yang diinputkan user mengandung karaktrer selain number atau tidak
     * @param data input yang akan dicek
     * @return 
     */
    private boolean containChar(String data){
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ`~!@#$%^&*()-=\\_+|[]{};':\",.<>/? ";
        char a, b;    
            for(int i = 0; i < chars.length(); i++){ // mencocokan karakter dengan var chars
                for(int j = 0; j < data.length(); j++){  // mengecek 1 per 1 karakter
                    a = chars.charAt(i); b = data.charAt(j);
                        if(a == b){ // jika ditemukan karakter lain selain number
                            return true;
                        }
                }
            }
        return false;
    }
    
    /**
     * Method ini digunakan untuk memulai timer
     * Sebelumnya method akan mengecek apakah input yang dimasukan user valid atau tidak 
     * Jika tidak valid maka method akan menampilkan pesan error ke window
     * Jika valid maka method akan menjalankan stopwatch
     * 
     * Input valid apabila memenuhi kriteria berikut
     * - input jam, menit, detik hanya berupa number
     * - input jam, menit, detik tidak boleh kosong
     * - input menit dan detik hanya dapat berkisar antara 0-59 saja
     * - input jam hanya dapat berkisar antara 0-9999 saja
     * - input timer minimum adalah 0 jam 0 menit 6 detik
     * - input timer maximum adalah 9999 jam 59 menit 59 detik
     * 
     * @param evt 
     */
    private void btnMulaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMulaiMouseClicked
        Sounds.stopSound(); // menonaktifkan audio/suara jika sedang diaktifkan
        // jika input yang dimasukan user tidak valid
        if(!isValidData){
            
            // mengecek input jam valid atau tidak
            if(inputJam.getText().length() <= 0){
                this.isValidData = false;
                inputJam.setText("0");
            }else if(this.containChar(inputJam.getText())){
                this.isValidData = false;
                this.lblErrorJam.setText("Harus dalam bentuk number");
            }else{
                this.isValidData = true;
                this.lblErrorJam.setText("");
            }

            // mengecek input menit valid atau tidak
            if(inputMenit.getText().length() <= 0){
                this.isValidData = false;
                inputMenit.setText("0");
            }else if(this.containChar(inputMenit.getText())){
                this.isValidData = false;
                this.lblErrorMenit.setText("Harus dalam bentuk number");
            }else if((Integer.parseInt(inputMenit.getText())) > 59 || (Integer.parseInt(inputMenit.getText())) < 0){
                this.isValidData = false;
                this.lblErrorMenit.setText("Input harus diantara 0-59 menit");
            }else{
                this.isValidData = true;
                this.lblErrorMenit.setText("");
            }
            
            // mengecek input detik valid atau tidak
            if(inputDetik.getText().length() <= 0){
                this.isValidData = false;
                inputDetik.setText("0");
            }else if(this.containChar(inputDetik.getText())){
                this.isValidData = false;
                this.lblErrorDetik.setText("Harus dalam bentuk number");
            }else if((Integer.parseInt(inputDetik.getText())) > 59 || (Integer.parseInt(inputDetik.getText())) < 0){
                this.isValidData = false;
                this.lblErrorDetik.setText("Input harus diantara 0-59 menit");
            }else{
                this.isValidData = true;
                this.lblErrorDetik.setText("");
            }
            
            // mengecek apakah input pada timer kurang dari 6 detik atau tidak 
            if(Integer.parseInt(inputJam.getText()) <= 0 && Integer.parseInt(inputMenit.getText()) <= 0 && Integer.parseInt(inputDetik.getText()) <= 5 ){
                this.isValidData = false;
                Sounds.playSound(Sounds.SOUND_NOTIF);
                JOptionPane.showMessageDialog(null, String.format("Input tidak valid\n00 jam 00 menit %02d detik\n"
                                                                 + "Minimal input : 00 jam 00 menit 06 detik\n"
                                                                 + "Maximal input : 9999 jam 59 menit 59 detik",
                                              Integer.parseInt(inputDetik.getText()) 
                ));
            }
            
        }else{ // jika input yang dimasukan user valid
            isTimerStart = true; // mengaktifkan timer
            Times.timerStart = true;
            WindowTimeUp.setPengingat(this.inputPengingat.getSelectedIndex()); // mengatur pengingat saat timer berakhir
            Sounds.playSound(Sounds.SOUND_BTN_START);
            Sounds.stopSound();
            jam = Integer.parseInt(inputJam.getText());
            menit = Integer.parseInt(inputMenit.getText());
            detik = Integer.parseInt(inputDetik.getText());
            
                // mengecek apakah input lebih dari 23 jam atau tidak
                if(jam > 23){ // jika lebih dari 23
                    hari = jam/24; // menghitung jumlah hari 
                    jam = jam - (hari*24); // menghitung jumlah jam
                    Times.setTimerValue(hari, jam, menit, detik);
                    
                    // menampilkan window timer dan memulai timer
                    java.awt.EventQueue.invokeLater(new Runnable(){

                        @Override
                        public void run(){
                            WindowTimer timer = new WindowTimer(hari, jam, menit, detik);
                            timer.setLocation(getX(), getY());
                            timer.setVisible(true);
                            dispose();
                        }
                    });
                }else{ // jika kurang 
                    Times.setTimerValue(hari, jam, menit, detik);
                    
                    // menampilkan window timer dan memulai timer
                    java.awt.EventQueue.invokeLater(new Runnable(){

                        @Override
                        public void run(){
                            WindowTimer timer = new WindowTimer(hari, jam, menit, detik);
                            timer.setLocation(getX(), getY());
                            timer.setVisible(true);
                            dispose();
                        }
                    });
                }
            
        }
        

    }//GEN-LAST:event_btnMulaiMouseClicked


    private void btnPauseAndResumeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPauseAndResumeMouseClicked

    }//GEN-LAST:event_btnPauseAndResumeMouseClicked

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked

    }//GEN-LAST:event_btnResetMouseClicked

    /**
     * Digunakan untuk mengatur maximum input yang dimasukan user saat minginputkan jam, menit, detik
     * Jika user menginputkan number lebih dari maximum length yang ditentukan maka text field akan diset ke ""
     * 
     * @param txt text field yang akan diatur maximum inputnya
     * @param minimumLength maximum length yang ditentukan
     */
    private void setMaximumLength(javax.swing.JTextField txt, int minimumLength){
        if(txt.getText().length() > minimumLength){
           txt.setText(""); 
        }
    }
    
    /**
     * mengatur maximum dari input menit ke 2
     * @param evt 
     */
    private void inputMenitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputMenitKeyTyped
        this.setMaximumLength(inputMenit, 1);
    }//GEN-LAST:event_inputMenitKeyTyped

    /**
     * mengatur maximum dari input detik ke 2
     * @param evt 
     */
    private void inputDetikKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputDetikKeyTyped
        this.setMaximumLength(inputDetik, 1);
    }//GEN-LAST:event_inputDetikKeyTyped

    /**
     * mengatur maximum dari input jam ke 4
     * @param evt 
     */
    private void inputJamKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputJamKeyTyped
        this.setMaximumLength(inputJam, 3);
    }//GEN-LAST:event_inputJamKeyTyped

    /**
     * Untuk membuka window jam saat tombol jam diklik
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

    private void btnTimerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimerMouseClicked
       
    }//GEN-LAST:event_btnTimerMouseClicked

    /**
     * Method ini untuk memutar/menonaktifkan audio/suara sesuai input yang dipilih user pada inputPengingat(JComboBox)
     * Jika input yang dipilih adalah "Tidak ada" atau "Tutup aplikasi" maka audio/suara gagal diaktifkan
     * 
     * @param evt 
     */
    private void lblSpeakerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSpeakerMouseClicked
        
        // jika sebelumnya audio/suara nonaktif maka audio/suara diaktifkan
        if(!speakerOn){
            speakerOn = true; // mengaktifkan audio/suara
            this.lblSpeaker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-windowsettimer-audioaktif.png")));
            // mengecek apakah input yang dimasukan user adalah input untuk suara atau tidak, jika ya maka audio/suara akan diputar
            if(inputPengingat.getSelectedIndex() > 0 && inputPengingat.getSelectedIndex() < 4){ 
                if(inputPengingat.getSelectedIndex() == 1){
                    Sounds.playSound(Sounds.SOUND_TIMEUP_1);
                }else if(inputPengingat.getSelectedIndex() == 2){
                    Sounds.playSound(Sounds.SOUND_TIMEUP_2);
                }else if(inputPengingat.getSelectedIndex() == 3){
                    Sounds.playSound(Sounds.SOUND_TIMEUP_3);
                }
            }else{ // jika tidak maka audio/ suara tidak akan diputar
                speakerOn = false;
                this.lblSpeaker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-windowsettimer-noaudio.png")));
                Sounds.playSound(Sounds.SOUND_NOTIF);
                JOptionPane.showMessageDialog(null, "Gagal mengaktifkan speaker!!!\nKarena anda memilih opsi \"Tidak ada\" atau \"Tutup applikasi\".");
            }
        }else{ // jika sebelumnya audio/suara aktif maka audio/suara dinonaktifkan
            speakerOn = false;
            Sounds.stopSound();
            this.lblSpeaker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-windowsettimer-noaudio.png")));
        }
    }//GEN-LAST:event_lblSpeakerMouseClicked

    /**
     * Jika inputPengingat diklik maka audio/suara akan dinonaktifkan
     * @param evt 
     */
    private void inputPengingatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputPengingatMouseClicked
        speakerOn = false;
        Sounds.stopSound();
        this.lblSpeaker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/media/icons/ic-windowsettimer-noaudio.png")));
    }//GEN-LAST:event_inputPengingatMouseClicked

    /**
     * Menonaktifkan audio/suara jika user keluar dari window
     * @param evt 
     */
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Sounds.stopSound();
    }//GEN-LAST:event_formWindowClosed


    public static void main(String args[]) {

        new Thread(new Runnable(){
        
            @Override
            public void run(){
                WindowSetTimer timer = new WindowSetTimer();
                timer.setVisible(true); 
            }
            
        }).start();
        
        

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnJam;
    private javax.swing.JLabel btnMulai;
    private javax.swing.JLabel btnPauseAndResume;
    private javax.swing.JLabel btnReset;
    private javax.swing.JLabel btnStopwatch;
    private javax.swing.JLabel btnTimer;
    private javax.swing.JTextField inputDetik;
    private javax.swing.JTextField inputJam;
    private javax.swing.JTextField inputMenit;
    private javax.swing.JComboBox inputPengingat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblErrorDetik;
    private javax.swing.JLabel lblErrorJam;
    private javax.swing.JLabel lblErrorMenit;
    private javax.swing.JLabel lblPengingat;
    private javax.swing.JLabel lblSpeaker;
    private javax.swing.JLabel lblTimer1;
    private javax.swing.JLabel lblTimer4;
    private javax.swing.JLabel lblTimer5;
    private javax.swing.JSeparator lineDetik;
    private javax.swing.JSeparator lineHour;
    private javax.swing.JSeparator lineMenit;
    private javax.swing.JPanel pnlBottom;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlTop;
    // End of variables declaration//GEN-END:variables
}
