package Capstone;


import java.util.List;

public class CheckTableModel extends javax.swing.table.AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int CHECK_NUMBER_COL = 0;
	private static final int DATE_OF_CHECK_COL = 1;
	private static final int ROUTING_NUMBER_COL = 2;
	private static final int HEALTH_INSURANCE_PROVIDER_COL = 3;
	private static final int CHECK_TOTAL_COL = 4;
	private static final int REMAINDER_COL = 5;
	
	private String[] columnNames = {"checknumber", "date_of_check", "routing_number", "health_insurance_provider" , "check_total", "remainder"};
	
	private List<Check> checks;
	
	public CheckTableModel(List<Check> theChecks) {
		checks = theChecks;
	}
	
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return checks.size();
	}
	
	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	
	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		Check tempCheck = checks.get(row);
		
		switch(col) {
			case CHECK_NUMBER_COL:
				return tempCheck.getCheckNum();
			case DATE_OF_CHECK_COL:
				return tempCheck.getDateOfCheck();
			case ROUTING_NUMBER_COL:
				return tempCheck.getRoutingNum();
			case HEALTH_INSURANCE_PROVIDER_COL:
				return tempCheck.getHealthInsProv();
			case CHECK_TOTAL_COL:
				return tempCheck.getCheckTotal();
			case REMAINDER_COL:
				return tempCheck.getCheckRemain();
			case OBJECT_COL:
				return tempCheck;
			default:
				return tempCheck.getCheckNum();
				
		}
		
		
		
	}

}
