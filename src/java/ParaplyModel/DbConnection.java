/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParaplyModel;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {
    public static String HOST = "jdbc:mysql://localhost:3306/paraplyet?autoReconnect=true&useSSL=false";
    public static String USERNAME = "root";
     public static String PASSWORD = "Remington870E";
//    public static String PASSWORD = "meiofasknasmisse123";
    private static Connection con;
       
    public void dbConnect() throws SQLException, ClassNotFoundException {
        
        if (con == null)    {
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(HOST, USERNAME, PASSWORD);   
        }
    }
    
        
    public void closeDbConnection() throws SQLException {
        con.close();
    }
    
    public void writeSp(String Sp) throws SQLException   {
        String sql = "{call " + Sp + "}";    
        try {
            dbConnect();
            CallableStatement call = con.prepareCall(sql);
            call.executeUpdate();
        }
        catch (ClassNotFoundException cfe)   {
            System.out.println("Class not found"+ cfe);
        }
                  
    }
    
    public ResultSet readSp(String Sp)  throws SQLException {
        ResultSet toReturn = null; 
        String sql = "{call " + Sp + "}";
        try {
            dbConnect();
            CallableStatement call = con.prepareCall(sql);
            toReturn= call.executeQuery();
        }
        catch (ClassNotFoundException cfe)   {
            System.out.println("Class not found"+ cfe);
        }
        return toReturn;
    }
}