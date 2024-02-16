package api.components.sakilaproject.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private final CityRepository cityRepo;
    public CityService (CityRepository cityRepo){
        this.cityRepo = cityRepo;
    }

    public List<City> readCities(){
        return cityRepo.findAll();
    }
}
