
package user.internalpages;

import config.ReceiptPrinter;
import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;


public class sendMoney extends javax.swing.JInternalFrame {

    public sendMoney() {
        initComponents();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
    }
    
    String empty = "";
    
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
    
    public int checkCustomer(String lastName, String firstName){
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
    
    public static String getCode() {
        String ncode = null;
        boolean dupCode;
        
        do{
            Random random = new Random();
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < 3; i++) {
                char randomChar = (char)(random.nextInt(26) + 'A'); 
                sb.append(randomChar);
            }

            sb.append("-");
            for(int i = 0; i < 3; i++) {
                sb.append(random.nextInt(10));
            }

            sb.append("-");
            for(int i = 0; i < 3; i++) {
                sb.append(random.nextInt(10));
            }

            try{

                dbConnector dbc = new dbConnector();
                ResultSet rs = dbc.getData("SELECT tr_code FROM tbl_transactions WHERE tr_code = '"+sb.toString()+"' ");

                    if(rs.next()){
                        dupCode = true;
                        rs.close();
                    }else{  
                        dupCode = false;
                        ncode = sb.toString();
                        rs.close();
                    }

            }catch(SQLException ex){
                System.out.println("Errors: "+ex.getMessage());
                dupCode = true;
            } 
            
        }while(dupCode);
            

        return ncode;
        
    }
    
    public static int getRate(int fee){
        int totalfee, initialfee;
        
                initialfee = fee / 100;
                    if((fee % 100) != 0){
                        initialfee += 1;
                    }
                totalfee = initialfee * 2;           

        return totalfee;
    }
    
    public void getInsert(){
        
        dbConnector dbc = new dbConnector();
        Session ses = Session.getInstance();     
        
        Date now = new Date();
        SimpleDateFormat nowformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattednow = nowformat.format(now);
        
        String code = getCode();
            
            if(dbc.insertData("INSERT INTO tbl_transactions  "
                    + "(tr_customer, tr_customerno, "
                    + " tr_counterparty, tr_counterpartyno, "
                    + " tr_location, tr_relation, tr_purpose, "
                    + " tr_amount, tr_fee, tr_total, "
                    + " tr_code, tr_when, tr_type, tr_teller)" 
                    + " VALUES ( '"+checkCustomer(send_lname.getText(), send_fname.getText())+"', '"+checkContact(send_contact.getText())+"', "
                    + " '"+checkCustomer(receive_lname.getText(), receive_fname.getText())+"', '"+checkContact(receive_contact.getText())+"', "
                    + " '"+location.getText()+"', '"+relations.getText()+"', '"+purpose.getText()+"', "
                    + " '"+amount.getText()+"', '"+fee.getText()+"', '"+total.getText()+"', "
                    + " '"+code+"', '"+formattednow+"', 'Send',  '"+ses.getEid()+"' ) ")
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
                        + " receive.co_number,"
                        + " DATE(tr_when) AS whenDate,"
                        + " DATE_FORMAT(TIME(tr_when), '%H:%i:%s') AS whenTime "
                        + " FROM tbl_transactions t " 
                        + " INNER JOIN tbl_customer sender ON t.tr_customer = sender.cu_id " 
                        + " INNER JOIN tbl_customer receiver ON t.tr_counterparty = receiver.cu_id " 
                        + " INNER JOIN tbl_contact send ON t.tr_customerno = send.co_id " 
                        + " INNER JOIN tbl_contact receive ON t.tr_counterpartyno = receive.co_id " 
                        + " INNER JOIN tbl_user tell ON t.tr_teller = tell.employeeid"
                        + " WHERE tr_code = '"+code+"' "
                        + " AND sender.cu_lname = '"+send_lname.getText()+"' "
                        + " AND sender.cu_fname = '"+send_fname.getText()+"' "
                        + " AND receiver.cu_lname = '"+receive_lname.getText()+"' "
                        + " AND receiver.cu_fname = '"+receive_fname.getText()+"' ");

                        if(rs.next()){

                            res_code.setText(rs.getString("tr_code"));
                            res_date.setText(rs.getString("whenDate"));
                            res_time.setText(rs.getString("whenTime"));

                            res_sename.setText(rs.getString("Customer"));
                            se_contact.setText(rs.getString("send.co_number"));

                            res_rename.setText(rs.getString("Counterparty"));
                            re_contact.setText(rs.getString("receive.co_number"));
                            res_location.setText(rs.getString("tr_location"));

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
    
    public int isNum(){
        try {
            int intAmount = Integer.parseInt(amount.getText());
            return intAmount;
        }catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Amount should be numerical", "Error", JOptionPane.ERROR_MESSAGE );
            return -1;
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genBackground1 = new config.genBackground();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        re_cus = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        location = new javax.swing.JTextField();
        receive_contact = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        receive_lname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        receive_fname = new javax.swing.JTextField();
        receive_mname = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        se_cus = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        send_contact = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        send_lname = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        send_fname = new javax.swing.JTextField();
        send_mname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        amount = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        fee = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        relations = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        purpose = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        receiptPane = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        res_code = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        res_time = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        res_date = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        res_sename = new javax.swing.JLabel();
        se_contact = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        res_rename = new javax.swing.JLabel();
        res_relationship = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        res_location = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
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
        re_contact = new javax.swing.JLabel();
        res_amount = new javax.swing.JLabel();
        res_fee = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        confirm = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1000, 479));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(40, 120, 240));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Receiver Info");

