package com.cmspackage;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerDAO customerDAO = new CustomerDAO();

        while (true) {
            System.out.println("\nCustomer Management System");
            System.out.println("1. Add Customer");
            System.out.println("2. View All Customers");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            System.out.println();
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add customer
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter DOB (YYYY-MM-DD): ");
                    String dob = scanner.nextLine();
                    System.out.print("Enter PAN Number: ");
                    String panNumber = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    long phoneNumber = scanner.nextLong();
                    System.out.print("Enter daily amount: ");
                    double dailyAmount = scanner.nextDouble();

                    Customer newCustomer = new Customer(name, dob, panNumber, phoneNumber, dailyAmount);
                    customerDAO.addCustomer(newCustomer);
                    break;
                case 2:
                    // View all customers
                    List<Customer> customers = customerDAO.getAllCustomers();
                    for (Customer customer : customers) {
                        System.out.println(" ID: " + customer.getId() 
                        				 + "\n Name: " + customer.getName() 
                        				 + "\n Phone: " + customer.getPhoneNumber() 
                        				 + "\n PAN: " + customer.getPanNumber() 
                        				 + "\n DOB: " + customer.getDob() 
                        				 + "\n Daily_Amount: " + customer.getDailyAmount() + "\n");
                    }
                    break;
                case 3:
                    // Update customer
                    System.out.print("Enter customer ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new DOB (YYYY-MM-DD): ");
                    String newDob = scanner.nextLine();
                    System.out.print("Enter new PAN Number: ");
                    String newPan = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    long newPhone = scanner.nextLong();
                    System.out.print("Enter new daily amount: ");
                    double newAmount = scanner.nextDouble();

                    Customer updatedCustomer = new Customer(newName, newDob, newPan, newPhone, newAmount);
                    updatedCustomer.setId(updateId);
                    customerDAO.updateCustomer(updatedCustomer);
                    break;
                case 4:
                    // Delete customer
                    System.out.print("Enter customer ID to delete: ");
                    int deleteId = scanner.nextInt();
                    customerDAO.deleteCustomer(deleteId);
                    break;
                case 5:
                    // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
