package Inventory;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField pwd1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	final Login f1 = new Login();
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					
				f1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 510);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(22, 84, 62, 70);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(141, 109, 117, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(22, 165, 75, 33);
		contentPane.add(lblNewLabel_1);
		final String data="Group_17";
		final String pwd="1234";
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
         if(textField.getText().equals(data) && pwd1.getText().equals(pwd)) {
        	 JOptionPane.showMessageDialog(null,"Login successful");
		      Employee_data d= new Employee_data();
		      Login login1 = new Login();
			login1.setVisible(false);
		    d.frame.setVisible(true);
		    
		      
			}
			}
		});
		btnNewButton_1.setBounds(169, 249, 89, 23);
		contentPane.add(btnNewButton_1);
		
		pwd1 = new JPasswordField();
		pwd1.setBounds(141, 171, 117, 20);
		contentPane.add(pwd1);
		
		JLabel lblNewLabel_2 = new JLabel("Login Page");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(107, 24, 373, 33);
		contentPane.add(lblNewLabel_2);
		
		
		
	}
}
