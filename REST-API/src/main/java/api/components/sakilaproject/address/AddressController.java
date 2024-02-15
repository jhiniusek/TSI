package api.components.sakilaproject.address;

import api.components.sakilaproject.actor.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private final AddressService addressService;

    public AddressController (AddressService addressService) {
        this.addressService = addressService;
    }


    @GetMapping
    public Iterable<Address> getAllAddresses() {
        return addressService.readAddresses();
    }
}
