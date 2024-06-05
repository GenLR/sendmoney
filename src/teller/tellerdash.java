/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teller;

import config.Session;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import login.logindash;
import user.internalpages.*;

public class tellerdash extends javax.swing.JFrame {

    
    public tellerdash() {
        initComponents();
        updateTimeAndDate();
    }
    
    private void updateTimeAndDate(){
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DateTimeFormatter times = DateTimeFormatter.ofPattern("HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                time.setText(times.format(now));
                
                DateTimeFormatter dates = DateTimeFormatter.ofPattern("MM-dd-yyy");
                date.setText(dates.format(now));
            }
        });
        timer.start();
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
        logout = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        send = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        receive = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        transaction = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        customer = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tellerpages = new javax.swing.JDesktopPane();
        genBackground1 = new config.genBackground();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        teller_name = new javax.swing.JLabel();

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

        jPanel2.setBackground(new java.awt.Color(20, 120, 240));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 80));
        jPanel2.setLayout(null);

        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        logout.setComponentPopupMenu(jPopupMenu1);
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
        jPanel7.add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 60, 20));

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

        jPanel6.setOpaque(false);

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

        jPanel3.setMinimumSize(new java.awt.Dimension(1, 30));
        jPanel3.setPreferredSize(new java.awt.Dimension(1, 25));

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

        jPanel4.setPreferredSize(new java.awt.Dimension(1, 25));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

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

        jPanel5.setPreferredSize(new java.awt.Dimension(1, 30));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(send)
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(receive)
                .addGap(9, 9, 9)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(transaction, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(customer)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(send, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(receive, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transaction, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2.add(jPanel6);
        jPanel6.setBounds(160, 50, 590, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo ('80).png"))); // NOI18N
        jPanel2.add(jLabel4);
        jLabel4.setBounds(0, 0, 142, 80);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("where money flies");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(50, 60, 100, 20);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1010, 80);

        tellerpages.setPreferredSize(new java.awt.Dimension(800, 459));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/money-remittance (1).png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 120, 240));
        jLabel1.setText("Welcome Teller");

        teller_name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        teller_name.setText("Name");

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
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(teller_name, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(297, Short.MAX_VALUE))
        );
        genBackground1Layout.setVerticalGroup(
            genBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(genBackground1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(genBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teller_name)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(127, 127, 127))
        );

        tellerpages.setLayer(genBackground1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout tellerpagesLayout = new javax.swing.GroupLayout(tellerpages);
        tellerpages.setLayout(tellerpagesLayout);
        tellerpagesLayout.setHorizontalGroup(
            tellerpagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tellerpagesLayout.createSequentialGroup()
                .addComponent(genBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        tellerpagesLayout.setVerticalGroup(
            tellerpagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(genBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(tellerpages);
        tellerpages.setBounds(0, 80, 1010, 420);

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
        teller_name.setText(fname[0]);
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
    private javax.swing.JLabel date;
    private config.genBackground genBackground1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel receive;
    private javax.swing.JLabel send;
    private javax.swing.JLabel teller_name;
    private javax.swing.JDesktopPane tellerpages;
    private javax.swing.JLabel time;
    private javax.swing.JLabel transaction;
    // End of variables declaration//GEN-END:variables
}
