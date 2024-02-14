package api.components.sakilaproject.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryRepository countryRepo;

    @GetMapping
    public Iterable<Country> getAllCountries() {
        return countryRepo.findAll();
    }
}
