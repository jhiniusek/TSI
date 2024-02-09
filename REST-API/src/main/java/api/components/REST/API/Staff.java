package api.components.REST.API;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;

import java.security.PrivateKey;

@Entity
@Table(name="staff")
public class Staff {
    @Id
    @Column(name="staff_id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.Staff.class)
    private short staffID;

    @Column(name="first_name")
    @JsonView({ JsonViews.Staff.class, JsonViews.Store.class })
    private String firstName;

    @Column(name="last_name")
    @JsonView({ JsonViews.Staff.class, JsonViews.Store.class })
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    @JsonView({ JsonViews.Staff.class, JsonViews.Store.class })
    private Address address;

    @Column(name="email")
    @JsonView({ JsonViews.Staff.class, JsonViews.Store.class })
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    @JsonView(JsonViews.Staff.class)
    private Store store;

    public short getStaffID() {
        return staffID;
    }

    public void setStaffID(short staffID) {
        this.staffID = staffID;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
