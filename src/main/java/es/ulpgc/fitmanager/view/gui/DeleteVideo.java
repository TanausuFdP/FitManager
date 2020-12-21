
package es.ulpgc.fitmanager.view.gui;

import es.ulpgc.fitmanager.controller.dbcontroller.VideoController;
import es.ulpgc.fitmanager.model.User;
import es.ulpgc.fitmanager.model.Video;
import java.util.List;
import javax.swing.DefaultListModel;


public class DeleteVideo extends javax.swing.JFrame {

    private final User loggedUser;
    private final DefaultListModel listModel = new DefaultListModel();

    private final VideoController videoController = new VideoController();

    public DeleteVideo(User user) {
        initComponents();
        loggedUser = user;
        
        List<Video>videos = videoController.getAllVideos();
        for (Video video : videos) {
            listModel.addElement(video);
        }
        this.videos.setModel(listModel);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titlePanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        generalPanel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        deleteVideoButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        videos = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titlePanel.setBackground(new java.awt.Color(255, 0, 0));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, Short.MAX_VALUE)
        );

        generalPanel.setBackground(new java.awt.Color(255, 255, 255));

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

        deleteVideoButton.setText("ELIMINAR VÍDEO");
        deleteVideoButton.setEnabled(false);
        deleteVideoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteVideoButtonActionPerformed(evt);
            }
        });

        videos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                videosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(videos);

        javax.swing.GroupLayout generalPanelLayout = new javax.swing.GroupLayout(generalPanel);
        generalPanel.setLayout(generalPanelLayout);
        generalPanelLayout.setHorizontalGroup(
            generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(generalPanelLayout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(generalPanelLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(deleteVideoButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        generalPanelLayout.setVerticalGroup(
            generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(deleteVideoButton)
                .addGap(68, 68, 68))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(generalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(generalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        MonitorVideo monitorVideo = new MonitorVideo(loggedUser);
        monitorVideo.setLocation(this.getLocation());
        monitorVideo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void deleteVideoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteVideoButtonActionPerformed
        Video video = (Video) listModel.get(videos.getSelectedIndex());
        videoController.deleteVideo(video.getId());   
        listModel.removeElementAt(videos.getSelectedIndex());
    }//GEN-LAST:event_deleteVideoButtonActionPerformed

    private void videosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_videosMouseClicked
        if(!videos.isSelectionEmpty()) deleteVideoButton.setEnabled(true);
    }//GEN-LAST:event_videosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton deleteVideoButton;
    private javax.swing.JPanel generalPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JList<String> videos;
    // End of variables declaration//GEN-END:variables
}
