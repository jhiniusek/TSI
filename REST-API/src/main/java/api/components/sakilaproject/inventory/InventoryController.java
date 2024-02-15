package api.components.sakilaproject.inventory;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventories")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public String getAllInventories() throws JsonProcessingException {
        return inventoryService.readInventories();
    }

    @GetMapping("/{id}")
    public String getInventoryByID(@PathVariable("id") int inventoryID) throws JsonProcessingException {
        return inventoryService.readInventory(inventoryID);
    }

    @GetMapping("/byFilmID/{id}")
    public String getInventoryByFilmID(@PathVariable("id") int filmID) throws JsonProcessingException {
        return inventoryService.readInventoriesByFilmID(filmID);
    }

    @GetMapping("/byStoreID/{id}")
    public String getInventoryByStoreID(@PathVariable("id") int store) throws JsonProcessingException {
        return inventoryService.readInventoriesByStoreID(store);
    }
}
