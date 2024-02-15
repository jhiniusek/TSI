package api.components.sakilaproject.payment;

import api.components.sakilaproject.inventory.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
