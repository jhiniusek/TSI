package api.components.sakilaproject.rental;

import api.components.sakilaproject.inventory.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental,Integer> {
    @Query("SELECT r FROM Rental r JOIN r.customer c WHERE c.customerID = ?1")
    List<Rental> getRentalByCustomerID(int customerID);

    @Query("SELECT r FROM Rental r JOIN r.customer c WHERE c.firstName LIKE CONCAT('%',:name,'%') OR c.lastName LIKE CONCAT('%',:name,'%')")
    List<Rental> getRentalByCustomerName(String name);

    @Query("SELECT r from Rental r JOIN r.inventory i JOIN i.store s WHERE s.storeID = ?1")
    List<Rental> getRentalByStoreID(int storeID);
}
