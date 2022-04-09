package Inventory;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.text.MessageFormat;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Inventory.employee_db;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Inventory.Updatetable;

public class Employee_data {

JFrame frame;
private JTextField jtxtEmployeeID;
private JTable table;
private JTextField jtxtSSN;
private JTextField jtxtFirstName;
private JTextField jtxtDOB;
private JTextField jtxtAge;
private JTextField jtxtSalary;
private JTextField jtxtLastName;
private JTextField jtxtGender;


    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
   
    DefaultTableModel model = new DefaultTableModel();
    private JTextField tar;

/**
* Launch the application.
*/
    public void updateTable()
    {
    conn = employee_db.connectdb();
    if(conn!=null)
    {
    String sql = "Select EmpID,SSN,Firstname,Lastname,Gender,DOB,Age,Salary";
   
    try
    {
    pst = conn.prepareStatement(sql);
    rs = pst.executeQuery();
    Object[] columnData = new Object[8];
    while(rs.next())
    {
    columnData [0]= rs.getString("EmpID");
    columnData [0]= rs.getString("SSN");
    columnData [0]= rs.getString("Firstname");
    columnData [0]= rs.getString("Lastname");
    columnData [0]= rs.getString("Gender");
    columnData [0]= rs.getString("DOB");
    columnData [0]= rs.getString("Age");
    columnData [0]= rs.getString("Salary");
   
    model.addRow(columnData);
   
    }
    }
    catch(Exception e)
   
    {
    JOptionPane.showMessageDialog(null,e);
    }
   
    }
    }
   
   
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
	
Employee_data window = new Employee_data();
window.frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}

/**
* Create the application.
*/
public Employee_data() {
initialize();

conn = employee_db.connectdb();
Object col[] = {"EmpID","SSN","Firstname","Lastname","Gender","DOB","Age","Salary"};
model.setColumnIdentifiers(col);
}

/**
* Initialize the contents of the frame.
*/
private void initialize() {
frame = new JFrame();
frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 18));
frame.setBounds(0, 0, 1450, 800);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);

JLabel lblNewLabel = new JLabel("Employee ID");
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
lblNewLabel.setBounds(44, 67, 135, 17);
frame.getContentPane().add(lblNewLabel);

jtxtEmployeeID = new JTextField();
jtxtEmployeeID.setFont(new Font("Tahoma", Font.BOLD, 18));
jtxtEmployeeID.setBounds(235, 65, 118, 20);
frame.getContentPane().add(jtxtEmployeeID);
jtxtEmployeeID.setColumns(10);

JButton btnNewButton = new JButton("Add New");
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {

  String sql = "INSERT INTO employees(EmpID,SSN,Firstname,Lastname,Gender,DOB,Age,Salary)VALUES(?,?,?,?,?,?,?,?)";
  try
  {
  pst = conn.prepareStatement(sql);
  pst.setString(1, jtxtEmployeeID.getText());
  pst.setString(2, jtxtSSN.getText());
  pst.setString(3, jtxtFirstName.getText());
  pst.setString(4, jtxtLastName.getText());
  pst.setString(5, jtxtGender.getText());
  pst.setString(6, jtxtDOB.getText());
  pst.setString(7, jtxtAge.getText());
  pst.setString(8, jtxtSalary.getText());
 
  pst.execute();
  rs.close();
  pst.close();
   
  }
  catch(Exception ev)
  {
  JOptionPane.showMessageDialog(null,"System Update Completed");
  }
  DefaultTableModel model = (DefaultTableModel) table.getModel();
  model.addRow(new Object[] {
   jtxtEmployeeID.getText(),
   jtxtSSN.getText(),
   jtxtFirstName.getText(),
   jtxtLastName.getText(),
   jtxtGender.getText(),
   jtxtDOB.getText(),
   jtxtAge.getText(),
   jtxtSalary.getText(),  
 
  });
  if(table.getSelectedRow() == -1) {
  if(table.getRowCount() == 0) {
  JOptionPane.showMessageDialog(null, "Membership Update Confirmed", "Employee Database System",
  JOptionPane.OK_OPTION);
  }
  }
}
});
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
btnNewButton.setBounds(263, 516, 126, 23);
frame.getContentPane().add(btnNewButton);

JScrollPane scrollPane = new JScrollPane();
scrollPane.setBounds(477, 69, 610, 415);
frame.getContentPane().add(scrollPane);

table = new JTable();
table.setModel(new DefaultTableModel(
new Object[][] {
},
new String[] {
"EmpID", "SSN", "Firstname", "Lastname", "Gender", "DOB", "Age", "Salary"
}
));
table.setFont(new Font("Tahoma", Font.BOLD, 14));
scrollPane.setViewportView(table);

