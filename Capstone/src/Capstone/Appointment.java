package Capstone;

public class Appointment {
	
	 private int id;
	    private String patientFirstName;
	    private String patientLastName;
	    private String date;
	    private String time;
	    private String phoneNum;
	    private String healthInsProv;
	    private String healthInsNum;
	    private String procedureCode;
	   

	    
	    public Appointment(int id,String date, String time, String patientFirstName, String patientLastName,   
	            String phoneNum, String healthInsProv, String healthInsNum, String procedureCode) {
	        super();
	        this.id = id;
	        this.patientFirstName = patientFirstName;
	        this.patientLastName = patientLastName;
	        this.date = date;
	        this.time = time;
	        this.phoneNum = phoneNum;
	        this.healthInsProv = healthInsProv;
	        this.healthInsNum = healthInsNum;
	        this.procedureCode = procedureCode;
	     
	    }
	    // ID getter and Setter
	    public int getId() {
	        return id;
	    }
	    
	    public void setId(int id) {
	        this.id = id;
	    }
	   // First Name getter and setter 
	    public String getFirstName() {
	        return patientFirstName;
	    }
	    
	    public void setFirstName(String firstName) {
	        this.patientFirstName = firstName;
	    }
	    //Last Name getter and setter
	    public String getLastName() {
	        return patientLastName;
	    }
	    
	    public void setLastName(String lastName) {
	        this.patientLastName = lastName;
	    }
//Date of Appointments  getter and setter
	    public String getDate() {
	        return date;
	    }
	   
	    public void setDate(String date) {
	        this.date = date;
	    }
	    
//Time of Appointments getter and setter	    
	    
	    public String getTime() {
	    	return time;
	    }
	    
	    public void setTime(String time) {
	    	this.time = time;
	    }
	    
//Phone Number Getter and Setter
	    public String getPhoneNum() {
	        return phoneNum;
	    }
	    public void setPhoneNum(String phoneNum) {
	        this.phoneNum = phoneNum;
	    }
	    
 //Health Insurance Provider getter and setter
	    public String getHealthInsProv() {
	        return healthInsProv;
	    }
	    public void setHealthInsProv(String healthInsProv) {
	        this.healthInsProv = healthInsProv;
	    }
	    
	    //Health Insurance Number getter and setter
	    public String getHealthInsNum() {
	        return healthInsNum;
	    }
	    public void setHealthInsNum(String healthInsNum){
	        this.healthInsNum = healthInsNum;
	    }
	    
	    public String getProcedureCode() {
	    	return procedureCode;
	    }
	    
	    public void setProcedureCode(String procedureCode) {
	    	this.procedureCode = procedureCode;
	    }
	    

	    
	    @Override
	    public String toString() {
	        return String
	                .format("Appointment [id=%s,  date=%s, time=%s, patientFirstName=%s, patientLastName=%s, phoneNum=%s, healthInsProv=%s, healthInsNum=%s, procedureCode=%s]", 
	                        id, date, time, patientFirstName, patientLastName,  phoneNum, healthInsProv, healthInsNum, procedureCode);
	    }

}
