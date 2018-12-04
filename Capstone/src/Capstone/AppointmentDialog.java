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
import java.awt.event.ActionEvent;
public class AppointmentDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private JTextField dateTextField;
	private JTextField timeTextField;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField phoneNumTextField;
	private JTextField healthInsProvTextField;
	private JTextField healthInsNumTextField;
	private JTextField procedureCodeTextField;
	
	private Capstone capstoneDAO;
	
	private AppointmentSchedule appointmentSchedule;
	
	private Appointment previousAppointment = null;
	private boolean updateMode = false;
	
	public AppointmentDialog(AppointmentSchedule theAppointmentSchedule, Capstone theCapstoneDAO, Appointment thePreviousAppointment, boolean theUpdateMode) {
		this();
		capstoneDAO = theCapstoneDAO;
		appointmentSchedule = theAppointmentSchedule;
		
		previousAppointment = thePreviousAppointment;
		
		updateMode = theUpdateMode;
		if (updateMode) {
			setTitle("Update Appointment");
			
			populateGui(previousAppointment);
		}
	}
	
	private void populateGui(Appointment theAppointment) {
		
		dateTextField.setText(theAppointment.getDate());
		timeTextField.setText(theAppointment.getTime());
		firstNameTextField.setText(theAppointment.getFirstName());
		lastNameTextField.setText(theAppointment.getLastName());
		phoneNumTextField.setText(theAppointment.getPhoneNum());
		healthInsProvTextField.setText(theAppointment.getHealthInsProv());
		healthInsNumTextField.setText(theAppointment.getHealthInsNum());
		procedureCodeTextField.setText(theAppointment.getProcedureCode());
		
	}
	
	public AppointmentDialog(AppointmentSchedule theAppointmentSchedule, Capstone theCapstoneDAO) {
		this(theAppointmentSchedule, theCapstoneDAO, null, false);
		
	}

	public AppointmentDialog() {
		setTitle("Add Appointment Dialog");
		setBounds(100, 100, 450, 300);
		
		
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
		
		{ // Date Label
			JLabel lblDate = new JLabel("Date of Appointment:");
			contentPanel.add(lblDate, "2, 2");
		}
		
		{// Date Text Field
			dateTextField = new JTextField();
			contentPanel.add(dateTextField, "6, 2, fill, default");
			dateTextField.setColumns(10);
		}
		
		{//Time Label
			JLabel lblTime = new JLabel("Time of Appointment:");
			contentPanel.add(lblTime, "2, 4");
		}
		
		{//Time Text Field
			timeTextField = new JTextField();
			contentPanel.add(timeTextField, "6, 4, fill, default");
			timeTextField.setColumns(10);
		}
		
		{//Patient First Name Label
			JLabel lblFirstName = new JLabel("Patient First Name:");
			contentPanel.add(lblFirstName, "2, 6");
		}
		
		{// Patient First Name Text Field
			firstNameTextField = new JTextField();
			contentPanel.add(firstNameTextField, "6, 6, fill, default");
			firstNameTextField.setColumns(10);
		}
		
		{// Patient Last Name Label
			JLabel lblLastName = new JLabel("Patient Last Name:");
			contentPanel.add(lblLastName, "2, 8");
		}
		
		{// Patient Last Name Text Field
			lastNameTextField = new JTextField();
			contentPanel.add(lastNameTextField, "6, 8, fill, default");
			lastNameTextField.setColumns(10);
		}
		
		{//Phone Number Label
			JLabel lblPhoneNumber = new JLabel("Phone Number:");
			contentPanel.add(lblPhoneNumber, "2, 10");
		}
		
		{//Phone Number Text Field
			phoneNumTextField = new JTextField();
			contentPanel.add(phoneNumTextField, "6, 10, fill, default");
			phoneNumTextField.setColumns(10);
		}
		
		{//Health Insurance Provider Label
			JLabel lblHealthInsProv = new JLabel("Health Insurance Provider:");
			contentPanel.add(lblHealthInsProv, "2, 12");
		}
		
		{//Health Insurance Provider Text Field
			healthInsProvTextField = new JTextField();
			contentPanel.add(healthInsProvTextField, "6, 12, fill, default");
			healthInsProvTextField.setColumns(10);
		}
		
		{//Health Insurance Number Label
			JLabel lblHealthInsNum = new JLabel("Health Insurance Number:");
			contentPanel.add(lblHealthInsNum, "2, 14");
		}
		
		{//Health Insurance Number Text Field
			healthInsNumTextField = new JTextField();
			contentPanel.add(healthInsNumTextField, "6, 14, fill, default");
			healthInsNumTextField.setColumns(10);
		}
		
		{//Procedure Code Label
			JLabel lblProcedureCode = new JLabel("Procedure Code:");
			contentPanel.add(lblProcedureCode, "2, 16");
		}
		
		{//Procedure Code Text Field
			procedureCodeTextField = new JTextField();
			contentPanel.add(procedureCodeTextField, "6, 16, fill, default");
			procedureCodeTextField.setColumns(10);
		}
	
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						saveAppointment();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
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
	
	public void saveAppointment() {
		
		String date = dateTextField.getText();
		String time = timeTextField.getText();
		String firstName = firstNameTextField.getText();
		String lastName = lastNameTextField.getText();
		String phoneNum = phoneNumTextField.getText();
		String healthInsProv = healthInsProvTextField.getText();
		String healthInsNum = healthInsNumTextField.getText();
		String procedureCode = procedureCodeTextField.getText();
		int id = 0;
		
		Appointment tempAppointment = null;
		
		if (updateMode) {
			tempAppointment = previousAppointment;
			
			tempAppointment.setDate(date);
			tempAppointment.setTime(time);
			tempAppointment.setFirstName(firstName);
			tempAppointment.setLastName(lastName);
			tempAppointment.setPhoneNum(phoneNum);
			tempAppointment.setHealthInsProv(healthInsProv);
			tempAppointment.setHealthInsNum(healthInsNum);
			tempAppointment.setProcedureCode(procedureCode);
			
		} else {
			tempAppointment = new Appointment (id, date, time, firstName, lastName, phoneNum, healthInsProv, healthInsNum, procedureCode);
		}
		
		
		try {
			
			if (updateMode) {
				capstoneDAO.updateAppointments(tempAppointment);
			} else {
				capstoneDAO.addAppointments(tempAppointment);
			}
			setVisible(false);
			dispose();
			
			appointmentSchedule.refreshApptView();
			
			JOptionPane.showMessageDialog(appointmentSchedule, "Appointment Successfully Added.", "Appointment Added", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(appointmentSchedule, "Error adding Appointment: " + exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}

}
