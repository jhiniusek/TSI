package CinemaBoxOffice;

public class SeatGenerator implements Runnable {
    private final Room room;
    private final int rowNumber;
    private final int seatsInARow;
    public SeatGenerator(Room room, int rowNumber, int seatsInARow) {
        this.room = room;
        this.rowNumber = rowNumber;
        this.seatsInARow = seatsInARow;
    }

    public void run(){
        for(int i = 1; i <= seatsInARow; i++){
            Seat seat = new Seat(room, rowNumber, i);
            seat.addToRoom();
        }
    }
}