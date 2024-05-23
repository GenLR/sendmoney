
package login;

import admin.admindash;
import config.*;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import teller.tellerdash;

public class logindash extends javax.swing.JFrame {

    
    public logindash() {
        initComponents();
    }

    public static boolean loginAccount(String username, String password, String empid){
        dbConnector connector = new dbConnector();
        
        try{
            String query = "SELECT * FROM tbl_user WHERE username = '"+username+"' AND employeeid = '"+empid+"' ";
            ResultSet rs = connector.getData(query);

            if(rs.next()){
                String hashedPass = rs.getString("password");
                
                System.out.println(""+rs.getString("employeeid"));
                System.out.println(""+rs.getString("username"));
                System.out.println(""+rs.getString("password"));
                System.out.println(""+passHash.hashPassword(password));
                
                if(passHash.hashPassword(password).equals(hashedPass)){
                    System.out.println("HERE");
                    Session ses =  Session.getInstance();
                        ses.setEid("employeeid");
                        ses.setName(rs.getString("fullname"));
                        ses.setUsername(rs.getString("username"));
                        ses.setPassword(rs.getString("password"));
                        ses.setAcctype(rs.getString("acctype"));
                        ses.setStatus(rs.getString("status"));
                        System.out.println("THERE");

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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        log_id = new javax.swing.JTextField();
        log_user = new javax.swing.JTextField();
        log_pass = new javax.swing.JTextField();
        login = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 450));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(60, 120, 240));
        jPanel2.setMinimumSize(new java.awt.Dimension(400, 539));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 539));
        jPanel2.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logomoney-removebg-preview.png"))); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(-10, 70, 313, 313);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 300, 450);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Segoe Print", 1, 60)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(40, 120, 240));
        jLabel3.setText("where");
        jPanel6.add(jLabel3);
        jLabel3.setBounds(90, 0, 182, 50);

        jLabel4.setFont(new java.awt.Font("Segoe Print", 1, 60)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(40, 120, 240));
        jLabel4.setText("money");
        jPanel6.add(jLabel4);
        jLabel4.setBounds(70, 20, 200, 90);

        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 60)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(40, 120, 240));
        jLabel2.setText("flies");
        jPanel6.add(jLabel2);
        jLabel2.setBounds(160, 90, 112, 60);

        jPanel5.setBackground(new java.awt.Color(255, 204, 0));
        jPanel5.setPreferredSize(new java.awt.Dimension(280, 5));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel5);
        jPanel5.setBounds(0, 150, 270, 5);

        jPanel1.add(jPanel6);
        jPanel6.setBounds(310, 30, 280, 160);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        log_id.setBackground(new java.awt.Color(230, 230, 230));
        log_id.setForeground(new java.awt.Color(102, 102, 102));
        log_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_idActionPerformed(evt);
            }
        });
        jPanel3.add(log_id);
        log_id.setBounds(40, 120, 190, 30);

        log_user.setBackground(new java.awt.Color(230, 230, 230));
        log_user.setForeground(new java.awt.Color(102, 102, 102));
        log_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_userActionPerformed(evt);
            }
        });
        jPanel3.add(log_user);
        log_user.setBounds(40, 20, 190, 30);

        log_pass.setBackground(new java.awt.Color(230, 230, 230));
        log_pass.setForeground(new java.awt.Color(102, 102, 102));
        log_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_passActionPerformed(evt);
            }
        });
        jPanel3.add(log_pass);
        log_pass.setBounds(40, 70, 190, 30);

        login.setBackground(new java.awt.Color(60, 120, 240));
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("LOGIN");

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel3.add(login);
        login.setBounds(90, 160, 100, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(19, 53, 112));
        jLabel11.setText("Employee ID");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(40, 100, 80, 20);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(19, 53, 112));
        jLabel12.setText("Username");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(40, 0, 60, 20);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(19, 53, 112));
        jLabel13.setText("Password");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(40, 50, 60, 20);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(320, 200, 270, 200);

        jLabel6.setText("Date         |        Time");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(480, 430, 120, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(616, 489));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void log_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_log_idActionPerformed

    private void log_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_log_userActionPerformed

    private void log_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_log_passActionPerformed

    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked
        
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
    }//GEN-LAST:event_loginMouseClicked

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField log_id;
    private javax.swing.JTextField log_pass;
    private javax.swing.JTextField log_user;
    private javax.swing.JPanel login;
    // End of variables declaration//GEN-END:variables
}
