import java.util.ArrayList;
import java.time.LocalDateTime;

public class BikeDatabase {
    public static ArrayList<Bike> bikes = new ArrayList<>();

    static {
        bikes.add(new Bike("B001", true, 85, LocalDateTime.now().minusHours(2), "Campus A"));
        bikes.add(new Bike("B002", false, 60, LocalDateTime.now(), "Campus B"));
        bikes.add(new Bike("B003", true, 90, LocalDateTime.now().minusDays(1), "Campus A"));
        bikes.add(new Bike("B004", true, 75, LocalDateTime.now().minusHours(5), "Campus C"));
    }
}