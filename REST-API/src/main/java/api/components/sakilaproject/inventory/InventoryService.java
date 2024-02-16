package api.components.sakilaproject.inventory;

import api.components.sakilaproject.JSONFix;
import api.components.sakilaproject.JsonViews;
import api.components.sakilaproject.film.FilmRepository;
import api.components.sakilaproject.store.StoreRepository;
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
    private final FilmRepository filmRepo;
    private final StoreRepository storeRepo;
    public InventoryService (InventoryRepository inventoryRepo, FilmRepository filmRepo, StoreRepository storeRepo){
        this.inventoryRepo = inventoryRepo;
        this.filmRepo = filmRepo;
        this.storeRepo = storeRepo;
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

    public String readInventoriesByFilmID(int filmID) throws JsonProcessingException {
        List<Inventory> objectInventories = inventoryRepo.getInventoryByFilmID(filmID);
        List<String> inventories = new ArrayList<String>();

        for(Inventory inventory : objectInventories){
            JSONObject jo = JSONFix.fixOrder(inventory, JsonViews.Inventory.class);
            inventories.add(jo.toString());
        }
        return inventories.toString();
    }

    public String readInventoriesByStoreID(int storeID) throws JsonProcessingException {
        List<Inventory> objectInventories = inventoryRepo.getInventoryByStoreID(storeID);
        List<String> inventories = new ArrayList<String>();

        for(Inventory inventory : objectInventories){
            JSONObject jo = JSONFix.fixOrder(inventory, JsonViews.Inventory.class);
            inventories.add(jo.toString());
        }
        return inventories.toString();
    }

    public Inventory createInventory(Inventory inventory){
        inventoryRepo.save(inventory);
        return inventory;
    }

    public String addInventory(short filmID, short storeID){

        Inventory newInventory = new Inventory();
        try{
            newInventory.setStore(storeRepo.findById((int)storeID).get());
        } catch (Exception e) {
            return "Invalid Store ID.";
        }
        try{
            newInventory.setFilm(filmRepo.findById((int)filmID).get());
        } catch (Exception e) {
            return "Invalid Film ID";
        }
        inventoryRepo.save(newInventory);
        return "Film ID: " + filmID + " added to a store with ID: " + storeID + ".";
    }
}
