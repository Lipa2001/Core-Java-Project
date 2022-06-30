import java.sql.*;
import java.util.Scanner;


public class MyJavaClass
{
	int empId, bSal; 
	String empName;
	Scanner sc = new Scanner(System.in);
	
	void insertData()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","");
			
			System.out.println("Enter Employee ID: ");
			empId=sc.nextInt();
			System.out.println("Enter Employee Name: ");
			empName=sc.next();
			System.out.println("Enter Basic Salary: ");
			bSal=sc.nextInt();
			
			PreparedStatement ps = con.prepareStatement("insert into user values(?,?,?)");
			ps.setInt(1, empId);
			ps.setString(2, empName);
			ps.setInt(3, bSal);
			
			int i = ps.executeUpdate();	
			
			if(i>=1)
			{
				System.out.println("Record inserted successfully..!!");
			}
			else
			{
				System.out.println("Record failed to insert..!!");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	void viewData()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","");
			
			System.out.println("Enter Employee ID: ");
			empId=sc.nextInt();	
			
			Statement st=con.createStatement();
			ResultSet rs = st.executeQuery("select * from user where id='"+empId+"'");
			
			if(rs.next())
			{
				System.out.println("Employee ID: "+rs.getInt(1));
				System.out.println("Employee Name: "+rs.getString(2));
				System.out.println("Employee Salary: "+rs.getInt(3));
			}
			else
			{
				System.out.println("No Record Found..!!");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		MyJavaClass obj=new MyJavaClass();
		Scanner sc = new Scanner(System.in);
		int ch;
		while(true)
		{
			System.out.println("------- Welcome to KCE -------");
			System.out.println("Menu: ");
			System.out.println("1. Add Employee");
			System.out.println("2. View Employee ");
			System.out.println("Enter your choice: ");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1: obj.insertData();
				break;
			case 2: obj.viewData();
				break;
			}
		}
	}

}
