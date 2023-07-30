
public class RenovationServices {
	private String assertTag;
    private String serviceName;

    public RenovationServices(String assertTag, String serviceName) {
    	this.assertTag = assertTag;
        this.serviceName = serviceName;
    }

    public String toString() {
        // Write your codes here
        String itemInfo = String.format("%-10s %-20s",
        		assertTag,
                serviceName);
        return itemInfo;
    }
    
    public String getAssertTag() {
		return assertTag;
	}

    public String getServiceName() {
        return serviceName;
    }
}
