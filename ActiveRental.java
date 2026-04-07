import java.util.HashMap;
import java.util.Map;

public class ActiveRental {

    private Map<String, String> activeRentals = new HashMap<>();
    public void addActiveRental(String bikeId, String userId) {
        activeRentals.put(bikeId, userId);
    }
    public void removeActiveRental(String bikeId) {
        activeRentals.remove(bikeId);
    }

    public void displayActiveRentals() {
        System.out.println("=== 当前活跃租赁列表 ===");
        if (activeRentals.isEmpty()) {
            System.out.println("暂无活跃租赁");
        } else {
            for (Map.Entry<String, String> entry : activeRentals.entrySet()) {
                System.out.println("自行车ID: " + entry.getKey() + " | 用户ID: " + entry.getValue());
            }
        }
        System.out.println("========================");
    }
    public boolean isBikeRented(String bikeId) {
        return activeRentals.containsKey(bikeId);
    }
}