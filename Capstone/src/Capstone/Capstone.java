/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capstone;

import java.math.BigDecimal;
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
    
    public void deletePatient(int id) throws SQLException {
		
		PreparedStatement stmt = null;
		
		try {
			stmt = connection.prepareStatement("delete from patientlist where id=?");
			
			stmt.setInt(1, id);
			
			stmt.executeUpdate();
		} 
		finally {
			close(stmt, null);
		}
		
		
	}
    public void updatePatient(Patient thePatient) throws SQLException {
    	PreparedStatement stmt = null;
    	
    	try {
    		
    		stmt = connection.prepareStatement("update patientlist " +
    				" set id=?, first_name=?, last_name=?, date_of_birth=?, phone_number=?, social_security_number=?, address=?, city=?, state=?, health_insurance_provider=?, health_insurance_number=?"
    				+ "where id=? ");
    		
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
    		stmt.setInt(12, thePatient.getId());
    		
    		stmt.executeUpdate();
    	}
    	finally {
    		close(stmt, null);
    	}
    	
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
     
        
        Patient tempPatient = new Patient(id, firstName, lastName, dateOfBirth, phoneNum, socialSec, address, city, state, healthInsProv, healthInsNum);
        return tempPatient;
    }
 
    
    
    
    
    
//Health Insurance Checks
    
    public void deleteCheck(String checkNum) throws SQLException {
		
  		PreparedStatement stmt = null;
  		
  		try {
  			stmt = connection.prepareStatement("delete from checks where checknumber=?");
  			
  			stmt.setString(1, checkNum);
  			
  			stmt.executeUpdate();
  		} 
  		finally {
  			close(stmt, null);
  		}
  		
  		
  	}
    
//Update Checks   
    public void updateChecks(Check theCheck) throws SQLException {
    	PreparedStatement stmt = null;
    	
    	try {
    		
    		stmt = connection.prepareStatement("update checks " +
    				" set checknumber=?, date_of_check=?, routing_number=?, health_insurance_provider=?, check_total=?, remainder=?"
    				+ "where checknumber=? ");
    		
    		stmt.setNString(1, theCheck.getCheckNum());
    		stmt.setString(2, theCheck.getDateOfCheck());
    		stmt.setString(3, theCheck.getRoutingNum());
    		stmt.setString(4, theCheck.getHealthInsProv());
    		stmt.setBigDecimal(5, theCheck.getCheckTotal());
    		stmt.setBigDecimal(6, theCheck.getCheckRemain());
    		stmt.setNString(7, theCheck.getCheckNum());
    		stmt.executeUpdate();
    	}
    	finally {
    		close(stmt, null);
    	}
    	
    }
    
// Add Checks    
    public void addChecks(Check theCheck) throws Exception {
    	PreparedStatement stmt = null;
    	
    	try {
    		
    		stmt = connection.prepareStatement("insert into checks " +
    				"(checknumber, date_of_check, routing_number, health_insurance_provider, check_total, remainder)"
    				+ " values (?, ?, ?, ?, ?, ?)");
    		
    		stmt.setNString(1, theCheck.getCheckNum());
    		stmt.setString(2, theCheck.getDateOfCheck());
    		stmt.setString(3, theCheck.getRoutingNum());
    		stmt.setString(4, theCheck.getHealthInsProv());
    		stmt.setBigDecimal(5, theCheck.getCheckTotal());
    		stmt.setBigDecimal(6, theCheck.getCheckRemain());
    		
    		
    		
    		stmt.executeUpdate();
    	}
    	finally {
    		close(stmt, null);
    	}
    	
    }
    
//Get All Checks    
    public List<Check> getAllChecks() throws Exception {
        List<Check> list = new ArrayList<>();
        
        Statement stmt = null;
        ResultSet myRs = null;
        
        try {
            stmt = connection.createStatement();
            myRs = stmt.executeQuery("select * from checks");
            
            while (myRs.next()) {
                Check tempCheck = convertRowToCheck(myRs);
                list.add(tempCheck);
            }
            
            return list;
            }
         finally {
            close(stmt, myRs);
        }
        }
    
 //Search Checks   
    public List<Check> searchChecks(String checkNum) throws Exception {
        List<Check> list = new ArrayList<>();
        
        PreparedStatement stmt = null;
        ResultSet myRs = null;
    try {
        checkNum += "%";
        stmt = connection.prepareStatement("select * from checks where checknumber like ?");
        
        stmt.setString(1, checkNum);
        
        myRs = stmt.executeQuery();
        
        while (myRs.next()) {
            Check tempCheck = convertRowToCheck(myRs);
            list.add(tempCheck);
        }
        return list;
        
    }
    finally {
        close(stmt, myRs);
    }
    }
 //Convert Row to Check   
    private Check convertRowToCheck(ResultSet myRs) throws SQLException {
        
        String checkNum = myRs.getNString("checknumber");
        String dateOfCheck = myRs.getString("date_of_check");
        String routingNum = myRs.getString("routing_number");
        String healthInsProv = myRs.getString("health_insurance_provider");
        BigDecimal checkTotal = myRs.getBigDecimal("check_total");
        BigDecimal checkRemain = myRs.getBigDecimal("remainder");
      
        
        Check tempCheck = new Check(checkNum, dateOfCheck, routingNum, healthInsProv, checkTotal, checkRemain);
        return tempCheck;
    }
    
    
