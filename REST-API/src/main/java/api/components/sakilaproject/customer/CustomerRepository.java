package api.components.sakilaproject.customer;

import api.components.sakilaproject.actor.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query("SELECT c FROM Customer c WHERE c.firstName LIKE CONCAT('%',:name,'%') OR c.lastName LIKE CONCAT('%',:name,'%')")
    List<Customer> findCustomerByName(String name);
}
