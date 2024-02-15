package api.components.sakilaproject.address;

import api.components.sakilaproject.actor.ActorRepository;
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
}
