/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capstone;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Danny Perez
 */
public class Capstone {
    
    
    private Connection connection;
    
    public Capstone() throws Exception {
         
           
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/445", "root", "password");
           
        
        
        
      /*
        String dburl = "jdbc:mysql://127.0.0.1:3306/445";
        conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/445", "root", "password");
        System.out.println("DB COnnection Successful to: " + dburl); 
       */ 
    }
    
    public void addPatient(Patient thePatient) throws Exception {
    	PreparedStatement stmt = null;
    	
    	try {
    		
    		stmt = connection.prepareStatement("insert into patientlist " +
    				"(id, first_name, last_name, date_of_birth, phone_number, social_security_number, address, city, state, health_insurance_provider, health_insurance_number)"
    				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
    		
    		stmt.setInt(1, thePatient.getId());
    		stmt.setString(2, thePatient.getFirstName());
    		stmt.setString(3, thePatient.getLastName());
    		stmt.setString(4, thePatient.getDateOfBirth());
    		stmt.setString(5,  thePatient.getPhoneNum());
    		stmt.setString(6, thePatient.getSocialSec());
    		stmt.setString(7, thePatient.getAddress());
    		stmt.setString(8,  thePatient.getCity());
    		stmt.setString(9, thePatient.getState());
    		stmt.setString(10,  thePatient.getHealthInsProv());
    		stmt.setString(11, thePatient.getHealthInsNum());
    		//stmt.setString(12, thePatient.getNotes());
    		
    		stmt.executeUpdate();
    	}
    	finally {
    		close(stmt, null);
    	}
    	
    }
    
    public List<Patient> getAllPatients() throws Exception {
        List<Patient> list = new ArrayList<>();
        
        Statement stmt = null;
        ResultSet myRs = null;
        
        try {
            stmt = connection.createStatement();
            myRs = stmt.executeQuery("select * from patientlist");
            
            while (myRs.next()) {
                Patient tempPatient = convertRowToPatient(myRs);
                list.add(tempPatient);
            }
            
            return list;
            }
         finally {
            close(stmt, myRs);
        }
        }
  
    public List<Patient> searchPatients(String lastName) throws Exception {
        List<Patient> list = new ArrayList<>();
        
        PreparedStatement stmt = null;
        ResultSet myRs = null;
    try {
        lastName += "%";
        stmt = connection.prepareStatement("select * from patientlist where last_name like ?");
        
        stmt.setString(1, lastName);
        
        myRs = stmt.executeQuery();
        
        while (myRs.next()) {
            Patient tempPatient = convertRowToPatient(myRs);
            list.add(tempPatient);
        }
        return list;
        
    }
    finally {
        close(stmt, myRs);
    }
    }
    
    private Patient convertRowToPatient(ResultSet myRs) throws SQLException {
    
        int id = myRs.getInt("id");
        String firstName = myRs.getString("first_name");
        String lastName = myRs.getString("last_name");
        String dateOfBirth = myRs.getString("date_of_birth");
        String phoneNum = myRs.getString("phone_number");
        String socialSec = myRs.getString("social_security_number");
        String address = myRs.getString("address");
        String city = myRs.getString("city");
        String state = myRs.getString("state");
        String healthInsProv = myRs.getString("health_insurance_provider");
        String healthInsNum = myRs.getString("health_insurance_number");
     //   String notes = myRs.getString("notes");
        
        Patient tempPatient = new Patient(id, firstName, lastName, dateOfBirth, phoneNum, socialSec, address, city, state, healthInsProv, healthInsNum);
        return tempPatient;
    }
    
    private static void close(Connection connection, Statement stmt, ResultSet myRs)
               throws SQLException {
        if (myRs != null) {
            myRs.close();
        }
        
        if (stmt != null) {
            
        }
        
        if (connection != null) {
            connection.close();
        }
    }
    
    private void close(Statement stmt, ResultSet myRs) throws SQLException {
            close(null, stmt, myRs);
    }
    
    public static void main(String[] args) throws Exception {
        Capstone dao = new Capstone();
        
        
    }
}
    

