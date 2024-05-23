/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.internalpages;

import config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Larosa Family
 */
public class sendMoney extends javax.swing.JInternalFrame {

    /**
     * Creates new form createTransaction
     */
    public sendMoney() {
        initComponents();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
    }

    public boolean checkCustomer(String nm){
        
        try{
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT cu_name FROM tbl_customer WHERE cu_name = '"+nm+"'");
                if(rs.next()){
                    rs.close();
                    return true;
                }else{
                    rs.close();
                    return false;
                }
            }catch(SQLException ex){
                System.out.println("Errors: "+ex.getMessage());
                return false;
            } 
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        se_cus = new javax.swing.JLabel();
        send_name = new javax.swing.JTextField();
        purpose = new javax.swing.JTextField();
        send_card = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        re_cus = new javax.swing.JLabel();
        receive_name = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        receive_contact = new javax.swing.JTextField();
        location = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        send_contact = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        retoreceiver = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        code = new javax.swing.JTextField();
        amount = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        charge = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 459));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(19, 53, 112));
        jLabel6.setText("Loyalty Card");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 190, 80, 20);

        jPanel2.setBackground(new java.awt.Color(40, 120, 240));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Sender Info");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(287, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 80, 370, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(19, 53, 112));
        jLabel5.setText("Name");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 110, 60, 20);

        jPanel3.setBackground(new java.awt.Color(40, 120, 240));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Receiver Info");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(279, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 240, 370, 20);

        jPanel4.setBackground(new java.awt.Color(40, 120, 240));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Other Info");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(295, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(420, 80, 370, 20);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(19, 53, 112));
        jLabel11.setText("to Receiver");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(440, 120, 70, 20);

        se_cus.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        se_cus.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(se_cus);
        se_cus.setBounds(260, 100, 120, 10);

        send_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                send_nameFocusLost(evt);
            }
        });
        send_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_nameActionPerformed(evt);
            }
        });
        jPanel1.add(send_name);
        send_name.setBounds(120, 110, 250, 30);
        jPanel1.add(purpose);
        purpose.setBounds(530, 150, 250, 30);
        jPanel1.add(send_card);
        send_card.setBounds(120, 190, 250, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(19, 53, 112));
        jLabel13.setText("Contact No.");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(20, 150, 80, 20);

        re_cus.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        re_cus.setForeground(new java.awt.Color(255, 0, 0));
        re_cus.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                re_cusFocusLost(evt);
            }
        });
        jPanel1.add(re_cus);
        re_cus.setBounds(260, 260, 120, 10);

        receive_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                receive_nameFocusLost(evt);
            }
        });
        receive_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receive_nameActionPerformed(evt);
            }
        });
        jPanel1.add(receive_name);
        receive_name.setBounds(120, 270, 250, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(19, 53, 112));
        jLabel8.setText("Name");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(20, 270, 60, 20);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(19, 53, 112));
        jLabel14.setText("Contact No.");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(20, 310, 80, 20);
        jPanel1.add(receive_contact);
        receive_contact.setBounds(120, 310, 250, 30);

        location.setText("Anywhere in the Philippines");
        jPanel1.add(location);
        location.setBounds(120, 350, 250, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(19, 53, 112));
        jLabel9.setText("Location");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(20, 360, 70, 20);
        jPanel1.add(send_contact);
        send_contact.setBounds(120, 150, 250, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(19, 53, 112));
        jLabel15.setText("Relationship");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(430, 110, 80, 20);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(19, 53, 112));
        jLabel16.setText("Branch");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(20, 350, 60, 20);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(19, 53, 112));
        jLabel17.setText("Purpose of");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(430, 150, 80, 20);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(19, 53, 112));
        jLabel18.setText("Transaction");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(440, 160, 80, 20);
        jPanel1.add(retoreceiver);
        retoreceiver.setBounds(530, 110, 250, 30);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(19, 53, 112));
        jLabel19.setText("Amount");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(430, 190, 80, 20);
        jPanel1.add(code);
        code.setBounds(120, 20, 170, 30);
        jPanel1.add(amount);
        amount.setBounds(530, 190, 250, 30);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(19, 53, 112));
        jLabel20.setText("Fee");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(430, 230, 80, 20);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(19, 53, 112));
        jLabel21.setText("Transaction");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(20, 20, 80, 20);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(19, 53, 112));
        jLabel22.setText("Code");
        jPanel1.add(jLabel22);
        jLabel22.setBounds(30, 30, 80, 20);
        jPanel1.add(charge);
        charge.setBounds(530, 230, 170, 30);

        jPanel5.setBackground(new java.awt.Color(20, 120, 240));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 51));
        jLabel3.setText("Generate Reciept");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5);
        jPanel5.setBounds(570, 310, 130, 31);

        jPanel6.setBackground(new java.awt.Color(20, 120, 240));
        jPanel6.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 204, 51));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("View Rates");
        jPanel6.add(jLabel12);
        jLabel12.setBounds(10, 0, 56, 30);

        jPanel1.add(jPanel6);
        jPanel6.setBounds(710, 230, 70, 30);

        jPanel7.setBackground(new java.awt.Color(20, 120, 240));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });
        jPanel7.setLayout(null);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 204, 51));
        jLabel24.setText("Generate");
        jPanel7.add(jLabel24);
        jLabel24.setBounds(10, 0, 46, 20);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 204, 51));
        jLabel25.setText("Code");
        jPanel7.add(jLabel25);
        jLabel25.setBounds(20, 10, 30, 20);

        jPanel1.add(jPanel7);
        jPanel7.setBounds(300, 20, 70, 30);

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void send_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_send_nameActionPerformed

    private void receive_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receive_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_receive_nameActionPerformed

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        
        String letters = "abcdefghijklmnopqrstuvwxyz";
        char[] alphanumeric = (letters + letters.toUpperCase() + "0123456789").toCharArray();
        
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < 10; i++){
            result.append(alphanumeric[new Random().nextInt(alphanumeric.length)]);
        }
        code.setText(result.toString());
        
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        
        dbConnector dbc = new dbConnector();
        
        if(!send_name.getText().equalsIgnoreCase(receive_name.getText())){
            System.out.println("Name Found");
            
        /*    if(dbc.insertData("INSERT INTO tbl_sender (se_name, se_contact, se_card) "
                    + "SELECT cu_id, '"+send_contact.getText()+"', '"+send_card.getText()+"' "
                    + "FROM tbl_customer "
                    + "WHERE cu_name = '"+send_name.getText()+"' ")){
                
            }
                    
            if(dbc.insertData("INSERT INTO tbl_receiver (re_name, re_contact, re_card) "
                    + "SELECT cu_id, '"+receive_contact.getText()+"', '0' "
                    + "FROM tbl_customer "
                    + "WHERE cu_name = '"+receive_name.getText()+"' ")){
                
            }
        
        
            dbc.insertData("INSERT INTO tbl_transactions (tr_sender, tr_receiver, tr_location, tr_amount, tr_charge, tr_code, re_datesent, re_datereceived) " +
                "SELECT se_id, re_id, '"+location.getText()+"', '"+amount.getText()+"', '"+charge.getText()+"', '"+code.getText()+"', '2002-08-22', '2002-08-06' "
                        + "FROM tbl_sender s "
                        + "INNER JOIN tbl_receiver r ON tbl_receiver.re_id = tbl_transantion.tr_id"
                        + "WHERE cu_name = '"+send_name.getText()+"' AND cu_name = '"+receive_name.getText()+"' ");
        */
        
            dbc.insertData("INSERT INTO tbl_transactions t (tr_sender, tr_receiver, tr_location, tr_amount, tr_charge, tr_code, re_datesent, re_datereceived)" +
                    "VALUES ( "
                    + "(SELECT se_id FROM tbl_sender s INNER JOIN tbl_customer c ON s.se_id = c.cu_id "
                    + " WHERE c.cu_name = '"+send_name.getText()+"' AND s.se_contact = '"+send_contact.getText()+"' ), "
                    + "(SELECT re_id FROM tbl_receiver r INNER JOIN tbl_customer c ON r.re_id = c.cu_id "
                    + " WHERE c.cu_name = '"+receive_name.getText()+"' AND r.re_contact = '"+receive_contact.getText()+"' ), "
                    + " '"+location.getText()+"', '"+amount.getText()+"', '"+charge.getText()+"', '"+code.getText()+"', '2002-08-22', '2002-08-06' "
                    + " ) " );

        
            JOptionPane.showMessageDialog(null, "Insert Successfully");
        }else if(!checkCustomer(send_name.getText()) && !checkCustomer(receive_name.getText())){
            System.out.println("No Found Name!");
        }else{
            JOptionPane.showMessageDialog(null, "Connection Error");
        }
    }//GEN-LAST:event_jPanel5MouseClicked

    private void send_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_send_nameFocusLost
        if(!checkCustomer(send_name.getText())){
            se_cus.setText("No Customer Information");
        }else{
            se_cus.setText("");
        }
    }//GEN-LAST:event_send_nameFocusLost

    private void re_cusFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_re_cusFocusLost

    }//GEN-LAST:event_re_cusFocusLost

    private void receive_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_receive_nameFocusLost
        if(!checkCustomer(receive_name.getText())){
            re_cus.setText("No Customer Information");
        }else{
            re_cus.setText("");
        }
    }//GEN-LAST:event_receive_nameFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount;
    private javax.swing.JTextField charge;
    private javax.swing.JTextField code;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField location;
    private javax.swing.JTextField purpose;
    private javax.swing.JLabel re_cus;
    private javax.swing.JTextField receive_contact;
    private javax.swing.JTextField receive_name;
    private javax.swing.JTextField retoreceiver;
    private javax.swing.JLabel se_cus;
    private javax.swing.JTextField send_card;
    private javax.swing.JTextField send_contact;
    private javax.swing.JTextField send_name;
    // End of variables declaration//GEN-END:variables
}
