package api.components.sakilaproject.store;

import api.components.sakilaproject.JSONFix;
import api.components.sakilaproject.JsonViews;
import api.components.sakilaproject.staff.StaffRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreService {
    @Autowired
    private final StoreRepository storeRepo;
    public StoreService (StoreRepository storeRepo){
        this.storeRepo = storeRepo;
    }

    public String readStores() throws JsonProcessingException {
        List<Store> objectStores = storeRepo.findAll();
        List<String> stores = new ArrayList<String>();

        for(Store store : objectStores){
            JSONObject jo = JSONFix.fixOrder(store, JsonViews.Store.class);
            stores.add(jo.toString());
        }
        return stores.toString();
    }
}
