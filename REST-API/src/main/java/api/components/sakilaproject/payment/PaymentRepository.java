package api.components.sakilaproject.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {

    @Query("SELECT p FROM Payment p JOIN p.customer c WHERE c.customerID = ?1")
    List<Payment> getPaymentByCustomerID(int customerID);

    @Query("SELECT p FROM Payment p JOIN p.customer c WHERE c.firstName LIKE CONCAT('%',:name,'%') OR c.lastName LIKE CONCAT('%',:name,'%')")
    List<Payment> getPaymentByCustomerName(String name);

    @Query("SELECT p from Payment p JOIN p.rental r JOIN r.inventory i JOIN i.store s WHERE s.storeID = ?1")
    List<Payment> getPaymentByStoreID(int storeID);

}
