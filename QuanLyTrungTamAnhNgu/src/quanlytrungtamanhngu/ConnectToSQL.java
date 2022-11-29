/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytrungtamanhngu;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author HP
 */
public class ConnectToSQL {
    public ConnectToSQL(){
    try {
            
        
        
              String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=quanlytrungtamanhngu"; 
              String user = "sa";
              String pass = "123456";
              Connection con = DriverManager.getConnection(connectionUrl, user, pass);
              if(con !=null){
                  System.out.println("ket noi thanh cong");
              }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new ConnectToSQL();
    }

}
