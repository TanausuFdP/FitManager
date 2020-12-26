package es.ulpgc.fitmanager.view.gui.main;

import es.ulpgc.fitmanager.model.User;

public class Help extends javax.swing.JFrame {

    User loggedUser;
    public Help(User loggedUser) {
        this.loggedUser = loggedUser;
        initComponents();
        switch(loggedUser.getRole()){
            case 1:
                accountText2.setText("administrador. Su cuenta está siendo controlada");
                accountText3.setText("por sus superiores. Para cualquier consulta,");
                accountText4.setText("dirígase a ellos.");
                dynamicIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/statistics_button.png")));
                dynamicText.setText("Ver las estadísticas del gimnasio.");
                break;
            case 2:
                accountText2.setText("monitor. Su cuenta está siendo controlada");
                accountText3.setText("por sus superiores. Para cualquier consulta,");
                accountText4.setText("dirígase a ellos.");
                dynamicIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/workday_button.png")));
                dynamicText.setText("Ver tu jornada laboral pendiente.");
                break;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        redPanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        whitePanel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        accountTitle = new javax.swing.JLabel();
        accountText1 = new javax.swing.JLabel();
        accountText2 = new javax.swing.JLabel();
        accountText3 = new javax.swing.JLabel();
        accountText4 = new javax.swing.JLabel();
        buttonsTitle = new javax.swing.JLabel();
        homeIcon = new javax.swing.JLabel();
        homeText = new javax.swing.JLabel();
        dynamicIcon = new javax.swing.JLabel();
        dynamicText = new javax.swing.JLabel();
        scheduleIcon = new javax.swing.JLabel();
        scheduleText = new javax.swing.JLabel();
        videosIcon = new javax.swing.JLabel();
        videosText = new javax.swing.JLabel();
        directsIcon = new javax.swing.JLabel();
        directsText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(320, 568));
        setMinimumSize(new java.awt.Dimension(320, 568));
        setResizable(false);

        redPanel.setBackground(new java.awt.Color(255, 0, 0));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        javax.swing.GroupLayout redPanelLayout = new javax.swing.GroupLayout(redPanel);
        redPanel.setLayout(redPanelLayout);
        redPanelLayout.setHorizontalGroup(
            redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        redPanelLayout.setVerticalGroup(
            redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, redPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        whitePanel.setBackground(new java.awt.Color(255, 255, 255));

        backButton.setForeground(new java.awt.Color(0, 51, 255));
        backButton.setText("<  Menú principal");
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

        accountTitle.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        accountTitle.setText("Cuenta");

        accountText1.setText("Está utilizando una cuenta de FitManager como");

        accountText2.setText("cliente, para cualquier consulta, modificación o");

        accountText3.setText("cancelación de la cuenta hable con la adminis-");

        accountText4.setText("tración de su gimnasio.");

        buttonsTitle.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        buttonsTitle.setText("Botones");

        homeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_button.png"))); // NOI18N

        homeText.setText("Ir al menú principal.");

        dynamicIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reservations_button.png"))); // NOI18N

        dynamicText.setText("Ver tus reservas.");

        scheduleIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schedule_button.png"))); // NOI18N

        scheduleText.setText("Ver el horario del gimnasio.");

        videosIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/video_button.png"))); // NOI18N

        videosText.setText("Buscar vídeos.");

        directsIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/directs_button.png"))); // NOI18N

        directsText.setText("Ver directos.");

        javax.swing.GroupLayout whitePanelLayout = new javax.swing.GroupLayout(whitePanel);
        whitePanel.setLayout(whitePanelLayout);
        whitePanelLayout.setHorizontalGroup(
            whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(whitePanelLayout.createSequentialGroup()
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(whitePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(accountText2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accountText1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accountText3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accountText4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(whitePanelLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(accountTitle))
                    .addGroup(whitePanelLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonsTitle)
                            .addGroup(whitePanelLayout.createSequentialGroup()
                                .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(homeIcon)
                                    .addComponent(dynamicIcon)
                                    .addComponent(scheduleIcon)
                                    .addComponent(videosIcon)
                                    .addComponent(directsIcon))
                                .addGap(30, 30, 30)
                                .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(homeText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dynamicText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(scheduleText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(videosText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(directsText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        whitePanelLayout.setVerticalGroup(
            whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(whitePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton)
                .addGap(4, 4, 4)
                .addComponent(accountTitle)
                .addGap(18, 18, 18)
                .addComponent(accountText1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(accountText2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(accountText3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(accountText4)
                .addGap(18, 18, 18)
                .addComponent(buttonsTitle)
                .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(whitePanelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(homeIcon))
                    .addGroup(whitePanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(homeText)))
                .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(whitePanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dynamicIcon))
                    .addGroup(whitePanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(dynamicText)))
                .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(whitePanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scheduleIcon))
                    .addGroup(whitePanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(scheduleText)))
                .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(whitePanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(videosIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(directsIcon)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(whitePanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(videosText)
                        .addGap(42, 42, 42)
                        .addComponent(directsText)
                        .addGap(44, 44, 44))))
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
        MainMenu mainMenu = new MainMenu(loggedUser);
        mainMenu.setLocation(this.getLocation());
        mainMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountText1;
    private javax.swing.JLabel accountText2;
    private javax.swing.JLabel accountText3;
    private javax.swing.JLabel accountText4;
    private javax.swing.JLabel accountTitle;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel buttonsTitle;
    private javax.swing.JLabel directsIcon;
    private javax.swing.JLabel directsText;
    private javax.swing.JLabel dynamicIcon;
    private javax.swing.JLabel dynamicText;
    private javax.swing.JLabel homeIcon;
    private javax.swing.JLabel homeText;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel redPanel;
    private javax.swing.JLabel scheduleIcon;
    private javax.swing.JLabel scheduleText;
    private javax.swing.JLabel videosIcon;
    private javax.swing.JLabel videosText;
    private javax.swing.JPanel whitePanel;
    // End of variables declaration//GEN-END:variables
}