JLabel lblSsn = new JLabel("SSN");
lblSsn.setFont(new Font("Tahoma", Font.BOLD, 18));
lblSsn.setBounds(44, 111, 135, 14);
frame.getContentPane().add(lblSsn);

jtxtSSN = new JTextField();
jtxtSSN.setFont(new Font("Tahoma", Font.BOLD, 18));
jtxtSSN.setColumns(10);
jtxtSSN.setBounds(235, 108, 118, 20);
frame.getContentPane().add(jtxtSSN);

JLabel lblNewLabel_1_1 = new JLabel("First Name");
lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
lblNewLabel_1_1.setBounds(44, 167, 135, 14);
frame.getContentPane().add(lblNewLabel_1_1);

jtxtFirstName = new JTextField();
jtxtFirstName.setFont(new Font("Tahoma", Font.BOLD, 18));
jtxtFirstName.setColumns(10);
jtxtFirstName.setBounds(235, 164, 118, 20);
frame.getContentPane().add(jtxtFirstName);

JLabel lblNewLabel_1_1_3 = new JLabel("DOB");
lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
lblNewLabel_1_1_3.setBounds(45, 336, 135, 14);
frame.getContentPane().add(lblNewLabel_1_1_3);

jtxtDOB = new JTextField();
jtxtDOB.setFont(new Font("Tahoma", Font.BOLD, 18));
jtxtDOB.setColumns(10);
jtxtDOB.setBounds(236, 333, 117, 20);
frame.getContentPane().add(jtxtDOB);

JLabel lblNewLabel_1_1_4 = new JLabel("Age");
lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 18));
lblNewLabel_1_1_4.setBounds(44, 404, 135, 23);
frame.getContentPane().add(lblNewLabel_1_1_4);

jtxtAge = new JTextField();
jtxtAge.setFont(new Font("Tahoma", Font.BOLD, 18));
jtxtAge.setColumns(10);
jtxtAge.setBounds(235, 401, 118, 20);
frame.getContentPane().add(jtxtAge);

JLabel lblNewLabel_1_1_5 = new JLabel("Salary");
lblNewLabel_1_1_5.setFont(new Font("Tahoma", Font.BOLD, 18));
lblNewLabel_1_1_5.setBounds(45, 452, 135, 32);
frame.getContentPane().add(lblNewLabel_1_1_5);

jtxtSalary = new JTextField();
jtxtSalary.setFont(new Font("Tahoma", Font.BOLD, 18));
jtxtSalary.setColumns(10);
jtxtSalary.setBounds(235, 458, 118, 20);
frame.getContentPane().add(jtxtSalary);

JButton btnPrint = new JButton("Print");
btnPrint.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
MessageFormat header = new MessageFormat("Printing in progress");
MessageFormat footer = new MessageFormat("Page {0,number,integer}");
try
{
table.print();
}
catch(java.awt.print.PrinterException ev)
{
System.err.format("No Printer Found", ev.getMessage());
}
}
});
btnPrint.setFont(new Font("Tahoma", Font.BOLD, 18));
btnPrint.setBounds(928, 516, 89, 23);
frame.getContentPane().add(btnPrint);

JButton btnNewButton_1_1 = new JButton("Reset");
btnNewButton_1_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
jtxtEmployeeID.setText(null);
jtxtSSN.setText(null);
jtxtFirstName.setText(null);
jtxtLastName.setText(null);
jtxtGender.setText(null);
jtxtDOB.setText(null);
jtxtAge.setText(null);
jtxtSalary.setText(null);
}
});
btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
btnNewButton_1_1.setBounds(762, 516, 118, 23);
frame.getContentPane().add(btnNewButton_1_1);

JButton btnNewButton_1_1_1 = new JButton("Exit");
btnNewButton_1_1_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent args0) {
frame = new JFrame("Exit");
if (JOptionPane.showConfirmDialog(frame,"Confirm if you want to exit","Employee Database System",
JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
System.exit(0);
}

}
});
btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
btnNewButton_1_1_1.setBounds(1051, 516, 89, 23);
frame.getContentPane().add(btnNewButton_1_1_1);

JLabel lblNewLabel_1_1_1 = new JLabel("Last Name");
lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
lblNewLabel_1_1_1.setBounds(45, 216, 135, 14);
frame.getContentPane().add(lblNewLabel_1_1_1);

