package CinemaBoxOffice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Room {
    private int roomNumber;
    private String title;
    private final List<Seat> seats = Collections.synchronizedList(new ArrayList<Seat>());

    public Room(int roomNumber, String title) {
        this.roomNumber = roomNumber;
        this.title = title;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public int getNumberOfSeats(){
        return seats.size();
    }

    public void addSeat(Seat seat){
        this.seats.add(seat);
    }

    public synchronized Seat getFirstFreeSeat(){
        for(Seat seat : seats){
            if(seat.isFree()){
                seat.setFree(false);
                return seat;
            }
        }
        System.out.println("No tickets left.");
        return null;
    }

    public Seat getSeat(int row, int col){
        for(Seat seat : seats){
            if(seat.getRow()==row && seat.getCol()==col) {
                if (seat.isFree()) {
                    seat.setFree(false);
                    return seat;
                } else {
                    System.out.println("This seat is taken.");
                    return null;
                }
            }
        }
        System.out.println("This seat doesn't exist.");
        return null;
    }

    public void endSeance(){
        for(Seat seat : seats){
            seat.setFree(true);
        }
    }
}