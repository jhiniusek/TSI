package api.components.sakilaproject.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private final CityService cityService;

    public CityController (CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public Iterable<City> getAllCities() {
        return cityService.readCities();
    }
}
