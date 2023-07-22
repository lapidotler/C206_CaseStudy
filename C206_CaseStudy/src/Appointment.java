
public class Appointment extends Action {
	// Variables
	private String username;
	private String contactNumber;
	private String description;

	// Constructor
	public Appointment(String serviceName, String username, String contactNumber, String description) {
		super(serviceName);
		this.username = username;
		this.contactNumber = contactNumber;
		this.description = description;
	}

	// Getters - ONLY FOR SET VARIABLES HERE
	public String getUsername() {
		return username;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}
	
	public String getDescription() {
		return description;
	}
	
	// toString Method - Display
	public String toString(){
		// Write your codes here
		String output = super.toString();
		output = String.format("%-31s %-10s %-10s %-30s", output, username, contactNumber, description);
		return output;
	}
}
