package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class codeApp {

	static {
		System.out.println("Welcome to our CURD operation Application");
		System.out.println();
	       }
	
	public static void main(String[] args) {

			Scanner sc=new Scanner(System.in);
			System.out.println("What u like to do.");
			for(;;)
			{
				System.out.println("Press -- > 1.Insert Values  2.Update Values  3.Delete values  4.Fetch All Data  5.Fetch Particular Row  6.Exit");
				switch(sc.nextInt())
				{
				case 1://Insert data
				{
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
				
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","Ritikdatey@1");
				
						PreparedStatement ps=con.prepareStatement("insert into myprograme.crud_program(id,name,email) values(?,?,?)");// '?' is nothing but the placeHolders .......
			
					
						System.out.println("Enter Id");
						int id=sc.nextInt();
						System.out.println("Enter Name");
						String name=sc.next();
						System.out.println("Enter Email");
						String email=sc.next();
				
						ps.setInt(1, id);
						ps.setString(2, name);
						ps.setString(3, email);
						ps.execute();
				      
						System.out.println("Data Inserted sucessfully");
				        
				        con.close();
				
					} catch (ClassNotFoundException e) {	
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}	
				}
				break;
				
				case 2://Update data
				{
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","Ritikdatey@1");
						System.out.println("To update data please Enter Id");
						int id=sc.nextInt();
						
						System.out.println("What you want to update -->");
						System.out.println("1.Name  2.Email  3.Both");
						
					
						switch(sc.nextInt())
						{
						case 1:
						{
							PreparedStatement ps=con.prepareStatement("update myprograme.crud_program set name=? where id=?");
							
							System.out.println("Enter new Name");
							String name=sc.next();
							ps.setString(1,name);
							ps.setInt(2, id);
							
							ps.executeUpdate();
							System.out.println("Name updated");
							con.close();
						}
						break;
						
						case 2: 
						{
							PreparedStatement ps=con.prepareStatement("update myprograme.crud_program set email=? where id=?");
							
							System.out.println("Enter new Email");
							String email=sc.next();
							ps.setString(1,email);
							ps.setInt(2, id);
							
							ps.executeUpdate();
							System.out.println("Email updated");
							con.close();
						}
						break;
						
						case 3: 
						{
							PreparedStatement ps=con.prepareStatement("update myprograme.crud_program set name=?, email=? where id=?");
							
							System.out.println("Enter new Name");
							String name=sc.next();
							
							
							System.out.println("Enter new Email");
							String email=sc.next();
							
							ps.setString(1,name);
							ps.setString(2,email);
							ps.setInt(3, id);
							
							ps.executeUpdate();
							System.out.println("Name and Email updated");
							con.close();
						}
						break;
						}
						
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
				}
				break;
				
				case 3://Delete data
				{
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","Ritikdatey@1");
						//in below we are deleting the rows into the table .......
						PreparedStatement ps=con.prepareStatement(" delete from myprograme.crud_program where id=? ");// '?' is nothing but the placeHolders .......
					
						System.out.println(" To delete the row from table");
					
						System.out.println("Please enter Id");
						int id=sc.nextInt();
						//with the help of the set we can set the values ........		
						ps.setInt(1, id);
						ps.execute();
						
						System.out.println("Row deleted");
					
				        con.close();
				
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
				
				case 4://fetch All data
				{
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","Ritikdatey@1");
						//in below we are deleting the rows into the table .......
						PreparedStatement ps=con.prepareStatement(" select * from myprograme.crud_program");// '?' is nothing but the placeHolders .......
					
						ps.execute();   
				        System.out.println("Id" + " " + "Name" + "  "+ "Email");
				        System.out.println("---------------------------");
				        ResultSet rs=ps.executeQuery();
						while(rs.next()) {
						System.out.print(rs.getInt(1) + "  ");
						System.out.print(rs.getString(2) + " ");
						System.out.print(rs.getString(3));
						System.out.println();
						}
				        System.out.println("Here is your data !");
				        con.close();
				
					 } catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					 } catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					 }
				}
				break;
				
				case 5://fetch particular row
				{
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","Ritikdatey@1");
						//in below we are deleting the rows into the table .......
						PreparedStatement ps=con.prepareStatement(" select * from myprograme.crud_program where id=? ");// '?' is nothing but the placeHolders .......
					
						System.out.println("To select a perticular row from table");
					
						System.out.println("Please enter Id");
						int id=sc.nextInt();
						//with the help of the set we can set the values ........		
						ps.setInt(1, id);
						ps.execute();   
				        
				        ResultSet rs=ps.executeQuery();
						while(rs.next()) {
						System.out.print(rs.getInt(1) + "  ");
						System.out.print(rs.getString(2) + " ");
						System.out.print(rs.getString(3));
						System.out.println();
						}
				        
				        con.close();
				
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
				
				case 6 ://exit
				{
					System.exit(0);
				}
				
			    }
			}
	}

}
