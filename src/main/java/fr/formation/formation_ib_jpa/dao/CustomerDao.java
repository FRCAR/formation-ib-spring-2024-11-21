package fr.formation.formation_ib_jpa.dao;

import fr.formation.formation_ib_jpa.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDao extends CrudRepository<Customer, Long> {
}