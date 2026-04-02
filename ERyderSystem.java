

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class ERyderSystem {
    
    private Stack<ERyderLog> systemLogs;

    
    private Queue<BikeRequest> bikeRequestQueue;

    public ERyderSystem() {
        systemLogs = new Stack<>();
        bikeRequestQueue = new LinkedList<>();
    }

   
    public void addLog(String action, String userEmail) {
        systemLogs.push(new ERyderLog(action, userEmail));
    }

    public Stack<ERyderLog> getSystemLogs() {
        return systemLogs;
    }

   
    public void addBikeRequest(String userEmail, String location) {
        bikeRequestQueue.add(new BikeRequest(userEmail, location));
        addLog("Bike requested", userEmail);
    }

    public BikeRequest processNextRequest() {
        return bikeRequestQueue.poll();
    }

    public boolean isRequestQueueEmpty() {
        return bikeRequestQueue.isEmpty();
    }

    public Queue<BikeRequest> getBikeRequestQueue() {
        return bikeRequestQueue;
    }
}
