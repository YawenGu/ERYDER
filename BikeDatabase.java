import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class BikeDatabase {
    private List<Bike> bikeList = new ArrayList<>();

    public BikeDatabase() {
        bikeList.add(new Bike("B001", true, 95, LocalDateTime.now().minusDays(1), "NJIT Gate 5"));
        bikeList.add(new Bike("B002", true, 88, LocalDateTime.now().minusDays(2), "Wending Square"));
        bikeList.add(new Bike("B003", false, 72, LocalDateTime.now(), "Central Station"));
    }

   
    public List<Bike> getBikeList() {
        return new ArrayList<>(bikeList);
    }

    public void displayAvailableBikes() {

        System.out.println("=== 可用自行车列表 ===");
        for (Bike bike : bikeList) {
            if (bike.isAvailable()) {
                System.out.println("ID: " + bike.getBikeID() +
                        " | 位置: " + bike.getLocation() +
                        " | 状态: 可用" +
                        " | 电量: " + bike.getBatteryLevel() + "");
            }
        }
        System.out.println("========================");
    }

    public boolean updateBikeStatus(String bikeId, String newStatus) {
        for (Bike bike : bikeList) {
            if (bike.getBikeID().equalsIgnoreCase(bikeId)) {
                if ("AVAILABLE".equalsIgnoreCase(newStatus)) {
                    bike.setAvailable(true);
                } else if ("RESERVED".equalsIgnoreCase(newStatus) || "RENTED".equalsIgnoreCase(newStatus)) {
                    bike.setAvailable(false);
                }
                return true;
            }
        }
        return false; 
    }

    public boolean isLocationValid(String location) {
        List<String> validLocations = List.of("NJIT Gate 5", "Wending Square", "Central Station");
        return validLocations.contains(location);
    }
}