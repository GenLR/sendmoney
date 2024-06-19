
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
import popupFrames.senderreceipt;


public class sendMoney extends javax.swing.JInternalFrame {

    public sendMoney() {
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
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genBackground1 = new config.genBackground();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        re_cus = new javax.swing.JLabel();
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
        jPanel7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        se_cus = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        send_lname = new javax.swing.JTextField();
        send_fname = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        send_mname = new javax.swing.JTextField();
        send_contact = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        send_card = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        relations = new javax.swing.JTextField();
        purpose = new javax.swing.JTextField();
        amount = new javax.swing.JTextField();
        fee = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        receiptPane = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        res_code = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        se_card = new javax.swing.JLabel();
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
        jLabel34 = new javax.swing.JLabel();
        res_sename = new javax.swing.JLabel();
        se_contact = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        re_name = new javax.swing.JLabel();
        relationship = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        location1 = new javax.swing.JLabel();
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
        total1 = new javax.swing.JLabel();
        purpose1 = new javax.swing.JLabel();
        re_contact = new javax.swing.JLabel();
        amount1 = new javax.swing.JLabel();
        fee1 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();

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

        jPanel6.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 290, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(19, 53, 112));
        jLabel8.setText("Last Name");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 70, 20));
        jPanel6.add(receive_lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 180, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(19, 53, 112));
        jLabel22.setText("First Name");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 65, 70, 20));
        jPanel6.add(receive_fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 65, 180, 30));

        receive_mname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                receive_mnameFocusLost(evt);
            }
        });
        jPanel6.add(receive_mname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 180, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(19, 53, 112));
        jLabel23.setText("Middle Name");
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 80, 20));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(19, 53, 112));
        jLabel14.setText("Contact No.");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 135, 80, 20));
        jPanel6.add(receive_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 135, 180, 30));

        location.setText("Anywhere in the Philippines");
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
        jPanel6.setBounds(10, 220, 310, 210);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
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

        jPanel7.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 300, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(19, 53, 112));
        jLabel12.setText("Last Name");
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 80, 20));
        jPanel7.add(send_lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 180, 30));
        jPanel7.add(send_fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 65, 180, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(19, 53, 112));
        jLabel21.setText("First Name");
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 65, 80, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(19, 53, 112));
        jLabel5.setText("Middle Name");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 80, 20));

        send_mname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                send_mnameFocusLost(evt);
            }
        });
        jPanel7.add(send_mname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 180, 30));

        send_contact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                send_contactFocusLost(evt);
            }
        });
        jPanel7.add(send_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 135, 180, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(19, 53, 112));
        jLabel13.setText("Contact No.");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 135, 80, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(19, 53, 112));
        jLabel6.setText("Loyalty Card");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 80, 20));
        jPanel7.add(send_card, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 180, 30));

        jPanel1.add(jPanel7);
        jPanel7.setBounds(10, 10, 310, 210);

        jPanel8.setOpaque(false);
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(relations, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 180, 30));
        jPanel8.add(purpose, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 65, 180, 30));

        amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                amountKeyReleased(evt);
            }
        });
        jPanel8.add(amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 180, 30));

        fee.setEditable(false);
        jPanel8.add(fee, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 135, 180, 30));

        total.setEditable(false);
        jPanel8.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 180, 30));

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
                .addContainerGap(215, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel8.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 290, 20));

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
        jPanel8.setBounds(330, 10, 320, 220);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Sender Info");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(-210, -10, 73, 20);

        jButton1.setBackground(new java.awt.Color(20, 120, 240));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Confirm & Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(510, 390, 130, 30);

        jPanel12.setBackground(new java.awt.Color(40, 120, 240));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        receiptPane.setBackground(new java.awt.Color(255, 255, 255));
        receiptPane.setPreferredSize(new java.awt.Dimension(306, 396));
        receiptPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo ('80).png"))); // NOI18N
        receiptPane.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(20, 120, 240));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("where money flies");
        receiptPane.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 100, 20));

        res_code.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_code.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receiptPane.add(res_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 80, 20));

        jLabel27.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Poblacion Ward II, Minglanilla, Cebu - Philippines");
        receiptPane.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 220, 20));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Time");
        receiptPane.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 40, 10));

        se_card.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        se_card.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receiptPane.add(se_card, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 60, 10));

        res_time.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receiptPane.add(res_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 60, 10));

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Date");
        receiptPane.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 40, 10));

        res_date.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Transaction Code");
        receiptPane.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 80, 20));

        jLabel32.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Name");
        receiptPane.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 30, 10));

        jLabel33.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Contact no.");
        receiptPane.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 50, 10));

        jLabel34.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Loyalty Card");
        receiptPane.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 60, 30));

        res_sename.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        res_sename.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receiptPane.add(res_sename, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 200, 10));

        se_contact.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        se_contact.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receiptPane.add(se_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 60, 10));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
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
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Contact no.");
        receiptPane.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 50, 10));

        re_name.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        re_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receiptPane.add(re_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 200, 10));

        relationship.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        relationship.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receiptPane.add(relationship, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 90, 20));

        jLabel38.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Location");
        receiptPane.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 292, 40, 10));

        location1.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        location1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receiptPane.add(location1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 200, 10));

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
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel40.setText("Total");
        receiptPane.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 40, 10));

        jLabel41.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("to Receiver");
        receiptPane.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 60, 10));

        jLabel42.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Transaction");
        receiptPane.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 60, 10));

        jLabel43.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Branch");
        receiptPane.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 30, 20));

        jLabel44.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Purpose of");
        receiptPane.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 60, 10));

        jLabel45.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Relationship");
        receiptPane.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 60, 10));

        jLabel46.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel46.setText("Amount");
        receiptPane.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 40, 10));

        jLabel47.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel47.setText("Fee");
        receiptPane.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 40, 10));

        total1.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        total1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receiptPane.add(total1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 60, 10));

        purpose1.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        purpose1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receiptPane.add(purpose1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 90, 20));

        re_contact.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        re_contact.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receiptPane.add(re_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 90, 10));

        amount1.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        amount1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receiptPane.add(amount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 60, 10));

        fee1.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        fee1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receiptPane.add(fee1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 60, 10));

        jPanel12.add(receiptPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 30, -1, -1));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Receipt Preview");
        jPanel12.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 160, 20));

        jPanel1.add(jPanel12);
        jPanel12.setBounds(660, 5, 315, 430);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
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
            try {
                int intAmount = Integer.parseInt(amount.getText());
                String strCharge = Integer.toString(getRate(intAmount));
                fee.setText(strCharge);
                
                String strTotal = Integer.toString(intAmount + getRate(intAmount));
                total.setText(strTotal);
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, ""+amount.getText()+" should be numerical" );
            }
        }else{
            fee.setText("");
        }
        
    }//GEN-LAST:event_amountKeyReleased

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           
        dbConnector dbc = new dbConnector();
        Session ses = Session.getInstance();     
        
        Date now = new Date();
        SimpleDateFormat nowformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattednow = nowformat.format(now);
        
        
        if(checkCustomer(receive_lname.getText(), receive_fname.getText()) == 0){
            if(!receive_lname.getText().isEmpty() && !receive_fname.getText().isEmpty()){
                dbc.insertData("INSERT INTO tbl_customer "
                    + "(cu_lname, cu_fname, cu_mname, cu_contact, "
                    + "cu_gender, cu_nationality, cu_address, cu_birthdate, "
                    + "cu_birthplace, cu_marital, cu_occupation)"
                    + " VALUES('"+receive_lname.getText()+"', '"+receive_fname.getText()+"', "
                    + " 'null', '"+checkContact(receive_contact.getText())+"', 'null', 'null', 'null', '111-11-11', 'null', 'null', 'null' ) ");

                    JOptionPane.showMessageDialog(null, "Temporary Receiver Inserted");
            }else{
                JOptionPane.showMessageDialog(null, "Connection Error");
            }
        }
        
        String loyalty;
            if(!send_card.getText().isEmpty()){
                loyalty = send_card.getText();
            }else{
                loyalty = "none";
            }
        
        if(!send_lname.getText().equalsIgnoreCase(receive_lname.getText()) && !send_fname.getText().equalsIgnoreCase(receive_fname.getText())){
            String code = getCode();
            
            if(dbc.insertData("INSERT INTO tbl_transactions  "
                    + "(tr_customer, tr_customerno, tr_customercard, "
                    + " tr_factorname, tr_factorno, "
                    + " tr_location, tr_relation, tr_purpose, "
                    + " tr_amount, tr_fee, tr_total, "
                    + " tr_code, tr_when, tr_type, tr_teller)" 
                    + " VALUES ( '"+checkCustomer(send_lname.getText(), send_fname.getText())+"', '"+checkContact(send_contact.getText())+"', '"+loyalty+"', "
                    + " '"+checkCustomer(receive_lname.getText(), receive_fname.getText())+"', '"+checkContact(receive_contact.getText())+"', "
                    + " '"+location.getText()+"', '"+relations.getText()+"', '"+purpose.getText()+"', "
                    + " '"+amount.getText()+"', '"+fee.getText()+"', '"+total.getText()+"', "
                    + " '"+code+"', '"+formattednow+"', 'Send',  '"+ses.getEid()+"' ) ")
            ){
                try{
            
                ResultSet rs = dbc.getData("SELECT *,DATE(tr_when) AS when_date, "
                        + " TIME(tr_when) AS when_time, "
                        + " CONCAT(tr_customer, ' ', LEFT(middlename, 1), '. ', lastname) AS full_sename "
                        + "FROM tbl_transactions WHERE tr_code = '"+code+"' ");
               
                if(rs.next()){
    /*                res_code.setText(""+rs.getString("tr_code"));
                    res_date.setText(""+rs.getString("when_date"));
                    res_time.setText(""+rs.getString("when_time"));
                        
                    res_sename.setText(""+rs.getString(""));
                    .setText(""+rs.getString(""));
                    .setText(""+rs.getString(""));
                    .setText(""+rs.getString(""));
                    .setText(""+rs.getString(""));
                    .setText(""+rs.getString(""));
                    .setText(""+rs.getString(""));
                    .setText(""+rs.getString(""));
                    .setText(""+rs.getString(""));
                    .setText(""+rs.getString(""));
                    .setText(""+rs.getString(""));
                    .setText(""+rs.getString(""));
                    .setText(""+rs.getString(""));
                    .setText(""+rs.getString(""));
                    .setText(""+rs.getString(""));
    */                
                    
                    
                    
                    
                    
                    rs.close();
                }else{  
                    rs.close();
                }
                
            }catch(SQLException ex){
                System.out.println("Errors: "+ex.getMessage());

            } 
                
                ReceiptPrinter rPrint = new ReceiptPrinter(receiptPane);
                rPrint.printPanel();
            }        
            
            
            
        //    JOptionPane.showOptionDialog(null, "Print Receipt", "");
        }else if(send_lname.getText().equalsIgnoreCase(receive_lname.getText()) && send_fname.getText().equalsIgnoreCase(receive_fname.getText())){
            JOptionPane.showMessageDialog(null, "Sender and Receiver is the same Person");
        }
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void send_contactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_send_contactFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_send_contactFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount;
    private javax.swing.JLabel amount1;
    private javax.swing.JTextField fee;
    private javax.swing.JLabel fee1;
    private config.genBackground genBackground1;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel34;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField location;
    private javax.swing.JLabel location1;
    private javax.swing.JTextField purpose;
    private javax.swing.JLabel purpose1;
    private javax.swing.JLabel re_contact;
    private javax.swing.JLabel re_cus;
    private javax.swing.JLabel re_name;
    private javax.swing.JPanel receiptPane;
    private javax.swing.JTextField receive_contact;
    private javax.swing.JTextField receive_fname;
    private javax.swing.JTextField receive_lname;
    private javax.swing.JTextField receive_mname;
    private javax.swing.JTextField relations;
    private javax.swing.JLabel relationship;
    private javax.swing.JLabel res_code;
    private javax.swing.JLabel res_date;
    private javax.swing.JLabel res_sename;
    private javax.swing.JLabel res_time;
    private javax.swing.JLabel se_card;
    private javax.swing.JLabel se_contact;
    private javax.swing.JLabel se_cus;
    private javax.swing.JTextField send_card;
    private javax.swing.JTextField send_contact;
    private javax.swing.JTextField send_fname;
    private javax.swing.JTextField send_lname;
    private javax.swing.JTextField send_mname;
    private javax.swing.JTextField total;
    private javax.swing.JLabel total1;
    // End of variables declaration//GEN-END:variables
}
