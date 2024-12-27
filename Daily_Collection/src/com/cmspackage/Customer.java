package com.cmspackage;

public class Customer {
    private int id;
    private String name;
    private String dob;
    private String panNumber;
    private long phoneNumber;
    private double dailyAmount;

    // Constructor
    public Customer(String name, String dob, String panNumber, long phoneNumber, double dailyAmount) {
        this.name = name;
        this.dob = dob;
        this.panNumber = panNumber;
        this.phoneNumber = phoneNumber;
        this.dailyAmount = dailyAmount;
    }

    // Getters and Setters
    public int getId(){ 
    	return id; 
    }
    public void setId(int id){
    	this.id = id; 
    }
    
    public String getName(){
    	return name;
    }
    public void setName(String name){
    	this.name = name; 
    }
    
    public String getDob(){
    	return dob; 
    }
    public void setDob(String dob){
    	this.dob = dob;
    }
    
    public String getPanNumber(){ 
    	return panNumber; 
    }
    public void setPanNumber(String panNumber){
    	this.panNumber = panNumber; 
    }
    
    public long getPhoneNumber(){
    	return phoneNumber; 
    }
    public void setPhoneNumber(long phoneNumber){
    	this.phoneNumber = phoneNumber; 
    }
    
    public double getDailyAmount(){
    	return dailyAmount; 
    }
    public void setDailyAmount(double dailyAmount){ 
    	this.dailyAmount = dailyAmount; 
    }
    
}
