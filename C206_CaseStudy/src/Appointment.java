
public class Appointment extends Action {
    // Variables
    private String date;
    private String time;
    private String location;

    // Constructor
    public Appointment(String assetTag, String serviceName, String recipientName, String date, String time, String location) {
        super(assetTag, serviceName, recipientName);
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

    // toString Method - Display
    public String toString() {
    	
    	String output = "";
		// Write your codes here
		return output;
    	
    	/* Not to be included until DURING REFRACTORING
    	
        String output = super.toString();
        output = String.format("%-93s %-10s %-10s %-20s", output, date, time, location);
        return output;
        
        */
    }
}
