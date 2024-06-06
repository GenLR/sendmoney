
package user.internalpages;

import config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

public class viewCustomer extends javax.swing.JInternalFrame {

    public viewCustomer() {
        initComponents();
        
        displayData();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
    }
    
    public void displayData(){
        try{
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT "
                    + " cu_id AS 'ID', "
                    + " cu_lname AS 'Last Name', "
                    + " cu_fname AS 'First Name', "
                    + " cu_mname AS 'Middle Name', "
                    + " co_number AS 'Contac mo.', "
                    + " cu_gender AS 'Gender', "
                    + " cu_nationality AS 'Nationality', "
                    + " cu_address AS 'Address', "
                    + " cu_birthdate AS 'Date of Birth', "
                    + " cu_birthplace AS 'Place of Birth', "
                    + " cu_marital AS 'Marital Status', "
                    + " cu_occupation AS 'Occupation' "
                    + " FROM tbl_customer "
                    + " JOIN tbl_contact ON tbl_customer.cu_id = tbl_contact.co_id");
            customer_table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        } 

    }
    
    public void searchTable(){
        DefaultTableModel model = (DefaultTableModel)customer_table.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
        customer_table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search.getText().trim()));     
    }
    
    public static int checkContact(String coNum){
        int conID;
        dbConnector dbc = new dbConnector();
        try{
            
            String query = "SELECT * FROM tbl_contact WHERE co_number = '"+coNum+"' ";
            ResultSet rs = dbc.getData(query);
            
            if(rs.next()){
                conID = rs.getInt("co_id");
                rs.close();
            }else{
                dbc.insertData("INSERT INTO tbl_contact (co_number) VALUES ('"+coNum+"') ");
                conID = checkContact(coNum);
                rs.close();    
            }
            
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
            return 0;
        }
        return conID;
    }
    
    public void clearFields(){
        cu_id.setText("");
        cu_lname.setText("");
        cu_fname.setText("");
        cu_mname.setText("");
        cu_contact.setText("");
        genderGroup.clearSelection();
        cu_nationality.setText("");
        cu_address.setText("");
        cu_birthdate.setDate(null);
        cu_birthplace.setText("");
        cu_marital.setSelectedItem("Single");
        cu_occupation.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderGroup = new javax.swing.ButtonGroup();
        genBackground1 = new config.genBackground();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        customer_table = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        cu_lname = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        cu_birthplace = new javax.swing.JTextField();
        cu_address = new javax.swing.JTextField();
        cu_nationality = new javax.swing.JTextField();
        cu_contact = new javax.swing.JTextField();
        cu_mname = new javax.swing.JTextField();
        cu_fname = new javax.swing.JTextField();
        cu_occupation = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        cu_birthdate = new com.toedter.calendar.JDateChooser();
        cu_marital = new javax.swing.JComboBox<>();
        clear = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        add = new javax.swing.JButton();
        cu_id = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(1000, 459));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(20, 120, 240));
        jPanel6.setLayout(null);

        jScrollPane1.setViewportView(customer_table);

        jPanel6.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 980, 150);

        jPanel1.add(jPanel6);
        jPanel6.setBounds(10, 40, 980, 150);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setOpaque(false);
        jPanel9.setLayout(null);
        jPanel9.add(cu_lname);
        cu_lname.setBounds(130, 30, 260, 30);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(19, 53, 112));
        jLabel26.setText("Contact no.");
        jPanel9.add(jLabel26);
        jLabel26.setBounds(30, 130, 80, 20);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(19, 53, 112));
        jLabel27.setText("Gender");
        jPanel9.add(jLabel27);
        jLabel27.setBounds(30, 160, 43, 20);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(19, 53, 112));
        jLabel28.setText("Nationality");
        jPanel9.add(jLabel28);
        jLabel28.setBounds(410, 10, 80, 20);

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(19, 53, 112));
        jLabel29.setText("Address");
        jPanel9.add(jLabel29);
        jLabel29.setBounds(410, 40, 60, 20);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(19, 53, 112));
        jLabel30.setText("Date of Birth");
        jPanel9.add(jLabel30);
        jLabel30.setBounds(410, 70, 80, 20);

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(19, 53, 112));
        jLabel31.setText("Place of Birth");
        jPanel9.add(jLabel31);
        jLabel31.setBounds(410, 100, 90, 20);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(19, 53, 112));
        jLabel32.setText("Marital Status");
        jPanel9.add(jLabel32);
        jLabel32.setBounds(410, 130, 90, 20);

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(19, 53, 112));
        jLabel33.setText("Occupation");
        jPanel9.add(jLabel33);
        jLabel33.setBounds(410, 160, 80, 20);
        jPanel9.add(cu_birthplace);
        cu_birthplace.setBounds(510, 90, 260, 30);
        jPanel9.add(cu_address);
        cu_address.setBounds(510, 30, 260, 30);
        jPanel9.add(cu_nationality);
        cu_nationality.setBounds(510, 0, 260, 30);
        jPanel9.add(cu_contact);
        cu_contact.setBounds(130, 120, 260, 30);
        jPanel9.add(cu_mname);
        cu_mname.setBounds(130, 90, 260, 30);
        jPanel9.add(cu_fname);
        cu_fname.setBounds(130, 60, 260, 30);
        jPanel9.add(cu_occupation);
        cu_occupation.setBounds(510, 150, 260, 30);

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(19, 53, 112));
        jLabel37.setText("Middle Name");
        jPanel9.add(jLabel37);
        jLabel37.setBounds(30, 100, 80, 20);

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(19, 53, 112));
        jLabel38.setText("Last Name");
        jPanel9.add(jLabel38);
        jLabel38.setBounds(30, 40, 80, 20);

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(19, 53, 112));
        jLabel39.setText("First Name");
        jPanel9.add(jLabel39);
        jLabel39.setBounds(30, 70, 80, 20);

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(19, 53, 112));
        jLabel40.setText("Customer ID");
        jPanel9.add(jLabel40);
        jLabel40.setBounds(30, 10, 80, 20);

        male.setBackground(new java.awt.Color(255, 255, 255));
        genderGroup.add(male);
        male.setText("Male");
        jPanel9.add(male);
        male.setBounds(130, 150, 70, 30);

        female.setBackground(new java.awt.Color(255, 255, 255));
        genderGroup.add(female);
        female.setText("Female");
        jPanel9.add(female);
        female.setBounds(210, 150, 80, 30);

        cu_birthdate.setDateFormatString("yyyy-MM-dd");
        jPanel9.add(cu_birthdate);
        cu_birthdate.setBounds(510, 60, 260, 30);

        cu_marital.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cu_marital.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Married", "Separated", "Widowed" }));
        jPanel9.add(cu_marital);
        cu_marital.setBounds(510, 120, 260, 30);

        clear.setBackground(new java.awt.Color(20, 120, 240));
        clear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clear.setForeground(new java.awt.Color(255, 255, 255));
        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel9.add(clear);
        clear.setBounds(890, 100, 90, 30);

        refresh.setBackground(new java.awt.Color(20, 120, 240));
        refresh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        refresh.setForeground(new java.awt.Color(255, 255, 255));
        refresh.setText("REFRESH");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        jPanel9.add(refresh);
        refresh.setBounds(890, 60, 90, 30);

        add.setBackground(new java.awt.Color(20, 120, 240));
        add.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel9.add(add);
        add.setBounds(890, 20, 90, 30);
        jPanel9.add(cu_id);
        cu_id.setBounds(130, 0, 260, 30);

        jPanel1.add(jPanel9);
        jPanel9.setBounds(0, 200, 990, 190);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(19, 53, 112));
        jLabel25.setText("Search");
        jPanel1.add(jLabel25);
        jLabel25.setBounds(770, 10, 50, 30);

        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchKeyTyped(evt);
            }
        });
        jPanel1.add(search);
        search.setBounds(820, 10, 170, 30);

        javax.swing.GroupLayout genBackground1Layout = new javax.swing.GroupLayout(genBackground1);
        genBackground1.setLayout(genBackground1Layout);
        genBackground1Layout.setHorizontalGroup(
            genBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(genBackground1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 994, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        genBackground1Layout.setVerticalGroup(
            genBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
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

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        
        System.out.println(""+checkContact(cu_contact.getText()));
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fd = dateFormat.format(cu_birthdate.getDate());

        String gender;
        if(male.isSelected()){
            gender = "Male";
        }else{
            gender = "Female";
        }
        
        dbConnector dbc = new dbConnector();
        if(dbc.insertData("INSERT INTO tbl_customer "
                + "(cu_lname, cu_fname, cu_mname, cu_contact, "
                + "cu_gender, cu_nationality, cu_address, cu_birthdate, "
                + "cu_birthplace, cu_marital, cu_occupation)"
                + "VALUES('"+cu_lname.getText()+"','"+cu_fname.getText()+"', '"+cu_mname.getText()+"', '"+checkContact(cu_contact.getText())+"', "
                + " '"+gender+"', '"+cu_nationality.getText()+"', '"+cu_address.getText()+"', '"+fd+"', "
                + " '"+cu_birthplace.getText()+"', '"+cu_marital.getSelectedItem()+"', '"+cu_occupation.getText()+"' )"))
        {
            JOptionPane.showMessageDialog(null, "Insert Successfully");
            displayData();
            clearFields();
        }else{
            JOptionPane.showMessageDialog(null, "Connection Error");
        }
       
    }//GEN-LAST:event_addActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        clearFields();
    }//GEN-LAST:event_clearActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        displayData();
    }//GEN-LAST:event_refreshActionPerformed

    private void searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyTyped
        searchTable();
    }//GEN-LAST:event_searchKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton clear;
    private javax.swing.JTextField cu_address;
    private com.toedter.calendar.JDateChooser cu_birthdate;
    private javax.swing.JTextField cu_birthplace;
    private javax.swing.JTextField cu_contact;
    private javax.swing.JTextField cu_fname;
    private javax.swing.JTextField cu_id;
    private javax.swing.JTextField cu_lname;
    private javax.swing.JComboBox<String> cu_marital;
    private javax.swing.JTextField cu_mname;
    private javax.swing.JTextField cu_nationality;
    private javax.swing.JTextField cu_occupation;
    private javax.swing.JTable customer_table;
    private javax.swing.JRadioButton female;
    private config.genBackground genBackground1;
    private javax.swing.ButtonGroup genderGroup;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton male;
    private javax.swing.JButton refresh;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
