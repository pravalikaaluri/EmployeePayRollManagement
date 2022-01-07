package test_sql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmployeeDelete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static EmployeeDelete frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new EmployeeDelete();
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
	public EmployeeDelete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = textField.getText();
		    	
		    	
		    	
		        String i=EmployeeOperations.delete(ID);
		    			if(i == "Success"){
		    				JOptionPane.showMessageDialog(EmployeeDelete.this,"Employe deleted successfully!");
		    				AdminOptions.main(new String[]{});
		    				frame.dispose();
		    				
		    			}else{
		    				JOptionPane.showMessageDialog(EmployeeDelete.this,"Sorry, unable to delete! "+i);
		    			}

			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(97, 130, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton Back = new JButton("Back");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminOptions.main(new String[]{});
            	frame.dispose();
			}
		});
		Back.setBounds(238, 130, 89, 23);
		contentPane.add(Back);
		
		textField = new JTextField();
		textField.setBounds(160, 81, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter ID of the Employee To Delete");
		lblNewLabel.setBounds(109, 35, 218, 35);
		contentPane.add(lblNewLabel);
	}
}
