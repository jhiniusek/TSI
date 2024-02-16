package api.components.sakilaproject.customer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    public String getCustomerByID(@PathVariable("id") int customerID) throws JsonProcessingException {
        return customerService.readCustomer(customerID);
    }

    @GetMapping("/searchByName/{name}")
    public String getCustomerByName(@PathVariable("name") String customerName) throws JsonProcessingException {
        return customerService.readCustomersByName(customerName);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }
}
