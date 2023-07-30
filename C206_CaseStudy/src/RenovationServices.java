
public class RenovationServices {
	private String assertTag;
    private String serviceName;
    private String serviceDescription;
    private String contactHours;
    private boolean isAvailable;

    // For Display
    public RenovationServices(String assertTag, String serviceName, String serviceDescription, String contactHours, boolean isAvailable) {
    	this.assertTag = assertTag;
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.contactHours = contactHours;
        this.isAvailable = isAvailable;
    }

    // For Action -> Quotes & Appointments
    public RenovationServices(String assertTag, String serviceName) {
    	this.assertTag = assertTag;
        this.serviceName = serviceName;
        this.serviceDescription = "";
        this.contactHours = "";
        this.isAvailable = true;
    }
    
    /* Not to be included until DURING REFRACTORING
    
    public String toString() {
        // Write your codes here
        String itemInfo = String.format("%-15s %-30s",
        		assertTag,
                serviceName);
        return itemInfo;
    }
    
    */
    
    public String getAssertTag() {
		return assertTag;
	}

    public String getServiceName() {
        return serviceName;
    }
    
    public String getServiceDescription() {
        return serviceDescription;
    }
    
    public String getContactHours() {
        return contactHours;
    }
    
    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
