package api.components.sakilaproject.customer;

import api.components.sakilaproject.actor.ActorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    public CustomerController (CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping
    public String getAllCustomers() throws JsonProcessingException {
        return customerService.readCustomers();
    }

    @GetMapping("/searchByID/{id}")
    public String getCustomerByID(@PathVariable("id") int custID) throws JsonProcessingException {
        return customerService.readCustomer(custID);
    }

    @GetMapping("/searchByName/{name}")
    public String getCustomerByName(@PathVariable("name") String custName) throws JsonProcessingException {
        return customerService.readCustomersByName(custName);
    }
}
