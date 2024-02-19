package CinemaBoxOffice;

import java.util.ArrayList;

public class Scenario2 {
    public static final Scenario2 instance = new Scenario2();
    private Scenario2() {}
    public static Scenario2 getInstance(){
        return instance;
    }
    public void startScenario(Room room1) throws InterruptedException {
        System.out.println("\n\033[32mSCENARIO 2: All seats has been taken.\033[0m\n");

        ArrayList<Thread> listOfThreads = new ArrayList<Thread>();

        for(int i = 1; i <= 41; i++){
            var myCustomer = new Thread(new Customer(i, room1));
            Thread.sleep(200);
            myCustomer.start();
            listOfThreads.add(myCustomer);
        }

        for(Thread x : listOfThreads){
            x.join();
        }
    }
}