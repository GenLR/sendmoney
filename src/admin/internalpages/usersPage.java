/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.internalpages;

import config.dbConnector;
import config.passHash;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Larosa Family
 */
public class usersPage extends javax.swing.JInternalFrame {

    /**
     * Creates new form employee
     */
    public usersPage() {
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
                ResultSet rs = dbc.getData("SELECT employeeid, fullname, acctype, username, status FROM tbl_user");
                users_table.setModel(DbUtils.resultSetToTableModel(rs));
                rs.close();
            }catch(SQLException ex){
                System.out.println("Errors: "+ex.getMessage());
            } 
        }else{
            try{
                dbConnector dbc = new dbConnector();
                ResultSet rs = dbc.getData("SELECT * FROM tbl_user WHERE employeeid = '"+search.getText()+"' OR "
                        + "fullname = '"+search.getText()+"' OR acctype = '"+search.getText()+"' OR"
                        + " username = '"+search.getText()+"' OR  status = '"+search.getText()+"' ");
                users_table.setModel(DbUtils.resultSetToTableModel(rs));
                rs.close();
            }catch(SQLException ex){
                System.out.println("Errors: "+ex.getMessage());
            } 
        }
    }
    
    public static String empid, name, user;
    
    public boolean dupchecker(){
        dbConnector connector = new dbConnector();
        try{
            String query = "SELECT * FROM tbl_user Where employeeid '"+employeeid.getText()+"' AND fullname = '"+fullname.getText()+"' AND username = '"+username.getText()+"' ";
            ResultSet rs = connector.getData(query);
            
            if(rs.next()){
                
                empid = rs.getString("employeeid");
                    if(empid.equals(employeeid.getText())){
                        JOptionPane.showMessageDialog(null, "Employee ID "+empid+" is already used!");
                        employeeid.setText("");
                    }
                    
                name = rs.getString("fullname");
                    if(name.equals(fullname.getText())){
                        JOptionPane.showMessageDialog(null, "Full Name "+name+" is already used!");
                        fullname.setText("");
                    }
                    
                user = rs.getString("username");
                    if(user.equals(username.getText())){
                        JOptionPane.showMessageDialog(null, "Username "+user+" already taken!");
                        username.setText("");
                    }
                    
                return true;
            }else{
                return false;
            }
             
        }catch(SQLException ex){
            System.out.println(""+ex);
            return false;
        }
    }
        
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genBackground1 = new config.genBackground();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        users_table = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        employeeid = new javax.swing.JTextField();
        fullname = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        add = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        acctype = new javax.swing.JComboBox<>();
        status = new javax.swing.JComboBox<>();
        search = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(1000, 420));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setOpaque(false);

        users_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                users_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(users_table);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel6);
        jPanel6.setBounds(0, 40, 1000, 230);

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(19, 53, 112));
        jLabel18.setText("Employee ID");
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 21, 80, 20));

        employeeid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeidActionPerformed(evt);
            }
        });
        jPanel7.add(employeeid, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 11, 260, 30));
        jPanel7.add(fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 41, 260, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(19, 53, 112));
        jLabel15.setText("Full Name");
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 51, 80, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(19, 53, 112));
        jLabel12.setText("Status");
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 60, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(19, 53, 112));
        jLabel5.setText("Account Type");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 90, 20));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(19, 53, 112));
        jLabel14.setText("Password");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 51, 60, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(19, 53, 112));
        jLabel11.setText("Username");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 21, 60, 20));
        jPanel7.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 11, 260, 30));
        jPanel7.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 41, 260, 30));

        add.setBackground(new java.awt.Color(20, 120, 240));
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ADD");

        javax.swing.GroupLayout addLayout = new javax.swing.GroupLayout(add);
        add.setLayout(addLayout);
        addLayout.setHorizontalGroup(
            addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        addLayout.setVerticalGroup(
            addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jPanel7.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        jPanel5.setBackground(new java.awt.Color(20, 120, 240));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("DELETE");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, -1, -1));

        jPanel3.setBackground(new java.awt.Color(20, 120, 240));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("UPDATE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, -1, -1));

        jPanel4.setBackground(new java.awt.Color(20, 120, 240));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("REFRESH");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, -1, -1));

        acctype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "teller" }));
        acctype.setSelectedIndex(1);
        jPanel7.add(acctype, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 260, 30));

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "active", "onhold", "terminated" }));
        jPanel7.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 260, 30));

        jPanel1.add(jPanel7);
        jPanel7.setBounds(0, 270, 800, 150);
        jPanel1.add(search);
        search.setBounds(830, 10, 160, 30);

        javax.swing.GroupLayout genBackground1Layout = new javax.swing.GroupLayout(genBackground1);
        genBackground1.setLayout(genBackground1Layout);
        genBackground1Layout.setHorizontalGroup(
            genBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        genBackground1Layout.setVerticalGroup(
            genBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
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

    private void employeeidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeidActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated

    }//GEN-LAST:event_formInternalFrameActivated

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        
        if( employeeid.getText().isEmpty() || fullname.getText().isEmpty() || username.getText().isEmpty() || password.getText().isEmpty() ){
            JOptionPane.showMessageDialog(null, "All information must be filled!");
        }else if(password.getText().length()<8){
            JOptionPane.showMessageDialog(null, "Password must be at least 8 characters and above!");
            password.setText("");
        }else if(dupchecker()){
            System.out.println("Duplicate Exists");
        }else{
            
            dbConnector dbc = new dbConnector();
            
            
            try{
                String pass = passHash.hashPassword(password.getText());
                
                if(dbc.insertData("INSERT INTO tbl_user "
                        + "(employeeid, fullname, acctype, username, password, status)"
                        + "VALUES('"+employeeid.getText()+"','"+fullname.getText()+"', '"+acctype.getSelectedItem()+"', "
                                + "'"+username.getText()+"', '"+pass+"', '"+status.getSelectedItem()+"' )"))
                {
                    JOptionPane.showMessageDialog(null, "Added Successfully");
                    employeeid.setText("");
                    fullname.setText("");
                    acctype.setSelectedItem(1);
                    username.setText("");
                    password.setText("");
                    status.setSelectedItem(0);
                }else{
                    JOptionPane.showMessageDialog(null, "Connection Error");
                } 
                
            }catch(NoSuchAlgorithmException ex){
                System.out.println(""+ex);
            }
                
        }
    }//GEN-LAST:event_addMouseClicked

    private void users_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_users_tableMouseClicked
        
        int rowIndex = users_table.getSelectedRow();
            if(rowIndex<0){
                JOptionPane.showMessageDialog(null,"Please Select an Item");
            }else{
                TableModel model = users_table.getModel();
                String ps = "none";
                dbConnector connector = new dbConnector();
                    try{
                        String query = "SELECT * FROM tbl_user  WHERE employeeid = '"+employeeid.getText()+"' ";
                        ResultSet rs = connector.getData(query);
                        if(rs.next()){
                            password.setText(rs.getString("password"));
                        }
                    }catch (SQLException ex) {
                        System.out.println(""+ex);
                    }

        
                employeeid.setText(""+model.getValueAt(rowIndex,0));      
                fullname.setText(""+model.getValueAt(rowIndex,1));
                acctype.setSelectedItem(""+model.getValueAt(rowIndex,2));
                username.setText(""+model.getValueAt(rowIndex,3));
                status.setSelectedItem(""+model.getValueAt(rowIndex,4)); 
                
            }
            
    }//GEN-LAST:event_users_tableMouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        
        if( employeeid.getText().isEmpty() || fullname.getText().isEmpty() || username.getText().isEmpty() || password.getText().isEmpty() ){
            JOptionPane.showMessageDialog(null, "All information must be filled!");
        }else if(password.getText().length()<8){
            JOptionPane.showMessageDialog(null, "Password must be at least 8 characters and above!");
            password.setText("");
        }else{
            dbConnector dbc = new dbConnector();
                dbc.updateData("UPDATE tbl_user SET fullname = '"+fullname.getText()+"' , acctype = '"+acctype.getSelectedItem()+"' "
                        + " username = '"+username.getText()+"' , password = '"+password.getText()+"' "
                        + " u_status = '"+status.getSelectedItem()+"' WHERE employeeid = '"+employeeid.getText()+"' ");
                
                    JOptionPane.showMessageDialog(null, "Insert Successfully");
                    employeeid.setText("");
                    fullname.setText("");
                    acctype.setSelectedItem(1);
                    username.setText("");
                    password.setText("");
                    status.setSelectedItem(0);

                
        }
    }//GEN-LAST:event_jPanel3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> acctype;
    private javax.swing.JPanel add;
    private javax.swing.JTextField employeeid;
    private javax.swing.JTextField fullname;
    private config.genBackground genBackground1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField password;
    private javax.swing.JTextField search;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JTextField username;
    private javax.swing.JTable users_table;
    // End of variables declaration//GEN-END:variables
}
