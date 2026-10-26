/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jFrame;

import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;

/**
 *
 * @author rudra
 */
public class DBConnection {
    static Connection con=null;
    public static Connection getConnection(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
    
    con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","arjun");
    
}
catch(Exception e){
            System.out.println(e);
}
    return con;
    
}
}
