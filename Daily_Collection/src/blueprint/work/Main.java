package blueprint.work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	
	private static final String url = "jdbc:mysql://localhost:3306/daily_collection";
	private static final String username = "root";
	private static final String password = "Ragnar@123";

	public static void main(String[] args) {

		// Load a JDBC Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// Database connection and Query execution......
		try {
			
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(" select * from customers");
			while(resultSet.next()) {
				
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String dob = resultSet.getString("dob");
				String pan_number = resultSet.getString("pan_number");
				long phone_number = resultSet.getLong("phone_number");
				double daily_amount =resultSet.getDouble("daily_amount");
				
				 System.out.println("ID: " + id + ", Name: " + name + ", DOB: " + dob + 
                         ", PAN: " + pan_number + ", Phone: " + phone_number + 
                         ", Daily Amount: " + daily_amount);
				
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
