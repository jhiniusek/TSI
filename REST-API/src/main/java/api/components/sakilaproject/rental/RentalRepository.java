package api.components.sakilaproject.rental;

import api.components.sakilaproject.inventory.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental,Integer> {
}
