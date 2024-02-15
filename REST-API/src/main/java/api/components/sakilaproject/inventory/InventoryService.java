package api.components.sakilaproject.inventory;

import api.components.sakilaproject.JSONFix;
import api.components.sakilaproject.JsonViews;
import api.components.sakilaproject.film.Film;
import api.components.sakilaproject.film.FilmRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private final InventoryRepository inventoryRepo;
    public InventoryService (InventoryRepository inventoryRepo){
        this.inventoryRepo = inventoryRepo;
    }


    public String readInventory(Integer id) throws JsonProcessingException {
        Inventory inventory;
        try{
            inventory = inventoryRepo.findById(id).get();
        } catch (Exception e){
            return "Invalid inventory ID.";
        }
        return (JSONFix.fixOrder(inventory, JsonViews.Inventory.class)).toString();
    }

    public String readInventories() throws JsonProcessingException {
        List<Inventory> objectInventories = inventoryRepo.findAll();
        List<String> inventories = new ArrayList<String>();

        for(Inventory inventory : objectInventories){
            JSONObject jo = JSONFix.fixOrder(inventory, JsonViews.Inventory.class);
            inventories.add(jo.toString());
        }
        return inventories.toString();
    }
}
