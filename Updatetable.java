package Inventory;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.*;
import Inventory.Employee_data;
import Inventory.employee_db;
import javax.swing.border.EmptyBorder;
import java.awt.Font;	
public class Updatetable extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Updatetable frame = new Updatetable();
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
	public Updatetable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(5, 62, 137, -43);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("EmpID");
		lblNewLabel_1.setBounds(26, 77, 76, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("SSN");
		lblNewLabel_2.setBounds(26, 133, 49, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Firstname");
		lblNewLabel_3.setBounds(26, 178, 76, 34);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Lastname");
		lblNewLabel_4.setBounds(26, 223, 76, 31);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Gender");
		lblNewLabel_5.setBounds(26, 265, 76, 31);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("DOB");
		lblNewLabel_6.setBounds(26, 314, 49, 31);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Age");
		lblNewLabel_7.setBounds(26, 364, 49, 31);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Salary");
		lblNewLabel_8.setBounds(26, 406, 60, 31);
		contentPane.add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setBounds(112, 82, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(112, 138, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(112, 185, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(112, 228, 96, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(112, 270, 96, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(112, 319, 96, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(112, 369, 96, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(112, 417, 96, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(textField.getText());
				int ssn=Integer.parseInt(textField_1.getText());
				String fname=textField_2.getText();
				String lname=textField_3.getText();
				String Gender=textField_4.getText();
				String DOB=textField_5.getText();
				int Age=Integer.parseInt(textField_6.getText());
				int Salary=Integer.parseInt(textField_7.getText());
				String sql="Update employees SET EmpID="+id+", SSN="+ssn+",Lastname='"+lname+"',Gender='"+Gender+"',DOB='"+DOB+"',Age="+Age+",Salary="+Salary+",Firstname='"+fname+"' Where EmpID="+id;
			try {
				 conn = employee_db.connectdb();
				 Statement s1=conn.createStatement();
				 int no=s1.executeUpdate(sql);
				 if(no>0) {
					  JOptionPane.showMessageDialog(null,"Updated Successful");
					  Employee_data obj=new Employee_data();
						obj.frame.setVisible(true);
						Updatetable updatetable = new Updatetable();
						updatetable.setVisible(false);
				 }
				 else {
					 JOptionPane.showMessageDialog(null,"Not Updated");
				 }
				}
			catch(Exception e3) {
				System.out.println(e3.getMessage());
			}
			}
		});
		btnNewButton_1.setBounds(307, 430, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_9 = new JLabel("Update Employee Details");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel_9.setBounds(251, 21, 354, 49);
		contentPane.add(lblNewLabel_9);
		
		JButton btnNewButton = new JButton("Update");
		
	}
	

}


