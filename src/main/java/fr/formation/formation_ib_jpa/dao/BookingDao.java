package fr.formation.formation_ib_jpa.dao;

import fr.formation.formation_ib_jpa.model.Booking;
import fr.formation.formation_ib_jpa.model.ExampleType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookingDao extends CrudRepository<Booking, Long> {


    @Query("select b " +
            " from Booking b " +
            " join fetch b.customer c " +
            " where b.id = :id ")
    Booking findByIdWithCustomer(Long id);
}