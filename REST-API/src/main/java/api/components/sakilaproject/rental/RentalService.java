package api.components.sakilaproject.rental;

import api.components.sakilaproject.JSONFix;
import api.components.sakilaproject.JsonViews;
import api.components.sakilaproject.customer.CustomerRepository;
import api.components.sakilaproject.inventory.Inventory;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentalService {

    @Autowired
    private final RentalRepository rentalRepo;
    public RentalService (RentalRepository rentalRepo){
        this.rentalRepo = rentalRepo;
    }

    public String readRentals() throws JsonProcessingException {
        List<Rental> objectRentals = rentalRepo.findAll();
        List<String> rentals = new ArrayList<String>();

        for(Rental rental : objectRentals){
            JSONObject jo = JSONFix.fixOrder(rental, JsonViews.Rental.class);
            rentals.add(jo.toString());
        }
        return rentals.toString();
    }
}
