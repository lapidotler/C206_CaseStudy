
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
            avail = "Resolved";
        } else {
            avail = "Pending";
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
 		// Write your codes here
 		String output = super.toString();
 		output = String.format("%-31s %-20s %-10s", output, recipientName, status);
 		return output;
 	}
}

