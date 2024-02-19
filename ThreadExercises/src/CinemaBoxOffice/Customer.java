package CinemaBoxOffice;

public class Customer implements Runnable{

    private final int customerID;
    private final Room room;
    private final Integer row;
    private final Integer col;

    public Customer(int customerID, Room room){
        this.customerID = customerID;
        this.room = room;
        this.row = null;
        this.col = null;
    }
    public Customer(int customerID, Room room, Integer row, Integer col) {
        this.customerID = customerID;
        this.room = room;
        this.row = row;
        this.col = col;
    }

    public void run(){
        System.out.println("Hi, I am customer " + customerID + ". I would like to book a seat.");
        if(row!=null && col!=null){
            Seat customerSeat = room.getSeat(row,col);
            if(customerSeat != null){
                customerSeat.setFree(false);
                System.out.println(customerSeat);
            }
        }else{
            Seat customerSeat = room.getFirstFreeSeat();
            if(customerSeat != null){
                customerSeat.setFree(false);
                System.out.println(customerSeat);
            }
        }



    }
}
