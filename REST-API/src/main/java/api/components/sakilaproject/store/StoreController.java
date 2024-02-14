package api.components.sakilaproject.store;

import api.components.sakilaproject.JSONFix;
import api.components.sakilaproject.JsonViews;
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
    private StoreRepository storeRepo;

    @GetMapping
    public String getAllStores() throws JsonProcessingException {
        List<Store> objectStores = storeRepo.findAll();
        List<String> stores = new ArrayList<String>();

        for(Store store : objectStores){
            JSONObject jo = JSONFix.fixOrder(store, JsonViews.Store.class);
            stores.add(jo.toString());
        }
        return stores.toString();
    }
}
