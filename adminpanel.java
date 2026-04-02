

import java.util.Stack;

public class AdminPanel {
    private ERyderSystem system;
    private BikeService bikeService;

    public AdminPanel(ERyderSystem system, BikeService bikeService) {
        this.system = system;
        this.bikeService = bikeService;
    }

    public void showSystemLogs() {
        System.out.println("\n=== System Logs ===");
        Stack<ERyderLog> logs = system.getSystemLogs();
        for (ERyderLog log : logs) {
            System.out.println(log);
        }
    }

    public void showPendingRequests() {
        System.out.println("\n=== Pending Bike Requests ===");
        if (system.isRequestQueueEmpty()) {
            System.out.println("Empty.");
            return;
        }
        for (BikeRequest req : system.getBikeRequestQueue()) {
            System.out.println(req);
        }
    }
}