        re_cus.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        re_cus.setForeground(new java.awt.Color(255, 0, 0));
        re_cus.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                re_cusFocusLost(evt);
            }
        });

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

        jPanel14.setOpaque(false);

        location.setText("Anywhere in the Philippines");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(19, 53, 112));
        jLabel14.setText("Contact No.");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(19, 53, 112));
        jLabel16.setText("Branch");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(19, 53, 112));
        jLabel9.setText("Location");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(receive_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(receive_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 280, 80));

        jPanel18.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(19, 53, 112));
        jLabel8.setText("Last Name");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(19, 53, 112));
        jLabel22.setText("First Name");

        receive_mname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                receive_mnameFocusLost(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(19, 53, 112));
        jLabel23.setText("Middle Name");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(receive_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(receive_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(receive_mname, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(receive_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(receive_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(receive_mname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel6.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jPanel1.add(jPanel6);
        jPanel6.setBounds(10, 130, 630, 130);

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
                .addGap(28, 28, 28)
                .addComponent(se_cus, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(319, Short.MAX_VALUE))
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

        jPanel13.setOpaque(false);

        send_contact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                send_contactFocusLost(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(19, 53, 112));
        jLabel13.setText("Contact No.");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(send_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(send_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 280, 40));

        jPanel16.setOpaque(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(19, 53, 112));
        jLabel12.setText("Last Name");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(19, 53, 112));
        jLabel21.setText("First Name");

        send_mname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                send_mnameFocusLost(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(19, 53, 112));
        jLabel5.setText("Middle Name");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(send_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(send_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(send_mname, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(send_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(send_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(send_mname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel7.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 280, -1));

        jPanel1.add(jPanel7);
        jPanel7.setBounds(10, 0, 630, 130);

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

        jPanel15.setOpaque(false);

        amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                amountKeyReleased(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(19, 53, 112));
        jLabel19.setText("Amount");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(19, 53, 112));
        jLabel20.setText("Fee");

        fee.setEditable(false);

        total.setEditable(false);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(19, 53, 112));
        jLabel25.setText("Total");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(fee, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 280, 110));

        jPanel19.setOpaque(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(19, 53, 112));
        jLabel15.setText("Relationship");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(19, 53, 112));
        jLabel11.setText("to Receiver");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(19, 53, 112));
        jLabel17.setText("Purpose of");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(19, 53, 112));
        jLabel18.setText("Transaction");

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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Sender Info");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(-210, -10, 73, 20);

        jPanel12.setBackground(new java.awt.Color(40, 120, 240));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        receiptPane.setBackground(new java.awt.Color(255, 255, 255));
        receiptPane.setPreferredSize(new java.awt.Dimension(306, 396));
        receiptPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo ('80).png"))); // NOI18N
        receiptPane.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(20, 120, 240));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("where money flies");
        receiptPane.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 100, 20));

        res_code.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_code.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receiptPane.add(res_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 80, 20));

        jLabel27.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Poblacion Ward II, Minglanilla, Cebu - Philippines");
        receiptPane.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 220, 20));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Time");
        receiptPane.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 40, 10));

        res_time.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_time.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receiptPane.add(res_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 60, 10));

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(102, 102, 102));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Date");
        receiptPane.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 40, 10));

        res_date.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_date.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receiptPane.add(res_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 60, 10));

        jPanel5.setBackground(new java.awt.Color(20, 120, 240));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sender Info");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 214, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        receiptPane.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jPanel9.setBackground(new java.awt.Color(20, 120, 240));

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Send Form");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
        );

        receiptPane.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel31.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(102, 102, 102));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Transaction Code");
        receiptPane.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 80, 20));

        jLabel32.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(102, 102, 102));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Name");
        receiptPane.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 30, 10));

        jLabel33.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(102, 102, 102));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Contact no.");
        receiptPane.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 50, 10));

        res_sename.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_sename.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receiptPane.add(res_sename, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 200, 10));

        se_contact.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        se_contact.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receiptPane.add(se_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 60, 10));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(102, 102, 102));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Name");
        receiptPane.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 30, 10));

        jPanel10.setBackground(new java.awt.Color(20, 120, 240));

        jLabel36.setBackground(new java.awt.Color(255, 255, 255));
        jLabel36.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Receiver Info");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 204, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        receiptPane.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel37.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(102, 102, 102));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Contact no.");
        receiptPane.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 50, 10));

        res_rename.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_rename.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receiptPane.add(res_rename, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 200, 10));

        res_relationship.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_relationship.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receiptPane.add(res_relationship, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 90, 20));

        jLabel38.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(102, 102, 102));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Location");
        receiptPane.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 292, 40, 10));

        res_location.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_location.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receiptPane.add(res_location, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 200, 10));

        jPanel11.setBackground(new java.awt.Color(20, 120, 240));

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Other Info");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 214, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        receiptPane.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jLabel40.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(102, 102, 102));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel40.setText("Total");
        receiptPane.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 40, 10));

        jLabel41.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(102, 102, 102));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("to Receiver");
        receiptPane.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 60, 10));

        jLabel42.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(102, 102, 102));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Transaction");
        receiptPane.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 60, 10));

        jLabel43.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(102, 102, 102));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Branch");
        receiptPane.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 30, 20));

        jLabel44.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(102, 102, 102));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Purpose of");
        receiptPane.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 60, 10));

        jLabel45.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(102, 102, 102));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Relationship");
        receiptPane.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 60, 10));

        jLabel46.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(102, 102, 102));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel46.setText("Amount");
        receiptPane.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 40, 10));

        jLabel47.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(102, 102, 102));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel47.setText("Fee");
        receiptPane.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 40, 10));

        res_total.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_total.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receiptPane.add(res_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 60, 10));

        res_purpose.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_purpose.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receiptPane.add(res_purpose, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 90, 20));

        re_contact.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        re_contact.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receiptPane.add(re_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 90, 10));

        res_amount.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_amount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receiptPane.add(res_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 60, 10));

        res_fee.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_fee.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receiptPane.add(res_fee, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 60, 10));

        jPanel12.add(receiptPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 30, -1, -1));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Receipt Preview");
        jPanel12.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 0, 160, 30));

        jPanel1.add(jPanel12);
        jPanel12.setBounds(660, 5, 315, 430);

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
            .addGroup(genBackground1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 994, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        genBackground1Layout.setVerticalGroup(
            genBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
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

    private void send_mnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_send_mnameFocusLost
            
        if(!send_lname.getText().isEmpty() && !send_fname.getText().isEmpty())
            if(checkCustomer(send_lname.getText(), send_fname.getText()) == 0){
                se_cus.setForeground(Color.red);
                se_cus.setText("New Customer");
            }else{
                se_cus.setForeground(new Color(0,153,51));
                se_cus.setText("Old Customer");
            }
    }//GEN-LAST:event_send_mnameFocusLost

    private void re_cusFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_re_cusFocusLost
        
    }//GEN-LAST:event_re_cusFocusLost

    private void amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountKeyReleased
        
        if(!amount.getText().isEmpty()){
            int intAmount = isNum();
            if(intAmount != -1){
                String strCharge = Integer.toString(getRate(intAmount));
                fee.setText(strCharge);
                
                String strTotal = Integer.toString(intAmount + getRate(intAmount));
                total.setText(strTotal);
                
            }else{
                fee.setText("");
                total.setText("");
            } 
            
        }
            
        
    }//GEN-LAST:event_amountKeyReleased

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
           
        dbConnector dbc = new dbConnector();
        
        if(checkCustomer(receive_lname.getText(), receive_fname.getText()) == 0){
            if(!receive_lname.getText().isEmpty() && !receive_fname.getText().isEmpty()){
                dbc.insertData("INSERT INTO tbl_customer "
                    + "(cu_lname, cu_fname, cu_mname, cu_contact, "
                    + "cu_gender, cu_nationality, cu_address, cu_birthdate, "
                    + "cu_birthplace, cu_marital, cu_occupation)"
                    + " VALUES('"+receive_lname.getText()+"', '"+receive_fname.getText()+"', "
                    + " '"+empty+"', '"+checkContact(receive_contact.getText())+"', '"+empty+"', '"+empty+"', '"+empty+"', '111-11-11', '"+empty+"', '"+empty+"', '"+empty+"' ) ");

                    JOptionPane.showMessageDialog(null, "Temporary Receiver Inserted");
            }else{
                JOptionPane.showMessageDialog(null, "Connection Error");
            }
        }
        
        //checks if all important fields are filled
        if(send_lname.getText().isEmpty() || send_fname.getText().isEmpty() || 
            send_contact.getText().isEmpty() || receive_lname.getText().isEmpty() || 
            receive_fname.getText().isEmpty() || receive_contact.getText().isEmpty() || 
            location.getText().isEmpty() || relations.getText().isEmpty() || 
            purpose.getText().isEmpty() || amount.getText().isEmpty() ){
            
            JOptionPane.showMessageDialog(null, "All Fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
        
        //checks the length of contact numbers    
        }else if(send_contact.getText().length()!=11 && receive_contact.getText().length()!=11){
            
            JOptionPane.showMessageDialog(null, "Contact number must contain 11 digits", "Error", JOptionPane.ERROR_MESSAGE);
        
        //checks if amount in a number   
        }else if(isNum() == -1){
            
            JOptionPane.showMessageDialog(null, "Amount should be numerical", "Error", JOptionPane.ERROR_MESSAGE );
        
        //checks if both contacts are the same
        }else if(send_contact.getText().equalsIgnoreCase(receive_contact.getText())){
            
            JOptionPane.showMessageDialog(null, "Both Contact Numbers are the same!", "Error", JOptionPane.ERROR_MESSAGE );
            
        //checks if sender and receiver are different person    
        }else if(send_lname.getText().equalsIgnoreCase(receive_lname.getText()) && send_fname.getText().equalsIgnoreCase(receive_fname.getText())){
            System.out.println(""+send_lname.getText());
            System.out.println(""+receive_lname.getText());
            System.out.println(""+send_fname.getText());
            System.out.println(""+receive_fname.getText());
            
            JOptionPane.showMessageDialog(null, "Sender and Receiver is the same Person", "Error", JOptionPane.ERROR_MESSAGE);   

        }else{
            getInsert();
        }          
        
    }//GEN-LAST:event_confirmActionPerformed

    private void send_contactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_send_contactFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_send_contactFocusLost

    private void receive_mnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_receive_mnameFocusLost

        if(!receive_lname.getText().isEmpty() && !receive_fname.getText().isEmpty()){
            if(checkCustomer(receive_lname.getText(), receive_fname.getText()) == 0){
                re_cus.setForeground(Color.red);
                re_cus.setText("New Customer");
            }else{
                re_cus.setForeground(new Color(0,153,51));
                re_cus.setText("Old Customer");
            }
        }

    }//GEN-LAST:event_receive_mnameFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount;
    private javax.swing.JButton confirm;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
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
    private javax.swing.JTextField location;
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
    private javax.swing.JLabel res_location;
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
    // End of variables declaration//GEN-END:variables
}
