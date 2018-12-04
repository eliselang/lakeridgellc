/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capstone;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.border.EmptyBorder;



/**
 *
 * @author Danny Perez
 */
public class PatientListSearch extends JFrame {
    
    private JPanel contentPane;
    private JTextField lastNameTextField;
    private JButton btnSearch;
    private JScrollPane scrollPane;
    private JTable table;
    
    private Capstone capstoneDAO;
    private JPanel panel_1;
    private JButton btnAddPatient;
    private JButton btnUpdate;
    private JButton btnDeletePatient;
    
/* Launch application */    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() { 
            @Override
            public void run() {
                try {
                    PatientListSearch frame = new PatientListSearch();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    
    public PatientListSearch() {
    
        try {
            capstoneDAO = new Capstone();
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        setTitle("Patient List Search");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 600, 400);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0,0));
        
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        contentPane.add(panel, BorderLayout.NORTH);
        
        JLabel lblEnterLastName = new JLabel("Enter last name");
        panel.add(lblEnterLastName);
        
        lastNameTextField = new JTextField();
        panel.add(lastNameTextField);
        lastNameTextField.setColumns(10);
        
        btnSearch = new JButton("Search");
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    String lastName = lastNameTextField.getText();
                    
                    List<Patient> patients = null;
                    
                    if (lastName != null && lastName.trim().length() > 0) {
                        patients = capstoneDAO.searchPatients(lastName);
                    } else {
                        patients = capstoneDAO.getAllPatients();
                    }
                    
            /*  Create Model and update the table*/
                    PatientTableModel model = new PatientTableModel(patients);
                    
                    table.setModel(model);
                    
                    
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(PatientListSearch.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
        panel.add(btnSearch);
        
        scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        
        panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.SOUTH);
        
        btnAddPatient = new JButton("Add Patient");
        btnAddPatient.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		AddPatientDialog dialog = new AddPatientDialog(PatientListSearch.this, capstoneDAO);
        		
        		dialog.setVisible(true);
        	}
        });
        panel_1.add(btnAddPatient);
        
        btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		int row = table.getSelectedRow();
        		
        		if (row < 0) {
        			JOptionPane.showMessageDialog(PatientListSearch.this , "You must select a patient" , "Error", JOptionPane.ERROR_MESSAGE);
        			return;
        		}
        		Patient tempPatient = (Patient) table.getValueAt(row, PatientTableModel.OBJECT_COL);
        		
        		AddPatientDialog dialog = new AddPatientDialog(PatientListSearch.this, capstoneDAO, tempPatient, true);
        		
        		dialog.setVisible(true);
        	
        	}
        });
        panel_1.add(btnUpdate);
        
        btnDeletePatient = new JButton("Delete Patient");
        btnDeletePatient.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		try {
        			int row = table.getSelectedRow();
        			
        			if (row <0) {
        				JOptionPane.showMessageDialog(PatientListSearch.this, "You must select a patient", "Error", JOptionPane.ERROR_MESSAGE);
        					return;
        			}
        			
        			int response = JOptionPane.showConfirmDialog(PatientListSearch.this, "Delete this Patient?", "Confirm", 
        					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        					
        			if(response != JOptionPane.YES_OPTION) {
        				return;
        			}
        			Patient tempPatient = (Patient) table.getValueAt(row, PatientTableModel.OBJECT_COL);
        			
        			capstoneDAO.deletePatient(tempPatient.getId());
        			
        			refreshPatientView();
        			
        			JOptionPane.showMessageDialog(PatientListSearch.this, "Patient Successfully Deleted", "Patient Deleted", JOptionPane.INFORMATION_MESSAGE);
        		
        		} catch (Exception exc) {
        			JOptionPane.showMessageDialog(PatientListSearch.this, "Error Deleting Patient: " + exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        		}
        		
        	}
        });
        panel_1.add(btnDeletePatient);
        
    }


	public void refreshPatientView() {
		// TODO Auto-generated method stub
		try {
			List<Patient> patients = capstoneDAO.getAllPatients();
			
			PatientTableModel model = new PatientTableModel(patients);
			
			table.setModel(model);
			
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
    
}
