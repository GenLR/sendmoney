/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import admin.internalpages.*;

/**
 *
 * @author Larosa Family
 */
public class admindash extends javax.swing.JFrame {

    /**
     * Creates new form admindash
     */
    public admindash() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        adminpages = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        users = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        transactions = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        reports = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(60, 120, 240));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 51));
        jLabel1.setText("Welcome Admin");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 10, 99, 17);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(120, 10, 99, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("LOGOUT");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(730, 10, 59, 17);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 830, 40);

        adminpages.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout adminpagesLayout = new javax.swing.GroupLayout(adminpages);
        adminpages.setLayout(adminpagesLayout);
        adminpagesLayout.setHorizontalGroup(
            adminpagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        adminpagesLayout.setVerticalGroup(
            adminpagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        jPanel1.add(adminpages);
        adminpages.setBounds(0, 80, 800, 400);

        jLabel3.setText("Date         |        Time");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(670, 480, 120, 20);

        users.setBackground(new java.awt.Color(255, 255, 255));
        users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Users");

        javax.swing.GroupLayout usersLayout = new javax.swing.GroupLayout(users);
        users.setLayout(usersLayout);
        usersLayout.setHorizontalGroup(
            usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usersLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel6)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        usersLayout.setVerticalGroup(
            usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(users);
        users.setBounds(0, 40, 170, 30);

        transactions.setBackground(new java.awt.Color(255, 255, 255));
        transactions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transactionsMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Transactions");

        javax.swing.GroupLayout transactionsLayout = new javax.swing.GroupLayout(transactions);
        transactions.setLayout(transactionsLayout);
        transactionsLayout.setHorizontalGroup(
            transactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transactionsLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel7)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        transactionsLayout.setVerticalGroup(
            transactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(transactions);
        transactions.setBounds(310, 40, 170, 30);

        reports.setBackground(new java.awt.Color(255, 255, 255));
        reports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportsMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Reports");

        javax.swing.GroupLayout reportsLayout = new javax.swing.GroupLayout(reports);
        reports.setLayout(reportsLayout);
        reportsLayout.setHorizontalGroup(
            reportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportsLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel8)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        reportsLayout.setVerticalGroup(
            reportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(reports);
        reports.setBounds(620, 40, 170, 30);

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

        setSize(new java.awt.Dimension(816, 539));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersMouseClicked
        usersPage uspa = new usersPage();
        adminpages.add(uspa).setVisible(true);
    }//GEN-LAST:event_usersMouseClicked

    private void transactionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionsMouseClicked
        transactionsPage trapa = new transactionsPage();
        adminpages.add(trapa).setVisible(true);
    }//GEN-LAST:event_transactionsMouseClicked

    private void reportsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportsMouseClicked
        reportsPage repa = new reportsPage();
        adminpages.add(repa).setVisible(true);
    }//GEN-LAST:event_reportsMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        /*usersPage uspa = new usersPage();
        adminpages.add(uspa).setVisible(true);
        */
    }//GEN-LAST:event_formWindowActivated

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
    private javax.swing.JPanel adminpages;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel reports;
    private javax.swing.JPanel transactions;
    private javax.swing.JPanel users;
    // End of variables declaration//GEN-END:variables
}