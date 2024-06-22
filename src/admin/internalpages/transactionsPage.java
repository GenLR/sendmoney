/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.internalpages;

import config.Session;
import config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
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
        Session ses = Session.getInstance();
       
        try{
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT "
                    + " tr_code AS Code, "
                    + " tr_type AS 'Transaction Type', "
                    + " CONCAT(sender.cu_lname, ', ', sender.cu_fname, ' ', LEFT(sender.cu_mname, 1), '.') AS Customer, "
                    + " send.co_number AS Contact, "
                    + " CONCAT(receiver.cu_lname, ', ', receiver.cu_fname, ' ', LEFT(receiver.cu_mname, 1), '.') AS Counterparty, "
                    + " receive.co_number AS Contact, "
                    + " tr_location AS Destination, "
                //    + " tr_relation AS Relationship, "
                //    + " tr_purpose AS Purpose, "
                    + " tr_amount AS Amount, "
                //    + " tr_fee AS Charge, "
                //    + " tr_total AS Payment, "
                    + " tr_when AS 'Date & Time', "
                    + " tell.fullname AS 'Teller Incharge' " 
                    + " FROM tbl_transactions t " 
                    + " INNER JOIN tbl_customer sender ON t.tr_customer = sender.cu_id " 
                    + " INNER JOIN tbl_customer receiver ON t.tr_counterparty = receiver.cu_id " 
                    + " INNER JOIN tbl_contact send ON t.tr_customerno = send.co_id " 
                    + " INNER JOIN tbl_contact receive ON t.tr_counterpartyno = receive.co_id "
                    + " INNER JOIN tbl_user tell ON t.tr_teller = tell.employeeid" );
            transaction_table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        } 
        
    }
    
    public void searchTable(){
        DefaultTableModel model = (DefaultTableModel)transaction_table.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
        transaction_table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search.getText().trim()));     
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genBackground1 = new config.genBackground();
        jPanel1 = new javax.swing.JPanel();
        search = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        transaction_table = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        send_lname = new javax.swing.JTextField();
        send_fname = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        send_mname = new javax.swing.JTextField();
        send_contact = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        receive_lname = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        receive_fname = new javax.swing.JTextField();
        receive_mname = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        receive_contact = new javax.swing.JTextField();
        location = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        relations = new javax.swing.JTextField();
        purpose = new javax.swing.JTextField();
        amount = new javax.swing.JTextField();
        fee = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1000, 459));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 459));
        jPanel1.setLayout(null);

        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchKeyTyped(evt);
            }
        });
        jPanel1.add(search);
        search.setBounds(840, 10, 150, 30);

        jPanel2.setBackground(new java.awt.Color(40, 120, 240));
        jPanel2.setOpaque(false);

        transaction_table.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        transaction_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        transaction_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transaction_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(transaction_table);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 40, 980, 180);

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(40, 120, 240));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Sender Info");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addContainerGap(217, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 300, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(19, 53, 112));
        jLabel12.setText("Last Name");
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 80, 20));

        send_lname.setEditable(false);
        jPanel7.add(send_lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 180, 30));

        send_fname.setEditable(false);
        jPanel7.add(send_fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 65, 180, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(19, 53, 112));
        jLabel21.setText("First Name");
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 65, 80, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(19, 53, 112));
        jLabel5.setText("Middle Name");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 80, 20));

        send_mname.setEditable(false);
        jPanel7.add(send_mname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 180, 30));

        send_contact.setEditable(false);
        jPanel7.add(send_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 135, 180, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(19, 53, 112));
        jLabel13.setText("Contact No.");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 135, 80, 20));

        jPanel1.add(jPanel7);
        jPanel7.setBounds(20, 220, 310, 180);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(40, 120, 240));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Receiver Info");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(199, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 290, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(19, 53, 112));
        jLabel8.setText("Last Name");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 70, 20));

        receive_lname.setEditable(false);
        jPanel6.add(receive_lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 180, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(19, 53, 112));
        jLabel22.setText("First Name");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 65, 70, 20));

        receive_fname.setEditable(false);
        jPanel6.add(receive_fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 65, 180, 30));

        receive_mname.setEditable(false);
        jPanel6.add(receive_mname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 180, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(19, 53, 112));
        jLabel23.setText("Middle Name");
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 80, 20));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(19, 53, 112));
        jLabel14.setText("Contact No.");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 135, 80, 20));

        receive_contact.setEditable(false);
        jPanel6.add(receive_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 135, 180, 30));

        location.setEditable(false);
        jPanel6.add(location, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 180, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(19, 53, 112));
        jLabel16.setText("Branch");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 60, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(19, 53, 112));
        jLabel9.setText("Location");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 70, 20));

        jPanel1.add(jPanel6);
        jPanel6.setBounds(350, 220, 310, 210);

        jPanel8.setOpaque(false);
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        relations.setEditable(false);
        jPanel8.add(relations, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 180, 30));

        purpose.setEditable(false);
        jPanel8.add(purpose, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 65, 180, 30));

        amount.setEditable(false);
        jPanel8.add(amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 180, 30));

        fee.setEditable(false);
        jPanel8.add(fee, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 135, 180, 30));

        total.setEditable(false);
        jPanel8.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 180, 30));

        jPanel5.setBackground(new java.awt.Color(40, 120, 240));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Other Info");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(215, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel8.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 290, 20));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(19, 53, 112));
        jLabel15.setText("Relationship");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 80, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(19, 53, 112));
        jLabel11.setText("to Receiver");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 70, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(19, 53, 112));
        jLabel17.setText("Purpose of");
        jPanel8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 65, 80, 20));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(19, 53, 112));
        jLabel18.setText("Transaction");
        jPanel8.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 80, 10));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(19, 53, 112));
        jLabel19.setText("Amount");
        jPanel8.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 80, 20));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(19, 53, 112));
        jLabel20.setText("Fee");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 135, 80, 20));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(19, 53, 112));
        jLabel25.setText("Total");
        jPanel8.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 80, 20));

        jPanel1.add(jPanel8);
        jPanel8.setBounds(680, 220, 320, 210);

        javax.swing.GroupLayout genBackground1Layout = new javax.swing.GroupLayout(genBackground1);
        genBackground1.setLayout(genBackground1Layout);
        genBackground1Layout.setHorizontalGroup(
            genBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(genBackground1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1009, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        genBackground1Layout.setVerticalGroup(
            genBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(genBackground1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyTyped
        searchTable();
    }//GEN-LAST:event_searchKeyTyped

    private void transaction_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transaction_tableMouseClicked

        int rowIndex = transaction_table.getSelectedRow();

        if(rowIndex<0){
            JOptionPane.showMessageDialog(null,"Please Select an Item");
        }else{
            TableModel model = transaction_table.getModel();

            String tCode = (String) model.getValueAt(rowIndex,0);
            String tCustomer = (String) model.getValueAt(rowIndex,2);
            String tCounterparty = (String) model.getValueAt(rowIndex,5);

            try{

                dbConnector dbc = new dbConnector();
                ResultSet rs = dbc.getData("SELECT *, "
                    + " sender.cu_lname, sender.cu_fname, sender.cu_mname, "
                    + " send.co_number, "
                    + " receiver.cu_lname, receiver.cu_fname, receiver.cu_mname, "
                    + " receive.co_number "
                    + " FROM tbl_transactions t "
                    + " INNER JOIN tbl_customer sender ON t.tr_customer = sender.cu_id "
                    + " INNER JOIN tbl_customer receiver ON t.tr_counterparty = receiver.cu_id "
                    + " INNER JOIN tbl_contact send ON t.tr_customerno = send.co_id "
                    + " INNER JOIN tbl_contact receive ON t.tr_counterpartyno = receive.co_id "
                    + " INNER JOIN tbl_user tell ON t.tr_teller = tell.employeeid"
                    + " WHERE tr_code = '"+tCode+"' "
                    + " AND CONCAT(sender.cu_lname, ', ', sender.cu_fname, ' ', LEFT(sender.cu_mname, 1), '.') = '"+tCustomer+"' "
                    + " AND CONCAT(receiver.cu_lname, ', ', receiver.cu_fname, ' ', LEFT(receiver.cu_mname, 1), '.') = '"+tCounterparty+"' ");

                if(rs.next()){

                    send_lname.setText(rs.getString("sender.cu_lname"));
                    send_fname.setText(rs.getString("sender.cu_fname"));
                    send_mname.setText(rs.getString("sender.cu_mname"));
                    send_contact.setText(rs.getString("send.co_number"));

                    receive_lname.setText(rs.getString("receiver.cu_lname"));
                    receive_fname.setText(rs.getString("receiver.cu_fname"));
                    receive_mname.setText(rs.getString("receiver.cu_mname"));
                    receive_contact.setText(rs.getString("receive.co_number"));
                    location.setText(rs.getString("tr_location"));

                    relations.setText(rs.getString("tr_relation"));
                    purpose.setText(rs.getString("tr_purpose"));
                    amount.setText(rs.getString("tr_amount"));
                    fee.setText(rs.getString("tr_fee"));
                    total.setText(rs.getString("tr_total"));

                    rs.close();
                }

            }catch(SQLException ex){
                System.out.println("Errors: "+ex.getMessage());
            }
        }

    }//GEN-LAST:event_transaction_tableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount;
    private javax.swing.JTextField fee;
    private config.genBackground genBackground1;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField location;
    private javax.swing.JTextField purpose;
    private javax.swing.JTextField receive_contact;
    private javax.swing.JTextField receive_fname;
    private javax.swing.JTextField receive_lname;
    private javax.swing.JTextField receive_mname;
    private javax.swing.JTextField relations;
    private javax.swing.JTextField search;
    private javax.swing.JTextField send_contact;
    private javax.swing.JTextField send_fname;
    private javax.swing.JTextField send_lname;
    private javax.swing.JTextField send_mname;
    private javax.swing.JTextField total;
    private javax.swing.JTable transaction_table;
    // End of variables declaration//GEN-END:variables
}
