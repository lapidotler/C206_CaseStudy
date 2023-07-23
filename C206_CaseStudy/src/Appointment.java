
public class Appointment extends Action {
	// Variables
	private String date;
	private String time;
	private String location;

	// Constructor
	public Appointment(String serviceName, String date, String time, String location) {
		super(serviceName);
		this.date = date;
		this.time = time;
		this.location = location;
	}

	// Getters - ONLY FOR SET VARIABLES HERE
	public String getUsername() {
		return date;
	}
	
	public String getContactNumber() {
		return time;
	}
	
	public String getDescription() {
		return location;
	}
	
	// toString Method - Display
	public String toString(){
		// Write your codes here
		String output = super.toString();
		output = String.format("%-31s %-10s %-10s %-20s", output, date, time, location);
		return output;
	}
}
