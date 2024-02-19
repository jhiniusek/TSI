package CinemaBoxOffice;

public class Customer implements Runnable{
    private final int customerID;
    private final Room room;
    private final Integer row;
    private final Integer col;

    public Customer(int customerID, Room room){
        this(customerID, room, null, null);
    }
    public Customer(int customerID, Room room, Integer row, Integer col) {
        this.customerID = customerID;
        this.room = room;
        this.row = row;
        this.col = col;
    }

    public void run(){
        System.out.println("\nHi, I am customer " + customerID + ". I would like to book a seat.");
        if(row!=null && col!=null){
            Seat customerSeat = room.getSeat(row,col);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(customerSeat != null){
                System.out.println("\nTicket of Customer " + customerID + ":\n" + customerSeat);
            }else{
                System.out.println("\nCustomer " + customerID + " didn't get his ticket.");
            }
        }else{
            Seat customerSeat = room.getFirstFreeSeat();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(customerSeat != null){
                System.out.println("\nTicket of Customer " + customerID + ":\n" + customerSeat);
            }else{
                System.out.println("\nCustomer " + customerID + " didn't get his ticket.");
            }
        }
    }
}