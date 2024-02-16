package api.components.sakilaproject.inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory,Integer> {

    @Query("SELECT i from Inventory i JOIN i.film f WHERE f.filmID = ?1")
    List<Inventory> getInventoryByFilmID(int filmID);

    @Query("SELECT i from Inventory i JOIN i.store s WHERE s.storeID = ?1")
    List<Inventory> getInventoryByStoreID(int storeID);
}
