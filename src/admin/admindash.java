
package admin;

import admin.internalpages.*;
import config.Session;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import login.logindash;

public class admindash extends javax.swing.JFrame {
    
    public admindash() {
        initComponents();
        updateTimeAndDate();
    }

    private void updateTimeAndDate() {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DateTimeFormatter times = DateTimeFormatter.ofPattern("HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                time.setText(times.format(now));
                
                DateTimeFormatter dates = DateTimeFormatter.ofPattern("MM-dd-yyyy");
                date.setText(dates.format(now));
            }
        });
        timer.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        logout = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        users = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        transactions = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        adminpages = new javax.swing.JDesktopPane();
        genBackground1 = new config.genBackground();
        jLabel4 = new javax.swing.JLabel();
        admin_name = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(20, 120, 240));
        jPanel2.setLayout(null);

        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        jPanel2.add(logout);
        logout.setBounds(970, 0, 24, 40);

        jPanel7.setBackground(new java.awt.Color(60, 120, 240));
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        date.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 20));

        time.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 60, 20));

        jPanel8.setPreferredSize(new java.awt.Dimension(1, 25));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jPanel2.add(jPanel7);
        jPanel7.setBounds(830, 50, 170, 30);

        jPanel4.setOpaque(false);

        users.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        users.setForeground(new java.awt.Color(255, 204, 51));
        users.setText("Users");
        users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersMouseClicked(evt);
            }
        });

        jPanel3.setPreferredSize(new java.awt.Dimension(1, 30));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        transactions.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        transactions.setForeground(new java.awt.Color(255, 204, 51));
        transactions.setText("Transactions");
        transactions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transactionsMouseClicked(evt);
            }
        });

        jPanel6.setPreferredSize(new java.awt.Dimension(1, 30));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 204, 51));
        jLabel8.setText("Reports");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(users)
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(transactions)
                .addGap(12, 12, 12)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(users, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transactions, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2.add(jPanel4);
        jPanel4.setBounds(160, 50, 300, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo ('80).png"))); // NOI18N
        jPanel2.add(jLabel5);
        jLabel5.setBounds(0, 0, 142, 80);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("where money flies");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(50, 60, 100, 20);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1010, 80);

        adminpages.setBackground(new java.awt.Color(204, 204, 204));
        adminpages.setPreferredSize(new java.awt.Dimension(800, 459));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(20, 120, 240));
        jLabel4.setText("Welcome Admin");

        admin_name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        admin_name.setText("Name");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/money-remittance (1).png"))); // NOI18N

        javax.swing.GroupLayout genBackground1Layout = new javax.swing.GroupLayout(genBackground1);
        genBackground1.setLayout(genBackground1Layout);
        genBackground1Layout.setHorizontalGroup(
            genBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(genBackground1Layout.createSequentialGroup()
                .addGroup(genBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(genBackground1Layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(jLabel3))
                    .addGroup(genBackground1Layout.createSequentialGroup()
                        .addGap(371, 371, 371)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(admin_name, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(297, Short.MAX_VALUE))
        );
        genBackground1Layout.setVerticalGroup(
            genBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(genBackground1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(genBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admin_name)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(127, 127, 127))
        );

        adminpages.setLayer(genBackground1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout adminpagesLayout = new javax.swing.GroupLayout(adminpages);
        adminpages.setLayout(adminpagesLayout);
        adminpagesLayout.setHorizontalGroup(
            adminpagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(genBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        adminpagesLayout.setVerticalGroup(
            adminpagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(genBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(adminpages);
        adminpages.setBounds(0, 80, 1000, 420);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1016, 539));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Session ses = Session.getInstance();
        String[] fname = ses.getName().split("\\s+");
        admin_name.setText(fname[0]);
    }//GEN-LAST:event_formWindowActivated

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        int res = JOptionPane.showConfirmDialog(null, "Confirm Logout?", "Confirmation", JOptionPane.YES_NO_OPTION);

        if(res == JOptionPane.YES_OPTION) {
            logindash loda = new logindash();
            loda.setVisible(true);
            this.dispose();
        }else if(res == JOptionPane.NO_OPTION) {
            System.out.println("User clicked No");
        }
    }//GEN-LAST:event_logoutMouseClicked

    private void usersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersMouseClicked
        usersPage uspa = new usersPage();
        adminpages.add(uspa).setVisible(true);
    }//GEN-LAST:event_usersMouseClicked

    private void transactionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionsMouseClicked
        transactionsPage trapa = new transactionsPage();
        adminpages.add(trapa).setVisible(true);
    }//GEN-LAST:event_transactionsMouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        reportsPage repa = new reportsPage();
        adminpages.add(repa).setVisible(true);
    }//GEN-LAST:event_jLabel8MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(admindash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admindash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admindash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admindash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admindash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel admin_name;
    private javax.swing.JDesktopPane adminpages;
    private javax.swing.JLabel date;
    private config.genBackground genBackground1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel time;
    private javax.swing.JLabel transactions;
    private javax.swing.JLabel users;
    // End of variables declaration//GEN-END:variables
}
