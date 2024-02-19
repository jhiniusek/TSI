package CinemaBoxOffice;

public class Seat {
    private Room room;
    private int row;
    private int col;
    private boolean free = true;

    public Seat(Room room, int row, int col) {
        this.room = room;
        this.row = row;
        this.col = col;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public void addToRoom(){
        room.addSeat(this);
    }

    @Override
    public String toString(){
        String ticket = "";
        ticket += "=========================" +
                "\nTicket for: " + room.getTitle() +
                "\nIn room number: " + room.getRoomNumber() +
                "\nSeat in row: " + row + " column: " + col +
                "\n=========================";
        return ticket;
    }
}
