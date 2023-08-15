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
public class User {
	private String recipientName;
	private String dateOfBirth;
	private String email;
	private String password;
    private String role;

    // Regular Users
    public User(String recipientName, String dateOfBirth, String email, String password, String role) {
        this.recipientName = recipientName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    
 // Regular Service Providers
    public User(String recipientName, String email, String password, String role) {
        this.recipientName = recipientName;
        this.dateOfBirth = "";
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String showStatus(boolean status) {
        String avail;

        if (status == true) {
            avail = "Pending";
        } else {
            avail = "Resolved";
        }
        return avail;
    }
    
    public String getRecipientName() {
        return recipientName;
    }

    public String getDOB() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
    	this.role = role;
    }
    
    // toString Method - Display
 	public String toString(){
 		String output = "";
 		
		// Write your codes here
 		if (role.equals("Service provider"))
 		{
 			output = String.format("%-45s %-30s %-20s %-20s\n",
		             recipientName, email, password, role);
 		}
 		else
 		{
 			output = String.format("%-15s %-20s %-30s %-20s %-20s\n",
 					recipientName, dateOfBirth, email, password, role);
 		}
 		return output;
 	}
}
