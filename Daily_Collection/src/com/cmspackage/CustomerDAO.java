package com.cmspackage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    // Insert a new customer
    public void addCustomer(Customer customer) {
    	
        String query = "INSERT INTO customers (name, dob, pan_number, phone_number, daily_amount) VALUES (?, ?, ?, ?, ?)";

        try{
        	Connection conn = DBConnection.getConnection();
        	PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getDob());
            stmt.setString(3, customer.getPanNumber());
            stmt.setLong(4, customer.getPhoneNumber());
            stmt.setDouble(5, customer.getDailyAmount());

            int result = stmt.executeUpdate();
            if (result > 0) {
                System.out.println("Customer added successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all customers
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM customers";

        try{
        	
        	Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            		
            while (rs.next()) {
                Customer customer = new Customer(
                        rs.getString("name"),
                        rs.getString("dob"),
                        rs.getString("pan_number"),
                        rs.getLong("phone_number"),
                        rs.getDouble("daily_amount")
                );
                customer.setId(rs.getInt("id"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    // Update customer details
    public void updateCustomer(Customer customer) {
        String query = "UPDATE customers SET name = ?, dob = ?, pan_number = ?, phone_number = ?, daily_amount = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getDob());
            stmt.setString(3, customer.getPanNumber());
            stmt.setLong(4, customer.getPhoneNumber());
            stmt.setDouble(5, customer.getDailyAmount());
            stmt.setInt(6, customer.getId());

            int result = stmt.executeUpdate();
            if (result > 0) {
                System.out.println("Customer updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a customer
    public void deleteCustomer(int customerId) {
    	
        String query = "DELETE FROM customers WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, customerId);

            int result = stmt.executeUpdate();
            if (result > 0) {
            	stmt.executeUpdate("SET @new_id = 0;");
                stmt.executeUpdate("UPDATE customers SET id = (@new_id := @new_id + 1);");
                stmt.executeUpdate("ALTER TABLE customers AUTO_INCREMENT = (SELECT MAX(id) + 1 FROM customers);");
                System.out.println("Customer deleted successfully!");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
