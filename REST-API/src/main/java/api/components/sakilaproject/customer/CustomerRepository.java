package api.components.sakilaproject.customer;

import api.components.sakilaproject.actor.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
