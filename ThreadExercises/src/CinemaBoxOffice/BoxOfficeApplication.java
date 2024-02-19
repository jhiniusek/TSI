package CinemaBoxOffice;

import java.util.ArrayList;

public class BoxOfficeApplication {

    public static void main(String[] args) throws InterruptedException {

        Room room1 = new Room(1, "Barbie");
        Room room2 = new Room(2, "Oppenheimer");
        ArrayList<Thread> listOfThreads = new ArrayList<Thread>();

        for(int x = 1; x <= 5; x++){
            var myThread = new Thread(new SeatGenerator(room1, x, 8));
            myThread.start();
            listOfThreads.add(myThread);
            var myThread2 = new Thread(new SeatGenerator(room2, x, 8));
            myThread2.start();
            listOfThreads.add(myThread2);
        }

        for(Thread x : listOfThreads){
            x.join();
        }

        System.out.println("Room 1 have: " + room1.getNumberOfSeats() + " seats for " + room1.getTitle());
        System.out.println("Room 2 have: " + room2.getNumberOfSeats() + " seats for " + room2.getTitle());

        Scenario1.getInstance().startScenario(room1);
        Thread.sleep(1000);
        room1.endSeance();

        Scenario2.getInstance().startScenario(room1);
        Thread.sleep(1000);
        room1.endSeance();

        Scenario3.getInstance().startScenario(room1, room2);
    }
}