package api.components.sakilaproject.customer;

import api.components.sakilaproject.JsonViews;
import api.components.sakilaproject.address.Address;
import api.components.sakilaproject.store.Store;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @Column(name="customer_id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.Customer.class)
    private short customerID;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    @JsonView({JsonViews.Customer.class, })
    private Store store;

    @Column(name="first_name")
    @JsonView({JsonViews.Customer.class, JsonViews.Rental.class, JsonViews.Payment.class})
    private String firstName;

    @Column(name="last_name")
    @JsonView({JsonViews.Customer.class, JsonViews.Rental.class, JsonViews.Payment.class})
    private String lastName;

    @Column(name="email")
    @JsonView({JsonViews.Customer.class, JsonViews.Rental.class, JsonViews.Payment.class})
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    @JsonView({JsonViews.Customer.class, JsonViews.Rental.class, JsonViews.Payment.class})
    private Address address;

    @Column(name="active")
    @JsonView(JsonViews.Customer.class)
    private boolean active;

    @Column(name="create_date")
    @JsonView(JsonViews.Customer.class)
    private Date createDate;

    public short getCustomerID() {
        return customerID;
    }

    public void setCustomerID(short customerID) {
        this.customerID = customerID;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCreateDate() {
        if(createDate == null){
            return "none";
        }
        return createDate.toString();
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
