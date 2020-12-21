package es.ulpgc.fitmanager.view.gui;

import es.ulpgc.fitmanager.model.User;
import java.awt.BorderLayout;
import java.io.File;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class PlayVideo extends javax.swing.JFrame {

   private final JFXPanel jfxPanel = new JFXPanel(); 
    private MediaPlayer oracleVid;
    private int flag;
    private String path;
    private final User loggedUser;
    
    public PlayVideo(User user, String path) {
        
        loggedUser = user;
        initComponents();
        createScene();
        this.path = path;
        setTitle("Java Swing Video con FX");
        setResizable(false);
        setLocationRelativeTo(null);
     
        videoPanel.add(jfxPanel, BorderLayout.CENTER);
        
        
    }

    private void createScene(){
        Platform.runLater(new Runnable() {
             @Override
             public void run() {                 
                File file = new File(path);                                   
                    oracleVid = new MediaPlayer(                                       
                        new Media(file.toURI().toString())
                    );
                    //se añade video al jfxPanel
                    jfxPanel.setScene(new Scene(new Group(new MediaView(oracleVid))));                    
                    oracleVid.setVolume(0.7);//volumen
                    oracleVid.setCycleCount(MediaPlayer.INDEFINITE);//repite video
                    oracleVid.play();//play video
                    flag = 0;
             }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        generalPanel = new javax.swing.JPanel();
        buttonsPanel = new javax.swing.JPanel();
        playPauseButton = new javax.swing.JButton();
        playPauseButton1 = new javax.swing.JButton();
        titlePanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        videoPanel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        generalPanel.setBackground(new java.awt.Color(255, 255, 255));

        buttonsPanel.setBackground(new java.awt.Color(255, 255, 255));

        playPauseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/play.png"))); // NOI18N
        playPauseButton.setBorder(null);
        playPauseButton.setBorderPainted(false);
        playPauseButton.setContentAreaFilled(false);
        playPauseButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        playPauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playPauseButtonActionPerformed(evt);
            }
        });

        playPauseButton1.setText("S");
        playPauseButton1.setBorder(null);
        playPauseButton1.setBorderPainted(false);
        playPauseButton1.setContentAreaFilled(false);
        playPauseButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        playPauseButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playPauseButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonsPanelLayout = new javax.swing.GroupLayout(buttonsPanel);
        buttonsPanel.setLayout(buttonsPanelLayout);
        buttonsPanelLayout.setHorizontalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addComponent(playPauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(playPauseButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        buttonsPanelLayout.setVerticalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(playPauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(playPauseButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        titlePanel.setBackground(new java.awt.Color(255, 51, 0));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        videoPanel.setBackground(new java.awt.Color(255, 255, 255));
        videoPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        videoPanel.setLayout(new java.awt.BorderLayout());

        backButton.setForeground(new java.awt.Color(0, 51, 255));
        backButton.setText("< Ver todos los vídeos ");
        backButton.setBorder(null);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout generalPanelLayout = new javax.swing.GroupLayout(generalPanel);
        generalPanel.setLayout(generalPanelLayout);
        generalPanelLayout.setHorizontalGroup(
            generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(generalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(generalPanelLayout.createSequentialGroup()
                        .addComponent(videoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(generalPanelLayout.createSequentialGroup()
                        .addComponent(backButton)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        generalPanelLayout.setVerticalGroup(
            generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPanelLayout.createSequentialGroup()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backButton)
                .addGap(18, 18, 18)
                .addComponent(videoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(generalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(generalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playPauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playPauseButtonActionPerformed
        if (flag == 0){
            flag = 1;
            oracleVid.pause();
            playPauseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pause.png")));
        }else{
            flag = 0;
            oracleVid.play();
            playPauseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/play (1).png")));
        }
    }//GEN-LAST:event_playPauseButtonActionPerformed

    private void playPauseButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playPauseButton1ActionPerformed
        oracleVid.stop();
    }//GEN-LAST:event_playPauseButton1ActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        VideosClient videos = new VideosClient(loggedUser);
        videos.setLocation(this.getLocation());
        videos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JPanel generalPanel;
    private javax.swing.JLabel logo;
    private javax.swing.JButton playPauseButton;
    private javax.swing.JButton playPauseButton1;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JPanel videoPanel;
    // End of variables declaration//GEN-END:variables
}
