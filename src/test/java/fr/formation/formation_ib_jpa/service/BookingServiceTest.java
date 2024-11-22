package fr.formation.formation_ib_jpa.service;


import fr.formation.formation_ib_jpa.dao.CustomerDao;
import fr.formation.formation_ib_jpa.model.Booking;
import fr.formation.formation_ib_jpa.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

@SpringBootTest
public class BookingServiceTest {

    @Autowired
    BookingService bookingService;

    @Autowired
    CustomerDao customerDao;

    @Test
    public void testSave() {
        //Arrange
        Booking booking = new Booking();
        booking.setName("Bonne réservation");

        //Act
        Booking bookingSaved = bookingService.save(booking);

        //Assert
        Assertions.assertNotNull(bookingSaved);
        Assertions.assertNotNull(bookingSaved.getId());
    }



    @Test
    public void testSaveWithCustomer() {

        Booking booking = new Booking();
        booking.setName("Réservation moyenne");

        Customer customer = new Customer();
        customer.setFirstName("Jean");
        Customer savedCustomer = customerDao.save(customer);

        booking.setCustomer(savedCustomer);

        Booking bookingSaved = bookingService.save(booking);
        Booking bookingLoaded = bookingService.findByIdWithCustomer(bookingSaved.getId());

        System.out.println(bookingLoaded);
        System.out.println(bookingLoaded.getCustomer());


        //Assert
        Assertions.assertNotNull(bookingSaved);
        Assertions.assertNotNull(bookingSaved.getId());
    }

}