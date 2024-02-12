package api.components.REST.API.City;

import api.components.REST.API.Country.Country;
import jakarta.persistence.*;

@Entity
@Table(name="city")
public class City {

    @Id
    @Column(name="city_id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short cityID;

    @Column(name="city")
    private String cityName;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    public short getCityID() {
        return cityID;
    }

    public void setCityID(short cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
