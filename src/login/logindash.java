
package login;

import admin.admindash;
import com.sun.glass.events.KeyEvent;
import config.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import teller.tellerdash;

public class logindash extends javax.swing.JFrame {

    
    public logindash() {
        initComponents();
        updateTimeAndDate();
    }

    public static boolean loginAccount(String username, String password, String empid){
        dbConnector connector = new dbConnector();
        
        try{
            String query = "SELECT * FROM tbl_user WHERE username = '"+username+"' AND employeeid = '"+empid+"' ";
            ResultSet rs = connector.getData(query);

            if(rs.next()){
                String hashedPass = rs.getString("password");
                
                if(passHash.hashPassword(password).equals(hashedPass)){
                    Session ses =  Session.getInstance();
                        ses.setEid("employeeid");
                        ses.setName(rs.getString("fullname"));
                        ses.setUsername(rs.getString("username"));
                        ses.setPassword(rs.getString("password"));
                        ses.setAcctype(rs.getString("acctype"));
                        ses.setStatus(rs.getString("status"));

                    return true;
                }else{
                    return false;
                }
                
            }else{
                return false;
            }   
            
        }catch(SQLException | NoSuchAlgorithmException ex){
            return false;
        }
    }
    
    private void getLogin(){
        
        Session ses = Session.getInstance();
        
        if(loginAccount(log_user.getText(), log_pass.getText(), log_id.getText())){
            
            if(ses.getStatus().equalsIgnoreCase("Active")){
                
                if(ses.getAcctype().equalsIgnoreCase("Admin")){
                    JOptionPane.showMessageDialog(null, "Login Success");
                    admindash adash = new admindash();
                    adash.setVisible(true);
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Login Success");
                    tellerdash udash = new tellerdash();
                    udash.setVisible(true);
                    this.dispose();
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Account not yet Activated");
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "No Account found"); 
        }
        
    }
    
    private void updateTimeAndDate(){
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DateTimeFormatter times = DateTimeFormatter.ofPattern("HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                time.setText(times.format(now));
                
                DateTimeFormatter dates = DateTimeFormatter.ofPattern("MM-dd-yyyy");
                date.setText(dates.format(now));
            }
        });
        timer.start();
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genBackground1 = new config.genBackground();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        log_id = new javax.swing.JTextField();
        log_pass = new javax.swing.JTextField();
        log_user = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 450));
        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(null);

        log_id.setBackground(new java.awt.Color(230, 230, 230));
        log_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_idActionPerformed(evt);
            }
        });
        log_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                log_idKeyPressed(evt);
            }
        });
        jPanel3.add(log_id);
        log_id.setBounds(40, 120, 190, 30);

        log_pass.setBackground(new java.awt.Color(230, 230, 230));
        log_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_passActionPerformed(evt);
            }
        });
        log_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                log_passKeyPressed(evt);
            }
        });
        jPanel3.add(log_pass);
        log_pass.setBounds(40, 70, 190, 30);

        log_user.setBackground(new java.awt.Color(230, 230, 230));
        log_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_userActionPerformed(evt);
            }
        });
        log_user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                log_userKeyPressed(evt);
            }
        });
        jPanel3.add(log_user);
        log_user.setBounds(40, 20, 190, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(19, 53, 112));
        jLabel12.setText("Username");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(20, 0, 60, 20);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(19, 53, 112));
        jLabel13.setText("Password");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(20, 50, 60, 20);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(19, 53, 112));
        jLabel11.setText("Employee ID");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(20, 100, 80, 20);

        login.setBackground(new java.awt.Color(60, 120, 240));
        login.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("LOGIN");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel3.add(login);
        login.setBounds(80, 160, 100, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(170, 240, 270, 200);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel7.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 20));
        jPanel7.add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 60, 20));

        jPanel8.setBackground(new java.awt.Color(60, 120, 240));
        jPanel8.setPreferredSize(new java.awt.Dimension(1, 25));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jPanel1.add(jPanel7);
        jPanel7.setBounds(420, 10, 170, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/money-remittance (1).png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(110, 40, 390, 200);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(40, 120, 240));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("where money flies");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(300, 200, 250, 50);

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

        setSize(new java.awt.Dimension(616, 489));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void log_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_log_idActionPerformed

    private void log_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_log_passActionPerformed

    private void log_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_log_userActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        getLogin();
    }//GEN-LAST:event_loginActionPerformed

    private void log_userKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_log_userKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            getLogin();
        }
    }//GEN-LAST:event_log_userKeyPressed

    private void log_passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_log_passKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            getLogin();
        }
    }//GEN-LAST:event_log_passKeyPressed

    private void log_idKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_log_idKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            getLogin();
        }
    }//GEN-LAST:event_log_idKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(logindash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(logindash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(logindash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(logindash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new logindash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel date;
    private config.genBackground genBackground1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField log_id;
    private javax.swing.JTextField log_pass;
    private javax.swing.JTextField log_user;
    private javax.swing.JButton login;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables
}
