package es.ulpgc.fitmanager.view.gui.statistics;

import es.ulpgc.fitmanager.controller.dbcontroller.ReservationController;
import es.ulpgc.fitmanager.controller.dbcontroller.UserController;
import es.ulpgc.fitmanager.model.User;
import java.util.List;
import javax.swing.DefaultListModel;

public class ClientStatistics extends javax.swing.JFrame {
    
    private final User loggedUser;
    
    private final DefaultListModel listModel = new DefaultListModel();

    private final UserController userController =  new UserController();
    
    private final ReservationController reservationController =  new ReservationController();
    
    public ClientStatistics(User user) {
        this.loggedUser = user;
        initComponents();
        
        List<User>clients  = userController.getUsersByRole(User.CLIENT_ROLE);
        
        for (User client :  clients) {
            listModel.addElement(client);
        }
        clientsList.setModel(listModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        redPanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        whitePanel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        showMoreButton = new javax.swing.JButton();
        clientsListScrollPane = new javax.swing.JScrollPane();
        clientsList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(320, 568));
        setResizable(false);

        redPanel.setBackground(new java.awt.Color(255, 0, 0));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        javax.swing.GroupLayout redPanelLayout = new javax.swing.GroupLayout(redPanel);
        redPanel.setLayout(redPanelLayout);
        redPanelLayout.setHorizontalGroup(
            redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        redPanelLayout.setVerticalGroup(
            redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, redPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        whitePanel.setBackground(new java.awt.Color(255, 255, 255));

        backButton.setForeground(new java.awt.Color(0, 51, 255));
        backButton.setText("<  Estadísticas");
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
        titleLabel.setText("Clientes");

        showMoreButton.setText("Ver más");
        showMoreButton.setEnabled(false);
        showMoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showMoreButtonActionPerformed(evt);
            }
        });

        clientsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        clientsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientsListMouseClicked(evt);
            }
        });
        clientsListScrollPane.setViewportView(clientsList);

        javax.swing.GroupLayout whitePanelLayout = new javax.swing.GroupLayout(whitePanel);
        whitePanel.setLayout(whitePanelLayout);
        whitePanelLayout.setHorizontalGroup(
            whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(whitePanelLayout.createSequentialGroup()
                .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton)
                    .addGroup(whitePanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(showMoreButton)
                            .addComponent(titleLabel)
                            .addComponent(clientsListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        whitePanelLayout.setVerticalGroup(
            whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, whitePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleLabel)
                .addGap(18, 18, 18)
                .addComponent(clientsListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(showMoreButton)
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(whitePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(redPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
        Statistics statistics = new Statistics(loggedUser);
        statistics.setLocation(this.getLocation());
        statistics.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void showMoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showMoreButtonActionPerformed
        User client = (User) listModel.get(clientsList.getSelectedIndex());
        ClientInformation clientInformation = new ClientInformation(loggedUser,client);
        clientInformation.setLocation(this.getLocation());
        clientInformation.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_showMoreButtonActionPerformed

    private void clientsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientsListMouseClicked
        if(!clientsList.isSelectionEmpty()){
            showMoreButton.setEnabled(true);
        }
    }//GEN-LAST:event_clientsListMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JList<String> clientsList;
    private javax.swing.JScrollPane clientsListScrollPane;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel redPanel;
    private javax.swing.JButton showMoreButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel whitePanel;
    // End of variables declaration//GEN-END:variables
}
