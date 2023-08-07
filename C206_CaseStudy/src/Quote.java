
public class Quote extends Action {
	// Variables
	private int contactNumber;
	private String description;
	private String reply;

	// Constructor for requesting quote
	public Quote(String assetTag, String serviceName, String recipientName, int contactNumber, String description) {
		super(assetTag, serviceName, recipientName);
		this.contactNumber = contactNumber;
		this.description = description;
		this.reply = "";
	}
	
	// Contructor for responding to quote
	public Quote(String assetTag, String serviceName, String recipientName, int contactNumber, String description, String reply) {
		super(assetTag, serviceName, recipientName);
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
