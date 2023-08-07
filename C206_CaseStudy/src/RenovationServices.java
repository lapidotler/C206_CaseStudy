
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
    
    // toString Method - Display
    public String toStringDisplay() {
        String itemInfo = String.format("%-15s %-30s %-50s %-25s %-10s\n",
                assertTag, 
                serviceName, 
                serviceDescription, 
                contactHours, 
                showAvailability(isAvailable));
        return itemInfo;
    }
    
    
    // toString Method - Quote/Appointment
    public String toString() {
    	String itemInfo = String.format("%-15s %-35s",
                assertTag, serviceName);
    	return itemInfo;
    }
    
    public static String showAvailability(boolean availability) {
        String avail;

        if (availability == true) {
            avail = "Available";
        } else {
            avail = "No Longer Available";
        }
        return avail;
    }
    
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
