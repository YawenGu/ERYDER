import javax.swing.SwingUtilities;

public class main {
    public static void main(String[] args) {
        
        ERyderSystem system = new ERyderSystem();
        BikeService bikeService = new BikeService(system);
 
        system.addLog("LOG001", "用户登录系统");
        system.addLog("LOG002", "创建自行车订单");
        system.addLog("LOG003", "管理员修改订单状态");

       
        system.addBikeRequest("REQ001", "用户A申请共享单车");
        system.addBikeRequest("REQ002", "用户B申请车辆调度");

       
        bikeService.reserveBike("B001", "userA@school.edu", "Campus Gate");
        bikeService.reserveBike("B002", "userB@school.edu", "Library");

       
        bikeService.removeTrip("B001");

        
        SwingUtilities.invokeLater(() -> {
            AdminPanel panel = new AdminPanel(system);
            panel.setVisible(true);
        });
    }
}