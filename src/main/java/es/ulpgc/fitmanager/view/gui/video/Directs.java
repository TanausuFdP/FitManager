package es.ulpgc.fitmanager.view.gui.video;

import es.ulpgc.fitmanager.controller.dbcontroller.VideoController;
import es.ulpgc.fitmanager.model.User;
import es.ulpgc.fitmanager.view.gui.main.MainMenu;
import es.ulpgc.fitmanager.view.gui.reservations.Reservations;
import es.ulpgc.fitmanager.view.gui.statistics.Statistics;
import es.ulpgc.fitmanager.view.gui.timetable.TimeTable;
import es.ulpgc.fitmanager.view.gui.workday.Workday;

import javax.swing.*;

public class Directs extends javax.swing.JFrame {

    private final User loggedUser;
    
    private final DefaultListModel listModel = new DefaultListModel();
    
    private final VideoController videoController = new VideoController();
    
    public Directs(User user) {
        initComponents();
        loggedUser = user;
        switch(loggedUser.getRole()){
            case User.ADMIN_ROLE:
                startStreamButton.setVisible(false);
                dynamicButton.setIcon(new ImageIcon(getClass().getResource("/statistics_button.png")));
                break;
            case User.MONITOR_ROLE:
                startStreamButton.setVisible(true);
                dynamicButton.setIcon(new ImageIcon(getClass().getResource("/workday_button.png")));
                break;
            case User.CLIENT_ROLE:
                startStreamButton.setVisible(false);
                dynamicButton.setIcon(new ImageIcon(getClass().getResource("/reservations_button.png")));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + loggedUser.getRole());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        redPanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        whitePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        videosListScrollPane = new javax.swing.JScrollPane();
        streamList = new javax.swing.JList<>();
        showVideoButton = new javax.swing.JButton();
        buttonsSeparator = new javax.swing.JSeparator();
        dynamicButton = new javax.swing.JButton();
        scheduleButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        videosButton = new javax.swing.JButton();
        directsButton = new javax.swing.JButton();
        startStreamButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        redPanel.setBackground(new java.awt.Color(255, 0, 0));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        javax.swing.GroupLayout redPanelLayout = new javax.swing.GroupLayout(redPanel);
        redPanel.setLayout(redPanelLayout);
        redPanelLayout.setHorizontalGroup(
            redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redPanelLayout.createSequentialGroup()
                .addComponent(logo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        redPanelLayout.setVerticalGroup(
            redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redPanelLayout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        whitePanel.setBackground(new java.awt.Color(255, 255, 255));

        titleLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        titleLabel.setText("Directos");

        streamList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        streamList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                streamListMouseClicked(evt);
            }
        });
        videosListScrollPane.setViewportView(streamList);

        showVideoButton.setText("Ver directo");
        showVideoButton.setEnabled(false);
        showVideoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showVideoButtonActionPerformed(evt);
            }
        });

        dynamicButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reservations_button.png"))); // NOI18N
        dynamicButton.setBorderPainted(false);
        dynamicButton.setContentAreaFilled(false);
        dynamicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dynamicButtonActionPerformed(evt);
            }
        });

        scheduleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schedule_button.png"))); // NOI18N
        scheduleButton.setBorderPainted(false);
        scheduleButton.setContentAreaFilled(false);
        scheduleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleButtonActionPerformed(evt);
            }
        });

        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_button.png"))); // NOI18N
        homeButton.setBorderPainted(false);
        homeButton.setContentAreaFilled(false);
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        videosButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/video_button.png"))); // NOI18N
        videosButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        videosButton.setBorderPainted(false);
        videosButton.setContentAreaFilled(false);
        videosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                videosButtonActionPerformed(evt);
            }
        });

        directsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/directs_button_pressed.png"))); // NOI18N
        directsButton.setBorderPainted(false);
        directsButton.setContentAreaFilled(false);

        startStreamButton.setText("Inciar directo");
        startStreamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startStreamButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout whitePanelLayout = new javax.swing.GroupLayout(whitePanel);
        whitePanel.setLayout(whitePanelLayout);
        whitePanelLayout.setHorizontalGroup(
            whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(whitePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(whitePanelLayout.createSequentialGroup()
                        .addComponent(showVideoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(startStreamButton))
                    .addComponent(videosListScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(whitePanelLayout.createSequentialGroup()
                        .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, whitePanelLayout.createSequentialGroup()
                                .addComponent(dynamicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scheduleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(videosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(directsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(buttonsSeparator, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        whitePanelLayout.setVerticalGroup(
            whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, whitePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(videosListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showVideoButton)
                    .addComponent(startStreamButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(buttonsSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dynamicButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(directsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(videosButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(homeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scheduleButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(whitePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(redPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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

    private void streamListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_streamListMouseClicked
        if(!streamList.isSelectionEmpty()) showVideoButton.setEnabled(true);
    }//GEN-LAST:event_streamListMouseClicked

    private void showVideoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showVideoButtonActionPerformed
        PlayVideo playVideo = (PlayVideo)listModel.getElementAt(streamList.getSelectedIndex());
        playVideo.setLocation(this.getLocation());
        playVideo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_showVideoButtonActionPerformed

    private void dynamicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dynamicButtonActionPerformed
        switch(loggedUser.getRole()){
            case User.ADMIN_ROLE:
                Statistics statistics = new Statistics(loggedUser);
                statistics.setLocation(this.getLocation());
                statistics.setVisible(true);
                break;
            case User.MONITOR_ROLE:
                Workday workday = new Workday(loggedUser);
                workday.setLocation(this.getLocation());
                workday.setVisible(true);
                break;
            case User.CLIENT_ROLE:
                Reservations reservation = new Reservations(loggedUser);
                reservation.setLocation(this.getLocation());
                reservation.setVisible(true);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + loggedUser.getRole());
        }
        this.dispose();
    }//GEN-LAST:event_dynamicButtonActionPerformed

    private void scheduleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleButtonActionPerformed
        TimeTable timeTable = new TimeTable(loggedUser);
        timeTable.setLocation(this.getLocation());
        timeTable.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_scheduleButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        MainMenu mainMenu = new MainMenu(loggedUser);
        mainMenu.setLocation(this.getLocation());
        mainMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeButtonActionPerformed

    private void videosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_videosButtonActionPerformed
        VideosClient videos = new VideosClient(loggedUser);
        videos.setLocation(this.getLocation());
        videos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_videosButtonActionPerformed

    private void startStreamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startStreamButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startStreamButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator buttonsSeparator;
    private javax.swing.JButton directsButton;
    private javax.swing.JButton dynamicButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel redPanel;
    private javax.swing.JButton scheduleButton;
    private javax.swing.JButton showVideoButton;
    private javax.swing.JButton startStreamButton;
    private javax.swing.JList<String> streamList;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton videosButton;
    private javax.swing.JScrollPane videosListScrollPane;
    private javax.swing.JPanel whitePanel;
    // End of variables declaration//GEN-END:variables
}
