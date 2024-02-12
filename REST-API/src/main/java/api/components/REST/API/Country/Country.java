package api.components.REST.API.Country;

import jakarta.persistence.*;

@Entity
@Table(name="country")
 public class Country {

    @Id
    @Column(name="country_id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short countryID;

    @Column(name="country")
    private String countryName;

    public short getCountryID() {
        return countryID;
    }

    public void setCountryID(short countryID) {
        this.countryID = countryID;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
