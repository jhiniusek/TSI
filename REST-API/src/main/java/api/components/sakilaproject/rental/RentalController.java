package api.components.sakilaproject.rental;

import api.components.sakilaproject.inventory.InventoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
