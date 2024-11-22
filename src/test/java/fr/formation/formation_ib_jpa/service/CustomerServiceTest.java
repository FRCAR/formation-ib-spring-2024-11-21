package fr.formation.formation_ib_jpa.service;


import fr.formation.formation_ib_jpa.dao.CustomerDao;
import fr.formation.formation_ib_jpa.model.Customer;
import fr.formation.formation_ib_jpa.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerDao customerDao;

    @Test
    public void testSave() {
        //Arrange
        Customer customer = new Customer();
        customer.setFirstName("Jean");
        customer.setLastName("Dupont");

        //Act
        Customer customerSaved = customerService.save(customer);

        //Assert
        Assertions.assertNotNull(customerSaved);
        Assertions.assertNotNull(customerSaved.getId());
        Assertions.assertEquals("Jean", customer.getFirstName());
        Assertions.assertEquals("Dupont", customer.getLastName());
    }




}