
public class Action extends RenovationServices {
    private String recipientName;
    private boolean status;

    public Action(String assertTag, String serviceName, String recipientName) {
    	super(assertTag, serviceName);
        this.recipientName = recipientName;
        this.status = true;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    // toString Method - Display
 	public String toString(){
 		
 		String output = "";
		// Write your codes here
		return output;
 		
 		/* Not to be included until DURING REFRACTORING
 		
 		// Write your codes here
 		String output = super.toString();
 		output = String.format("%-46s %-20s %-10s", output, recipientName, status);
 		return output;
 		
 		*/
 	}
}

