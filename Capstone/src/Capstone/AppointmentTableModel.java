package Capstone;

import java.util.List;

public class AppointmentTableModel extends javax.swing.table.AbstractTableModel {
	
	public static final int OBJECT_COL = -1;
	private static final int ID_COL = 0;
	private static final int DATE_COL = 1;
	private static final int TIME_COL = 2;
	private static final int PATIENT_FIRST_NAME_COL = 3;
	private static final int PATIENT_LAST_NAME_COL = 4;
	private static final int PHONE_NUMBER_COL = 5;
	private static final int HEALTH_INSURANCE_PROVIDER_COL = 6;
	private static final int HEALTH_INSURANCE_NUMBER_COL = 7;
	private static final int PROCEDURE_CODE_COL = 8;
	
	private String[] columnNames = {"id", "date", "time", "patient_first_name", "patient_last_name" , "phone_number",
			"health_insurance_provider", "health_insurance_number", "procedure_code" };
	
	private List<Appointment> appointments;
	
	public AppointmentTableModel(List<Appointment> theAppointments) {
		appointments = theAppointments;
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return appointments.size();
	}
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		Appointment tempAppointment = appointments.get(row);
		
		switch(col) {
			case ID_COL:
				return tempAppointment.getId();
			case DATE_COL:
				return tempAppointment.getDate();
			case TIME_COL:
				return tempAppointment.getTime();
			case PATIENT_FIRST_NAME_COL:
				return tempAppointment.getFirstName();
			case PATIENT_LAST_NAME_COL:
				return tempAppointment.getLastName();
			case PHONE_NUMBER_COL:
				return tempAppointment.getPhoneNum();
			case HEALTH_INSURANCE_PROVIDER_COL:
				return tempAppointment.getHealthInsProv();
			case HEALTH_INSURANCE_NUMBER_COL:
				return tempAppointment.getHealthInsNum();
			case PROCEDURE_CODE_COL:
				return tempAppointment.getProcedureCode();
			case OBJECT_COL:
				return tempAppointment;
			default:
				return tempAppointment.getId();
				
		}
		
		
		
	}


}
