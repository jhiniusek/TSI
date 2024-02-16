package api.components.sakilaproject.rental;

import api.components.sakilaproject.JSONFix;
import api.components.sakilaproject.JsonViews;
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

    public String readRentalsByCustomerID(int custID) throws JsonProcessingException {
        List<Rental> objectRentals = rentalRepo.getRentalByCustomerID(custID);
        List<String> rentals = new ArrayList<String>();

        for(Rental rental : objectRentals){
            JSONObject jo = JSONFix.fixOrder(rental, JsonViews.Rental.class);
            rentals.add(jo.toString());
        }
        return rentals.toString();
    }

    public String readRentalsByCustomerName(String name) throws JsonProcessingException {
        List<Rental> objectRentals = rentalRepo.getRentalByCustomerName(name);
        List<String> rentals = new ArrayList<String>();

        for(Rental rental : objectRentals){
            JSONObject jo = JSONFix.fixOrder(rental, JsonViews.Rental.class);
            rentals.add(jo.toString());
        }
        return rentals.toString();
    }

    public String readRentalsByStoreID(int storeID) throws JsonProcessingException {
        List<Rental> objectRentals = rentalRepo.getRentalByStoreID(storeID);
        List<String> rentals = new ArrayList<String>();

        for(Rental rental : objectRentals){
            JSONObject jo = JSONFix.fixOrder(rental, JsonViews.Rental.class);
            rentals.add(jo.toString());
        }
        return rentals.toString();
    }

    public Rental createRental(Rental rental){
        rentalRepo.save(rental);
        return rental;
    }
}
