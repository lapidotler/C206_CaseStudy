/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Irfan Iskandar Bin Abdul Rahim
 * Student ID: 22024044
 * Class: W65C
 * Date/Time created: Saturday 20-07-2023 20:00
 */

/**
 * @author 22024044
 *
 */
public class Appointment extends Action {
    // Variables
    private String date;
    private String time;
    private String location;

    // Constructor
    public Appointment(String assertTag, String serviceName, String recipientName, String date, String time, String location) {
        super(assertTag, serviceName, recipientName);
        this.date = date;
        this.time = time;
        this.location = location;
    }

    // Getters - ONLY FOR SET VARIABLES HERE
    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }
    
    // setters for additional variables
    public void setDate(String date) {
    	this.date=date;
    }
    
    public void setTime(String time) {
    	this.time=time;
    }
    
    public void setLocation(String location) {
    	this.location=location;
    }
    
    // add and edit methods
    public static Appointment createAppointment (String assertTag, String serviceName, String recipientName, String date, String time, String location) {
    	return new Appointment(assertTag, serviceName, recipientName, date, time, location);
    }
    
    public void editAppointment(String date, String time, String location) {
        this.date = date;
        this.time = time;
        this.location = location;
    }

    // toString Method - Display
    public String toString() {
    	
    	String output = "";
		// Write your codes here
		return output;
    	
    	/* Not to be included until DURING REFRACTORING
    	
        String output = super.toString();
        output = String.format("%-88s %-10s %-10s %-20s", output, date, time, location);
        return output;
        
        */
    }
}