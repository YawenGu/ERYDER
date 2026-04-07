public class RentalService {
   
    double BASE_FARE = 3.0;

   
    private ActiveRental activeRental = new ActiveRental();
    private BikeDatabase bikeDatabase = new BikeDatabase();

    public RentalService(ActiveRental activeRental, BikeDatabase bikeDatabase) {
        this.activeRental = activeRental;
        this.bikeDatabase = bikeDatabase;
    }

    public void startRental(String bikeId, String userId) {
        System.out.println("[RentalService] 开始租赁 - 车ID:" + bikeId + " 用户ID:" + userId);
        activeRental.addActiveRental(bikeId, userId);
        bikeDatabase.updateBikeStatus(bikeId, "RENTED");
    }

    public void endRental(String bikeId) {
        System.out.println("[RentalService] 结束租赁 - 车ID:" + bikeId);
        activeRental.removeActiveRental(bikeId);
        bikeDatabase.updateBikeStatus(bikeId, "AVAILABLE");
    }

   
    public void cancelRental(String bikeId) {
        System.out.println("[RentalService] 取消租赁 - 车ID:" + bikeId);
        activeRental.removeActiveRental(bikeId);
        bikeDatabase.updateBikeStatus(bikeId, "AVAILABLE");
    }
   
    public void trackActiveRentals() {
    
        System.out.println("[RentalService] 追踪所有活跃租赁...");
        activeRental.displayActiveRentals();
    }
}