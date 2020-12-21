package es.ulpgc.fitmanager.view.gui;

import es.ulpgc.fitmanager.controller.dbcontroller.ActivityController;
import es.ulpgc.fitmanager.controller.dbcontroller.ReservationController;
import es.ulpgc.fitmanager.model.Activity;
import es.ulpgc.fitmanager.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;



public class TimeTable extends javax.swing.JFrame {

    private final User loggedUser;
    private ActivityController activityController = new ActivityController();
    private final ReservationController reservationController = new ReservationController();
    private final DefaultListModel listModel = new DefaultListModel();
    
    public TimeTable(User user) {
        this.loggedUser = user;
        initComponents();
        addActivities();
    }

    private void addActivities() {
        List<Activity> activities = new ArrayList<Activity> ();
        for (Activity activity : activityController.getActivitiesByType(true)) 
            activities.add(activity);
        for (Activity activity : activityController.getActivitiesByType(false)) 
            activities.add(activity);
        if (activities.isEmpty()) noReservationsLabel.setText("No tiene ninguna reserva");
        else {
            sortReservationsList(activities);
            for (Activity activity : activities) {
                listModel.addElement(activity);
            }
        }
        jList1.setModel(listModel);
    }

    private void sortReservationsList(List<Activity> activities) {
        Activity lessDate;
        int lessDateIndex;
        for (int i= 0; i < activities.size(); i++) {
            //lessDate = reservations.get(i);
            lessDateIndex = i;
            for(int j= i+1; j < activities.size(); j++)
                if(activities.get(lessDateIndex).getDate().compareTo(activities.get(j).getDate()) > 0)
                    //lessDate = reservations.get(j);
                    lessDateIndex = j;
            if(lessDateIndex != i){
                lessDate = activities.get(lessDateIndex);
                activities.set(lessDateIndex, activities.get(i));
                activities.set(i, lessDate);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        dynamicButton1 = new javax.swing.JButton();
        scheduleButton1 = new javax.swing.JButton();
        videosButton1 = new javax.swing.JButton();
        directsButton1 = new javax.swing.JButton();
        accountButton2 = new javax.swing.JButton();
        noReservationsLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        titleLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        titleLabel.setText("Horario");

        jScrollPane1.setViewportView(jList1);

        dynamicButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reservations_button.png"))); // NOI18N
        dynamicButton1.setBorderPainted(false);
        dynamicButton1.setContentAreaFilled(false);
        dynamicButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dynamicButton1ActionPerformed(evt);
            }
        });

        scheduleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schedule_button_pressed.png"))); // NOI18N
        scheduleButton1.setBorderPainted(false);
        scheduleButton1.setContentAreaFilled(false);

        videosButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/video_button.png"))); // NOI18N
        videosButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        videosButton1.setBorderPainted(false);
        videosButton1.setContentAreaFilled(false);
        videosButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                videosButton1ActionPerformed(evt);
            }
        });

        directsButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/directs_button.png"))); // NOI18N
        directsButton1.setBorderPainted(false);
        directsButton1.setContentAreaFilled(false);

        accountButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_button.png"))); // NOI18N
        accountButton2.setBorderPainted(false);
        accountButton2.setContentAreaFilled(false);
        accountButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleLabel)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(dynamicButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scheduleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(accountButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(videosButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(directsButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(noReservationsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(noReservationsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(directsButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(accountButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dynamicButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(scheduleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(videosButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void dynamicButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dynamicButton1ActionPerformed
        Reservations reservation = new Reservations(loggedUser);
        reservation.setLocation(this.getLocation());
        reservation.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dynamicButton1ActionPerformed

    private void accountButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountButton2ActionPerformed
        MainMenu mainMenu = new MainMenu(loggedUser);
        mainMenu.setLocation(this.getLocation());
        mainMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_accountButton2ActionPerformed

    private void videosButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_videosButton1ActionPerformed
        VideosClient videos = new VideosClient(loggedUser);
        switch(loggedUser.getRole()){
            case 1:
                videos.setLocation(this.getLocation());
                videos.setVisible(true);
                break;
            case 2:
                MonitorVideo monitorVideo = new MonitorVideo(loggedUser);
                monitorVideo.setLocation(this.getLocation());
                monitorVideo.setVisible(true);
                break;
            case 3:
                videos.setLocation(this.getLocation());
                videos.setVisible(true);
                break;
        }
        this.dispose();
    }//GEN-LAST:event_videosButton1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accountButton2;
    private javax.swing.JButton directsButton1;
    private javax.swing.JButton dynamicButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel noReservationsLabel;
    private javax.swing.JButton scheduleButton1;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton videosButton1;
    // End of variables declaration//GEN-END:variables

}
