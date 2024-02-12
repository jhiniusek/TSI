package api.components.sakilaproject.address;

import api.components.sakilaproject.city.City;
import jakarta.persistence.*;

@Entity
@Table(name="address")
public class Address {
    @Id
    @Column(name="address_id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short addressID;

    @Column(name="address")
    private String addressLine;

    @Column(name="district")
    private String district;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Column(name="postal_code")
    private String postalCode;

    @Column(name="phone")
    private String phoneNumber;

    public short getAddressID() {
        return addressID;
    }

    public void setAddressID(short addressID) {
        this.addressID = addressID;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
