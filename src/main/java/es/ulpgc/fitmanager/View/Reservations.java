package es.ulpgc.fitmanager.View;

public class Reservations extends javax.swing.JFrame {

    public Reservations() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        noReservationsLabel = new javax.swing.JLabel();
        reservationsList = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        newReservationButton = new javax.swing.JButton();
        viewReservationButton = new javax.swing.JButton();
        cancelReservationButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        titleLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        titleLabel.setText("Mis reservas");

        backButton.setForeground(new java.awt.Color(0, 51, 255));
        backButton.setText("<  Menú principal");
        backButton.setBorder(null);
        backButton.setFocusCycleRoot(true);
        backButton.setFocusPainted(false);
        backButton.setFocusTraversalKeysEnabled(false);
        backButton.setFocusable(false);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        noReservationsLabel.setText("No tienes ninguna reserva.");

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        reservationsList.setViewportView(jList1);

        newReservationButton.setText("Nueva reserva");
        newReservationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newReservationButtonActionPerformed(evt);
            }
        });

        viewReservationButton.setText("Ver reserva");

        cancelReservationButton.setText("Cancelar reserva");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(noReservationsLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleLabel)
                            .addComponent(reservationsList, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cancelReservationButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewReservationButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newReservationButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(96, 96, 96))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(backButton)
                .addGap(18, 18, 18)
                .addComponent(titleLabel)
                .addGap(35, 35, 35)
                .addComponent(noReservationsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reservationsList, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(newReservationButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewReservationButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelReservationButton)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        MainMenu mainMenu = new MainMenu();
        mainMenu.setLocation(this.getLocation());
        mainMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void newReservationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newReservationButtonActionPerformed
        NewReservation newReservation = new NewReservation();
        newReservation.setLocation(this.getLocation());
        newReservation.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_newReservationButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton cancelReservationButton;
    private javax.swing.JList<String> jList1;
    private javax.swing.JButton newReservationButton;
    private javax.swing.JLabel noReservationsLabel;
    private javax.swing.JScrollPane reservationsList;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton viewReservationButton;
    // End of variables declaration//GEN-END:variables
}
