package es.ulpgc.fitmanager.view.gui.reservations;

import es.ulpgc.fitmanager.controller.dbcontroller.UserController;
import es.ulpgc.fitmanager.model.Activity;
import es.ulpgc.fitmanager.model.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ShowReservation extends javax.swing.JFrame {

    private final User loggedUser;
    private final Activity activity;
    private final UserController userController = new UserController();
    
    public ShowReservation(User user, Activity activity) {
        initComponents();
        this.loggedUser = user;
        this.activity = activity; 
        showActivityElements();
    }

    private void showActivityElements() {
        LocalDateTime finalDate = activity.getDate().plusMinutes(activity.getDuration());
        titleLabel.setText(activity.getName());
        descriptionText.setWrapStyleWord(true);
        descriptionText.setLineWrap(true);
        descriptionText.setText(activity.getDescription());
        instructorLabel.setText(userController.getUserById(activity.getMonitorId()).getName());
        dateLabel.setText("" + activity.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
        finalLabel.setText("" + finalDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
        durationLabel.setText(activity.getDuration() + " minutos");
        weeklyCheckBox.setSelected(activity.isWeekly());
        capacityLabel.setText(activity.getCapacity().toString());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        redPanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        whitePanel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        descriptionTextScrollPane = new javax.swing.JScrollPane();
        descriptionText = new javax.swing.JTextArea();
        separator1 = new javax.swing.JSeparator();
        instructorInformationLabel = new javax.swing.JLabel();
        instructorLabel = new javax.swing.JLabel();
        separator2 = new javax.swing.JSeparator();
        dateInformationLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        finalInformationLabel = new javax.swing.JLabel();
        finalLabel = new javax.swing.JLabel();
        durationInformationLabel = new javax.swing.JLabel();
        durationLabel = new javax.swing.JLabel();
        separator3 = new javax.swing.JSeparator();
        weeklyInformationLabel = new javax.swing.JLabel();
        weeklyCheckBox = new javax.swing.JCheckBox();
        capacityInformationLabel = new javax.swing.JLabel();
        capacityLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
            .addGroup(redPanelLayout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        whitePanel.setBackground(new java.awt.Color(255, 255, 255));

        backButton.setForeground(new java.awt.Color(0, 51, 255));
        backButton.setText("<  Mis reservas");
        backButton.setToolTipText("");
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusCycleRoot(true);
        backButton.setFocusPainted(false);
        backButton.setFocusable(false);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        titleLabel.setText("Título actividad");

        descriptionTextScrollPane.setBorder(null);

        descriptionText.setEditable(false);
        descriptionText.setColumns(20);
        descriptionText.setRows(5);
        descriptionTextScrollPane.setViewportView(descriptionText);

        instructorInformationLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        instructorInformationLabel.setText("Monitor:");

        instructorLabel.setText("jLabel1");

        dateInformationLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        dateInformationLabel.setText("Inicio:");

        dateLabel.setText("jLabel1");

        finalInformationLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        finalInformationLabel.setText("Final:");

        finalLabel.setText("jLabel1");

        durationInformationLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        durationInformationLabel.setText("Duración:");

        durationLabel.setText("jLabel1");

        weeklyInformationLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        weeklyInformationLabel.setText("Semanal:");

        weeklyCheckBox.setEnabled(false);
        weeklyCheckBox.setFocusable(false);

        capacityInformationLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        capacityInformationLabel.setText("Aforo:");

        capacityLabel.setText("jLabel1");

        javax.swing.GroupLayout whitePanelLayout = new javax.swing.GroupLayout(whitePanel);
        whitePanel.setLayout(whitePanelLayout);
        whitePanelLayout.setHorizontalGroup(
            whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(whitePanelLayout.createSequentialGroup()
                .addComponent(backButton)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(whitePanelLayout.createSequentialGroup()
                .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, whitePanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(instructorInformationLabel)
                        .addGap(18, 18, 18)
                        .addComponent(instructorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(whitePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(separator2))
                    .addComponent(separator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(whitePanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateInformationLabel)
                            .addComponent(finalInformationLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(finalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(whitePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(durationInformationLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(durationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(whitePanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(weeklyInformationLabel)
                            .addComponent(capacityInformationLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(capacityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(whitePanelLayout.createSequentialGroup()
                                .addComponent(weeklyCheckBox)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(whitePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(separator1))
                    .addGroup(whitePanelLayout.createSequentialGroup()
                        .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(whitePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(descriptionTextScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(whitePanelLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(titleLabel)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        whitePanelLayout.setVerticalGroup(
            whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(whitePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleLabel)
                .addGap(18, 18, 18)
                .addComponent(descriptionTextScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(separator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(instructorInformationLabel)
                    .addComponent(instructorLabel))
                .addGap(18, 18, 18)
                .addComponent(separator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel)
                    .addComponent(dateInformationLabel))
                .addGap(18, 18, 18)
                .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finalLabel)
                    .addComponent(finalInformationLabel))
                .addGap(18, 18, 18)
                .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(durationLabel)
                    .addComponent(durationInformationLabel))
                .addGap(18, 18, 18)
                .addComponent(separator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(weeklyInformationLabel)
                    .addComponent(weeklyCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(capacityInformationLabel)
                    .addComponent(capacityLabel))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(redPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(whitePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel capacityInformationLabel;
    private javax.swing.JLabel capacityLabel;
    private javax.swing.JLabel dateInformationLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextArea descriptionText;
    private javax.swing.JScrollPane descriptionTextScrollPane;
    private javax.swing.JLabel durationInformationLabel;
    private javax.swing.JLabel durationLabel;
    private javax.swing.JLabel finalInformationLabel;
    private javax.swing.JLabel finalLabel;
    private javax.swing.JLabel instructorInformationLabel;
    private javax.swing.JLabel instructorLabel;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel redPanel;
    private javax.swing.JSeparator separator1;
    private javax.swing.JSeparator separator2;
    private javax.swing.JSeparator separator3;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JCheckBox weeklyCheckBox;
    private javax.swing.JLabel weeklyInformationLabel;
    private javax.swing.JPanel whitePanel;
    // End of variables declaration//GEN-END:variables

    
}
