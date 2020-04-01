package com.crossover.techtrial.service;

import com.crossover.techtrial.model.Customer;
import com.crossover.techtrial.model.HourlyElectricity;
import com.crossover.techtrial.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;


/**
 * CustomerServiceImpl for customer related handling.
 * @author Crossover
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  CustomerRepository customerRepository;
  
  /* (non-Javadoc)
   * @see com.crossover.techtrial.service.PanelService#register(com.crossover.techtrial.model.Panel)
   */
  
  @Override
  public void register(Customer customer) { 
    customerRepository.save(customer);
  }
 /* @Override
  public Customer findBySerial(String serial) {
    return customerRepository.findBySerial(serial);
  }*/
  
  @Override
  public void delete(Customer customer) { 
    customerRepository.delete(customer);
  }
 
 @Override
@Modifying
@Query("update Customer c set c.fullname = ?1 where c.id = ?2")
public void update(String fullname, Long userId){
    
}

  
  
  @Override
  public Page<Customer> findAll(Pageable pageable) {
    return customerRepository.findAll(pageable);
  }
}
