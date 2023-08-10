
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
 		String output = super.toString();
 		output = String.format("%-51s %-20s %-15s", output, recipientName, showStatus(status));
 		return output;
 	}
}

