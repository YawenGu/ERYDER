

public class BikeService {
    private ERyderSystem system;

    public BikeService(ERyderSystem system) {
        this.system = system;
    }

    
    public void requestBike(String userEmail, String location) {
        system.addBikeRequest(userEmail, location);
        System.out.println("Request added to queue.");
    }

    
    public void handleNextRequest() {
        if (system.isRequestQueueEmpty()) {
            System.out.println("No pending requests.");
            return;
        }
        BikeRequest req = system.processNextRequest();
        System.out.println("Processing: " + req);
        system.addLog("Request processed", req.getUserEmail());
    }
}