/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.internalpages;

import config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Larosa Family
 */
public class transactionsPage extends javax.swing.JInternalFrame {

    /**
     * Creates new form transactionPage
     */
    public transactionsPage() {
        initComponents();
        displayData();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
    }
    
    public void displayData(){
        
        if(search.getText().isEmpty()){
            try{
                dbConnector dbc = new dbConnector();
                ResultSet rs = dbc.getData("SELECT * FROM tbl_transactions");
                transaction_table.setModel(DbUtils.resultSetToTableModel(rs));
                rs.close();
            }catch(SQLException ex){
                System.out.println("Errors: "+ex.getMessage());
            } 
        }else{
            try{
                dbConnector dbc = new dbConnector();
                ResultSet rs = dbc.getData("SELECT * FROM tbl_user WHERE tr_senderinfo = '"+search.getText()+"' OR "
                        + "tr_receiverinfo = '"+search.getText()+"' OR tr_location = '"+search.getText()+"' OR "
                        + "tr_amount = '"+search.getText()+"' OR tr_charge = '"+search.getText()+"' "
                        + "OR tr_code = '"+search.getText()+"' OR tr_datesent = '"+search.getText()+"' "
                        + "OR tr_datereceived = '"+search.getText()+"'");
                transaction_table.setModel(DbUtils.resultSetToTableModel(rs));
                rs.close();
            }catch(SQLException ex){
                System.out.println("Errors: "+ex.getMessage());
            } 
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genBackground1 = new config.genBackground();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        transaction_table = new javax.swing.JTable();
        search = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(1000, 420));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 420));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 0, 204));
        jPanel2.setMinimumSize(new java.awt.Dimension(800, 320));
        jPanel2.setOpaque(false);

        jScrollPane1.setViewportView(transaction_table);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 50, 1000, 370);
        jPanel1.add(search);
        search.setBounds(830, 20, 160, 30);

        javax.swing.GroupLayout genBackground1Layout = new javax.swing.GroupLayout(genBackground1);
        genBackground1.setLayout(genBackground1Layout);
        genBackground1Layout.setHorizontalGroup(
            genBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        genBackground1Layout.setVerticalGroup(
            genBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(genBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(genBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private config.genBackground genBackground1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField search;
    private javax.swing.JTable transaction_table;
    // End of variables declaration//GEN-END:variables
}