//Appointment Schedule 
    

//Delete Appointment    
    
 public void deleteAppointment(int id) throws SQLException {
		
  		PreparedStatement stmt = null;
  		
  		try {
  			stmt = connection.prepareStatement("delete from appointment where id=?");
  			
  			stmt.setInt(1, id);
  			
  			stmt.executeUpdate();
  		} 
  		finally {
  			close(stmt, null);
  		}
  		
  		
  	}
    
//Update Appointments
 
    public void updateAppointments(Appointment theAppointment) throws SQLException {
    	PreparedStatement stmt = null;
    	
    	try {
    		
    		stmt = connection.prepareStatement("update appointment " +
    				" set id=?, date=?, time=?, patient_first_name=?, patient_last_name=?, phone_number=?, health_insurance_provider=?, health_insurance_number=?, procedure_code=?"
    				+ "where id=? ");
    		
    		stmt.setInt(1, theAppointment.getId());
    		stmt.setString(2, theAppointment.getDate());
    		stmt.setString(3, theAppointment.getTime());
    		stmt.setString(4, theAppointment.getFirstName());
    		stmt.setString(5, theAppointment.getLastName());
    		stmt.setString(6, theAppointment.getPhoneNum());
    		stmt.setString(7, theAppointment.getHealthInsProv());
    		stmt.setString(8, theAppointment.getHealthInsNum());
    		stmt.setString(9, theAppointment.getProcedureCode());
    		stmt.setInt(10, theAppointment.getId());

    		
    		stmt.executeUpdate();
    	}
    	finally {
    		close(stmt, null);
    	}
    	
    }
    
// Add Appointments    
    public void addAppointments(Appointment theAppointment) throws Exception {
    	PreparedStatement stmt = null;
    	
    	try {
    		
    		stmt = connection.prepareStatement("insert into appointment " +
    				"(id, date, time, patient_first_name, patient_last_name, phone_number, health_insurance_provider, health_insurance_number, procedure_code)"
    				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
    		
    		
    		stmt.setInt(1, theAppointment.getId());
    		stmt.setString(2, theAppointment.getDate());
    		stmt.setString(3, theAppointment.getTime());
    		stmt.setString(4, theAppointment.getFirstName());
    		stmt.setString(5, theAppointment.getLastName());
    		stmt.setString(6, theAppointment.getPhoneNum());
    		stmt.setString(7, theAppointment.getHealthInsProv());
    		stmt.setString(8, theAppointment.getHealthInsNum());
    		stmt.setString(9, theAppointment.getProcedureCode());
    		
    		
    		stmt.executeUpdate();
    	}
    	finally {
    		close(stmt, null);
    	}
    	
    }
    
//Get All Appointments
    public List<Appointment> getAllAppts() throws Exception {
        List<Appointment> list = new ArrayList<>();
        
        Statement stmt = null;
        ResultSet myRs = null;
        
        try {
            stmt = connection.createStatement();
            myRs = stmt.executeQuery("select * from appointment");
            
            while (myRs.next()) {
                Appointment tempAppt = convertRowToAppt(myRs);
                list.add(tempAppt);
            }
            
            return list;
            }
         finally {
            close(stmt, myRs);
        }
        }
    
 //Search Appointments
    public List<Appointment> searchAppts(String date) throws Exception {
        List<Appointment> list = new ArrayList<>();
        
        PreparedStatement stmt = null;
        ResultSet myRs = null;
    try {
        date += "%";
        stmt = connection.prepareStatement("select * from appointment where date like ?");
        
        stmt.setString(1, date);
        
        myRs = stmt.executeQuery();
        
        while (myRs.next()) {
            Appointment tempAppt = convertRowToAppt(myRs);
            list.add(tempAppt);
        }
        return list;
        
    }
    finally {
        close(stmt, myRs);
    }
    }
// Convert Row to Appointment    
   private Appointment convertRowToAppt(ResultSet myRs) throws SQLException {
        
        int id = myRs.getInt("id");
        String date = myRs.getString("date");
        String time = myRs.getString("time");
        String patientFirstName = myRs.getString("patient_first_name");
        String patientLastName = myRs.getString("patient_last_name");
        String phoneNum = myRs.getString("phone_number");
        String healthInsProv = myRs.getString("health_insurance_provider");
        String healthInsNum = myRs.getString("health_insurance_number");
        String procedureCode = myRs.getString("procedure_code");
      
        
        Appointment tempAppt = new Appointment(id, date, time, patientFirstName, patientLastName, phoneNum,  healthInsProv, healthInsNum, procedureCode);
        return tempAppt;
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
        PatientListSearch search = new PatientListSearch();
        
        
        
    }

	
}
    

