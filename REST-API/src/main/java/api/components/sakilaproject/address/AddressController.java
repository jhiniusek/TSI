package api.components.sakilaproject.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Address addAddress(@RequestBody Address address){
        return addressService.createAddress(address);
    }

    @DeleteMapping("/{id}")
    public String removeAddress(@PathVariable("id") int addressID){
        return addressService.removeAddress(addressID);
    }
}
