
public class Action {
    private String serviceName;
    private boolean status;

    public Action(String serviceName) {
        this.serviceName = serviceName;
        this.status = true;
    }

    public String toString() {
        // Write your codes here
        String itemInfo = String.format("%-20s %-10s",
                serviceName,
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

    public String getServiceName() {
        return serviceName;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

