package CinemaBoxOffice;

public class BoxOfficeApplication {

    public static void main(String[] args) throws InterruptedException {

        Room room1 = new Room(1, "Barbie");
        Room room2 = new Room(2, "Oppenheimer");

        for(int x = 1; x <= 5; x++){
            var myThread = new Thread(new SeatGenerator(room1, x, 8));
            myThread.start();
            var myThread2 = new Thread(new SeatGenerator(room2, x, 8));
            myThread2.start();

            myThread.join();
            myThread2.join();
        }

        System.out.println("Room 1 have: " + room1.getNumberOfSeats() + " seats for " + room1.getTitle());
        System.out.println("Room 2 have: " + room2.getNumberOfSeats() + " seats for " + room2.getTitle());

        Scenario1.startScenario(room1);

        Thread.sleep(1000);

        room1.endSeance();

        Scenario2.startScenario(room1);

        Thread.sleep(1000);

        room1.endSeance();

        Scenario3.startScenario(room1, room2);

    }
}
