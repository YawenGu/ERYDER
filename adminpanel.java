import java.util.Scanner;
public class AdminPanel {
    private Scanner scanner = new Scanner(System.in);
  
    private UserService userService;
    private BikeService bikeService;
    private RentalService rentalService;

    public AdminPanel(BikeDatabase bikeDatabase, ActiveRental activeRental) {
        this.userService = new UserService();
        this.bikeService = new BikeService(bikeDatabase, activeRental);
        this.rentalService = new RentalService(activeRental, bikeDatabase);
    }

    public void userManagementOptions() {
        while (true) {
            System.out.println("\n===== E-Ryder Admin Panel =====");
            System.out.println("1. 用户管理");
            System.out.println("2. 自行车管理");
            System.out.println("3. 租赁管理");
            System.out.println("4. 退出");
            System.out.print("请选择操作: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    handleUserManagement();
                    break;
                case 2:
                    handleBikeManagement();
                    break;
                case 3:
                    handleRentalManagement();
                    break;
                case 4:
                    System.out.println("退出管理面板...");
                    return; 
                default:
                    System.out.println("无效选择，请重新输入！");
            }
        }
    }

    private void handleUserManagement() {
        System.out.println("\n----- 用户管理 -----");
        System.out.println("1. 添加用户");
        System.out.println("2. 查看所有用户");
        System.out.println("3. 删除用户");
        System.out.print("请选择: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                System.out.println("功能暂未实现，请在UserService中完善。");
                break;
            case 2:
                userService.retrieveUsers();
                break;
            case 3:
                System.out.print("输入要删除的用户邮箱: ");
                String email = scanner.nextLine();
                userService.removeUser(email);
                break;
            default:
                System.out.println("无效操作！");
        }
    }

    private void handleBikeManagement() {
        System.out.println("\n----- 自行车管理 -----");
        System.out.println("1. 查看可用自行车");
        System.out.println("2. 预约自行车");
        System.out.print("请选择: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                bikeService.findAvailableBikes();
                break;
            case 2:
                System.out.print("输入自行车ID: ");
                String bikeId = scanner.nextLine();
                bikeService.reserveBike(bikeId);
                break;
            default:
                System.out.println("无效操作！");
        }
    }

    private void handleRentalManagement() {
        System.out.println("\n----- 租赁管理 -----");
        System.out.println("1. 开始租赁");
        System.out.println("2. 结束租赁");
        System.out.println("3. 查看活跃租赁");
        System.out.print("请选择: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                System.out.print("输入自行车ID: ");
                String bikeId = scanner.nextLine();
                System.out.print("输入用户ID/邮箱: ");
                String userId = scanner.nextLine();
                rentalService.startRental(bikeId, userId);
                break;
            case 2:
                System.out.print("输入自行车ID: ");
                String endBikeId = scanner.nextLine();
                rentalService.endRental(endBikeId);
                break;
            case 3:
                rentalService.trackActiveRentals();
                break;
            default:
                System.out.println("无效操作！");
        }
    }
}