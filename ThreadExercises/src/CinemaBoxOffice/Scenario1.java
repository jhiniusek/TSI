package CinemaBoxOffice;

public class Scenario1 {
    public static final Scenario1 instance = new Scenario1();
    private Scenario1() {}
    public static Scenario1 getInstance(){
        return instance;
    }
    public void startScenario(Room room1) throws InterruptedException {
        System.out.println("\n\033[32mSCENARIO 1: Two customers wants to book same seat.\033[0m\n");

        var myCustomer = new Thread(new Customer(1, room1, 1,1));
        myCustomer.start();

        var myCustomer2 = new Thread(new Customer(2, room1, 1,1));
        myCustomer2.start();

        myCustomer.join();
        myCustomer2.join();
    }
}