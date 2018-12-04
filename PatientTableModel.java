/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capstone;

import java.util.List;
/**
 *
 * @author Danny Perez
 */
class PatientTableModel  extends javax.swing.table.AbstractTableModel {
    
    private static final int ID_COL = 0;
    private static final int FIRST_NAME_COL = 1;
    private static final int LAST_NAME_COL = 2;
    private static final int DATE_OF_BIRTH_COL = 3;
    private static final int PHONE_NUMBER_COL = 4;
    private static final int SOCIAL_SECURITY_NUMBER_COL = 5;
    private static final int ADDRESS_COL = 6;
    private static final int CITY_COL = 7;
    private static final int STATE_COL = 8;
    private static final int HEALTH_INSURANCE_PROVIDER_COL = 9;
    private static final int HEALTH_INSURANCE_NUMBER_COL = 10;
    private static final int NOTES_COL = 11;
    
    private String[] columnNames = {"id", "first_name", "last_name", "date_of_birth", "phone_number", "social_security_number", "address", "city", "state","health_insurance_provider", "health_insurance_number", "notes" };
    
    private List<Patient> patients;
    
    public PatientTableModel(List<Patient> thePatients) {
        patients = thePatients;
    }
    
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    @Override 
    public int getRowCount() {
        return patients.size();
    }
    
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    @Override 
    public Object getValueAt(int row, int col) {
        
        Patient tempPatient = patients.get(row);
        
        switch (col) {
            case ID_COL:
                return tempPatient.getId();
            case FIRST_NAME_COL:
                return tempPatient.getFirstName();
            case LAST_NAME_COL:
                return tempPatient.getLastName();
            case DATE_OF_BIRTH_COL:
                return tempPatient.getDateOfBirth();
            case PHONE_NUMBER_COL:
                return tempPatient.getPhoneNum();
            case SOCIAL_SECURITY_NUMBER_COL:
                return tempPatient.getSocialSec();
            case ADDRESS_COL:
                return tempPatient.getAddress();
            case CITY_COL:
                return tempPatient.getCity();
            case STATE_COL:
                return tempPatient.getState();
            case HEALTH_INSURANCE_PROVIDER_COL:
                return tempPatient.getHealthInsProv();
            case HEALTH_INSURANCE_NUMBER_COL:
                return tempPatient.getHealthInsNum();
            case NOTES_COL:
                return tempPatient.getNotes();
            default:
                return tempPatient.getLastName();
        }
    
    }
    
    
}
