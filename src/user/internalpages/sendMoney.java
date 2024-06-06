
package user.internalpages;

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

        return sb.toString();
        
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
        re_cus = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
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
        se_cus = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        relations = new javax.swing.JTextField();
        purpose = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        fee = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1000, 459));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jPanel6.setOpaque(false);

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

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

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(19, 53, 112));
        jLabel14.setText("Contact No.");

        location.setText("Anywhere in the Philippines");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(19, 53, 112));
        jLabel16.setText("Branch");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(19, 53, 112));
        jLabel9.setText("Location");

        re_cus.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        re_cus.setForeground(new java.awt.Color(255, 0, 0));
        re_cus.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                re_cusFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(receive_lname))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(receive_fname))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(receive_mname))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(receive_contact))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(re_cus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(location, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(receive_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(receive_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(receive_mname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(receive_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(re_cus, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6);
        jPanel6.setBounds(350, 10, 310, 300);

        jPanel7.setOpaque(false);

        jPanel2.setBackground(new java.awt.Color(40, 120, 240));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Sender Info");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(19, 53, 112));
        jLabel12.setText("Last Name");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(19, 53, 112));
        jLabel21.setText("First Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(19, 53, 112));
        jLabel5.setText("Middle Name");

        send_mname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                send_mnameFocusLost(evt);
            }
        });

        send_contact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                send_contactFocusLost(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(19, 53, 112));
        jLabel13.setText("Contact No.");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(19, 53, 112));
        jLabel6.setText("Loyalty Card");

        se_cus.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        se_cus.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(send_lname, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(send_fname))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(send_mname))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(send_contact))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(se_cus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(send_card)))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(send_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(send_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(send_mname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(send_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(send_card, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(se_cus, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7);
        jPanel7.setBounds(20, 10, 310, 310);

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
                .addContainerGap(215, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel8.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 290, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(19, 53, 112));
        jLabel15.setText("Relationship");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 80, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(19, 53, 112));
        jLabel11.setText("to Receiver");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 70, 20));
        jPanel8.add(relations, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 180, 30));
        jPanel8.add(purpose, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 180, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(19, 53, 112));
        jLabel17.setText("Purpose of");
        jPanel8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 80, 20));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(19, 53, 112));
        jLabel18.setText("Transaction");
        jPanel8.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 80, 20));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(19, 53, 112));
        jLabel19.setText("Amount");
        jPanel8.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 80, 20));

        amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                amountKeyReleased(evt);
            }
        });
        jPanel8.add(amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 180, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(19, 53, 112));
        jLabel20.setText("Fee");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 80, 20));
        jPanel8.add(fee, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 180, 30));
        jPanel8.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 180, 30));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(19, 53, 112));
        jLabel25.setText("Total");
        jPanel8.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 80, 20));

        jPanel1.add(jPanel8);
        jPanel8.setBounds(670, 10, 310, 240);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Sender Info");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(-210, -10, 73, 20);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(370, 330, 120, 40);

        javax.swing.GroupLayout genBackground1Layout = new javax.swing.GroupLayout(genBackground1);
        genBackground1.setLayout(genBackground1Layout);
        genBackground1Layout.setHorizontalGroup(
            genBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
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
        int senderID = checkCustomer(send_lname.getText(), send_lname.getText());
        int receiverID = checkCustomer(receive_lname.getText(), receive_lname.getText());
        String code = getCode();
        
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
                    + " 'temp', '"+checkContact(receive_contact.getText())+"', 'temp', 'temp', 'temp', '1111-11-11', 'temp', 'temp', 'temp' ) ");

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
            System.out.println("Name Found");
            int secoID = checkContact(send_contact.getText());
            int recoID = checkContact(receive_contact.getText());
            
            dbc.insertData("INSERT INTO tbl_transactions  "
                    + "(tr_customer, tr_customerno, tr_customercard, "
                    + " tr_factorname, tr_factorno, "
                    + " tr_location, tr_relation, tr_purpose, "
                    + " tr_amount, tr_fee, tr_total, "
                    + " tr_code, tr_when, tr_type, tr_teller)" 
                    + " VALUES ( '"+senderID+"', '"+secoID+"', '"+loyalty+"', "
                    + " '"+receiverID+"', '"+recoID+"', "
                    + " '"+location.getText()+"', '"+relations.getText()+"', '"+purpose.getText()+"', "
                    + " '"+amount.getText()+"', '"+fee.getText()+"', '"+total.getText()+"', "
                    + " '"+code+"', '"+formattednow+"', 'Send',  '"+ses.getEid()+"' ) ");
        
            JOptionPane.showMessageDialog(null, "Transaction Success");
        }else if(send_lname.getText().equalsIgnoreCase(receive_lname.getText()) && send_fname.getText().equalsIgnoreCase(receive_fname.getText())){
            JOptionPane.showMessageDialog(null, "Sender and Receiver is the same Person");
        }
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void send_contactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_send_contactFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_send_contactFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount;
    private javax.swing.JTextField fee;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField location;
    private javax.swing.JTextField purpose;
    private javax.swing.JLabel re_cus;
    private javax.swing.JTextField receive_contact;
    private javax.swing.JTextField receive_fname;
    private javax.swing.JTextField receive_lname;
    private javax.swing.JTextField receive_mname;
    private javax.swing.JTextField relations;
    private javax.swing.JLabel se_cus;
    private javax.swing.JTextField send_card;
    private javax.swing.JTextField send_contact;
    private javax.swing.JTextField send_fname;
    private javax.swing.JTextField send_lname;
    private javax.swing.JTextField send_mname;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
