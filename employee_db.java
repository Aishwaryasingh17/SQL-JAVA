package Inventory;
import java.sql.*;
import javax.swing.*;

public class employee_db {
     
public static Connection connectdb()
    {
try
{
	Connection con= DriverManager.getConnection("jdbc:sqlserver://0.0.0.0:1433;databaseName=employee_db;","Group_17","1234");
	Statement s1=con.createStatement();
	System.out.println("Connection Successful");
JOptionPane.showMessageDialog(null,"Connection Successful");
return con;

}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,"Connection Error oppps");
return null;
}
    }
}