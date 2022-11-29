/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytrungtamanhngu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class DBConnection {
     public Connection conn;
     public   Statement myStmt=null;
     public   ResultSet myRs=null;
     
    public Connection KetNoiCSDL() throws ClassNotFoundException{
        String user="sa";
        String pass="123456";
        try{
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=quanlytrungtamanhngu",user,pass);
            System.out.println("Thanh Cong");
            return conn;
        }catch(SQLException e)
        {
             e.printStackTrace();
        }
        return conn;
    }
   

    /* public static String databaseName = "quanlytrungtamanhngu";
    public static Connection getConnection() {
    String url = "net.sourceforge.jtds.jdbc.Driver";
        try {
            Class.forName(url);
            String dbUrl = "jdbc:jtds:sqlserver://localhost:1433/quanlytrungtamanhngu;instance=SQLEXPRESS";
            return DriverManager.getConnection(dbUrl,"sa","123456");
//          return DriverManager.getConnection(dbUrl,user, pass);
        } catch (Exception ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static void main(String[] args) {
        DBConnection.getConnection();
    }
    */
}
