package fr.formation.formation_ib_jpa.service;

import fr.formation.formation_ib_jpa.dao.CustomerDao;
import fr.formation.formation_ib_jpa.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Transactional
    public Customer save(Customer customer){
        return customerDao.save(customer);
    }

    @Transactional
    public void deleteById(Long customerId){
        customerDao.deleteById(customerId);
    }

    public Customer findById(Long id){
        Optional<Customer> customer = customerDao.findById(id);
        if(customer.isPresent()){
            return customer.get();
        }
        return null;
    }


}
