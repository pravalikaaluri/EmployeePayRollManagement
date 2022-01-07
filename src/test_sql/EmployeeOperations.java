package test_sql;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class EmployeeOperations {

	
	public static String save(String Name, String Age,String Gender,String ID,String Address,String State,String City,String Email,String Phone,String Type){
		int status=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Emp1","root","root");
			PreparedStatement ps=con.prepareStatement("insert into Employee(id,name,age,gender,address,state,city,email,phone,type) values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,ID);
			ps.setString(2,Name);
			ps.setString(3,Age);
			ps.setString(4,Gender);
			ps.setString(5,Address);
			ps.setString(6,State);
			ps.setString(7,City);
			ps.setString(8,Email);
			ps.setString(9,Phone);
			ps.setString(10,Type);
			
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e); return e.getMessage();}
		//return status;
		return "Success";
		
	}
	public static String save_salary(String ID,String HRA,String DA,String PF,String BasicSal,String Bonus){
		int status=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Emp1","root","root");
			PreparedStatement ps=con.prepareStatement("insert into Employee_Salary(id1,hra,da,pf,basic_salary,bonus,pid1) values(?,?,?,?,?,?,?)");
			ps.setString(1,ID);
			ps.setString(2,HRA);
			ps.setString(3,DA);
			ps.setString(4,PF);
			ps.setString(5,BasicSal);
			ps.setString(6,Bonus);
			ps.setString(7,ID);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e); return e.getMessage();}
		//return status;
		return "Success";
		
	}
	public static String update_salary(String ID,String HRA,String DA,String PF,String BasicSal,String Bonus){
		int status=0;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Emp1","root","root");
			Statement stmt = con.createStatement();
			String sql = "update Employee_Salary set hra = '"+HRA+"',da='"+DA+"',pf='"+PF+"',basic_salary='"+BasicSal+"',bonus='"+Bonus+"'where id1 = '"+ID+"'";
			//PreparedStatement ps=con.prepareStatement("update Employee_Salary set hra = HRA,da=DA,pf=PF,basic_salary=BasicSal, pid1=ID where id1 in ID");
			status = stmt.executeUpdate(sql);
			//ps.setString(1,HRA);
			//ps.setString(2,DA);
			//ps.setString(3,PF);
			//ps.setString(4,BasicSal);
			//ps.setString(5,ID);
			//status=ps.executeUpdate();
			if(status==0)
				return "Employee Not Found";
			con.close();
		}catch(Exception e){System.out.println(e); return e.getMessage();}
		//return status;
		return "Success";
		
	}
	public static String delete(String id){
		int status=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Emp1","root","root");
			
			PreparedStatement ps=con.prepareStatement("delete from employee_salary where id1=?");
			ps.setString(1,id);
			status=ps.executeUpdate();
			
			//System.out.println(status);
			ps=con.prepareStatement("delete from employee where id=?");
			ps.setString(1,id);
			status=ps.executeUpdate();
			//System.out.println(status);
			if(status==0)
				return "Employee Not Found";
			
			con.close();
		}catch(Exception e){System.out.println(e); return e.getMessage();}
		//return status;
		return "Success";
	}

	public static boolean validate(String name,String password){
		boolean status=false;
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Emp1","root","root");
			PreparedStatement ps=con.prepareStatement("select * from employee where name=? and password=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

}
