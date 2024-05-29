/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teller;

import java.awt.Color;
import javax.swing.JOptionPane;
import login.logindash;
import user.internalpages.*;

public class tellerdash extends javax.swing.JFrame {

    
    public tellerdash() {
        initComponents();
        
    }
    
    Color myYellow = new Color(255,204,51);
    Color myWhite = new Color(240,240,240);
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        confirmOut = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        send = new javax.swing.JLabel();
        receive = new javax.swing.JLabel();
        transaction = new javax.swing.JLabel();
        customer = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        tellerpages = new javax.swing.JDesktopPane();

        confirmOut.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        confirmOut.setText("Confirm Logout");
        jPopupMenu1.add(confirmOut);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(60, 120, 240));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 80));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 51));
        jLabel1.setText("Welcome Teller");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 10, 92, 17);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(110, 10, 99, 17);

        jPanel3.setPreferredSize(new java.awt.Dimension(5, 25));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(145, 40, 5, 30);

        jPanel4.setPreferredSize(new java.awt.Dimension(5, 25));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4);
        jPanel4.setBounds(310, 40, 5, 30);

        jPanel5.setPreferredSize(new java.awt.Dimension(5, 25));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5);
        jPanel5.setBounds(455, 40, 5, 30);

        send.setBackground(new java.awt.Color(60, 120, 240));
        send.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        send.setForeground(new java.awt.Color(255, 204, 51));
        send.setText("Send Money");
        send.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        send.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sendMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sendMouseExited(evt);
            }
        });
        jPanel2.add(send);
        send.setBounds(20, 40, 110, 30);

        receive.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        receive.setForeground(new java.awt.Color(255, 204, 51));
        receive.setText("Receive Money");
        receive.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        receive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                receiveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                receiveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                receiveMouseExited(evt);
            }
        });
        jPanel2.add(receive);
        receive.setBounds(160, 40, 136, 30);

        transaction.setBackground(new java.awt.Color(60, 120, 240));
        transaction.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        transaction.setForeground(new java.awt.Color(255, 204, 51));
        transaction.setText("Transactions");
        transaction.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        transaction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transactionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                transactionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                transactionMouseExited(evt);
            }
        });
        jPanel2.add(transaction);
        transaction.setBounds(326, 40, 120, 30);

        customer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        customer.setForeground(new java.awt.Color(255, 204, 51));
        customer.setText("View Customer");
        customer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                customerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                customerMouseExited(evt);
            }
        });
        jPanel2.add(customer);
        customer.setBounds(470, 40, 136, 30);

        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        logout.setComponentPopupMenu(jPopupMenu1);
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        jPanel2.add(logout);
        logout.setBounds(770, 0, 24, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 800, 80);

        tellerpages.setPreferredSize(new java.awt.Dimension(800, 459));

        javax.swing.GroupLayout tellerpagesLayout = new javax.swing.GroupLayout(tellerpages);
        tellerpages.setLayout(tellerpagesLayout);
        tellerpagesLayout.setHorizontalGroup(
            tellerpagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        tellerpagesLayout.setVerticalGroup(
            tellerpagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        jPanel1.add(tellerpages);
        tellerpages.setBounds(0, 80, 800, 420);

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
        
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    //    viewHistory his = new viewHistory();
    //    tellerpages.add(his).setVisible(true);
    }//GEN-LAST:event_formWindowActivated

    private void sendMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendMouseEntered
        send.setForeground(myWhite);
    }//GEN-LAST:event_sendMouseEntered

    private void sendMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendMouseExited
        send.setForeground(myYellow);
    }//GEN-LAST:event_sendMouseExited

    private void customerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerMouseEntered
        customer.setForeground(myWhite);
    }//GEN-LAST:event_customerMouseEntered

    private void customerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerMouseExited
        customer.setForeground(myYellow);
    }//GEN-LAST:event_customerMouseExited

    private void sendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendMouseClicked
        sendMoney semo = new sendMoney();
        tellerpages.add(semo).setVisible(true);
    }//GEN-LAST:event_sendMouseClicked

    private void receiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receiveMouseClicked
        receiveMoney remo = new receiveMoney();
        tellerpages.add(remo).setVisible(true);
    }//GEN-LAST:event_receiveMouseClicked

    private void receiveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receiveMouseEntered
        receive.setForeground(myWhite);
    }//GEN-LAST:event_receiveMouseEntered

    private void receiveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receiveMouseExited
        receive.setForeground(myYellow);
    }//GEN-LAST:event_receiveMouseExited

    private void transactionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionMouseClicked
        viewHistory his = new viewHistory();
        tellerpages.add(his).setVisible(true);
    }//GEN-LAST:event_transactionMouseClicked

    private void transactionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionMouseEntered
        transaction.setForeground(myWhite);
    }//GEN-LAST:event_transactionMouseEntered

    private void transactionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionMouseExited
        transaction.setForeground(myYellow);
    }//GEN-LAST:event_transactionMouseExited

    private void customerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerMouseClicked
        viewCustomer vicu = new viewCustomer();
        tellerpages.add(vicu).setVisible(true);
    }//GEN-LAST:event_customerMouseClicked

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
            java.util.logging.Logger.getLogger(tellerdash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tellerdash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tellerdash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tellerdash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tellerdash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem confirmOut;
    private javax.swing.JLabel customer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel receive;
    private javax.swing.JLabel send;
    private javax.swing.JDesktopPane tellerpages;
    private javax.swing.JLabel transaction;
    // End of variables declaration//GEN-END:variables
}
