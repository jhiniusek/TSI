package api.components.sakilaproject.rental;

import api.components.sakilaproject.inventory.InventoryService;
import api.components.sakilaproject.payment.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @GetMapping
    public String getAllRentals() throws JsonProcessingException {
        return rentalService.readRentals();
    }

    @GetMapping("/byCustomerID/{id}")
    public String getRentalByCustomerID(@PathVariable("id") int custID) throws JsonProcessingException {
        return rentalService.readRentalsByCustomerID(custID);
    }

    @GetMapping("/byCustomerName/{name}")
    public String getRentalByCustomerID(@PathVariable("name") String custName) throws JsonProcessingException {
        return rentalService.readRentalsByCustomerName(custName);
    }

    @GetMapping("/byStoreID/{id}")
    public String getRentalByStoreID(@PathVariable("id") int storeID) throws JsonProcessingException {
        return rentalService.readRentalsByStoreID(storeID);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Rental addRental(@RequestBody Rental rental){
        return rentalService.createRental(rental);
    }
}
