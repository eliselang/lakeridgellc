package Capstone;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class CheckListSearch extends JFrame {

	private JPanel contentPane;
	private JTextField checkNumTextField;
	private JTable table;
	
	
	private Capstone capstoneDAO;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckListSearch frame = new CheckListSearch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CheckListSearch() {
		
		try {
			capstoneDAO = new Capstone();
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error:" + exc, "Error", JOptionPane.ERROR_MESSAGE );
		}
		
		setTitle("Health Insurance Checks");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblCheckNumLabel = new JLabel("Enter Check Number");
		lblCheckNumLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblCheckNumLabel);
		
		checkNumTextField = new JTextField();
		panel.add(checkNumTextField);
		checkNumTextField.setColumns(10);
		
		JButton btnSearchButton = new JButton("Search");
		btnSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try {
	                    String checkNum = checkNumTextField.getText();
	                    
	                    List<Check> checks = null;
	                    
	                    if (checkNum != null && checkNum.trim().length() > 0) {
	                        checks = capstoneDAO.searchChecks(checkNum);
	                    } else {
	                        checks = capstoneDAO.getAllChecks();
	                    }
	                    
	            /*  Create Model and update the table*/
	                    CheckTableModel model = new CheckTableModel(checks);
	                    
	                    table.setModel(model);
	                    
	                    
	                } catch (Exception exc) {
	                    JOptionPane.showMessageDialog(CheckListSearch.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
	                }
	                
	            }
	        });
			
		
		panel.add(btnSearchButton);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnAddCheckButton = new JButton("Add Check");
		btnAddCheckButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CheckDialog dialog = new CheckDialog(CheckListSearch.this, capstoneDAO);
				
				dialog.setVisible(true);
				
			}
		});
		panel_1.add(btnAddCheckButton);
		
		JButton btnUpdateCheck = new JButton("Update Check");
		btnUpdateCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
        		
        		if (row < 0) {
        			JOptionPane.showMessageDialog(CheckListSearch.this , "You must select a check" , "Error", JOptionPane.ERROR_MESSAGE);
        			return;
        		}
        		Check tempCheck = (Check) table.getValueAt(row, CheckTableModel.OBJECT_COL);
        		
        		CheckDialog dialog = new CheckDialog(CheckListSearch.this, capstoneDAO, tempCheck, true);
        		
        		dialog.setVisible(true);
			}
		});
		panel_1.add(btnUpdateCheck);
		
		JButton btnDeleteButton = new JButton("Delete Check");
		btnDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
        			int row = table.getSelectedRow();
        			
        			if (row <0) {
        				JOptionPane.showMessageDialog(CheckListSearch.this, "You must select a check", "Error", JOptionPane.ERROR_MESSAGE);
        					return;
        			}
        			
        			int response = JOptionPane.showConfirmDialog(CheckListSearch.this, "Delete this Check?", "Confirm", 
        					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        					
        			if(response != JOptionPane.YES_OPTION) {
        				return;
        			}
        			Check tempCheck = (Check) table.getValueAt(row, CheckTableModel.OBJECT_COL);
        			
        			capstoneDAO.deleteCheck(tempCheck.getCheckNum());
        			
        			refreshCheckView();
        			
        			JOptionPane.showMessageDialog(CheckListSearch.this, "Check Successfully Deleted", "Check Deleted", JOptionPane.INFORMATION_MESSAGE);
        		
        		} catch (Exception exc) {
        			JOptionPane.showMessageDialog(CheckListSearch.this, "Error Deleting Check: " + exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        		}
        		
        	
			}
		});
		panel_1.add(btnDeleteButton);
	}
	
	public void refreshCheckView() {
		// TODO Auto-generated method stub
		try {
			List<Check> checks = capstoneDAO.getAllChecks();
			
			CheckTableModel model = new CheckTableModel(checks);
			
			table.setModel(model);
			
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
