/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Danny Perez
 */
public class Capstone {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/445", "root", "password");
            System.out.println("Success!");
        } catch (SQLException ex) {
             Logger.getLogger(Capstone.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
    }
    
}
