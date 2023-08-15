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
public class Quote extends Action {
	// Variables
	private int contactNumber;
	private String description;
	private String reply;

	// Constructor for requesting quote
	public Quote(String assertTag, String serviceName, String recipientName, int contactNumber, String description) {
		super(assertTag, serviceName, recipientName);
		this.contactNumber = contactNumber;
		this.description = description;
		this.reply = "";
	}
	
	// Constructor for responding to quote
	public Quote(String assertTag, String serviceName, String recipientName, int contactNumber, String description, String reply) {
		super(assertTag, serviceName, recipientName);
		this.contactNumber = contactNumber;
		this.description = description;
		this.reply = reply;
	}

	// Getters - ONLY FOR SET VARIABLES HERE
    
	public int getContactNumber() {
		return contactNumber;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getReply() {
		return reply;
	}
	
	// Setter
	public void setReply(String reply) {
		this.reply = reply;
	}
	
	// toString Method - Display
	public String toStringDisplay() {
	    String output = super.toString();
	    output = String.format("%-88s %-20s %-50s", output, contactNumber, description);
	    return output;
	}
	
	// toString Method - Reply
	public String toStringReply() {
		String output = super.toString();
		output = String.format("%-88s %-20s %-50s %-50s", output, contactNumber, description, reply);
		return output;
	}
}