import java.util.ArrayList;
import java.util.List;

public class BikeService {
    private List<String> availableBikes;

    public BikeService() {
        availableBikes = new ArrayList<>();
        availableBikes.add("B001");
        availableBikes.add("B002");
        availableBikes.add("B003");
    }

    public List<String> getAvailableBikes() {
        return availableBikes;
    }

    public boolean reserveBike(String bikeId) {
        return availableBikes.remove(bikeId);
    }

    public void returnBike(String bikeId) {
        availableBikes.add(bikeId);
    }
