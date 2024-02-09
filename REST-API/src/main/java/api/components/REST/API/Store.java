package api.components.REST.API;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;

@Entity
@Table(name="store")
public class Store {

    @Id
    @Column(name="store_id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.Store.class)
    private short staffID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_staff_id", referencedColumnName = "staff_id")
    @JsonView(JsonViews.Store.class)
    private Staff manager;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    @JsonView({ JsonViews.Staff.class, JsonViews.Store.class })
    private Address address;

    public short getStaffID() {
        return staffID;
    }

    public void setStaffID(short staffID) {
        this.staffID = staffID;
    }

    public Staff getManager() {
        return manager;
    }

    public void setManager(Staff manager) {
        this.manager = manager;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
