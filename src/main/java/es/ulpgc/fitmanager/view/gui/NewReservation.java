package es.ulpgc.fitmanager.view.gui;

import es.ulpgc.fitmanager.controller.action.GetActivityByNameAction;
import es.ulpgc.fitmanager.controller.dbcontroller.ActivityController;
import es.ulpgc.fitmanager.controller.dbcontroller.ReservationController;
import es.ulpgc.fitmanager.model.Activity;
import es.ulpgc.fitmanager.model.Reservation;
import es.ulpgc.fitmanager.model.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;

public class NewReservation extends javax.swing.JFrame {

    private static final boolean ROOM = true;
    private static final boolean ACTIVITY = false;
    
    private final User loggedUser;
    
    private ActivityController activityController = new ActivityController();
    private ReservationController reservationController = new ReservationController();
    private final DefaultListModel listModel = new DefaultListModel();
    
    private Map<Integer, Integer> activitiesId = new HashMap<>();
    
    public NewReservation(User user) {
        initComponents();
        this.loggedUser = user;
        activitiesToList(ROOM);
    }
    
    private void activitiesToList(boolean type){
        List<Activity> activitiesByType = activityController.getActivitiesByType(type);
        activitiesId = new HashMap<>();
        //if (reservations.isEmpty()) noReservationsLabel.setText("No tiene ninguna reserva");
        //else {
        int count = 0;
        for (Activity activity : activitiesByType) {
            listModel.addElement(activity);
            activitiesId.put(count, activity.getId());
            count++;
        }
            //activitiesByType.stream().forEach(listModel::addElement);
        //}
        jList1.setModel(listModel);
        jList1.setSelectionMode(SINGLE_SELECTION);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        toggleButtonsSeparator = new javax.swing.JSeparator();
        backButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        roomsToggleButton = new javax.swing.JToggleButton();
        activitiesToggleButton = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JSeparator();
        directsButton = new javax.swing.JButton();
        videosButton = new javax.swing.JButton();
        scheduleButton = new javax.swing.JButton();
        accountButton1 = new javax.swing.JButton();
        dynamicButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        reservationButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(logo)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        backButton.setForeground(new java.awt.Color(0, 51, 255));
        backButton.setText("<  Mis reservas");
        backButton.setBorder(null);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        titleLabel.setText("Nueva reserva");

        buttonGroup1.add(roomsToggleButton);
        roomsToggleButton.setSelected(true);
        roomsToggleButton.setText("Salas");
        roomsToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomsToggleButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(activitiesToggleButton);
        activitiesToggleButton.setText("Actividades");
        activitiesToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activitiesToggleButtonActionPerformed(evt);
            }
        });

        directsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/directs_button.png"))); // NOI18N
        directsButton.setBorderPainted(false);
        directsButton.setContentAreaFilled(false);

        videosButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/video_button.png"))); // NOI18N
        videosButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        videosButton.setBorderPainted(false);
        videosButton.setContentAreaFilled(false);
        videosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                videosButtonActionPerformed(evt);
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

        accountButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_button.png"))); // NOI18N
        accountButton1.setBorderPainted(false);
        accountButton1.setContentAreaFilled(false);

        dynamicButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reservations_button.png"))); // NOI18N
        dynamicButton.setBorderPainted(false);
        dynamicButton.setContentAreaFilled(false);
        dynamicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dynamicButtonActionPerformed(evt);
            }
        });

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        reservationButton.setText("Reservar");
        reservationButton.setEnabled(false);
        reservationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservationButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(roomsToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(activitiesToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(toggleButtonsSeparator)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(dynamicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scheduleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(accountButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(videosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(directsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(titleLabel)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(reservationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(activitiesToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(roomsToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toggleButtonsSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reservationButton, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scheduleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dynamicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accountButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(directsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(videosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        Reservations reservations = new Reservations(loggedUser);
        reservations.setLocation(this.getLocation());
        reservations.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void dynamicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dynamicButtonActionPerformed
        Reservations reservation = new Reservations(loggedUser);
        reservation.setLocation(this.getLocation());
        reservation.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dynamicButtonActionPerformed

    private void scheduleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleButtonActionPerformed

    }//GEN-LAST:event_scheduleButtonActionPerformed

    private void videosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_videosButtonActionPerformed
        Videos videos = new Videos(loggedUser);
        videos.setLocation(this.getLocation());
        videos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_videosButtonActionPerformed

    private void roomsToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomsToggleButtonActionPerformed
        listModel.clear();
        reservationButton.setEnabled(false);
        activitiesToList(ROOM);
    }//GEN-LAST:event_roomsToggleButtonActionPerformed

    private void activitiesToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activitiesToggleButtonActionPerformed
        listModel.clear();
        reservationButton.setEnabled(false);
        activitiesToList(ACTIVITY);
    }//GEN-LAST:event_activitiesToggleButtonActionPerformed

    private void reservationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservationButtonActionPerformed
        Reservation reservation = new Reservation(loggedUser.getId(), activitiesId.get(jList1.getSelectedIndex())); 
        reservationController.insertReservation(reservation);
        Reservations reservations = new Reservations(loggedUser);
        reservations.setLocation(this.getLocation());
        reservations.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_reservationButtonActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        if(!jList1.isSelectionEmpty()) reservationButton.setEnabled(true);
    }//GEN-LAST:event_jList1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accountButton1;
    private javax.swing.JToggleButton activitiesToggleButton;
    private javax.swing.JButton backButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton directsButton;
    private javax.swing.JButton dynamicButton;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel logo;
    private javax.swing.JButton reservationButton;
    private javax.swing.JToggleButton roomsToggleButton;
    private javax.swing.JButton scheduleButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JSeparator toggleButtonsSeparator;
    private javax.swing.JButton videosButton;
    // End of variables declaration//GEN-END:variables
}
