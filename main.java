public class Main {
   public static void main(String[] args) {
    ERyder bike1 = new ERyder();
    bike1.printBikeDetails();
    ERyder bike2 = new ERyder("B824",85,true,100.0f);
    bike2.ride();
    bike2.printBikeDetails();
}
}
