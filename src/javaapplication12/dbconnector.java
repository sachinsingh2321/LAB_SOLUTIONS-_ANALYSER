/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication12;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author hp
 */
public class dbconnector {
     public static Connection con;
    
    public static Connection getconnection(){
        
//        try{
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "Vikash@123");
//        }
//        catch(Exception e){
//            System.out.println("err: "+ e);
//        }
//         return con ;
         
         
           
         try{
             
            Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "Vikash@123");
          return con;
        }
        catch(Exception e){
            System.out.println("err: "+ e);
            return con;
        }
}
};
