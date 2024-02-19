package CinemaBoxOffice;

public class Scenario3 {
    public static final Scenario3 instance = new Scenario3();
    private Scenario3() {}
    public static Scenario3 getInstance(){
        return instance;
    }
    public void startScenario(Room room1, Room room2) throws InterruptedException {
        System.out.println("\n\033[32mSCENARIO 3: Two customers wants to book same seat in different rooms.\033[0m\n");

        var myCustomer = new Thread(new Customer(1, room1, 1,1));
        myCustomer.start();

        var myCustomer2 = new Thread(new Customer(2, room2, 1,1));
        myCustomer2.start();

        myCustomer.join();
        myCustomer2.join();
    }
}