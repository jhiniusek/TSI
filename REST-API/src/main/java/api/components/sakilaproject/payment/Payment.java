package api.components.sakilaproject.payment;

import api.components.sakilaproject.JsonViews;
import api.components.sakilaproject.customer.Customer;
import api.components.sakilaproject.rental.Rental;
import api.components.sakilaproject.staff.Staff;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="payment")
public class Payment {
    @Id
    @Column(name="payment_id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.Payment.class)
    private short paymentID;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonView(JsonViews.Payment.class)
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "staff_id", nullable = false)
    @JsonView(JsonViews.Payment.class)
    private Staff staff;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "rental_id", nullable = false)
    @JsonView(JsonViews.Payment.class)
    private Rental rental;

    @Column(name="amount")
    @JsonView(JsonViews.Payment.class)
    private double amount;

    @Column(name="payment_date")
    @JsonView(JsonViews.Payment.class)
    private Date paymentDate;

    public short getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(short paymentID) {
        this.paymentID = paymentID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentDate() {
        if(paymentDate == null){
            return "none";
        }
        return paymentDate.toString();
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
