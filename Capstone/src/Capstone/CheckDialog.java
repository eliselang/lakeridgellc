package Capstone;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class CheckDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField checkNumTextField;
	private JTextField dateTextField;
	private JTextField routingNumTextField;
	private JTextField healthInsProvTextField;
	private JTextField checkTotalTextField;
	private JTextField checkRemainTextField;

	
	private Capstone capstoneDAO;
	
	private CheckListSearch checkListSearch;
	
	private Check previousCheck = null;
	private boolean updateMode = false;
	
	public CheckDialog(CheckListSearch theCheckListSearch, Capstone theCapstoneDAO, Check thePreviousCheck, boolean theUpdateMode) {
		this();
		capstoneDAO = theCapstoneDAO;
		checkListSearch = theCheckListSearch;
		
		previousCheck = thePreviousCheck;
		
		updateMode = theUpdateMode;
		if (updateMode) {
			setTitle("Update Check");
			
			populateGui(previousCheck);
		}
	}
	
	private void populateGui(Check theCheck) {
		checkNumTextField.setText(theCheck.getCheckNum());
		dateTextField.setText(theCheck.getDateOfCheck());
		routingNumTextField.setText(theCheck.getRoutingNum());
		healthInsProvTextField.setText(theCheck.getHealthInsProv());
		checkTotalTextField.setText(theCheck.getCheckTotal().toString());
		checkRemainTextField.setText(theCheck.getCheckRemain().toString());
		
			
	}

	public CheckDialog(CheckListSearch theCheckListSearch, Capstone theCapstoneDAO) {
		this(theCheckListSearch, theCapstoneDAO, null, false);
		
	}
	
	public CheckDialog() {
		setTitle("Add Health Insurance Check");
		setBounds(100, 100, 450, 385);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		{
			JLabel lblCheckNum = new JLabel("Check Number");
			contentPanel.add(lblCheckNum, "2, 2");
		}
		{
			checkNumTextField = new JTextField();
			contentPanel.add(checkNumTextField, "6, 2, fill, default");
			checkNumTextField.setColumns(10);
		}
		{
			JLabel lblDateOfCheck = new JLabel("Date of Check");
			contentPanel.add(lblDateOfCheck, "2, 4");
		}
		{
			dateTextField = new JTextField();
			contentPanel.add(dateTextField, "6, 4, fill, default");
			dateTextField.setColumns(10);
		}
		{
			JLabel lblRoutingNum = new JLabel("Routing Number");
			contentPanel.add(lblRoutingNum, "2, 6");
		}
		{
			routingNumTextField = new JTextField();
			contentPanel.add(routingNumTextField, "6, 6, fill, default");
			routingNumTextField.setColumns(10);
		}
		{
			JLabel lblHealthInsProv = new JLabel("Health Insurance Provider");
			contentPanel.add(lblHealthInsProv, "2, 8");
		}
		{
			healthInsProvTextField = new JTextField();
			contentPanel.add(healthInsProvTextField, "6, 8, fill, default");
			healthInsProvTextField.setColumns(10);
		}
		{
			JLabel lblCheckTotal = new JLabel("Check Total");
			contentPanel.add(lblCheckTotal, "2, 10");
		}
		{
			checkTotalTextField = new JTextField();
			contentPanel.add(checkTotalTextField, "6, 10, fill, default");
			checkTotalTextField.setColumns(10);
		}
		{
			JLabel lblCheckRemain = new JLabel("Remainder");
			contentPanel.add(lblCheckRemain, "2, 12");
		}
		{
			checkRemainTextField = new JTextField();
			contentPanel.add(checkRemainTextField, "6, 12, fill, default");
			checkRemainTextField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton saveButton = new JButton("Save");
				saveButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						saveCheck();
					}
				});
				saveButton.setActionCommand("OK");
				buttonPane.add(saveButton);
				getRootPane().setDefaultButton(saveButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	protected BigDecimal convertStringTotalToBigDecimal(String checkTotalStr) {

		BigDecimal result = null;

		try {
			double checkTotalDouble = Double.parseDouble(checkTotalStr);

			result = BigDecimal.valueOf(checkTotalDouble);
		} catch (Exception exc) {
			System.out.println("Invalid value. Defaulting to 0.0");
			result = BigDecimal.valueOf(0.0);
		}

		return result;
	}
	protected BigDecimal convertStringRemainToBigDecimal(String checkRemainStr) {

		BigDecimal result = null;

		try {
			double salaryDouble = Double.parseDouble(checkRemainStr);

			result = BigDecimal.valueOf(salaryDouble);
		} catch (Exception exc) {
			System.out.println("Invalid value. Defaulting to 0.0");
			result = BigDecimal.valueOf(0.0);
		}

		return result;
	}
	
	protected void saveCheck() {
		
		String checkNum = checkNumTextField.getText();
		String dateOfCheck = dateTextField.getText();
		String routingNum = routingNumTextField.getText();
		String healthInsProv = healthInsProvTextField.getText();
		
		String checkTotalStr = checkTotalTextField.getText();
		BigDecimal checkTotal = convertStringTotalToBigDecimal(checkTotalStr);
		
		String checkRemainStr = checkRemainTextField.getText();
		BigDecimal checkRemain = convertStringRemainToBigDecimal(checkRemainStr);
		
		

		Check tempCheck = null;
		if (updateMode) {
			tempCheck = previousCheck;
			
			tempCheck.setCheckNum(checkNum);
			tempCheck.setDateOfCheck(dateOfCheck);
			tempCheck.setRoutingNum(routingNum);
			tempCheck.setHealthInsProv(healthInsProv);
			tempCheck.setCheckTotal(checkTotal);
			tempCheck.setCheckRemain(checkRemain);
			
		} else {
			tempCheck = new Check (checkNum, dateOfCheck, routingNum, healthInsProv, checkTotal, checkRemain);
		}
		
		
		
		try {
			
			if (updateMode) {
				capstoneDAO.updateChecks(tempCheck);
			} else {
				capstoneDAO.addChecks(tempCheck);
			}
			setVisible(false);
			dispose();
			
			checkListSearch.refreshCheckView();
			
			JOptionPane.showMessageDialog(checkListSearch, "Check Successfully Added.", "Check Added", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(checkListSearch, "Error adding Check: " + exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
	
	

}