jtxtLastName = new JTextField();
jtxtLastName.setFont(new Font("Tahoma", Font.BOLD, 18));
jtxtLastName.setColumns(10);
jtxtLastName.setBounds(236, 213, 117, 20);
frame.getContentPane().add(jtxtLastName);

JLabel lblNewLabel_1_1_2 = new JLabel("Gender");
lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
lblNewLabel_1_1_2.setBounds(45, 270, 135, 14);
frame.getContentPane().add(lblNewLabel_1_1_2);

jtxtGender = new JTextField();
jtxtGender.setFont(new Font("Tahoma", Font.BOLD, 18));
jtxtGender.setColumns(10);
jtxtGender.setBounds(235, 267, 118, 20);
frame.getContentPane().add(jtxtGender);

JLabel lblNewLabel_1 = new JLabel("Employee Database Management System");
lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
lblNewLabel_1.setBounds(291, 11, 545, 42);
frame.getContentPane().add(lblNewLabel_1);
JButton btnNewButton_1 = new JButton("Show Employee");
btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
btnNewButton_1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		try{
			String sql="Select * from employees";
		 Statement s1= conn.createStatement();
		 rs= s1.executeQuery(sql);
		 pst = conn.prepareStatement(sql);
		 DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] columnData = new Object[8];
		 while(rs.next())
		    {
			         model.addRow(new Object[] {
					  rs.getString("EmpID"),
					    rs.getString("SSN"),
					     rs.getString("Firstname"),
					     rs.getString("Lastname"),
					    rs.getString("Gender"),
					     rs.getString("DOB"),
					     rs.getString("Age"),
					     rs.getString("Salary"),
					 
					  });
					
		   }
		 pst.execute();
		  rs.close();
		  pst.close();
		 
		}
		catch(Exception e1) {
			System.out.println("Sorry!");
			JOptionPane.showMessageDialog(null,e1);
		}
		 
		
	}
});
btnNewButton_1.setBounds(22, 516, 187, 23);
frame.getContentPane().add(btnNewButton_1);
JButton btnNewButton_2 = new JButton("Delete");
final JLabel lblNewLabel_2 = new JLabel("EmpID");
lblNewLabel_2.setVisible(false);
final JButton btnNewButton_3 = new JButton("Submit");
btnNewButton_3.setVisible(false);
btnNewButton_2.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		tar.setVisible(true);
	     lblNewLabel_2.setVisible(true);
	     btnNewButton_3.setVisible(true);
   
	}
});

btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
btnNewButton_2.setBounds(601, 516, 113, 23);
frame.getContentPane().add(btnNewButton_2);
tar = new JTextField();
tar.setVisible(false);
tar.setBounds(319, 572, 135, 34);
frame.getContentPane().add(tar);
tar.setColumns(10);
lblNewLabel_2.setBounds(273, 582, 49, 14);
frame.getContentPane().add(lblNewLabel_2);

btnNewButton_3.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		 try {
		     String s=tar.getText();
		     System.out.println(s);
		     String sql="Delete from employees where EmpID= " +s;
		     
		     System.out.println(sql);
			  PreparedStatement p= conn.prepareStatement(sql);
			  p.execute();
			  JOptionPane.showMessageDialog(null,"Deleted Employee with ID:"+s);
			  DefaultTableModel model = (DefaultTableModel) table.getModel();
			  model.setRowCount(0);
			  tar.setText("");
			  tar.setVisible(false);
			  lblNewLabel_2.setVisible(false);
			  btnNewButton_3.setVisible(false);
			  
		 }
		     catch(Exception e1) {
					System.out.println("Sorry!");
					JOptionPane.showMessageDialog(null,e1);
		     }
	}
});
btnNewButton_3.setBounds(347, 629, 89, 23);
frame.getContentPane().add(btnNewButton_3);
final JButton btnNewButton_5 = new JButton("Enter");
btnNewButton_5.setVisible(false);
JButton btnNewButton_4 = new JButton("Update");
btnNewButton_4.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		tar.setVisible(true);
	     lblNewLabel_2.setVisible(true);
	     btnNewButton_5.setVisible(true);
		
	}
});
btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 18));
btnNewButton_4.setBounds(424, 516, 108, 23);
frame.getContentPane().add(btnNewButton_4);

btnNewButton_5.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		Employee_data obj=new Employee_data();
		obj.frame.setVisible(false);
		Updatetable updatetable = new Updatetable();
		updatetable.setVisible(true);
		
	}
});
btnNewButton_5.setBounds(491, 578, 89, 23);
frame.getContentPane().add(btnNewButton_5);
}
}
