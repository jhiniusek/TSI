package api.components.sakilaproject.store;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stores")
public class StoreController {
    @Autowired
    private final StoreService storeService;

    public StoreController (StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public String getAllStores() throws JsonProcessingException {
        return storeService.readStores();
    }
}
