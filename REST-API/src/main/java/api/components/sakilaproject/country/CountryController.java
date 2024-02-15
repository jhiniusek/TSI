package api.components.sakilaproject.country;

import api.components.sakilaproject.city.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private final CountryService countryService;

    public CountryController (CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public Iterable<Country> getAllCountries() {
        return countryService.readCountries();
    }
}
