package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Mini_Project {
/*
Q2)------->
1.Admin should  add new members.
2.admin should view all members data
3.admin should update members profile
4.admin should delete members.
5.admin should search any member using name.
 */
	void add(Scanner sc,Connection conn)
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
PreparedStatement ps=conn.prepareStatement("insert into employeeProject(name,Course,City,Phone_No,fees,Cousr"
		+ "e_Duration,Email_Id,age)values(?,?,?,?,?,?,?,?)");
	
		System.out.println("Enter the Record:");
		System.out.println("-----------------");
		System.out.println("ENTER THE NAME:");
		String name=sc.next();
		ps.setString(1, name);
		System.out.println("ENTER THE COURSE:");
		String cousre=sc.next();
		ps.setString(2, cousre);
		System.out.println("ENTER THE CITY:");
		String city=sc.next();
		ps.setString(3, city);
		
		System.out.println("ENTER THE MOBILE_NO:");
		String mo=sc.next();
		ps.setString(4, mo);
		
		System.out.println("ENTER THE FEES:");
		String fees=sc.next();
		ps.setString(5, fees);
		
		System.out.println("ENTER MEMBERSHIP Duration:");
		String Dur=sc.next();
		ps.setString(6, Dur);
		
		System.out.println("ENTER EMAIL_ID:");
		String EM=sc.next();
		ps.setString(7, EM);
		
		
		System.out.println("ENTER YOUR AGE:");
		String AGE=sc.next();
		ps.setString(8, AGE);
		
		ps.executeUpdate();
		System.out.println("data inserted succesfully...!");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	void viewList(Connection conn,Scanner sc)
	{
		try
		{
			
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		PreparedStatement ps=conn.prepareStatement("select * from employeeProject");
		ps.execute();
		ResultSet rs=ps.executeQuery();
		System.out.println("Showing the Gym Data:");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+" "+rs.getString(9));
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		
	}
	void Update(Connection conn,Scanner sc)
	{
		try
		{
			
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		System.out.println("ENTER THE ID:");	
		int id1=sc.nextInt();
		
		System.out.println("ENETR THE UPDATING NAME:");
		String name1=sc.next();
		
		PreparedStatement ps=conn.prepareStatement("update employeeProject set name='"+name1+"' where id="+id1+" ");
		System.out.println("------------");
		ps.executeUpdate();
		
		/*ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5)+" "+rs.getString(6));
		}
		*/
		System.out.println("update successfullyyy");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

		
		
	}
	void delete(Connection conn,Scanner sc)
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("ENETR THE DELETING ID:");
		
		int ID=sc.nextInt();
		
		PreparedStatement ps=conn.prepareStatement("delete from employeeProject where id="+ID+"");
	
		ps.execute();
		
//		ResultSet rs=ps.executeQuery();
//		while(rs.next())
//		{
//			System.out.println(rs.getInt(1)+" "+rs.getString(2));
//		}
		
		
		System.out.println("record deleted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		}
		public void isSerched(Connection conn,Scanner sc)
		{
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				PreparedStatement ps=conn.prepareStatement("select * from employeeProject where name=?");
				System.out.println("serch the perticular name:");
				String name=sc.next();
				ps.setString(1, name);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","12345");

		Scanner sc=new Scanner(System.in);
		int n=1;
		System.out.println();
		String s="|--H--| WELCOME TO GYM MANAGEMENT |--P--|";
		try
		{
		for(int i=0;i<s.length();i++)
		{
			Thread.sleep(200);
			System.out.print(s.charAt(i));
		}
		System.out.println();
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		while(n!=0)
		{
		
		
		System.out.println("------------------");
		String s2="MENU OF GYM:";
		try{
			for(int i=0;i<s2.length();i++){
				Thread.sleep(200);
				System.out.print(s2.charAt(i));
			}
			System.out.println();
			
			
			
		System.out.println("------------------");
		Thread.sleep(2000);
		System.out.println("1.ADD\n2.VIEW\n3.UPDATE\n4.DELETE\n5.SERCH");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("------------------");
		String S1="ENTER YOUR CHOICE:";
		try{
		for(int i=0;i<S1.length();i++){
			Thread.sleep(200);
			System.out.print(S1.charAt(i));
		}
		System.out.println();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		 n=sc.nextInt();
		System.out.println("------------------");
		Mini_Project m=new Mini_Project();
		
		switch(n)
		{
		case 1:
			m.add(sc,conn);
			break;
		case 2:
			m.viewList(conn,sc);
			break;
		case 3:
			m.Update(conn,sc);
			break;
		case 4:
			m.delete(conn,sc);
			break;
			
		case 5:
			m.isSerched(conn,sc);
			break;
		default:
			System.out.println("Invalid Input....!!");
			break;
		}
		

	}
	}

}
