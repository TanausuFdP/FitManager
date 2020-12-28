package es.ulpgc.fitmanager.view.gui.reservations;

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

    private final User loggedUser;
    
    private ActivityController activityController = new ActivityController();
    private ReservationController reservationController = new ReservationController();
    private final DefaultListModel listModel = new DefaultListModel();
    
    private Map<Integer, Integer> activitiesId = new HashMap<>();
    private List<Integer> activitiesNotAvailable = new ArrayList<>();
    
    public NewReservation(User user) {
        initComponents();
        this.loggedUser = user;
        activitiesToList(Activity.ROOM);
    }
    
    private void activitiesToList(boolean type){
        List<Activity> activitiesByType = activityController.getActivitiesByType(type);
        List <Activity> reservedActivities = reservationController.getReservationsByClientId(loggedUser.getId());
        activitiesId = new HashMap<>();
        int count = 0;
        for (Activity activity : activitiesByType) {
            if(!activitiesContains(reservedActivities, activity)){
                if(reservationController.getCountOfReservationsByActivityId(activity.getId()) ==
                        activity.getCapacity()){
                    listModel.addElement(activity.getName() + " - Sin tickets disponibles");
                    activitiesNotAvailable.add(count);
                } else {
                    listModel.addElement(activity);
                    activitiesId.put(count, activity.getId());
                }
                count++;
            }
        }
        reservationsList.setModel(listModel);
        reservationsList.setSelectionMode(SINGLE_SELECTION);
    }
    
    private boolean activitiesContains(List<Activity> list, Activity activity){
        for (Activity activityOnList : list) {
            if(activityOnList.getId() == activity.getId())
                return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        redPanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        whitePanel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        roomsToggleButton = new javax.swing.JToggleButton();
        activitiesToggleButton = new javax.swing.JToggleButton();
        toggleButtonsSeparator = new javax.swing.JSeparator();
        reservationsListScrollPane = new javax.swing.JScrollPane();
        reservationsList = new javax.swing.JList<>();
        reserveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        redPanel.setBackground(new java.awt.Color(255, 0, 0));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        javax.swing.GroupLayout redPanelLayout = new javax.swing.GroupLayout(redPanel);
        redPanel.setLayout(redPanelLayout);
        redPanelLayout.setHorizontalGroup(
            redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redPanelLayout.createSequentialGroup()
                .addComponent(logo)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        redPanelLayout.setVerticalGroup(
            redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        whitePanel.setBackground(new java.awt.Color(255, 255, 255));

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

        reservationsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        reservationsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reservationsListMouseClicked(evt);
            }
        });
        reservationsListScrollPane.setViewportView(reservationsList);

        reserveButton.setText("Reservar");
        reserveButton.setEnabled(false);
        reserveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reserveButtonActionPerformed(evt);
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
                        .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(whitePanelLayout.createSequentialGroup()
                                .addComponent(roomsToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(activitiesToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(toggleButtonsSeparator)
                            .addComponent(reservationsListScrollPane))
                        .addContainerGap())
                    .addGroup(whitePanelLayout.createSequentialGroup()
                        .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(whitePanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(titleLabel)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(whitePanelLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(reserveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        whitePanelLayout.setVerticalGroup(
            whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(whitePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(activitiesToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(roomsToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toggleButtonsSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reservationsListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reserveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addGap(18, 18, 18))
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

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        Reservations reservations = new Reservations(loggedUser);
        reservations.setLocation(this.getLocation());
        reservations.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void roomsToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomsToggleButtonActionPerformed
        listModel.clear();
        reserveButton.setEnabled(false);
        activitiesToList(Activity.ROOM);
    }//GEN-LAST:event_roomsToggleButtonActionPerformed

    private void activitiesToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activitiesToggleButtonActionPerformed
        listModel.clear();
        reserveButton.setEnabled(false);
        activitiesToList(Activity.ACTIVITY);
    }//GEN-LAST:event_activitiesToggleButtonActionPerformed

    private void reserveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reserveButtonActionPerformed
        Reservation reservation = new Reservation(loggedUser.getId(), activitiesId.get(reservationsList.getSelectedIndex())); 
        reservationController.insertReservation(reservation);
        Reservations reservations = new Reservations(loggedUser);
        reservations.setLocation(this.getLocation());
        reservations.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_reserveButtonActionPerformed

    private void reservationsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reservationsListMouseClicked
        if(!reservationsList.isSelectionEmpty() && !activitiesNotAvailable.contains(reservationsList.getSelectedIndex()))
            reserveButton.setEnabled(true);
        else
            reserveButton.setEnabled(false);
    }//GEN-LAST:event_reservationsListMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton activitiesToggleButton;
    private javax.swing.JButton backButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel redPanel;
    private javax.swing.JList<String> reservationsList;
    private javax.swing.JScrollPane reservationsListScrollPane;
    private javax.swing.JButton reserveButton;
    private javax.swing.JToggleButton roomsToggleButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JSeparator toggleButtonsSeparator;
    private javax.swing.JPanel whitePanel;
    // End of variables declaration//GEN-END:variables
}
