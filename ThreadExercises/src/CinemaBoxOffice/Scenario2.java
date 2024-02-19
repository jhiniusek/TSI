package CinemaBoxOffice;

public class Scenario2 {
    public static void startScenario(Room room1) throws InterruptedException {

        System.out.println("\n\033[32mSCENARIO 2: All seats has been taken.\033[0m\n");

        for(int i = 1; i <= 41; i++){
            var myCustomer = new Thread(new Customer(i, room1));
            myCustomer.start();
            myCustomer.join();
        }
    }
}
