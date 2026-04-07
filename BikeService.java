public class BikeService {
  
    private BikeDatabase bikeDatabase;
    private ActiveRental activeRental;

   
    public BikeService(BikeDatabase bikeDatabase, ActiveRental activeRental) {
        this.bikeDatabase = bikeDatabase;
        this.activeRental = activeRental;
    }

   
    public void findAvailableBikes() {
        System.out.println("【BikeService】正在查询可用自行车...");
       
        bikeDatabase.displayAvailableBikes();
    }

  
    public boolean reserveBike(String bikeId) {
        System.out.println("【BikeService】尝试预约自行车,ID:" + bikeId);
       
        boolean success = bikeDatabase.updateBikeStatus(bikeId, "RESERVED");
        if (success) {
            System.out.println("预约成功！");
        } else {
            System.out.println("预约失败：车辆不存在或已被占用");
        }
        return success;
    }

   
    public boolean validateLocation(String location) {
        System.out.println("【BikeService】验证位置:" + location);
        return bikeDatabase.isLocationValid(location);
    }

    public boolean releaseBike(String bikeId) {
        System.out.println("【BikeService】释放自行车,ID:" + bikeId);
        boolean success = bikeDatabase.updateBikeStatus(bikeId, "AVAILABLE");
        if (success) {
            System.out.println("释放成功！");
        } else {
            System.out.println("释放失败：车辆不存在");
        }
        return success;
    }
}