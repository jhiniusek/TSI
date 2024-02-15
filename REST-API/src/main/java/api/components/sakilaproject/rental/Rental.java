package api.components.sakilaproject.rental;

import api.components.sakilaproject.JsonViews;
import api.components.sakilaproject.customer.Customer;
import api.components.sakilaproject.inventory.Inventory;
import api.components.sakilaproject.staff.Staff;
import api.components.sakilaproject.store.Store;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="rental")
public class Rental {
    @Id
    @Column(name="rental_id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.Rental.class)
    private short rentalID;

    @Column(name="rental_date")
    @JsonView({JsonViews.Rental.class, JsonViews.Payment.class})
    private Date rentalDate;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "inventory_id", nullable = false)
    @JsonView({JsonViews.Rental.class, JsonViews.Payment.class})
    private Inventory inventory;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonView(JsonViews.Rental.class)
    private Customer customer;

    @Column(name="return_date")
    @JsonView({JsonViews.Rental.class, JsonViews.Payment.class})
    private Date returnDate;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "staff_id", nullable = false)
    @JsonView(JsonViews.Rental.class)
    private Staff staff;

    public short getRentalID() {
        return rentalID;
    }

    public void setRentalID(short rentalID) {
        this.rentalID = rentalID;
    }

    public String getRentalDate() {
        if(rentalDate == null){
            return "none";
        }
        return rentalDate.toString();
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getReturnDate() {
        if(returnDate == null){
            return "none";
        }
        return returnDate.toString();
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
