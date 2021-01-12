package es.ulpgc.fitmanager.view.gui.video;

import es.ulpgc.fitmanager.controller.dbcontroller.VideoController;
import es.ulpgc.fitmanager.model.User;
import es.ulpgc.fitmanager.model.Video;
import es.ulpgc.fitmanager.model.VideoCategory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class UploadVideo extends javax.swing.JFrame {

    private final User loggedUser;
    private final VideoController videoController = new VideoController();
    public UploadVideo(User user) {
        initComponents();
        loggedUser = user;
        
        List<VideoCategory> videoCategoriesList = videoController.getVideoCategories();
        for (VideoCategory videoCategory : videoCategoriesList) {
            categoryComboBox.addItem(videoCategory.getName());
        }
        
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        redPanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        whitePanel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        categoryLabel = new javax.swing.JLabel();
        categoryComboBox = new javax.swing.JComboBox<>();
        urlLabel = new javax.swing.JLabel();
        urlTextField = new javax.swing.JTextField();
        uploadVideo = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        warningLabel = new javax.swing.JLabel();
        durationLabel = new javax.swing.JLabel();
        durationTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(322, 568));

        redPanel.setBackground(new java.awt.Color(255, 0, 0));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        javax.swing.GroupLayout redPanelLayout = new javax.swing.GroupLayout(redPanel);
        redPanel.setLayout(redPanelLayout);
        redPanelLayout.setHorizontalGroup(
            redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        redPanelLayout.setVerticalGroup(
            redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, Short.MAX_VALUE)
        );

        whitePanel.setBackground(new java.awt.Color(255, 255, 255));

        backButton.setForeground(new java.awt.Color(0, 51, 255));
        backButton.setText("<  Vídeos");
        backButton.setBorder(null);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        nameLabel.setText("Nombre:");

        categoryLabel.setText("Categoría:");

        urlLabel.setText("URL:");

        uploadVideo.setText("SUBIR VÍDEO");
        uploadVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadVideoActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        titleLabel.setText("Subir vídeo");

        warningLabel.setText("Sólo se admiten vídeos en formato MP4.");

        durationLabel.setText("Duración:");

        javax.swing.GroupLayout whitePanelLayout = new javax.swing.GroupLayout(whitePanel);
        whitePanel.setLayout(whitePanelLayout);
        whitePanelLayout.setHorizontalGroup(
            whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(whitePanelLayout.createSequentialGroup()
                .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(whitePanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(titleLabel))
                    .addGroup(whitePanelLayout.createSequentialGroup()
                        .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(whitePanelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(nameLabel))
                            .addGroup(whitePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(categoryLabel))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, whitePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(urlLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(durationLabel, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(18, 18, 18)
                        .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(durationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(urlTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(whitePanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(warningLabel))
                    .addGroup(whitePanelLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(uploadVideo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        whitePanelLayout.setVerticalGroup(
            whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, whitePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(titleLabel)
                .addGap(45, 45, 45)
                .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addGap(48, 48, 48)
                .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryLabel))
                .addGap(44, 44, 44)
                .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(urlTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(urlLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(durationLabel)
                    .addComponent(durationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(warningLabel)
                .addGap(18, 18, 18)
                .addComponent(uploadVideo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(redPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(whitePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(redPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(whitePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uploadVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadVideoActionPerformed
        if (nameTextField.getText().equals("") || urlTextField.getText().equals("")) return;
            
        Video video = new Video(null,nameTextField.getText(),
            Double.parseDouble(durationTextField.getText()),
            getClass().getResource(urlTextField.getText()).toString(),
            categoryComboBox.getSelectedIndex()+1,
            loggedUser.getVideoListId());
        
        videoController.insertVideo(video);
        
        MonitorVideo monitorVideo = new MonitorVideo(loggedUser);
        monitorVideo.setLocation(this.getLocation());
        monitorVideo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_uploadVideoActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        MonitorVideo monitorVideo = new MonitorVideo(loggedUser);
        monitorVideo.setLocation(this.getLocation());
        monitorVideo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JLabel durationLabel;
    private javax.swing.JTextField durationTextField;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JPanel redPanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton uploadVideo;
    private javax.swing.JLabel urlLabel;
    private javax.swing.JTextField urlTextField;
    private javax.swing.JLabel warningLabel;
    private javax.swing.JPanel whitePanel;
    // End of variables declaration//GEN-END:variables
}
