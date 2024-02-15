package api.components.sakilaproject.country;

import api.components.sakilaproject.city.City;
import api.components.sakilaproject.city.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private final CountryRepository countryRepo;
    public CountryService (CountryRepository countryRepo){
        this.countryRepo = countryRepo;
    }

    public List<Country> readCountries(){
        return countryRepo.findAll();
    }
}
