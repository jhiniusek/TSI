package api.components.sakilaproject.store;

import api.components.sakilaproject.JSONFix;
import api.components.sakilaproject.JsonViews;
import api.components.sakilaproject.staff.StaffService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

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
