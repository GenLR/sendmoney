
package user.internalpages;

import config.ReceiptPrinter;
import config.Session;
import config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;


public class receiveMoney extends javax.swing.JInternalFrame {

    
    public receiveMoney() {
        initComponents();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
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
    
    public boolean checkCustomer(String lastName, String firstName){
        dbConnector dbc = new dbConnector();
        
        try{
            
            ResultSet rs = dbc.getData("SELECT * FROM tbl_customer WHERE cu_lname = '"+lastName+"' AND cu_fname = '"+firstName+"' ");
                
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
    
    public int getCustomer(String lastName, String firstName){
        dbConnector dbc = new dbConnector();
        int cu_ID;
        
        try{
            
            ResultSet rs = dbc.getData("SELECT * FROM tbl_customer WHERE cu_lname = '"+lastName+"' AND cu_fname = '"+firstName+"' ");
                
                if(rs.next()){
                    cu_ID = rs.getInt("cu_id");
                    rs.close();
                    return cu_ID;
                }else{  
                    rs.close();
                    return 0;
                }
                
            }catch(SQLException ex){
                System.out.println("Errors: "+ex.getMessage());
                return 0;
            } 
       
    }
    
    String location, re_code;
    public void autoFill(){
        dbConnector dbc = new dbConnector();
        
        try{
                ResultSet rs = dbc.getData("SELECT *, "
                    + " sender.cu_lname, "
                    + " sender.cu_fname, "
                    + " sender.cu_mname, "
                    + " send.co_number, "
                    + " receiver.cu_lname, "
                    + " receiver.cu_fname, "
                    + " receiver.cu_mname, "
                    + " receive.co_number "
                    + " FROM tbl_transactions t "
                    + " INNER JOIN tbl_customer sender ON t.tr_customer = sender.cu_id "
                    + " INNER JOIN tbl_customer receiver ON t.tr_counterparty = receiver.cu_id "
                    + " INNER JOIN tbl_contact send ON t.tr_customerno = send.co_id "
                    + " INNER JOIN tbl_contact receive ON t.tr_counterpartyno = receive.co_id "
                    + " INNER JOIN tbl_user tell ON t.tr_teller = tell.employeeid"
                    + " WHERE tr_code = '"+code.getText()+"' AND tr_type = 'Send' ");

                if(rs.next()){

                    receive_lname.setText(rs.getString("receiver.cu_lname"));
                    receive_fname.setText(rs.getString("receiver.cu_fname"));
                    receive_mname.setText(rs.getString("receiver.cu_mname"));
                    receive_contact.setText(rs.getString("receive.co_number"));
                    
                    send_lname.setText(rs.getString("sender.cu_lname"));
                    send_fname.setText(rs.getString("sender.cu_fname"));
                    send_mname.setText(rs.getString("sender.cu_mname"));
                    send_contact.setText(rs.getString("send.co_number"));
                    
                    relations.setText(rs.getString("tr_relation"));
                    purpose.setText(rs.getString("tr_purpose"));
                    amount.setText(rs.getString("tr_amount"));
                    fee.setText(rs.getString("tr_fee"));
                    total.setText(rs.getString("tr_total"));
                    
                    location = rs.getString("tr_location");
                    re_code = rs.getString("tr_code");

                    rs.close();
                }else{
                    JOptionPane.showMessageDialog(null, "No matching Code!", "Error", JOptionPane.ERROR_MESSAGE);
                    rs.close();
                }

            }catch(SQLException ex){
                System.out.println("Errors: "+ex.getMessage());

            }
        
    }
    
    public void getInsert(){
        
        dbConnector dbc = new dbConnector();
        Session ses = Session.getInstance();

        Date now = new Date();
        SimpleDateFormat nowformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattednow = nowformat.format(now);
        
        if(dbc.insertData("INSERT INTO tbl_transactions  "
            + "(tr_customer, tr_customerno, "
            + " tr_counterparty, tr_counterpartyno, "
            + " tr_location, tr_relation, tr_purpose, "
            + " tr_amount, tr_fee, tr_total, "
            + " tr_code, tr_when, tr_type, tr_teller)"
            + " VALUES ( '"+getCustomer(receive_lname.getText(), receive_fname.getText())+"', '"+checkContact(receive_contact.getText())+"',   "
            + " '"+getCustomer(send_lname.getText(), send_fname.getText())+"', '"+checkContact(send_contact.getText())+"', "
            + " '"+location+"', '"+relations.getText()+"', '"+purpose.getText()+"', "
            + " '"+amount.getText()+"', '"+fee.getText()+"', '"+total.getText()+"', "
            + " '"+re_code+"', '"+formattednow+"', 'Receive',  '"+ses.getEid()+"' ) ")
        ){

            try{
                ResultSet rs = dbc.getData("SELECT *, "
                    + " CASE"
                    + "     WHEN sender.cu_mname IS NOT NULL "
                    + "     THEN CONCAT(sender.cu_lname, ', ', sender.cu_fname, ' ', LEFT(sender.cu_mname, 1), '.') "
                    + "     ELSE CONCAT(sender.cu_lname, ', ', sender.cu_fname) "
                    + " END AS Customer,"
                    + " send.co_number, "
                    + " CASE"
                    + "     WHEN receiver.cu_mname IS NOT NULL "
                    + "     THEN CONCAT(receiver.cu_lname, ', ', receiver.cu_fname, ' ', LEFT(receiver.cu_mname, 1), '.') "
                    + "     ELSE CONCAT(receiver.cu_lname, ', ', receiver.cu_fname) "
                    + " END AS Counterparty, "
                    + " receiver.cu_lname, receiver.cu_fname, receiver.cu_mname, "
                    + " receive.co_number,"
                    + " DATE(tr_when) AS whenDate,"
                    + " DATE_FORMAT(TIME(tr_when), '%H:%i:%s') AS whenTime "
                    + " FROM tbl_transactions t "
                    + " INNER JOIN tbl_customer sender ON t.tr_customer = sender.cu_id "
                    + " INNER JOIN tbl_customer receiver ON t.tr_counterparty = receiver.cu_id "
                    + " INNER JOIN tbl_contact send ON t.tr_customerno = send.co_id "
                    + " INNER JOIN tbl_contact receive ON t.tr_counterpartyno = receive.co_id "
                    + " INNER JOIN tbl_user tell ON t.tr_teller = tell.employeeid"
                    + " WHERE tr_code = '"+re_code+"' AND tr_type = 'Receive' ");

                if(rs.next()){

                    res_code.setText(rs.getString("tr_code"));
                    res_date.setText(rs.getString("whenDate"));
                    res_time.setText(rs.getString("whenTime"));

                    res_rename.setText(rs.getString("Customer"));
                    re_contact.setText(rs.getString("receive.co_number"));

                    res_sename.setText(rs.getString("Counterparty"));
                    se_contact.setText(rs.getString("send.co_number"));

                    res_relationship.setText(rs.getString("tr_relation"));
                    res_purpose.setText(rs.getString("tr_purpose"));
                    res_amount.setText(rs.getString("tr_amount"));
                    res_fee.setText(rs.getString("tr_fee"));
                    res_total.setText(rs.getString("tr_total"));
                    
                    JOptionPane.showMessageDialog(null, "Transaction Success!/nProceed to Printing.");
                    
                    ReceiptPrinter rPrint = new ReceiptPrinter(receiptPane);
                    rPrint.printPanel();

                    rs.close();
                }else{
                    rs.close();
                }

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
        jPanel7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        se_cus = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        send_contact = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        send_fname = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        send_lname = new javax.swing.JTextField();
        send_mname = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        re_cus = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        receive_contact = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        receive_fname = new javax.swing.JTextField();
        receive_mname = new javax.swing.JTextField();
        receive_lname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        total = new javax.swing.JTextField();
        fee = new javax.swing.JTextField();
        amount = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        relations = new javax.swing.JTextField();
        purpose = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        receiptPane = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        res_code = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        res_time = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        res_date = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        res_rename = new javax.swing.JLabel();
        re_contact = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        res_sename = new javax.swing.JLabel();
        res_relationship = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        res_total = new javax.swing.JLabel();
        res_purpose = new javax.swing.JLabel();
        se_contact = new javax.swing.JLabel();
        res_amount = new javax.swing.JLabel();
        res_fee = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        code = new javax.swing.JTextField();
        verify = new javax.swing.JButton();
        confirm = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1000, 459));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(40, 120, 240));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Sender Info");

        se_cus.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        se_cus.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 347, Short.MAX_VALUE)
                .addComponent(se_cus, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(se_cus, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 610, 20));

        jPanel14.setOpaque(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(19, 53, 112));
        jLabel13.setText("Contact No.");

        send_contact.setEditable(false);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(send_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(send_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 280, 50));

        jPanel18.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(19, 53, 112));
        jLabel5.setText("Middle Name");

        send_fname.setEditable(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(19, 53, 112));
        jLabel12.setText("Last Name");

        send_lname.setEditable(false);

        send_mname.setEditable(false);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(19, 53, 112));
        jLabel26.setText("First Name");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(send_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(send_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(send_mname, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(send_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(send_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(send_mname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel7.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jPanel1.add(jPanel7);
        jPanel7.setBounds(10, 130, 630, 130);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(40, 120, 240));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Receiver Info");

        re_cus.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        re_cus.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(re_cus, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(re_cus, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 610, 20));

        jPanel15.setOpaque(false);

        receive_contact.setEditable(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(19, 53, 112));
        jLabel14.setText("Contact No.");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(receive_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(receive_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 280, 50));

        jPanel17.setOpaque(false);

        receive_fname.setEditable(false);

        receive_mname.setEditable(false);

        receive_lname.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(19, 53, 112));
        jLabel8.setText("Last Name");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(19, 53, 112));
        jLabel27.setText("First Name");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(19, 53, 112));
        jLabel23.setText("Middle Name");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(receive_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(receive_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(receive_mname, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(receive_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(receive_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(receive_mname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel6.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jPanel1.add(jPanel6);
        jPanel6.setBounds(10, 0, 630, 130);

        jPanel8.setOpaque(false);
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                .addContainerGap(535, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel8.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 610, 20));

        jPanel16.setOpaque(false);

        total.setEditable(false);

        fee.setEditable(false);

        amount.setEditable(false);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(19, 53, 112));
        jLabel19.setText("Amount");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(19, 53, 112));
        jLabel20.setText("Fee");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(19, 53, 112));
        jLabel25.setText("Total");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(fee, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, 120));

        jPanel19.setOpaque(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(19, 53, 112));
        jLabel11.setText("to Receiver");

        relations.setEditable(false);

        purpose.setEditable(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(19, 53, 112));
        jLabel18.setText("Transaction");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(19, 53, 112));
        jLabel17.setText("Purpose of");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(19, 53, 112));
        jLabel15.setText("Relationship");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addComponent(relations, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addComponent(purpose, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(relations, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(purpose, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 80));

        jPanel1.add(jPanel8);
        jPanel8.setBounds(10, 260, 630, 130);

        jPanel12.setBackground(new java.awt.Color(40, 120, 240));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Receipt Preview");
        jPanel12.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 160, 20));

        receiptPane.setBackground(new java.awt.Color(255, 255, 255));
        receiptPane.setPreferredSize(new java.awt.Dimension(306, 396));
        receiptPane.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo ('80).png"))); // NOI18N
        receiptPane.add(jLabel2);
        jLabel2.setBounds(80, 10, 142, 80);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(20, 120, 240));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("where money flies");
        receiptPane.add(jLabel28);
        jLabel28.setBounds(130, 70, 100, 20);

        res_code.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_code.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receiptPane.add(res_code);
        res_code.setBounds(100, 140, 80, 20);

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Poblacion Ward II, Minglanilla, Cebu - Philippines");
        receiptPane.add(jLabel29);
        jLabel29.setBounds(40, 90, 220, 20);

        jLabel30.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 102, 102));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Time");
        receiptPane.add(jLabel30);
        jLabel30.setBounds(190, 150, 40, 10);

        res_time.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_time.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receiptPane.add(res_time);
        res_time.setBounds(230, 150, 60, 10);

        jLabel31.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(102, 102, 102));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Date");
        receiptPane.add(jLabel31);
        jLabel31.setBounds(190, 140, 40, 10);

        res_date.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_date.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receiptPane.add(res_date);
        res_date.setBounds(230, 140, 60, 10);

        jPanel5.setBackground(new java.awt.Color(20, 120, 240));

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Receiver Info");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 204, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        receiptPane.add(jPanel5);
        jPanel5.setBounds(20, 170, 270, 13);

        jPanel9.setBackground(new java.awt.Color(20, 120, 240));

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Receive Form");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel33)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
        );

        receiptPane.add(jPanel9);
        jPanel9.setBounds(20, 110, 270, 20);

        jLabel34.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(102, 102, 102));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Transaction Code");
        receiptPane.add(jLabel34);
        jLabel34.setBounds(20, 140, 80, 20);

        jLabel35.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(102, 102, 102));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Name");
        receiptPane.add(jLabel35);
        jLabel35.setBounds(30, 190, 30, 10);

        jLabel36.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(102, 102, 102));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Contact no.");
        receiptPane.add(jLabel36);
        jLabel36.setBounds(30, 210, 50, 10);

        res_rename.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_rename.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receiptPane.add(res_rename);
        res_rename.setBounds(90, 190, 200, 10);

        re_contact.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        re_contact.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receiptPane.add(re_contact);
        re_contact.setBounds(90, 210, 60, 10);

        jLabel38.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(102, 102, 102));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Name");
        receiptPane.add(jLabel38);
        jLabel38.setBounds(30, 250, 30, 10);

        jPanel10.setBackground(new java.awt.Color(20, 120, 240));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sender Info");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 214, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        receiptPane.add(jPanel10);
        jPanel10.setBounds(20, 230, 270, 13);

        jLabel39.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(102, 102, 102));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Contact no.");
        receiptPane.add(jLabel39);
        jLabel39.setBounds(30, 270, 50, 10);

        res_sename.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_sename.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receiptPane.add(res_sename);
        res_sename.setBounds(90, 250, 200, 10);

        res_relationship.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_relationship.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receiptPane.add(res_relationship);
        res_relationship.setBounds(90, 360, 90, 20);

        jPanel11.setBackground(new java.awt.Color(20, 120, 240));

        jLabel40.setBackground(new java.awt.Color(255, 255, 255));
        jLabel40.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Other Info");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 214, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        receiptPane.add(jPanel11);
        jPanel11.setBounds(20, 310, 270, 13);

        jLabel41.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(102, 102, 102));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel41.setText("Total");
        receiptPane.add(jLabel41);
        jLabel41.setBounds(180, 370, 40, 10);

        jLabel42.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(102, 102, 102));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("to Receiver");
        receiptPane.add(jLabel42);
        jLabel42.setBounds(30, 370, 60, 10);

        jLabel43.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(102, 102, 102));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Transaction");
        receiptPane.add(jLabel43);
        jLabel43.setBounds(30, 340, 60, 10);

        jLabel44.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(102, 102, 102));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Purpose of");
        receiptPane.add(jLabel44);
        jLabel44.setBounds(20, 330, 60, 10);

        jLabel45.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(102, 102, 102));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Relationship");
        receiptPane.add(jLabel45);
        jLabel45.setBounds(20, 360, 60, 10);

        jLabel46.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(102, 102, 102));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel46.setText("Amount");
        receiptPane.add(jLabel46);
        jLabel46.setBounds(180, 330, 40, 10);

        jLabel47.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(102, 102, 102));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel47.setText("Fee");
        receiptPane.add(jLabel47);
        jLabel47.setBounds(180, 350, 40, 10);

        res_total.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_total.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receiptPane.add(res_total);
        res_total.setBounds(230, 370, 60, 10);

        res_purpose.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_purpose.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receiptPane.add(res_purpose);
        res_purpose.setBounds(90, 330, 90, 20);

        se_contact.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        se_contact.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receiptPane.add(se_contact);
        se_contact.setBounds(90, 270, 90, 10);

        res_amount.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_amount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receiptPane.add(res_amount);
        res_amount.setBounds(230, 330, 60, 10);

        res_fee.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_fee.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receiptPane.add(res_fee);
        res_fee.setBounds(230, 350, 60, 10);

        jPanel12.add(receiptPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 30, -1, -1));

        jPanel1.add(jPanel12);
        jPanel12.setBounds(660, 5, 315, 430);

        jPanel13.setOpaque(false);
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(19, 53, 112));
        jLabel22.setText("Enter Code");
        jPanel13.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, 20));
        jPanel13.add(code, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 180, 30));

        verify.setBackground(new java.awt.Color(40, 120, 240));
        verify.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        verify.setForeground(new java.awt.Color(255, 255, 255));
        verify.setText("Verify");
        verify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyActionPerformed(evt);
            }
        });
        jPanel13.add(verify, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 80, 30));

        jPanel1.add(jPanel13);
        jPanel13.setBounds(20, 400, 400, 40);

        confirm.setBackground(new java.awt.Color(40, 120, 240));
        confirm.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        confirm.setForeground(new java.awt.Color(255, 255, 255));
        confirm.setText("Confirm & Print");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });
        jPanel1.add(confirm);
        confirm.setBounds(490, 400, 130, 30);

        javax.swing.GroupLayout genBackground1Layout = new javax.swing.GroupLayout(genBackground1);
        genBackground1.setLayout(genBackground1Layout);
        genBackground1Layout.setHorizontalGroup(
            genBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
        );
        genBackground1Layout.setVerticalGroup(
            genBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(genBackground1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
    
        //checks if code has been verified
        if(!receive_lname.getText().isEmpty() && !send_lname.getText().isEmpty()){
            getInsert();
        }
        

    }//GEN-LAST:event_confirmActionPerformed

    private void verifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifyActionPerformed
        dbConnector dbc = new dbConnector();
        
        try{
            ResultSet rs = dbc.getData("SELECT * FROM tbl_transactions WHERE tr_code = '"+code.getText()+"' AND tr_type = 'Receive' ");
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Code already been used!", "Error", JOptionPane.ERROR_MESSAGE);
                rs.close();
            }else{
                rs.close();
                autoFill();  
            }
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        }
    }//GEN-LAST:event_verifyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount;
    private javax.swing.JTextField code;
    private javax.swing.JButton confirm;
    private javax.swing.JTextField fee;
    private config.genBackground genBackground1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
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
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField purpose;
    private javax.swing.JLabel re_contact;
    private javax.swing.JLabel re_cus;
    private javax.swing.JPanel receiptPane;
    private javax.swing.JTextField receive_contact;
    private javax.swing.JTextField receive_fname;
    private javax.swing.JTextField receive_lname;
    private javax.swing.JTextField receive_mname;
    private javax.swing.JTextField relations;
    private javax.swing.JLabel res_amount;
    private javax.swing.JLabel res_code;
    private javax.swing.JLabel res_date;
    private javax.swing.JLabel res_fee;
    private javax.swing.JLabel res_purpose;
    private javax.swing.JLabel res_relationship;
    private javax.swing.JLabel res_rename;
    private javax.swing.JLabel res_sename;
    private javax.swing.JLabel res_time;
    private javax.swing.JLabel res_total;
    private javax.swing.JLabel se_contact;
    private javax.swing.JLabel se_cus;
    private javax.swing.JTextField send_contact;
    private javax.swing.JTextField send_fname;
    private javax.swing.JTextField send_lname;
    private javax.swing.JTextField send_mname;
    private javax.swing.JTextField total;
    private javax.swing.JButton verify;
    // End of variables declaration//GEN-END:variables
}
