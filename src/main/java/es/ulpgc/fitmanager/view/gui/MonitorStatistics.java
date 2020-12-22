package es.ulpgc.fitmanager.view.gui;

import es.ulpgc.fitmanager.controller.dbcontroller.ActivityController;
import es.ulpgc.fitmanager.controller.dbcontroller.UserController;
import es.ulpgc.fitmanager.model.Activity;
import es.ulpgc.fitmanager.model.User;
import java.util.List;
import javax.swing.DefaultListModel;
import org.jfree.data.xy.XYSeries;


public class MonitorStatistics extends javax.swing.JFrame {

    private final User loggedUser;
    
    private final ActivityController activityController = new ActivityController();
    
    private final UserController userController = new UserController();
    
    private final DefaultListModel listModel = new DefaultListModel();

    
    public MonitorStatistics(User user) {
        initComponents();
        loggedUser = user;
        jList1.setModel(listModel);
        
        List<User>monitors = userController.getUsersByRole(User.MONITOR_ROLE);
        
        for (User monitor : monitors) {
            int sizeActivities = activityController.getCountOfActivitiesByMonitorId(monitor.getId(), Activity.ACTIVITY);
            int sizeRooms = activityController.getCountOfActivitiesByMonitorId(monitor.getId(), Activity.ROOM);
            listModel.addElement(monitor.getName() + " " + monitor.getSurname() +
                    ": " + sizeActivities + " actividad/es y " + sizeRooms + " salas");
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoPanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        generalPanel = new javax.swing.JPanel();
        statisticsButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logoPanel.setBackground(new java.awt.Color(255, 0, 0));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        javax.swing.GroupLayout logoPanelLayout = new javax.swing.GroupLayout(logoPanel);
        logoPanel.setLayout(logoPanelLayout);
        logoPanelLayout.setHorizontalGroup(
            logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        logoPanelLayout.setVerticalGroup(
            logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, Short.MAX_VALUE)
        );

        generalPanel.setBackground(new java.awt.Color(255, 255, 255));

        statisticsButton.setForeground(new java.awt.Color(0, 51, 255));
        statisticsButton.setText("<  Estadísticas");
        statisticsButton.setToolTipText("");
        statisticsButton.setBorderPainted(false);
        statisticsButton.setContentAreaFilled(false);
        statisticsButton.setFocusCycleRoot(true);
        statisticsButton.setFocusPainted(false);
        statisticsButton.setFocusable(false);
        statisticsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statisticsButtonActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        titleLabel.setText("Monitores");

        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout generalPanelLayout = new javax.swing.GroupLayout(generalPanel);
        generalPanel.setLayout(generalPanelLayout);
        generalPanelLayout.setHorizontalGroup(
            generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(generalPanelLayout.createSequentialGroup()
                        .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(statisticsButton)
                            .addComponent(titleLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        generalPanelLayout.setVerticalGroup(
            generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statisticsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(generalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(logoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(generalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void statisticsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statisticsButtonActionPerformed
        Statistics statistics = new Statistics(loggedUser);
        statistics.setLocation(this.getLocation());
        statistics.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_statisticsButtonActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel generalPanel;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel logoPanel;
    private javax.swing.JButton statisticsButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
