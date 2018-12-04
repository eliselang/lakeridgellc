/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capstone;

/**
 *
 * @author Danny Perez
 */
public class Patient {
    private int id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String phoneNum;
    private String socialSec;
    private String address;
    private String city;
    private String state;
    private String healthInsProv;
    private String healthInsNum;
 //   private String notes;   
    
    public Patient(int id, String firstName, String lastName, String dateOfBirth, 
            String phoneNum, String socialSec, String address, String city, String state,
            String healthInsProv, String healthInsNum) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNum = phoneNum;
        this.socialSec = socialSec;
        this.address = address;
        this.city = city;
        this.state = state;
        this.healthInsProv = healthInsProv;
        this.healthInsNum = healthInsNum;
   //     this.notes = notes;    
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
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    //Last Name getter and setter
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    //Date of Birth getter and setter
    public String getDateOfBirth() {
        return dateOfBirth;
    }
   
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    //Phone Number Getter and Setter
    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    
    //Social Security getter and setter
    public String getSocialSec() {
        return socialSec;
    }
    public void setSocialSec(String socialSec) {
        this.socialSec = socialSec;
    }
    
    //Address getter and setter
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
    //City getter and setter
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    
    //State getter and setter
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
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
    
    //Notes getter and setter
   // public String getNotes(){
  //      return notes;
 //   }
//    public void setNotes(String notes) {
//        this.notes = notes;
//    }
    
    @Override
    public String toString() {
        return String
                .format("Patient [id=%s, firstName=%s, lastName=%s, dateOfBirth=%s, phoneNum=%s, socialSec=%s, address=%s, city=%s, state=%s, healthInsProv=%s, healthInsNum=%s]", 
                        id, firstName, lastName, dateOfBirth, phoneNum, socialSec, address, city, state, healthInsProv, healthInsNum);
    }
    
}
