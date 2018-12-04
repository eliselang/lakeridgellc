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
import java.util.List;

import javax.swing.JButton;
import com.toedter.calendar.JCalendar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;

public class AppointmentSchedule extends JFrame {

	private JPanel contentPane;
	private JTextField txtDateTimeTextField;
	private JButton btnSearchButton;
	
	private Capstone capstoneDAO;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppointmentSchedule frame = new AppointmentSchedule();
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
	public AppointmentSchedule() {
		
	    try {
            capstoneDAO = new Capstone();
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }
		
		
		setTitle("Appointment Schedule");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblDateTimeLabel = new JLabel("Search by Appointment Date Time");
		lblDateTimeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblDateTimeLabel);
		
		txtDateTimeTextField = new JTextField();
		txtDateTimeTextField.setText("YYYY-MM-DD");
		panel.add(txtDateTimeTextField);
		txtDateTimeTextField.setColumns(20);
		
		JButton btnSearchButton = new JButton("Search");
		btnSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    try {
                    String dateTime = txtDateTimeTextField.getText();
                    
                    List<Appointment> appointments = null;
                    
                    if (dateTime != null && dateTime.trim().length() > 0) {
                        appointments = capstoneDAO.searchAppts(dateTime);
                    } else {
                        appointments = capstoneDAO.getAllAppts();
                    }
                    
            /*  Create Model and update the table*/
                    AppointmentTableModel model = new AppointmentTableModel(appointments);
                    
                    table.setModel(model);
                    
                    
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(AppointmentSchedule.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
                }
			
			
			}
		});
		panel.add(btnSearchButton);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		
		JCalendar calendar = new JCalendar();
		calendar.addPropertyChangeListener("calendar", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				String Current = calendar.getDate().toString();
				try {
	                 
                    List<Appointment> appointments = null;
                    
                    if (Current != null && Current.trim().length() > 0) {
                        appointments = capstoneDAO.searchAppts(Current);
                    } else {
                        appointments = capstoneDAO.getAllAppts();
                    }
                    
            /* Create Model and update the table*/
                    AppointmentTableModel model = new AppointmentTableModel(appointments);
                    
                    table.setModel(model);
                    
                    
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(AppointmentSchedule.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
                }
			}});
		/*calendar.addMouseListener(new MouseListener() {
        	
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String DateChoice = calendar.getDate().toString();
				
				 try {
	                 
	                    List<Appointment> appointments = null;
	                    
	                    if (DateChoice != null && DateChoice.trim().length() > 0) {
	                        appointments = capstoneDAO.searchAppts(DateChoice);
	                    } else {
	                        appointments = capstoneDAO.getAllAppts();
	                    }
	                    
	            /*  Create Model and update the table*/
	    /*                AppointmentTableModel model = new AppointmentTableModel(appointments);
	                    
	                    table.setModel(model);
	                    
	                    
	                } catch (Exception exc) {
	                    JOptionPane.showMessageDialog(AppointmentSchedule.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
	                }
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
        });*/
		panel_1.add(calendar);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnAddAppointment = new JButton("Add Appointment");
		btnAddAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AppointmentDialog dialog = new AppointmentDialog(AppointmentSchedule.this, capstoneDAO);
        		
        		dialog.setVisible(true);
			}
		});
		panel_2.add(btnAddAppointment);
		
		JButton btnDeleteAppointment = new JButton("Delete Appointment");
		btnDeleteAppointment.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		try {
	        			int row = table.getSelectedRow();
	        			
	        			if (row <0) {
	        				JOptionPane.showMessageDialog(AppointmentSchedule.this, "You must select an Appointment", "Error", JOptionPane.ERROR_MESSAGE);
	        					return;
	        			}
	        			
	        			int response = JOptionPane.showConfirmDialog(AppointmentSchedule.this, "Delete this Appointment?", "Confirm", 
	        					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	        					
	        			if(response != JOptionPane.YES_OPTION) {
	        				return;
	        			}
	        			Appointment tempAppointment = (Appointment) table.getValueAt(row, AppointmentTableModel.OBJECT_COL);
	        			
	        			capstoneDAO.deleteAppointment(tempAppointment.getId());
	        			
	        			refreshApptView();
	        			
	        			JOptionPane.showMessageDialog(AppointmentSchedule.this, "Patient Successfully Deleted", "Patient Deleted", JOptionPane.INFORMATION_MESSAGE);
	        		
	        		} catch (Exception exc) {
	        			JOptionPane.showMessageDialog(AppointmentSchedule.this, "Error Deleting Patient: " + exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        		}
	        		
	        	}
	        });
		panel_2.add(btnDeleteAppointment);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
	}

	public void refreshApptView() {
		// TODO Auto-generated method stub
		try {
			List<Appointment> appointments = capstoneDAO.getAllAppts();
			
			AppointmentTableModel model = new AppointmentTableModel(appointments);
			
			table.setModel(model);
			
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}


}
