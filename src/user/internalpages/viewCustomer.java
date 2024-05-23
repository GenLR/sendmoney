/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.internalpages;

import config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Larosa Family
 */
public class viewCustomer extends javax.swing.JInternalFrame {

    /**
     * Creates new form viewCustomer
     */
    public viewCustomer() {
        initComponents();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
    }
    
    public void displayData(){
        
        if(search.getText().isEmpty()){
            try{
                dbConnector dbc = new dbConnector();
                ResultSet rs = dbc.getData("SELECT tr_id, tbl_sender.se_name, tbl_sender.se_contact, tbl_sender.se_card, tbl_receiver.re_name, tbl_receiver.re_contact, tbl_receiver.re_card, tr_location, tr_amount, tr_charge, tr_code, tr_datesent, tr_datereceived  \n" +
                        "FROM `tbl_transactions`\n" +
                        "\n" +
                        "INNER JOIN tbl_sender \n" +
                        "ON tbl_sender.se_id = tbl_transactions.tr_id \n" +
                        "\n" +
                        "INNER JOIN tbl_receiver \n" +
                        "ON tbl_receiver.re_id = tbl_transactions.tr_id");
                customer_table.setModel(DbUtils.resultSetToTableModel(rs));
                rs.close();
            }catch(SQLException ex){
                System.out.println("Errors: "+ex.getMessage());
            } 
        }else{
            try{
                dbConnector dbc = new dbConnector();
                ResultSet rs = dbc.getData("SELECT * FROM tbl_transactions WHERE tr_senderinfo = '"+search.getText()+"' OR "
                        + "tr_receiverinfo = '"+search.getText()+"' OR tr_location = '"+search.getText()+"' OR "
                        + "tr_amount = '"+search.getText()+"' OR tr_charge = '"+search.getText()+"' "
                        + "OR tr_code = '"+search.getText()+"' OR tr_datesent = '"+search.getText()+"' "
                        + "OR tr_datereceived = '"+search.getText()+"'");
                customer_table.setModel(DbUtils.resultSetToTableModel(rs));
                rs.close();
            }catch(SQLException ex){
                System.out.println("Errors: "+ex.getMessage());
            } 
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        customer_table = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(800, 400));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setViewportView(customer_table);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel6);
        jPanel6.setBounds(390, 0, 390, 370);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(null);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(19, 53, 112));
        jLabel25.setText("Full Name");
        jPanel9.add(jLabel25);
        jLabel25.setBounds(10, 60, 80, 20);
        jPanel9.add(name);
        name.setBounds(110, 50, 260, 30);
        jPanel9.add(jTextField23);
        jTextField23.setBounds(110, 80, 260, 30);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(19, 53, 112));
        jLabel26.setText("Contact no.");
        jPanel9.add(jLabel26);
        jLabel26.setBounds(10, 90, 80, 20);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(19, 53, 112));
        jLabel27.setText("Gender");
        jPanel9.add(jLabel27);
        jLabel27.setBounds(10, 120, 43, 20);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(19, 53, 112));
        jLabel28.setText("Nationality");
        jPanel9.add(jLabel28);
        jLabel28.setBounds(10, 150, 80, 20);

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(19, 53, 112));
        jLabel29.setText("Address");
        jPanel9.add(jLabel29);
        jLabel29.setBounds(10, 180, 60, 20);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(19, 53, 112));
        jLabel30.setText("Date of Birth");
        jPanel9.add(jLabel30);
        jLabel30.setBounds(10, 210, 80, 20);

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(19, 53, 112));
        jLabel31.setText("Place of Birth");
        jPanel9.add(jLabel31);
        jLabel31.setBounds(10, 240, 90, 20);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(19, 53, 112));
        jLabel32.setText("Marital Status");
        jPanel9.add(jLabel32);
        jLabel32.setBounds(10, 270, 90, 20);

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(19, 53, 112));
        jLabel33.setText("Occupation");
        jPanel9.add(jLabel33);
        jLabel33.setBounds(10, 300, 80, 20);
        jPanel9.add(jTextField24);
        jTextField24.setBounds(110, 290, 260, 30);
        jPanel9.add(jTextField25);
        jTextField25.setBounds(110, 260, 260, 30);
        jPanel9.add(jTextField26);
        jTextField26.setBounds(110, 230, 260, 30);
        jPanel9.add(jTextField27);
        jTextField27.setBounds(110, 200, 260, 30);
        jPanel9.add(jTextField28);
        jTextField28.setBounds(110, 170, 260, 30);
        jPanel9.add(jTextField29);
        jTextField29.setBounds(110, 140, 260, 30);
        jPanel9.add(jTextField30);
        jTextField30.setBounds(110, 110, 260, 30);

        jPanel4.setBackground(new java.awt.Color(20, 120, 240));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ADD");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel4);
        jPanel4.setBounds(110, 340, 80, 31);

        jPanel10.setBackground(new java.awt.Color(20, 120, 240));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("UPDATE");
        jPanel10.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 31));

        jPanel9.add(jPanel10);
        jPanel10.setBounds(200, 340, 80, 31);

        jPanel11.setBackground(new java.awt.Color(20, 120, 240));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("REFRESH");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel11);
        jPanel11.setBounds(290, 340, 80, 31);

        jPanel3.setBackground(new java.awt.Color(20, 120, 240));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SEARCH");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel3);
        jPanel3.setBounds(290, 10, 80, 30);

        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel9.add(search);
        search.setBounds(160, 10, 120, 30);

        jPanel1.add(jPanel9);
        jPanel9.setBounds(0, 0, 390, 370);

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

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        displayData();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable customer_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField name;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
