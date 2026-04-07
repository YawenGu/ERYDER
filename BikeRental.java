import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

// 注意：重构后BikeRental类已拆分，此为兼容旧逻辑的修正版
public class BikeRental {
    // 依赖注入（匹配你现有类结构）
    private BikeDatabase bikeDatabase;
    private List<ActiveRental> activeRentalsList;

    // 构造器
    public BikeRental(BikeDatabase bikeDatabase, List<ActiveRental> activeRentalsList) {
        this.bikeDatabase = bikeDatabase;
        this.activeRentalsList = activeRentalsList;
    }

    // 1. 修正reserveBike方法（解决所有红线）
    private void reserveBike(String bikeID, String emailAddress) {
        // 遍历自行车数据库找对应ID
        for (Bike bike : bikeDatabase.getBikeList()) {
            // 修正：方法名getBikeID()（大写D，匹配Bike类），isAvailable()判断可用
            if (bike.getBikeID().equals(bikeID) && bike.isAvailable()) {
                LocalDateTime tripStartTime = LocalDateTime.now();
                // 修正：setAvailable(false)，setLastUsedTime()
                bike.setAvailable(false);
                bike.setLastUsedTime(tripStartTime);
                System.out.println("Reserving the bike with the " + bikeID + ". Please following the on-screen instructions.");

                // 修正：ActiveRental构造器匹配，添加到活跃租赁列表
                ActiveRental activeRental = new ActiveRental(bikeID, emailAddress, tripStartTime);
                activeRentalsList.add(activeRental);
                break;
            }
        }
        // 无匹配车辆提示
        System.out.println("Sorry, we're unable to reserve a bike at this time. Please try again later.");
    }

    // 2. 修正viewActiveRentals方法（删除x:语法错误）
    private void viewActiveRentals() {
        if (activeRentalsList.isEmpty()) {
            System.out.println("No active rentals at the moment.");
        } else {
            for (ActiveRental rental : activeRentalsList) {
                System.out.println(rental);
            }
        }
    }

    // 3. 修正removeTrip方法（解决迭代器&方法名红线）
    private void removeTrip(String bikeID) {
        Iterator<ActiveRental> iterator = activeRentalsList.iterator();
        while (iterator.hasNext()) {
            ActiveRental rental = iterator.next();
            // 修正：getBikeID()方法名匹配
            if (rental.getBikeID().equals(bikeID)) {
                iterator.remove();
                break;
            }
        }

        // 同步恢复自行车状态
        for (Bike bike : bikeDatabase.getBikeList()) {
            if (bike.getBikeID().equals(bikeID)) {
                bike.setAvailable(true);
                bike.setLastUsedTime(LocalDateTime.now());
                System.out.println("Your trip has ended. Thank you for riding with us.");
                break;
            }
        }
    }
}