
package popupFrames;

import config.ReceiptPrinter;
import javax.swing.JPanel;


public class receiverreceipt extends javax.swing.JFrame {

    public receiverreceipt() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genBackground1 = new config.genBackground();
        receiptPane = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        code = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        re_card = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        re_name = new javax.swing.JLabel();
        re_contact = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        se_name = new javax.swing.JLabel();
        relationship = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        purpose = new javax.swing.JLabel();
        se_contact = new javax.swing.JLabel();
        amount = new javax.swing.JLabel();
        fee = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(350, 500));

        genBackground1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        receiptPane.setBackground(new java.awt.Color(255, 255, 255));
        receiptPane.setPreferredSize(new java.awt.Dimension(306, 396));
        receiptPane.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo ('80).png"))); // NOI18N
        receiptPane.add(jLabel2);
        jLabel2.setBounds(80, 10, 142, 80);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(20, 120, 240));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("where money flies");
        receiptPane.add(jLabel5);
        jLabel5.setBounds(130, 70, 100, 20);

        code.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        code.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receiptPane.add(code);
        code.setBounds(100, 140, 80, 20);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Poblacion Ward II, Minglanilla, Cebu - Philippines");
        receiptPane.add(jLabel7);
        jLabel7.setBounds(40, 90, 220, 20);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Time");
        receiptPane.add(jLabel8);
        jLabel8.setBounds(190, 150, 40, 10);

        re_card.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        re_card.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receiptPane.add(re_card);
        re_card.setBounds(220, 210, 60, 10);

        time.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receiptPane.add(time);
        time.setBounds(230, 150, 60, 10);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Date");
        receiptPane.add(jLabel11);
        jLabel11.setBounds(190, 140, 40, 10);

        date.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receiptPane.add(date);
        date.setBounds(230, 140, 60, 10);

        jPanel2.setBackground(new java.awt.Color(20, 120, 240));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Receiver Info");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 204, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        receiptPane.add(jPanel2);
        jPanel2.setBounds(20, 170, 270, 13);

        jPanel3.setBackground(new java.awt.Color(20, 120, 240));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Receive Form");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel6)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
        );

        receiptPane.add(jPanel3);
        jPanel3.setBounds(20, 110, 270, 20);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Transaction Code");
        receiptPane.add(jLabel10);
        jLabel10.setBounds(20, 140, 80, 20);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Name");
        receiptPane.add(jLabel12);
        jLabel12.setBounds(30, 190, 30, 10);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Contact no.");
        receiptPane.add(jLabel13);
        jLabel13.setBounds(30, 210, 50, 10);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Loyalty Card");
        receiptPane.add(jLabel14);
        jLabel14.setBounds(150, 200, 60, 30);

        re_name.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        re_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receiptPane.add(re_name);
        re_name.setBounds(90, 190, 200, 10);

        re_contact.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        re_contact.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receiptPane.add(re_contact);
        re_contact.setBounds(90, 210, 60, 10);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Name");
        receiptPane.add(jLabel17);
        jLabel17.setBounds(30, 250, 30, 10);

        jPanel4.setBackground(new java.awt.Color(20, 120, 240));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sender Info");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 214, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        receiptPane.add(jPanel4);
        jPanel4.setBounds(20, 230, 270, 13);

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Contact no.");
        receiptPane.add(jLabel19);
        jLabel19.setBounds(30, 270, 50, 10);

        se_name.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        se_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receiptPane.add(se_name);
        se_name.setBounds(90, 250, 200, 10);

        relationship.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        relationship.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receiptPane.add(relationship);
        relationship.setBounds(90, 360, 90, 20);

        jPanel5.setBackground(new java.awt.Color(20, 120, 240));

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Other Info");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 214, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        receiptPane.add(jPanel5);
        jPanel5.setBounds(20, 310, 270, 13);

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Total");
        receiptPane.add(jLabel25);
        jLabel25.setBounds(180, 370, 40, 10);

        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("to Receiver");
        receiptPane.add(jLabel26);
        jLabel26.setBounds(30, 370, 60, 10);

        jLabel27.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Transaction");
        receiptPane.add(jLabel27);
        jLabel27.setBounds(30, 340, 60, 10);

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Purpose of");
        receiptPane.add(jLabel29);
        jLabel29.setBounds(20, 330, 60, 10);

        jLabel30.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Relationship");
        receiptPane.add(jLabel30);
        jLabel30.setBounds(20, 360, 60, 10);

        jLabel31.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("Amount");
        receiptPane.add(jLabel31);
        jLabel31.setBounds(180, 330, 40, 10);

        jLabel32.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel32.setText("Fee");
        receiptPane.add(jLabel32);
        jLabel32.setBounds(180, 350, 40, 10);

        total.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receiptPane.add(total);
        total.setBounds(230, 370, 60, 10);

        purpose.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        purpose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receiptPane.add(purpose);
        purpose.setBounds(90, 330, 90, 20);

        se_contact.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        se_contact.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receiptPane.add(se_contact);
        se_contact.setBounds(90, 270, 90, 10);

        amount.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        amount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receiptPane.add(amount);
        amount.setBounds(230, 330, 60, 10);

        fee.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        fee.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receiptPane.add(fee);
        fee.setBounds(230, 350, 60, 10);

        genBackground1.add(receiptPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 20, -1, -1));

        jButton1.setBackground(new java.awt.Color(20, 120, 240));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("PRINT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        genBackground1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 170, 30));

        jPanel1.setBackground(new java.awt.Color(40, 120, 240));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Receiver Receipt ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 7, 170, 24));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back ('24).png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, -1, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(genBackground1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(genBackground1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setSize(new java.awt.Dimension(366, 539));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JPanel myPanel = new JPanel();
        ReceiptPrinter rPrint = new ReceiptPrinter(receiptPane);
        rPrint.printPanel();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(receiverreceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(receiverreceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(receiverreceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(receiverreceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new receiverreceipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amount;
    private javax.swing.JLabel code;
    private javax.swing.JLabel date;
    private javax.swing.JLabel fee;
    private config.genBackground genBackground1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel purpose;
    private javax.swing.JLabel re_card;
    private javax.swing.JLabel re_contact;
    private javax.swing.JLabel re_name;
    private javax.swing.JPanel receiptPane;
    private javax.swing.JLabel relationship;
    private javax.swing.JLabel se_contact;
    private javax.swing.JLabel se_name;
    private javax.swing.JLabel time;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
