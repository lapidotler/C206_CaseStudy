
public class Action {
	private String assertTag;
    private String serviceName;
    private String recipientName;
    private boolean status;

    public Action(String assertTag, String serviceName, String recipientName) {
    	this.assertTag = assertTag;
        this.serviceName = serviceName;
        this.recipientName = recipientName;
        this.status = true;
    }

    public String toString() {
        // Write your codes here
        String itemInfo = String.format("%-10s %-20s %-20s %-10s",
        		assertTag,
                serviceName,
                recipientName,
                showStatus(status));
        return itemInfo;
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
    
    public String getAssertTag() {
		return assertTag;
	}

    public String getServiceName() {
        return serviceName;
    }
    
    public String getRecipientName() {
        return serviceName;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

