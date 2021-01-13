package es.ulpgc.fitmanager.view.gui.reservations;

import es.ulpgc.fitmanager.controller.dbcontroller.ReservationController;
import es.ulpgc.fitmanager.model.Activity;
import es.ulpgc.fitmanager.model.User;
import es.ulpgc.fitmanager.view.gui.main.MainMenu;
import es.ulpgc.fitmanager.view.gui.timetable.TimeTable;
import es.ulpgc.fitmanager.view.gui.video.Directs;
import es.ulpgc.fitmanager.view.gui.video.VideosClient;

import javax.swing.*;
import java.util.List;

public class Reservations extends javax.swing.JFrame {

    private final User loggedUser;
    private final ReservationController reservationController = new ReservationController();
    private final DefaultListModel listModel = new DefaultListModel();

    public Reservations(User user) {
        initComponents();
        this.loggedUser = user;
        addReservations();
    }
    
    private void addReservations() {
        List<Activity> reservations = reservationController.getReservationsByClientId(loggedUser.getId());
        if (reservations.isEmpty())noReservationsLabel.setText("No tiene ninguna reserva");
        else {
            sortReservationsList(reservations);
            for (Activity activity : reservations) listModel.addElement(activity);
        }
        reservationsList.setModel(listModel);
    }
    
    private void sortReservationsList(List<Activity> reservations) {
        Activity lessDate;
        int lessDateIndex;
        for (int i= 0; i < reservations.size(); i++) {
            lessDateIndex = i;
            for(int j= i+1; j < reservations.size(); j++)
                if(reservations.get(lessDateIndex).getDate().compareTo(reservations.get(j).getDate()) > 0)
                    lessDateIndex = j;
            if(lessDateIndex != i){
                lessDate = reservations.get(lessDateIndex);
                reservations.set(lessDateIndex, reservations.get(i));
                reservations.set(i, lessDate);
            }
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        redPanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        whitePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        noReservationsLabel = new javax.swing.JLabel();
        reservationsListScrollPane = new javax.swing.JScrollPane();
        reservationsList = new javax.swing.JList<>();
        newReservationButton = new javax.swing.JButton();
        viewReservationButton = new javax.swing.JButton();
        cancelReservationButton = new javax.swing.JButton();
        buttonsSeparator = new javax.swing.JSeparator();
        reservationsButton = new javax.swing.JButton();
        scheduleButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        videosButton = new javax.swing.JButton();
        directsButton = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(320, 568));
        setResizable(false);
        setSize(new java.awt.Dimension(320, 568));

        redPanel.setBackground(new java.awt.Color(255, 0, 0));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        javax.swing.GroupLayout redPanelLayout = new javax.swing.GroupLayout(redPanel);
        redPanel.setLayout(redPanelLayout);
        redPanelLayout.setHorizontalGroup(
            redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo)
        );
        redPanelLayout.setVerticalGroup(
            redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        whitePanel.setBackground(new java.awt.Color(255, 255, 255));

        titleLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        titleLabel.setText("Mis reservas");

        noReservationsLabel.setForeground(new java.awt.Color(255, 0, 0));

        reservationsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        reservationsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reservationsListMouseClicked(evt);
            }
        });
        reservationsListScrollPane.setViewportView(reservationsList);

        newReservationButton.setText("Nueva reserva");
        newReservationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newReservationButtonActionPerformed(evt);
            }
        });

        viewReservationButton.setText("Ver reserva");
        viewReservationButton.setEnabled(false);
        viewReservationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewReservationButtonActionPerformed(evt);
            }
        });

        cancelReservationButton.setText("Cancelar reserva");
        cancelReservationButton.setEnabled(false);
        cancelReservationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelReservationButtonActionPerformed(evt);
            }
        });

        reservationsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reservations_button_pressed.png"))); // NOI18N
        reservationsButton.setBorderPainted(false);
        reservationsButton.setContentAreaFilled(false);

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

        directsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/directs_button.png"))); // NOI18N
        directsButton.setBorderPainted(false);
        directsButton.setContentAreaFilled(false);
        directsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                directsButtonActionPerformed(evt);
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
                        .addGap(6, 6, 6)
                        .addComponent(reservationsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scheduleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(videosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(directsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(whitePanelLayout.createSequentialGroup()
                        .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonsSeparator)
                            .addComponent(reservationsListScrollPane))
                        .addContainerGap())))
            .addGroup(whitePanelLayout.createSequentialGroup()
                .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(whitePanelLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newReservationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(viewReservationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelReservationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(whitePanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(titleLabel))
                    .addGroup(whitePanelLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(noReservationsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        whitePanelLayout.setVerticalGroup(
            whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(whitePanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noReservationsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reservationsListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newReservationButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewReservationButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelReservationButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonsSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(reservationsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(videosButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(homeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(scheduleButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(directsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(whitePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(redPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(redPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(whitePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newReservationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newReservationButtonActionPerformed
        NewReservation newReservation = new NewReservation(loggedUser);
        newReservation.setLocation(this.getLocation());
        newReservation.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_newReservationButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        MainMenu mainMenu = new MainMenu(loggedUser);
        mainMenu.setLocation(this.getLocation());
        mainMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeButtonActionPerformed

    private void scheduleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleButtonActionPerformed
        TimeTable timeTable = new TimeTable(loggedUser);
        timeTable.setLocation(this.getLocation());
        timeTable.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_scheduleButtonActionPerformed

    private void videosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_videosButtonActionPerformed
        VideosClient videos = new VideosClient(loggedUser);
        videos.setLocation(this.getLocation());
        videos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_videosButtonActionPerformed

    private void reservationsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reservationsListMouseClicked
        if(!reservationsList.isSelectionEmpty()){
            viewReservationButton.setEnabled(true);
            cancelReservationButton.setEnabled(true);
        }
    }//GEN-LAST:event_reservationsListMouseClicked

    private void viewReservationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewReservationButtonActionPerformed
        Object activity2 = listModel.get(reservationsList.getSelectedIndex());
        Activity activity = (Activity) activity2;
        
        ShowReservation showReservation = new ShowReservation(loggedUser, activity);
        showReservation.setLocation(this.getLocation());
        showReservation.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewReservationButtonActionPerformed

    private void cancelReservationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelReservationButtonActionPerformed
        Activity activity = (Activity)listModel.getElementAt(reservationsList.getSelectedIndex());
        CancelReservationMessage cancel = new CancelReservationMessage(loggedUser, activity);
        cancel.setLocation(this.getLocation());
        cancel.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelReservationButtonActionPerformed

    private void directsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_directsButtonActionPerformed
        Directs directs = new Directs(loggedUser);
        directs.setLocation(this.getLocation());
        directs.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_directsButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator buttonsSeparator;
    private javax.swing.JButton cancelReservationButton;
    private javax.swing.JButton directsButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel logo;
    private javax.swing.JButton newReservationButton;
    private javax.swing.JLabel noReservationsLabel;
    private javax.swing.JPanel redPanel;
    private javax.swing.JButton reservationsButton;
    private javax.swing.JList<String> reservationsList;
    private javax.swing.JScrollPane reservationsListScrollPane;
    private javax.swing.JButton scheduleButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton videosButton;
    private javax.swing.JButton viewReservationButton;
    private javax.swing.JPanel whitePanel;
    // End of variables declaration//GEN-END:variables
}
