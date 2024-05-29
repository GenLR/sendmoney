/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teller;

import user.internalpages.*;

public class tellerdash extends javax.swing.JFrame {

    
    public tellerdash() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        send = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        receive = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        history = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        customer = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        tellerpages = new javax.swing.JDesktopPane();

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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("LOGOUT");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(730, 10, 59, 17);

        send.setBackground(new java.awt.Color(60, 120, 240));
        send.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendMouseClicked(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(60, 120, 240));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 204, 51));
        jLabel9.setText("Send Money");

        javax.swing.GroupLayout sendLayout = new javax.swing.GroupLayout(send);
        send.setLayout(sendLayout);
        sendLayout.setHorizontalGroup(
            sendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sendLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sendLayout.setVerticalGroup(
            sendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel2.add(send);
        send.setBounds(10, 40, 130, 30);

        receive.setBackground(new java.awt.Color(60, 120, 240));
        receive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                receiveMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 204, 51));
        jLabel6.setText("Receive Money");

        javax.swing.GroupLayout receiveLayout = new javax.swing.GroupLayout(receive);
        receive.setLayout(receiveLayout);
        receiveLayout.setHorizontalGroup(
            receiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receiveLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        receiveLayout.setVerticalGroup(
            receiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel2.add(receive);
        receive.setBounds(160, 40, 156, 30);

        history.setBackground(new java.awt.Color(60, 120, 240));
        history.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historyMouseClicked(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(60, 120, 240));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 204, 51));
        jLabel8.setText("Transactions");

        javax.swing.GroupLayout historyLayout = new javax.swing.GroupLayout(history);
        history.setLayout(historyLayout);
        historyLayout.setHorizontalGroup(
            historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(historyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        historyLayout.setVerticalGroup(
            historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel2.add(history);
        history.setBounds(330, 40, 136, 30);

        customer.setBackground(new java.awt.Color(60, 120, 240));
        customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 204, 51));
        jLabel7.setText("View Customer");

        javax.swing.GroupLayout customerLayout = new javax.swing.GroupLayout(customer);
        customer.setLayout(customerLayout);
        customerLayout.setHorizontalGroup(
            customerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        customerLayout.setVerticalGroup(
            customerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel2.add(customer);
        customer.setBounds(480, 40, 160, 30);

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
        jPanel4.setBounds(320, 40, 5, 30);

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
        jPanel5.setBounds(470, 40, 5, 30);

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

    private void receiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receiveMouseClicked
        receiveMoney remo = new receiveMoney();
        tellerpages.add(remo).setVisible(true);
    }//GEN-LAST:event_receiveMouseClicked
        
    private void customerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerMouseClicked
        viewCustomer vicu = new viewCustomer();
        tellerpages.add(vicu).setVisible(true);
    }//GEN-LAST:event_customerMouseClicked

    private void historyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyMouseClicked
        viewHistory his = new viewHistory();
        tellerpages.add(his).setVisible(true);
    }//GEN-LAST:event_historyMouseClicked

    private void sendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendMouseClicked
        sendMoney semo = new sendMoney();
        tellerpages.add(semo).setVisible(true);
    }//GEN-LAST:event_sendMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    //    viewHistory his = new viewHistory();
    //    tellerpages.add(his).setVisible(true);
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
    private javax.swing.JPanel customer;
    private javax.swing.JPanel history;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel receive;
    private javax.swing.JPanel send;
    private javax.swing.JDesktopPane tellerpages;
    // End of variables declaration//GEN-END:variables
}
