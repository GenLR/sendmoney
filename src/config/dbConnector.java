
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class dbConnector {
    
    private Connection connect;
    
    //Function to connect to the database
    public dbConnector(){  
        try{
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/sendmoneydbs", "root", "");

        }catch(SQLException ex){
            System.out.println("Can't connect to database: " + ex.getMessage());
        }
    }
    
    //Function to retrieve data
    public ResultSet getData(String sql) throws SQLException{
        Statement stmt = connect.createStatement();
        ResultSet rst = stmt.executeQuery(sql);
        return rst;
    }
    
    //Function to save/add data
    public boolean insertData(String sql){
        try{
            PreparedStatement pst = connect.prepareStatement(sql);
            pst.executeUpdate();
            System.out.println("Inserted Successfully!");
            pst.close();
            return true;
        }catch(SQLException ex){
            System.out.println("Connection Error: "+ex);
            return false;
        }
    }
    
    //Function to undate/change data
    public void updateData(String sql){
        try{
            PreparedStatement pst = connect.prepareStatement(sql);
            int rows = pst.executeUpdate();
                
                if(rows>0){
                    JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                }else{
                    System.out.println("Update Failed");
                }
        }catch(SQLException ex){
            System.out.println("Connection Error"+ex);
        }
    }
    
}
