package api.components.sakilaproject.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private final AddressRepository addressRepo;
    public AddressService (AddressRepository addressRepo){
        this.addressRepo = addressRepo;
    }

    public List<Address> readAddresses(){
        return addressRepo.findAll();
    }

    public Address createAddress(Address address){
        addressRepo.save(address);
        return address;
    }

    public String removeAddress(int ID){
        if(addressRepo.existsById(ID)){
            addressRepo.deleteById(ID);
            return "Address with ID " + ID + " removed.";
        }
        else{
            return "Address with ID " + ID + " not found.";
        }
    }
}
