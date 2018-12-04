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

public class AddPatientDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField dateOfBirthTextField;
	private JTextField phoneNumTextField;
	private JTextField socialSecTextField;
	private JTextField addressTextField;
	private JTextField cityTextField;
	private JTextField stateTextField;
	private JTextField healthInsProvTextField;
	private JTextField healthInsNumTextField;

	
	private Capstone capstoneDAO;
	
	private PatientListSearch patientListSearch;
	
	private Patient previousPatient = null;
	private boolean updateMode = false;
	
	public AddPatientDialog(PatientListSearch thePatientListSearch, Capstone theCapstoneDAO, Patient thePreviousPatient, boolean theUpdateMode) {
		this();
		capstoneDAO = theCapstoneDAO;
		patientListSearch = thePatientListSearch;
		
		previousPatient = thePreviousPatient;
		
		updateMode = theUpdateMode;
		if (updateMode) {
			setTitle("Update Patient");
			
			populateGui(previousPatient);
		}
	}
	
	private void populateGui(Patient thePatient) {
		firstNameTextField.setText(thePatient.getFirstName());
		lastNameTextField.setText(thePatient.getLastName());
		dateOfBirthTextField.setText(thePatient.getDateOfBirth());
		phoneNumTextField.setText(thePatient.getPhoneNum());
		socialSecTextField.setText(thePatient.getSocialSec());
		addressTextField.setText(thePatient.getAddress());
		cityTextField.setText(thePatient.getCity());
		stateTextField.setText(thePatient.getState());
		healthInsProvTextField.setText(thePatient.getHealthInsProv());
		healthInsNumTextField.setText(thePatient.getHealthInsNum());
			
	}

	public AddPatientDialog(PatientListSearch thePatientListSearch, Capstone theCapstoneDAO) {
		this(thePatientListSearch, theCapstoneDAO, null, false);
		
	}
	
	public AddPatientDialog() {
		setTitle("Add Patient");
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
			JLabel lblFirstName = new JLabel("First Name");
			contentPanel.add(lblFirstName, "2, 2");
		}
		{
			firstNameTextField = new JTextField();
			contentPanel.add(firstNameTextField, "6, 2, fill, default");
			firstNameTextField.setColumns(10);
		}
		{
			JLabel lblLastName = new JLabel("Last Name");
			contentPanel.add(lblLastName, "2, 4");
		}
		{
			lastNameTextField = new JTextField();
			contentPanel.add(lastNameTextField, "6, 4, fill, default");
			lastNameTextField.setColumns(10);
		}
		{
			JLabel lblDateOfBirth = new JLabel("Date of Birth");
			contentPanel.add(lblDateOfBirth, "2, 6");
		}
		{
			dateOfBirthTextField = new JTextField();
			contentPanel.add(dateOfBirthTextField, "6, 6, fill, default");
			dateOfBirthTextField.setColumns(10);
		}
		{
			JLabel lblPhone = new JLabel("Phone Number");
			contentPanel.add(lblPhone, "2, 8");
		}
		{
			phoneNumTextField = new JTextField();
			contentPanel.add(phoneNumTextField, "6, 8, fill, default");
			phoneNumTextField.setColumns(10);
		}
		{
			JLabel lblSocialSecurity = new JLabel("Social Security");
			contentPanel.add(lblSocialSecurity, "2, 10");
		}
		{
			socialSecTextField = new JTextField();
			contentPanel.add(socialSecTextField, "6, 10, fill, default");
			socialSecTextField.setColumns(10);
		}
		{
			JLabel lblAddress = new JLabel("Address");
			contentPanel.add(lblAddress, "2, 12");
		}
		{
			addressTextField = new JTextField();
			contentPanel.add(addressTextField, "6, 12, fill, default");
			addressTextField.setColumns(10);
		}
		{
			JLabel lblCity = new JLabel("City");
			contentPanel.add(lblCity, "2, 14");
		}
		{
			cityTextField = new JTextField();
			contentPanel.add(cityTextField, "6, 14, fill, default");
			cityTextField.setColumns(10);
		}
		{
			JLabel lblState = new JLabel("State");
			contentPanel.add(lblState, "2, 16");
		}
		{
			stateTextField = new JTextField();
			contentPanel.add(stateTextField, "6, 16, fill, default");
			stateTextField.setColumns(10);
		}
		{
			JLabel lblHealthInsuranceProvider = new JLabel("Health Insurance Provider");
			contentPanel.add(lblHealthInsuranceProvider, "2, 18");
		}
		{
			healthInsProvTextField = new JTextField();
			contentPanel.add(healthInsProvTextField, "6, 18, fill, default");
			healthInsProvTextField.setColumns(10);
		}
		{
			JLabel lblHealthInsuranceNumber = new JLabel("Health Insurance Number");
			contentPanel.add(lblHealthInsuranceNumber, "2, 20");
		}
		{
			healthInsNumTextField = new JTextField();
			contentPanel.add(healthInsNumTextField, "6, 20, fill, default");
			healthInsNumTextField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						savePatient();
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
	
	public void savePatient() {
		
		String firstName = firstNameTextField.getText();
		String lastName = lastNameTextField.getText();
		String dateOfBirth = dateOfBirthTextField.getText();
		String phoneNum = phoneNumTextField.getText();
		String socialSec = socialSecTextField.getText();
		String address = addressTextField.getText();
		String city = cityTextField.getText();
		String state = stateTextField.getText();
		String healthInsProv = healthInsProvTextField.getText();
		String healthInsNum = healthInsNumTextField.getText();
		int id = 0 ;

		Patient tempPatient = null;
		if (updateMode) {
			tempPatient = previousPatient;
			
			tempPatient.setFirstName(firstName);
			tempPatient.setLastName(lastName);
			tempPatient.setDateOfBirth(dateOfBirth);
			tempPatient.setPhoneNum(phoneNum);
			tempPatient.setSocialSec(socialSec);
			tempPatient.setAddress(address);
			tempPatient.setCity(city);
			tempPatient.setState(state);
			tempPatient.setHealthInsProv(healthInsProv);
			tempPatient.setHealthInsNum(healthInsNum);
			
		} else {
			tempPatient = new Patient (id, firstName, lastName, dateOfBirth, phoneNum, socialSec, address, city, state, healthInsProv, healthInsNum);
		}
		
		
		
		try {
			
			if (updateMode) {
				capstoneDAO.updatePatient(tempPatient);
			} else {
				capstoneDAO.addPatient(tempPatient);
			}
			setVisible(false);
			dispose();
			
			patientListSearch.refreshPatientView();
			
			JOptionPane.showMessageDialog(patientListSearch, "Patient Successfully Added.", "Patient Added", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(patientListSearch, "Error adding Patient: " + exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
	
	

}
