package api.components.sakilaproject.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressRepository addressRepo;

    @GetMapping
    public Iterable<Address> getAllAddresses() {
        return addressRepo.findAll();
    }
}
