package CinemaBoxOffice;

public class Scenario1 {
    public static void startScenario(Room room1) throws InterruptedException {

        System.out.println("\n\033[32mSCENARIO 1: Two customers wants to book same seat.\033[0m\n");

        var myCustomer = new Thread(new Customer(1, room1, 1,1));
        myCustomer.start();
        myCustomer.join();

        var myCustomer2 = new Thread(new Customer(2, room1, 1,1));
        myCustomer2.start();
        myCustomer2.join();

    }
}
