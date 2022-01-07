package test_sql;
import java.sql.Connection;
import java.sql.DriverManager;
public class CreateDatabase {

	
	public static String create(){
		
		try{
					
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","root");
			java.sql.PreparedStatement stmt=con.prepareStatement("CREATE DATABASE Emp1");
			stmt.executeUpdate();
			stmt = con.prepareStatement("CREATE TABLE Emp1.Employee (ID int NOT NULL,Name varchar(255), Age int,Gender varchar(255), Address varchar(255),State varchar(255),City varchar(255), Email varchar(255),Phone varchar(255),Type varchar(255), primary key (ID))");
			//HRA int, DA int, PF int, BasicSalary int,
		    stmt.executeUpdate();
		    stmt = con.prepareStatement("create table Emp1.employee_salary(ID1 int not null, hra float,da float,pf float,basic_salary float, Bonus int,pID1 int,primary key(ID1), foreign key(pID1) references Employee(ID))");
		    stmt.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e); return e.getMessage();}
		//return status;
		return "Success";
		
	}
	public static void main(String[] args) {
			System.out.println( create());
	}

}
