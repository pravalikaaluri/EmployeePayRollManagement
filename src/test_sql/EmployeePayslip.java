package test_sql;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
//import org.apache.commons.dbutils.DbUtils;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
public class EmployeePayslip extends JFrame {

	private JPanel contentPane;
	private JTable table;
	static EmployeePayslip  frame;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JButton Enter;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new EmployeePayslip();
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
	public EmployeePayslip() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 364);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 177, 530, 46);
		//contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Employee ID", "Name", "HRA", "DA", "PF", "Basic Salary","Bonus"
			}
		));
		try{
			//Class.forName("com.mysql.jdbc.Driver");  
			//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Emp","root","root");
			//PreparedStatement ps=con.prepareStatement("select Employee.name as Name, id1 as Employee_ID,hra as HRA,da as DA,pf as PF,basic_salary as Basic_Salary from Employee_salary inner join Employee on ID1=ID");
			//ResultSet rs=ps.executeQuery();
			contentPane.add(scrollPane);
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			
			JButton Back = new JButton("Back");
			Back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AdminOptions.main(new String[]{});
					frame.dispose();
				}
			});
			Back.setBounds(246, 293, 89, 23);
			contentPane.add(Back);
			
			lblNewLabel = new JLabel("Playslip of Employees");
			lblNewLabel.setBounds(222, 11, 147, 14);
			contentPane.add(lblNewLabel);
			
			textField = new JTextField();
			textField.setBounds(322, 55, 47, 20);
			contentPane.add(textField);
			textField.setColumns(10);
			
			lblNewLabel_1 = new JLabel("Enter Employee Id");
			lblNewLabel_1.setBounds(184, 58, 123, 14);
			contentPane.add(lblNewLabel_1);
			
			Enter = new JButton("Enter to Generate Payslip");
			Enter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String ID = textField.getText();
		
					try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Emp1","root","root");
					String qry = "select id1 as Employee_ID, Employee.name as Name, hra as HRA,da as DA,pf as PF,basic_salary as Basic_Salary from Employee_salary inner join Employee on ID1=ID and ID='"+ID+"'";
					PreparedStatement ps=con.prepareStatement(qry);
					ResultSet rs=ps.executeQuery();
					//contentPane.add(scrollPane);
					//DbUtils.resultSetToTableModel(rs).getRowCount()
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
		
					if(DbUtils.resultSetToTableModel(ps.executeQuery()).getRowCount()==0)
						JOptionPane.showMessageDialog(EmployeePayslip.this,"Sorry, no data with the employee id found! ");
					con.close();
					}
					catch(Exception e1){System.out.println(e1);}	
				}
			});
			Enter.setBounds(184, 104, 200, 23);
			contentPane.add(Enter);
			
			//con.close();
		}catch(Exception e){System.out.println(e);}
		//return status;
		
		

	}
	
}
